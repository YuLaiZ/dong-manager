package com.yulaiz.dong.web.service;

/**
 * Created by YuLai on 2018/1/19.
 */
public interface BookUpdateTimeService {

    boolean addBookUpdateTime(String updateTime);

    String getNearestTime();
}
