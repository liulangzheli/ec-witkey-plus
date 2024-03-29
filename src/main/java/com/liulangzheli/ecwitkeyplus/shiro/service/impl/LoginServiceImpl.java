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

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liulangzheli.ecwitkeyplus.constant.CommonConstant;
import com.liulangzheli.ecwitkeyplus.constant.CommonRedisKey;
import com.liulangzheli.ecwitkeyplus.core.properties.EcWitkeyPlusProperties;
import com.liulangzheli.ecwitkeyplus.enums.StateEnum;
import com.liulangzheli.ecwitkeyplus.shiro.cache.LoginRedisService;
import com.liulangzheli.ecwitkeyplus.shiro.jwt.JwtProperties;
import com.liulangzheli.ecwitkeyplus.shiro.jwt.JwtToken;
import com.liulangzheli.ecwitkeyplus.shiro.param.LoginParam;
import com.liulangzheli.ecwitkeyplus.shiro.service.LoginService;
import com.liulangzheli.ecwitkeyplus.shiro.util.JwtTokenUtil;
import com.liulangzheli.ecwitkeyplus.shiro.util.JwtUtil;
import com.liulangzheli.ecwitkeyplus.shiro.util.SaltUtil;
import com.liulangzheli.ecwitkeyplus.shiro.vo.LoginSysUserVo;
import com.liulangzheli.ecwitkeyplus.system.convert.SysUserConvert;
import com.liulangzheli.ecwitkeyplus.system.entity.SysDepartment;
import com.liulangzheli.ecwitkeyplus.system.entity.SysRole;
import com.liulangzheli.ecwitkeyplus.system.entity.SysUser;
import com.liulangzheli.ecwitkeyplus.system.exception.VerificationCodeException;
import com.liulangzheli.ecwitkeyplus.system.mapper.SysUserMapper;
import com.liulangzheli.ecwitkeyplus.system.service.SysDepartmentService;
import com.liulangzheli.ecwitkeyplus.system.service.SysRolePermissionService;
import com.liulangzheli.ecwitkeyplus.system.service.SysRoleService;
import com.liulangzheli.ecwitkeyplus.system.vo.LoginSysUserTokenVo;
import com.liulangzheli.ecwitkeyplus.util.PasswordUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

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

    @Autowired
    private SysDepartmentService sysDepartmentService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysRolePermissionService sysRolePermissionService;

    @Autowired
    private EcWitkeyPlusProperties ecWitkeyPlusProperties;

    @Autowired
    private RedisTemplate redisTemplate;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public LoginSysUserTokenVo login(LoginParam loginParam) throws Exception {
        // 校验验证码
        checkVerifyCode(loginParam.getVerifyToken(), loginParam.getCode());

        String username = loginParam.getUsername();
        // 从数据库中获取登陆用户信息
        SysUser sysUser = getSysUserByUsername(username);
        if (sysUser == null) {
            log.error("登陆失败,loginParam:{}", loginParam);
            throw new AuthenticationException("用户名或密码错误");
        }
        if (StateEnum.DISABLE.getKey().equals(sysUser.getState())) {
            throw new AuthenticationException("账号已禁用");
        }

        // 实际项目中，前端传过来的密码应先加密
        // 原始密码明文：123456
        // 原始密码前端加密：sha256(123456)
        // 后台加密规则：sha256(sha256(123456) + salt)
        String encryptPassword = PasswordUtil.encrypt(loginParam.getPassword(), sysUser.getSalt());
        if (!encryptPassword.equals(sysUser.getPassword())) {
            throw new AuthenticationException("用户名或密码错误");
        }

        // 将系统用户对象转换成登陆用户对象
        LoginSysUserVo loginSysUserVo = SysUserConvert.INSTANCE.sysUserToLoginSysUserVo(sysUser);

        // 获取部门
        SysDepartment sysDepartment = sysDepartmentService.getById(sysUser.getDepartmentId());
        if (sysDepartment == null) {
            throw new AuthenticationException("部门不存在");
        }
        if (!StateEnum.ENABLE.getKey().equals(sysDepartment.getState())) {
            throw new AuthenticationException("部门已禁用");
        }
        loginSysUserVo.setDepartmentId(sysDepartment.getId())
                .setDepartmentName(sysDepartment.getName());

        // 获取当前用户角色
        Long roleId = sysUser.getRoleId();
        SysRole sysRole = sysRoleService.getById(roleId);
        if (sysRole == null) {
            throw new AuthenticationException("角色不存在");
        }
        if (StateEnum.DISABLE.getKey().equals(sysRole.getState())) {
            throw new AuthenticationException("角色已禁用");
        }
        loginSysUserVo.setRoleId(sysRole.getId())
                .setRoleName(sysRole.getName())
                .setRoleCode(sysRole.getCode());

        // 获取当前用户权限
        Set<String> permissionCodes = sysRolePermissionService.getPermissionCodesByRoleId(roleId);
        if (CollectionUtils.isEmpty(permissionCodes)) {
            throw new AuthenticationException("权限列表不能为空");
        }
        loginSysUserVo.setPermissionCodes(permissionCodes);

        // 获取数据库中保存的盐值
        String newSalt = SaltUtil.getSalt(sysUser.getSalt(), jwtProperties);

        // 生成token字符串并返回
        Long expireSecond = jwtProperties.getExpireSecond();
        String token = JwtUtil.generateToken(username, newSalt, Duration.ofSeconds(expireSecond));
        log.debug("token:{}", token);

        // 创建AuthenticationToken
        JwtToken jwtToken = JwtToken.build(token, username, newSalt, expireSecond);
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 执行认证登陆
        subject.login(jwtToken);

        // 缓存登陆信息到Redis
        loginRedisService.cacheLoginInfo(jwtToken, loginSysUserVo);
        log.debug("登陆成功,username:{}", username);

        // 返回token和登陆用户信息对象
        LoginSysUserTokenVo loginSysUserTokenVo = new LoginSysUserTokenVo();
        loginSysUserTokenVo.setToken(token);
        loginSysUserTokenVo.setLoginSysUserVo(loginSysUserVo);
        return loginSysUserTokenVo;
    }

    @Override
    public void checkVerifyCode(String verifyToken, String code) throws Exception {
        // 如果没有启用验证码，则返回
        if (!ecWitkeyPlusProperties.isEnableVerifyCode()) {
            return;
        }
        // 校验验证码
        if (StringUtils.isBlank(code)) {
            throw new VerificationCodeException("请输入验证码");
        }
        // 从redis中获取
        String redisKey = String.format(CommonRedisKey.VERIFY_CODE, verifyToken);
        String generateCode = (String) redisTemplate.opsForValue().get(redisKey);
        if (StringUtils.isBlank(generateCode)) {
            throw new VerificationCodeException("验证码已过期或不正确");
        }
        // 不区分大小写
        if (!generateCode.equalsIgnoreCase(code)) {
            throw new VerificationCodeException("验证码错误");
        }
        // 验证码校验成功，删除Redis缓存
        redisTemplate.delete(redisKey);
    }

    @Override
    public void refreshToken(JwtToken jwtToken, HttpServletResponse httpServletResponse) throws Exception {
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
    public void logout(HttpServletRequest request) throws Exception {
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
    public SysUser getSysUserByUsername(String username) throws Exception {
        SysUser sysUser = new SysUser().setUsername(username);
        return sysUserMapper.selectOne(new QueryWrapper(sysUser));
    }

}
