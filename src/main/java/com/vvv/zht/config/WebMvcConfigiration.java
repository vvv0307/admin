package com.vvv.zht.config;

import com.vvv.zht.Interceptor.CorsInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class WebMvcConfigiration extends WebMvcConfigurerAdapter {

    @Autowired
    private CorsInterceptor corsInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(corsInterceptor).addPathPatterns("/**");
    }
}
