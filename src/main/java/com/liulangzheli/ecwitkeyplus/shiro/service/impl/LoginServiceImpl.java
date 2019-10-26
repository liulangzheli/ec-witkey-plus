/*
 * Copyright 2019-2029 liulangzheli(https://github.com/liulangzheli)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.liulangzheli.ecwitkeyplus.shiro.service.impl;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.liulangzheli.ecwitkeyplus.constant.CommonConstant;
import com.liulangzheli.ecwitkeyplus.shiro.cache.LoginRedisService;
import com.liulangzheli.ecwitkeyplus.shiro.jwt.JwtProperties;
import com.liulangzheli.ecwitkeyplus.shiro.jwt.JwtToken;
import com.liulangzheli.ecwitkeyplus.shiro.param.LoginParam;
import com.liulangzheli.ecwitkeyplus.shiro.util.JwtTokenUtil;
import com.liulangzheli.ecwitkeyplus.shiro.util.JwtUtil;
import com.liulangzheli.ecwitkeyplus.shiro.util.SaltUtil;
import com.liulangzheli.ecwitkeyplus.shiro.vo.LoginSysUserVo;
import com.liulangzheli.ecwitkeyplus.common.api.ApiCode;
import com.liulangzheli.ecwitkeyplus.common.api.ApiResult;
import com.liulangzheli.ecwitkeyplus.shiro.service.LoginService;
import com.liulangzheli.ecwitkeyplus.shiro.vo.LoginSysUserRedisVo;
import com.liulangzheli.ecwitkeyplus.system.convert.SysUserConvert;
import com.liulangzheli.ecwitkeyplus.system.entity.SysUser;
import com.liulangzheli.ecwitkeyplus.system.mapper.SysUserMapper;
import com.liulangzheli.ecwitkeyplus.util.PasswordUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.SetUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 登录服务实现类
 * </p>
 *
 * @author liulangzheli
 * @date 2019-05-23
 **/
@Api
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRedisService loginRedisService;

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public ApiResult login(LoginParam loginParam, HttpServletResponse response) {
        String username = loginParam.getUsername();
        // 从数据库中获取登陆用户信息
        SysUser sysUser = sysUserMapper.getSysUserByUsername(username);
        if (sysUser == null) {
            log.error("登陆失败,loginParam:{}", loginParam);
            return ApiResult.fail(ApiCode.LOGIN_EXCEPTION);
        }
        // 实际项目中，前端传过来的密码应先加密
        // 原始密码：123456
        // 加密规则：sha256(666666+123456) = 751ade2f90ceb660cb2460f12cc6fe08268e628e4607bdb88a00605b3d66973c
        String encryptPassword = PasswordUtil.encrypt(loginParam.getPassword());
        if (!encryptPassword.equals(sysUser.getPassword())) {
            log.error("用户名或密码错误");
            return ApiResult.fail(ApiCode.LOGIN_EXCEPTION);
        }
        // 将系统用户对象转换成登陆用户对象
        LoginSysUserVo loginSysUserVo = SysUserConvert.INSTANCE.sysUserToLoginSysUserVo(sysUser);
        // TODO 从数据库中获取登陆用户角色权限信息
        loginSysUserVo.setRoles(SetUtils.hashSet("admin"));

        String newSalt;
        if (jwtProperties.isSaltCheck()) {
            // 包装盐值
            newSalt = SaltUtil.getSalt(jwtProperties.getSecret(), loginSysUserVo.getSalt());
        } else {
            newSalt = jwtProperties.getSecret();
        }
        // 删除登陆用户盐值，盐值保存到后台Redis缓存中
        loginSysUserVo.setSalt(null);

        // 生成token字符串并返回
        Duration expireDuration = Duration.ofSeconds(jwtProperties.getExpireSecond());
        String token = JwtUtil.generateToken(username, newSalt, expireDuration);
        log.debug("token:{}", token);

        // 创建AuthenticationToken
        JwtToken jwtToken = JwtToken.build(token, username, newSalt, jwtProperties.getExpireSecond());
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 执行认证登陆
        subject.login(jwtToken);

        // 缓存登陆信息到Redis
        loginRedisService.cacheLoginInfo(jwtToken, loginSysUserVo);
        // 设置响应头
        response.setHeader(JwtTokenUtil.getTokenName(), token);
        log.debug("登陆成功,username:{}", username);
        // 返回token
        return ApiResult.ok(token, "登陆成功");
    }

    @Override
    public void refreshToken(JwtToken jwtToken, HttpServletResponse httpServletResponse) {
        if (jwtToken == null) {
            return;
        }
        String token = jwtToken.getToken();
        if (StringUtils.isBlank(token)) {
            return;
        }
        // 判断是否刷新token
        boolean isRefreshToken = jwtProperties.isRefreshToken();
        if (!isRefreshToken) {
            return;
        }
        // 获取过期时间
        Date expireDate = JwtUtil.getExpireDate(token);
        // 获取倒计时
        Integer countdown = jwtProperties.getRefreshTokenCountdown();
        // 如果(当前时间+倒计时) > 过期时间，则刷新token
        boolean refresh = DateUtils.addSeconds(new Date(), countdown).after(expireDate);

        if (!refresh) {
            return;
        }

        // 如果token继续发往后台，则提示，此token已失效，请使用新token，不在返回新token，返回状态码：461
        // 如果Redis缓存中没有，JwtToken没有过期，则说明，已经刷新token
        boolean exists = loginRedisService.exists(token);
        if (!exists) {
            httpServletResponse.setStatus(CommonConstant.JWT_INVALID_TOKEN_CODE);
            throw new AuthenticationException("token已无效，请使用已刷新的token");
        }
        String username = jwtToken.getUsername();
        String salt = jwtToken.getSalt();
        Long expireSecond = jwtProperties.getExpireSecond();
        // 生成新token字符串
        String newToken = JwtUtil.generateToken(username, salt, Duration.ofSeconds(expireSecond));
        // 生成新JwtToken对象
        JwtToken newJwtToken = JwtToken.build(newToken, username, salt, expireSecond);
        // 更新redis缓存
        loginRedisService.refreshLoginInfo(token, username, newJwtToken);
        log.debug("刷新token成功，原token:{}，新token:{}", token, newToken);
        // 设置响应头
        // 刷新token
        httpServletResponse.setStatus(CommonConstant.JWT_REFRESH_TOKEN_CODE);
        httpServletResponse.setHeader(JwtTokenUtil.getTokenName(), newToken);
    }

    @Override
    public void logout(HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        //注销
        subject.logout();
        // 获取token
        String token = JwtTokenUtil.getToken(request);
        String username = JwtUtil.getUsername(token);
        // 删除Redis缓存信息
        loginRedisService.deleteLoginInfo(token, username);
        log.info("登出成功,username:{},token:{}", username, token);
    }

    @Override
    public List<String> getUserRoles(Long id) {
        return Arrays.asList("admin");
    }


}
