package com.lzy.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;

import java.util.Properties;

public class FileUtils {
    /**
     * 获取默认配置及application.yml中配置
     * @return
     */
    public static Properties getDefaultConfig() {
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("application.yml"));
        Properties ps = yaml.getObject();
        return ps;
    }

    /**
     * 获取指定yml文件配置
     * @param fileName
     * @return
     */
    public static Properties getYmlFileConfig(String fileName) {
        if(StringUtils.isEmpty(fileName)) getDefaultConfig();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource(fileName));
        Properties ps = yaml.getObject();
        return ps;
    }
}
