package com.atguigu.gilimall.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;


import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * @Author: tzm
 * @Date: 2020/7/26 22:12
 * @description: com.atguigu.gilimall.gateway.config
 * @description: 配置所有的请求的跨域
 */
@Configuration
public class GuLICorsConfiguration {

    @Bean
    public CorsWebFilter corsWebFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //1、配置跨域
        // /**：所有请求进行跨域
        corsConfiguration.addAllowedHeader("*");//允许某些头部进行跨域
        corsConfiguration.addAllowedMethod("*");//允许某些请求方式进行跨域
        corsConfiguration.addAllowedOrigin("*");//允许某些请求来源进行跨域
        corsConfiguration.setAllowCredentials(true);//是否允许带cookie请求进行跨域


        source.registerCorsConfiguration("/**",corsConfiguration);


        return new CorsWebFilter(source);
    }
}
