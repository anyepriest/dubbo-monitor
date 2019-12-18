package com.lzy.provider.server;/*
 *@auther chenz
 *@date 19-12-12上午10:39
 */

import com.alibaba.dubbo.config.annotation.Service;
import com.lzy.common.cns.LZYDE;
import com.lzy.common.exception.LZYException;
import com.lzy.common.utils.SerialNoUtils;
import com.lzy.common.utils.SpringUtils;
import com.lzy.common.web.ResponseDto;
import com.lzy.dubbo.db.dao.MonitorUserMapper;
import com.lzy.dubbo.db.dto.MonitorUser;
import com.lzy.dubboapi.api.IDubboProvider;
import com.lzy.dubboapi.api.Response;
import com.lzy.mongodb.MongoDbUtils;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;

@Service(
        version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class DubboProvider implements IDubboProvider {
    @Autowired
    MonitorUserMapper mMonitorUserMapper;
    @Override
    public Response sayHello() {

        MongoDbUtils mongoDbUtils=new MongoDbUtils();
    Document  document=mongoDbUtils.findById("collection_test","5df32ee4dc1956535c6464d3");
//        JedisUtil.setString("lwt","hello");
//        return new Response(JedisUtil.getString("lwt"));

        return new Response(document.getString("age"));
    }

    @Override
    public ResponseDto hello() {
        try{
            MonitorUser userDto = new MonitorUser();
            userDto.setUserName("lwt");
            userDto.setPassword("123");
            userDto.setRole("system");
            userDto.setStatus("valid");
            userDto.setUserKey(SerialNoUtils.getSerialNo());
            userDto.seteMail("2277506759@qq.com");
            mMonitorUserMapper.insert(userDto);
            MonitorUser selectUser = new MonitorUser();
            selectUser.setUserKey(userDto.getUserKey());
            selectUser = mMonitorUserMapper.select(selectUser).get(0);
            return SpringUtils.returnSuccess(selectUser);
        }catch (LZYException ex){
//            log.debug(ex.getMessage());
            return SpringUtils.returnError(ex.getMessage());
        }catch (Throwable ex){
//            log.error("", ex);
            return SpringUtils.returnInfo(LZYDE.SYS_EXCEPTION, null);
        }
    }
}
