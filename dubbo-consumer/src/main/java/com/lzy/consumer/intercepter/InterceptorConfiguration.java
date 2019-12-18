package com.lzy.consumer.intercepter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class InterceptorConfiguration extends WebMvcConfigurerAdapter {
    public void addInterceptors(InterceptorRegistry registry) {
        //配置拦截器
        AjaxDomainInterceptor ajaxDomain = new AjaxDomainInterceptor();
        registry.addInterceptor(ajaxDomain).addPathPatterns("/**");
    }
}
