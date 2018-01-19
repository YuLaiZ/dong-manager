package com.yulaiz.dong.web.service.impl;

import com.yulaiz.dong.web.common.utils.UUIDUtil;
import com.yulaiz.dong.web.dao.UserMapper;
import com.yulaiz.dong.web.model.entity.UserInfo;
import com.yulaiz.dong.web.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created by YuLai on 2018/1/19.
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public String login(String userName, String password) {
        UserInfo userInfo = userMapper.checkUser(userName, password);
        String token = UUIDUtil.getUUID();
        stringRedisTemplate.opsForValue().set(token, userInfo.getId(), 24 * 60L, TimeUnit.MINUTES);
        return token;
    }

    @Override
    public UserInfo getUserByToken(String token) {
        String userId = stringRedisTemplate.opsForValue().get(token);
        return userMapper.getUserById(userId);
    }
}
