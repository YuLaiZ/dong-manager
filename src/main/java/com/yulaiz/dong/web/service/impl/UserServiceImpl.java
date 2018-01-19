package com.yulaiz.dong.web.service.impl;

import com.yulaiz.dong.web.common.exception.ExeResultException;
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

    private final static String ACCESS_TOKEN = "ACCESS_TOKEN_";


    @Override
    public String login(String userName, String password) {
        UserInfo userInfo = userMapper.checkUser(userName, password);
        if (userInfo == null) {
            throw new ExeResultException("用户名或密码错误");
        }
        String token = ACCESS_TOKEN + UUIDUtil.getUUID();
        stringRedisTemplate.opsForValue().set(token, userInfo.getId(), 24 * 60L, TimeUnit.MINUTES);
        return token;
    }

    @Override
    public UserInfo getUserByToken(String token) {
        String userId = stringRedisTemplate.opsForValue().get(token);
        if (userId == null) {
            throw new ExeResultException("无效token");
        }
        UserInfo userInfo = userMapper.getUserById(userId);
        if (userInfo == null) {
            throw new ExeResultException("无效token");
        }
        return userInfo;
    }
}
