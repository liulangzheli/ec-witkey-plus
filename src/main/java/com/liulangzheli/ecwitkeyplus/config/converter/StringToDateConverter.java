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

package com.liulangzheli.ecwitkeyplus.config.converter;

import org.springframework.core.convert.converter.Converter;

import java.util.Date;

/**
 * <code>
 * 日期转换器,将请求参数的日期字符串转换成java.util.Date类型
 * </code>
 * @author liulangzheli
 * @date 2018-11-08
 */
public class StringToDateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		return StringToDateUtil.convert(source);
	}
}
