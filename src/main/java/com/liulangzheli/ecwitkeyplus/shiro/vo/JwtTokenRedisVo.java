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

package com.liulangzheli.ecwitkeyplus.shiro.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * JwtToken Redis缓存对象
 *
 * @author liulangzheli
 * @date 2019-09-30
 **/
@Data
@Accessors(chain = true)
public class JwtTokenRedisVo implements Serializable {
    private static final long serialVersionUID = 1831633309466775223L;
    /**
     * 登陆ip
     */
    private String host;
    /**
     * 登陆用户名称
     */
    private String username;
    /**
     * 登陆盐值
     */
    private String salt;
    /**
     * 登陆token
     */
    private String token;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 多长时间过期，默认一小时
     */
    private long expireSecond;
    /**
     * 过期日期
     */
    private Date expireDate;

}
