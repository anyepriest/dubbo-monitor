package com.lzy.common.web;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto<T> extends SerializableClass {
    private static final long serialVersionUID = -7658545820599061388L;
    private String code;
    private String message;
    private T data;

    public ResponseDto() {
    }

}
