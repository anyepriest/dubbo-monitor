package com.lzy.consumer.intercepter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


@Component
public class InterceptorConfiguration extends WebMvcConfigurationSupport {


    @Autowired
    private AjaxDomainInterceptor ajaxDomainInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        //配置拦截器

        registry.addInterceptor(ajaxDomainInterceptor).addPathPatterns("/**");
    }
}
