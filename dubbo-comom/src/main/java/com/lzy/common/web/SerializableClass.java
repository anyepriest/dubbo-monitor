package com.lzy.common.web;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

public class SerializableClass implements Serializable {
    private static final long serialVersionUID = 5258016247869947421L;

    public SerializableClass() {
    }

    public String toString() {
        String s = null;

        try {
            s = JSON.toJSONString(this);
        } catch (Exception var3) {
            s = ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
        }

        return s;
    }

    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    public int hashcode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
