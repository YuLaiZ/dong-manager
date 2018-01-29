package com.yulaiz.dong.web.service.impl;

import com.yulaiz.dong.web.common.exception.ExeResultException;
import com.yulaiz.dong.web.common.utils.UUIDUtil;
import com.yulaiz.dong.web.dao.UserMapper;
import com.yulaiz.dong.web.model.entity.UserInfo;
import com.yulaiz.dong.web.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/**
 * Created by YuLai on 2018/1/19.
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    private final static String ACCESS_TOKEN = "ACCESS_TOKEN_";

    //token超时时间（单位分）
    private static final long DEFAULT_TOKEN_EXPIRE = 30L;

    private static final Pattern REG_USER_NAME = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]{3,19}$");
    private static final Pattern REG_PASSWORD = Pattern.compile("^[A-Z0-9]{32}$");

    @Value(value = "${config.register-url}")
    private String registerUrl;

    @Override
    public String login(String userName, String password) {
        if (!REG_USER_NAME.matcher(userName).matches()
                || !REG_PASSWORD.matcher(password).matches()) {
            throw new ExeResultException("用户名或密码非法");
        }
        UserInfo userInfo = userMapper.checkUser(userName, password);
        if (userInfo == null) {
            throw new ExeResultException("用户名或密码错误");
        }
        String token = ACCESS_TOKEN + UUIDUtil.get32UUID().toUpperCase();
        stringRedisTemplate.opsForValue().set(token, userInfo.getUuid(), DEFAULT_TOKEN_EXPIRE, TimeUnit.MINUTES);
        return token;
    }

    @Override
    public UserInfo getUserByToken(String token) {
        String userId = stringRedisTemplate.opsForValue().get(token);
        if (userId == null) {
            throw new ExeResultException("无效token");
        }
        UserInfo userInfo = userMapper.getUserByUUId(userId);
        if (userInfo == null) {
            throw new ExeResultException("无效token");
        }
        return userInfo;
    }

    @Override
    public String getRegisterLink(UserInfo userInfo) {
        if (!userMapper.checkIsAdministrator(userInfo.getId())) {
            throw new ExeResultException("该用户无权限操作");
        }
        String registeredToken = UUIDUtil.get32UUID();
        stringRedisTemplate.opsForValue().set(registeredToken, registeredToken, 5L, TimeUnit.MINUTES);
        return "链接有效期为5分钟，请及时注册！ " + registerUrl + "?token=" + registeredToken;
    }

    @Override
    public boolean register(String token, String userName, String password) {
        String tokenValue = stringRedisTemplate.opsForValue().get(token);
        if (tokenValue == null) {
            throw new ExeResultException("无效token");
        }
        if (!REG_USER_NAME.matcher(userName).matches()
                || !REG_PASSWORD.matcher(password).matches()) {
            throw new ExeResultException("用户名或密码非法");
        }
        if (userMapper.hasExistUserByToken(token)) {
            throw new ExeResultException("该链接已经注册过用户");
        }
        if (userMapper.hasExistUserName(userName)) {
            throw new ExeResultException("用户名已存在请重试");
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUuid(UUIDUtil.get32UUID());
        userInfo.setUserName(userName);
        userInfo.setPassword(password);
        userInfo.setRegisterToken(token);
        return userMapper.addUser(userInfo) == 1;
    }
}
