package com.example.self_manager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static com.example.self_manager.constant.SecurityConstant.FRONT_END_URL;
import static com.example.self_manager.constant.SecurityConstant.FRONT_END_URL2;

@EnableWebMvc
@Configuration
public class WebCorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins(FRONT_END_URL, FRONT_END_URL2)
                .allowedMethods("GET", "POST", "OPTIONS", "PUT", "DELETE", "PATCH")
                .allowCredentials(true);
    }

}
