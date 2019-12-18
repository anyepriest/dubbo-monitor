package com.lzy.dubboapi.api;/*
 *@auther chenz
 *@date 19-12-12上午10:07
 */


import com.lzy.common.web.ResponseDto;

public interface IDubboProvider {

    Response sayHello();
    ResponseDto hello();
}
