package com.lzy.common.cns;

import com.lzy.common.utils.FileUtils;

import java.util.Properties;

public class LZYCNS {
    public static final Properties APPLICATION_FILE = FileUtils.getDefaultConfig();
    public static final String SERVICE_ID = APPLICATION_FILE.getProperty("service.id");
}
