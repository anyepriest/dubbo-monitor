package com.lzy.consumer.service.impl;/*
 *@auther chenz
 *@date 19-12-20下午2:25
 */


import com.lzy.dubbo.db.dao.MonitorUserMapper;
import com.lzy.dubbo.db.dto.JwtUser;
import com.lzy.dubbo.db.dto.MonitorUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private MonitorUserMapper  monitorUserMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        MonitorUser monitorUser =new MonitorUser();
        monitorUser.setUserName(s);
        MonitorUser user = monitorUserMapper.selectOne(monitorUser);
        return new JwtUser(user);
    }

}