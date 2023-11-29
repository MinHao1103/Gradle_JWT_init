package com.hao.Gradle_JWT_Init.config;

import com.hao.Gradle_JWT_Init.interceptor.JWTInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private JWTInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/v1/test")
                .excludePathPatterns("/v1/test/login")
                .excludePathPatterns("/error")
                .excludePathPatterns(
                        "/swagger-ui.html",        // Swagger UI HTML
                        "/swagger-ui/**",          // Swagger UI resources
                        "/swagger-resources/**",   // Swagger resources
                        "/v3/**"                   // api-docs
                );
    }

}
