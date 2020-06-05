package com.intecsec.mall.gateway.config;

import com.intecsec.mall.gateway.interceptor.PermissionInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description: mvc配置
 * @author: peter.peng
 * @create: 2020-03-01 20:57
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${spring.profiles.active}")
    private String env;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        if("online".equals(env)) {
            registry.addInterceptor(new PermissionInterceptor());
        }
    }
}
