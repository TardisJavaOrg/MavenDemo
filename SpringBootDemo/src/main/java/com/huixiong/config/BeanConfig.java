package com.huixiong.config;

import com.huixiong.interceptor.LoggerInterceptor;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <描述>
 *
 * @author timothy.yang cloudwise
 * @since 2021-09-07 13:50
 */
@Configuration
public class BeanConfig {

    @Autowired
    LoggerInterceptor interceptor;

    @Bean
    WebMvcConfigurer createWebMvcConfigurer() {
        return new WebMvcConfigurer() {
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(interceptor);
            }
        };
    }
}
