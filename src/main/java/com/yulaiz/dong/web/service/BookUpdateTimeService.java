package com.yulaiz.dong.web.service;

import com.yulaiz.dong.web.model.entity.UserInfo;

import java.util.Date;

/**
 * Created by YuLai on 2018/1/19.
 */
public interface BookUpdateTimeService {

    boolean addBookUpdateTime(Date updateTime, UserInfo userInfo);

    String getNearestTime();
}
