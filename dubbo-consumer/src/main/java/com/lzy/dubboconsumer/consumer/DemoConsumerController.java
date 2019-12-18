package com.lzy.dubboconsumer.consumer;/*
 *@auther chenz
 *@date 19-12-12上午10:20
 */

import com.lzy.common.web.ResponseDto;
import com.lzy.dubboapi.api.IDubboProvider;
import com.lzy.dubboapi.api.Response;
import com.alibaba.dubbo.config.annotation.Reference;
import com.lzy.redis.JedisUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoConsumerController {

    @Reference(version = "${demo.service.version}",
            application = "${dubbo.application.id}",
            registry = "${dubbo.registry.id}")
    private IDubboProvider dubboProvider;

    @RequestMapping("/sayHello")
    public Response sayHello() {
        JedisUtil.setString("consumer","this is consumer");
        System.out.println(JedisUtil.getString("consumer"));
        return dubboProvider.sayHello();
    }
    @RequestMapping("/hello")
    public ResponseDto hello(){
        return dubboProvider.hello();
    }
}