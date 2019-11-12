package com.liulangzheli.ecwitkeyplus.core.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @program: ec-witkey-plus
 * @Date: 2019-11-12 20:59
 * @Author: Mr.Deng
 * @Description:
 */
public class DefaultView extends WebMvcConfigurationSupport {

    /**
     * 默认登录页
     * @param registry 主页注册器
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //设置主页
        registry.addViewController("/").setViewName("/index");
        //设置优先级
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        //将主页注册器添加到视图控制器中
        super.addViewControllers(registry);
    }
}
