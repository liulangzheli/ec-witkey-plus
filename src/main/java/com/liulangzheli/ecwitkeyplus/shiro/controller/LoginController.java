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

package com.liulangzheli.ecwitkeyplus.shiro.controller;

import com.liulangzheli.ecwitkeyplus.shiro.param.LoginParam;
import com.liulangzheli.ecwitkeyplus.common.api.ApiResult;
import com.liulangzheli.ecwitkeyplus.shiro.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * 登陆控制器
 *
 * @author liulangzheli
 * @date 2019-09-28
 * @since 1.3.0.RELEASE
 **/
@Api("登陆控制器")
@Slf4j
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    @ApiOperation(value = "登陆", notes = "系统用户登陆", response = ApiResult.class)
    public ApiResult login(@Valid @RequestBody LoginParam loginParam, HttpServletResponse response) {
        return loginService.login(loginParam, response);
    }

    @PostMapping("/logout")
    public ApiResult logout(HttpServletRequest request) {
        loginService.logout(request);
        return ApiResult.ok("退出成功");
    }
}
