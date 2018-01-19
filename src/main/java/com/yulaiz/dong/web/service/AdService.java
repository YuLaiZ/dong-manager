package com.yulaiz.dong.web.service;

import com.yulaiz.dong.web.model.entity.AdInfo;
import com.yulaiz.dong.web.model.vo.AdServiceListVo;

/**
 * Created by YuLai on 2018/1/19.
 */
public interface AdService {

    AdInfo getAdById(String id);

    AdServiceListVo getAdList();

    AdServiceListVo getAdListByPage(int page, int size);

    boolean addAd(String title, String description);

    boolean modifyAd(String id, String title, String description);

    boolean delAdById(String id);
}
