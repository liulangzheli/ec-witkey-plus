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
package com.liulangzheli.ecwitkeyplus.core.config;

import com.liulangzheli.ecwitkeyplus.aop.LogAop;
import com.liulangzheli.ecwitkeyplus.core.properties.*;
import com.liulangzheli.ecwitkeyplus.interceptor.PermissionInterceptor;
import com.liulangzheli.ecwitkeyplus.resource.interceptor.DownloadInterceptor;
import com.liulangzheli.ecwitkeyplus.resource.interceptor.ResourceInterceptor;
import com.liulangzheli.ecwitkeyplus.resource.interceptor.UploadInterceptor;
import com.liulangzheli.ecwitkeyplus.core.properties.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ec-witkey-plus配置
 *
 * @author liulangzheli
 * @date 2019/8/4
 * @since 1.2.0-RELEASE
 */
@Slf4j
@Configuration
@EnableConfigurationProperties({
        EcWitkeyPlusProperties.class,
        EcWitkeyPlusCorsProperties.class,
        EcWitkeyPlusFilterProperties.class,
        EcWitkeyPlusInterceptorProperties.class,
        EcWitkeyPlusAopProperties.class
})
public class EcWitkeyPlusConfig {

    /**
     * 配置日志AOP
     *
     * @param ecWitkeyPlusProperties
     * @return
     */
    @Bean
    public LogAop logAop(EcWitkeyPlusProperties ecWitkeyPlusProperties) {
        LogAop logAop = new LogAop();
        logAop.setRequestLogFormat(ecWitkeyPlusProperties.isRequestLogFormat());
        logAop.setResponseLogFormat(ecWitkeyPlusProperties.isResponseLogFormat());
        log.debug("init LogAop success");
        return logAop;
    }

    /**
     * 权限拦截器
     *
     * @return
     */
    @Bean
    public PermissionInterceptor permissionInterceptor() {
        PermissionInterceptor permissionInterceptor = new PermissionInterceptor();
        return permissionInterceptor;
    }

    /**
     * 上传拦截器
     *
     * @return
     */
    @Bean
    public UploadInterceptor uploadInterceptor() {
        UploadInterceptor uploadInterceptor = new UploadInterceptor();
        return uploadInterceptor;
    }

    /**
     * 资源拦截器
     *
     * @return
     */
    @Bean
    public ResourceInterceptor resourceInterceptor() {
        ResourceInterceptor resourceInterceptor = new ResourceInterceptor();
        return resourceInterceptor;
    }

    /**
     * 下载拦截器
     *
     * @return
     */
    @Bean
    public DownloadInterceptor downloadInterceptor() {
        DownloadInterceptor downloadInterceptor = new DownloadInterceptor();
        return downloadInterceptor;
    }
}
