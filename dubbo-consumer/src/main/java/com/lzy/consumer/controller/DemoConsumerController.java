package com.lzy.consumer.controller;/*
 *@auther chenz
 *@date 19-12-12上午10:20
 */

import com.lzy.common.web.ResponseDto;
import com.lzy.dubboapi.api.IDubboProvider;
import com.lzy.dubboapi.api.Response;
import com.alibaba.dubbo.config.annotation.Reference;
import com.lzy.redis.JedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "消费接口", tags = "消费接口", description = "")
public class DemoConsumerController {

    @Reference(version = "${demo.service.version}",
            application = "${dubbo.application.id}",
            registry = "${dubbo.registry.id}")
    private IDubboProvider dubboProvider;

    @RequestMapping(value="/sayHello",method = RequestMethod.GET)
    public Response sayHello() {
        JedisUtil.setString("controller","this is controller");
        System.out.println(JedisUtil.getString("controller"));
        return dubboProvider.sayHello();
    }
    @ApiOperation(value = "测试获取用户信息", notes = "获取用户信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful request"),
            @ApiResponse(code = 500, message = "internal server error")})
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public ResponseDto hello(){
        return dubboProvider.hello();
    }
}