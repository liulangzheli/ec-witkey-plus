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

package com.liulangzheli.ecwitkeyplus.common.controller;

import com.liulangzheli.ecwitkeyplus.common.api.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * <p>
 *     项目根路径提示信息
 * </p>
 * @author liulangzheli
 * @date 2018/11/12
 */
@RestController
@ApiIgnore
@Slf4j
public class IndexController {

    @RequestMapping("/index")
    public ApiResult<String> index(){
        log.debug("index...");
        return ApiResult.ok("Welcome to Ec Witkey Plus Project...");
    }
}
