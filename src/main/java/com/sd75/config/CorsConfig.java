package com.sd75.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Apply to all endpoints
                .allowedOrigins("*") // Allowed origins
                .allowedMethods("*") // Allowed HTTP methods
                .allowedHeaders("*") // Allowed headers
                .allowCredentials(false) // Allow cookies and authorization headers
                .maxAge(3600); // Max age for preflight requests
    }
}