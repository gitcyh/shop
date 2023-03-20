package com.cyh.shop.config;

import com.cyh.shop.interceptor.JwtInterceptor;
import com.cyh.shop.interceptor.WXJwtInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor())
                .addPathPatterns("/pc/**")  //拦截所有请求，通过判断token是否合法来判断是否需要登录
                .excludePathPatterns("/pc/login","/pc/register","/pc/forget","/pc/editor/download","/**/export","/**/import");   //排除规则

        registry.addInterceptor(wxjwtInterceptor())
                .addPathPatterns("/wx/**")  //拦截所有请求，通过判断token是否合法来判断是否需要登录
                .excludePathPatterns("/wx/login","/wx/getIndexGoods","/wx/getGoodsList","/wx/download","/**/export","/**/import");   //排除规则

    }

    @Bean
    public HandlerInterceptor jwtInterceptor(){
        return new JwtInterceptor();
    }

    @Bean
    public HandlerInterceptor wxjwtInterceptor(){return new WXJwtInterceptor();}
}
