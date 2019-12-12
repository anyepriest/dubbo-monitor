package com.lzy.dubboprovider.server;/*
 *@auther chenz
 *@date 19-12-12上午10:39
 */

import com.alibaba.dubbo.config.annotation.Service;
import com.lzy.dubboapi.api.IDubboProvider;
import com.lzy.dubboapi.api.Response;

@Service(
        version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class DubboProvider implements IDubboProvider {

    @Override
    public Response sayHello() {
        return new Response("connect success!!");
    }
}
