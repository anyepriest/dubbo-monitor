package com.lzy.common.web;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContext implements ApplicationContextAware {
    protected static ApplicationContext context;

    public SpringContext() {
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        context = applicationContext;
    }

    public static ApplicationContext getContext() {
        return context;
    }

    public static Object getBeanByName(String pBeanName) {
        return StringUtils.isEmpty(pBeanName) ? null : context.getBean(pBeanName);
    }
}
