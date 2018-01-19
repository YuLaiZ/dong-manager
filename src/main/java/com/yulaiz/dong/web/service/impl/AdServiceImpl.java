package com.yulaiz.dong.web.service.impl;

import com.yulaiz.dong.web.dao.AdMapper;
import com.yulaiz.dong.web.model.entity.AdInfo;
import com.yulaiz.dong.web.service.AdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YuLai on 2018/1/19.
 */
@Service
@Slf4j
public class AdServiceImpl implements AdService {

    @Autowired
    private AdMapper adMapper;

    @Override
    public AdInfo getAdById(String id) {
        return adMapper.getAdById(id);
    }

    @Override
    public List<AdInfo> getAdList() {
        return adMapper.getAdList();
    }

    @Override
    public List<AdInfo> getAdListByPage(int page, int size) {
        return adMapper.getAdListByPage(page * size, size);
    }

    @Override
    public boolean addAd(String title, String description) {
        AdInfo AdInfo = new AdInfo();
        AdInfo.setTitle(title);
        AdInfo.setDescription(description);
        return adMapper.addAd(AdInfo) == 1;
    }

    @Override
    public boolean modifyAd(String id, String title, String description) {
        AdInfo AdInfo = new AdInfo();
        AdInfo.setId(id);
        AdInfo.setTitle(title);
        AdInfo.setDescription(description);
        return adMapper.modifyAd(AdInfo) == 1;
    }

    @Override
    public boolean delAdById(String id) {
        return adMapper.delAdById(id) == 1;
    }
}
