package com.lzy.constant;/*
 *@auther chenz
 *@date 19-12-13下午2:55
 */

public  enum constProps {
    MONGODB_URL("mongodb_url","mongodb://127.0.0.1:27017"),
    LINK_LIMIT("link_limit","50"),
    DATABASE_NAME("database_name","test");


    private String value;

    constProps(String key, String value) {
        this.value = value;
        this.key = key;
    }

    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
