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

package com.liulangzheli.ecwitkeyplus.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 自定义异常
 * @author liulangzheli
 * @date 2018-11-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class EcWitkeyPlusException extends RuntimeException{
    private Integer errorCode;
    private String message;

    public EcWitkeyPlusException(String message) {
        super(message);
        this.message = message;
    }

    public EcWitkeyPlusException(Integer errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }
}
