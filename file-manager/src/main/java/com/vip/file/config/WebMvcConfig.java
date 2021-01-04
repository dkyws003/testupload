package com.vip.file.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 解决跨域访问
 *
 * @author wgb
 * @date 2019/12/29 22:01
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
              .allowedOrigins("*")
              .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
              .maxAge(3600)
              .allowCredentials(true);
    }
}

