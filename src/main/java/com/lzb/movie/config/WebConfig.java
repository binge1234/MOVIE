package com.lzb.movie.config;

/*
*
* 配置拦截器的配置类
* */

import com.lzb.movie.common.inteceptor.ExceptionInteceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Bean
    public ExceptionInteceptor exceptionInteceptor(){
        return new ExceptionInteceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(exceptionInteceptor()).addPathPatterns("/hello/**");
        super.addInterceptors(registry);
    }

}
