package com.lzy.dubboapi.api;/*
 *@auther chenz
 *@date 19-12-12上午10:08
 */

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Response implements Serializable {
    String result;
}
