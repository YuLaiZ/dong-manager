package com.yulaiz.dong.web.service;

import com.yulaiz.dong.web.model.entity.UserInfo;
import com.yulaiz.dong.web.model.vo.AdServiceListVo;
import com.yulaiz.dong.web.model.vo.AdVo;

/**
 * Created by YuLai on 2018/1/19.
 */
public interface AdService {

    AdVo getAdById(String id);

    AdServiceListVo getAdList();

    AdServiceListVo getAdListByPage(int page, int size);

    boolean addAd(String title, String description, UserInfo userInfo);

    boolean modifyAd(String id, String title, String description, UserInfo userInfo);

    boolean delAdById(String id, UserInfo userInfo);
}
