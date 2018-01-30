package com.yulaiz.dong.web.service;

import com.yulaiz.dong.web.model.entity.UserInfo;

/**
 * Created by YuLai on 2018/1/19.
 */
public interface UserService {
    String login(String userName, String password);

    UserInfo getUserByToken(String token);

    String getRegisterLink(String remark, UserInfo userInfo, String url);

    boolean register(String token, String userName, String password);
}
