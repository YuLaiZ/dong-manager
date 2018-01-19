package com.yulaiz.dong.web.service;

import com.yulaiz.dong.web.model.entity.BookUpdateTimeInfo;

/**
 * Created by YuLai on 2018/1/19.
 */
public interface BookUpdateTimeService {

    boolean addBookUpdateTime(String updateTime);

    BookUpdateTimeInfo getNearestTime();
}
