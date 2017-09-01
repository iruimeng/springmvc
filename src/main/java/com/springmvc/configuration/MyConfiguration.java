package com.springmvc.configuration;

import com.springmvc.interceptor.TimeIterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by mengrui-g on 2017/9/1.
 */

@Configuration
public class MyConfiguration extends WebMvcConfigurerAdapter {

    public void addInterceptors(InterceptorRegistry ir) {
        System.out.println("come!!!");
        ir.addInterceptor(new TimeIterceptor()).addPathPatterns("/*");
    }
}
