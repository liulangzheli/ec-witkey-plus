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

import com.alibaba.fastjson.JSON;
import com.liulangzheli.ecwitkeyplus.interceptor.PermissionInterceptor;
import com.liulangzheli.ecwitkeyplus.resource.interceptor.DownloadInterceptor;
import com.liulangzheli.ecwitkeyplus.resource.interceptor.ResourceInterceptor;
import com.liulangzheli.ecwitkeyplus.resource.interceptor.UploadInterceptor;
import com.liulangzheli.ecwitkeyplus.core.properties.EcWitkeyPlusInterceptorProperties;
import com.liulangzheli.ecwitkeyplus.core.properties.EcWitkeyPlusProperties;
import com.liulangzheli.ecwitkeyplus.util.IniUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * WebMvc配置
 * @author liulangzheli
 * @date 2018-11-08
 */
@Slf4j
@Configuration
public class EcWitkeyPlusWebMvcConfig implements WebMvcConfigurer {

    /**
     * ec-witkey-plus配置属性
     */
    @Autowired
    private EcWitkeyPlusProperties ecWitkeyPlusProperties;

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


    @PostConstruct
    public void init(){
        // 打印EcWitkeyPlusProperties配置信息
        log.debug("EcWitkeyPlusProperties：{}", JSON.toJSONString(ecWitkeyPlusProperties));
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        EcWitkeyPlusInterceptorProperties interceptorConfig = ecWitkeyPlusProperties.getInterceptor();

        // 上传拦截器
        if (interceptorConfig.getUpload().isEnabled()){
            registry.addInterceptor(uploadInterceptor())
                    .addPathPatterns(interceptorConfig.getUpload().getIncludePaths());
        }

        // 资源拦截器注册
        if (interceptorConfig.getResource().isEnabled()){
            registry.addInterceptor(resourceInterceptor())
                    .addPathPatterns(interceptorConfig.getResource().getIncludePaths());
        }

        // 下载拦截器注册
        if (interceptorConfig.getDownload().isEnabled()){
            registry.addInterceptor(downloadInterceptor())
                    .addPathPatterns(interceptorConfig.getDownload().getIncludePaths());
        }

        if (interceptorConfig.getPermission().isEnabled()){
            // 权限拦截器注册
            registry.addInterceptor(permissionInterceptor())
                    .addPathPatterns(interceptorConfig.getPermission().getIncludePaths())
                    .excludePathPatterns(interceptorConfig.getPermission().getExcludePaths());
        }
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 设置项目静态资源访问
        String resourceHandlers = ecWitkeyPlusProperties.getResourceHandlers();
        if (StringUtils.isNotBlank(resourceHandlers)){
            Map<String,String> map = IniUtil.parseIni(resourceHandlers);
            for (Map.Entry<String,String> entry : map.entrySet()){
                String pathPatterns = entry.getKey();
                String resourceLocations = entry.getValue();
                registry.addResourceHandler(pathPatterns)
                        .addResourceLocations(resourceLocations);
            }
        }

        // 设置上传文件访问路径
        registry.addResourceHandler(ecWitkeyPlusProperties.getResourceAccessPatterns())
                .addResourceLocations("file:" + ecWitkeyPlusProperties.getUploadPath());
    }

}
