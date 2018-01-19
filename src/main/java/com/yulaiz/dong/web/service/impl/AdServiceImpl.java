package com.yulaiz.dong.web.service.impl;

import com.yulaiz.dong.web.dao.AdMapper;
import com.yulaiz.dong.web.model.entity.AdInfo;
import com.yulaiz.dong.web.model.vo.AdServiceListVo;
import com.yulaiz.dong.web.service.AdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by YuLai on 2018/1/19.
 */
@Service
@Slf4j
public class AdServiceImpl implements AdService {

    @Autowired
    private AdMapper adMapper;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private final static String REDIS_HEADER = "AD_";
    private final static String REDIS_LIST_HEADER = "AD_LIST_";
    private final static String REDIS_TOTAL = "AD_TOTAL";

    private void clearRedis() {
        Set<String> keys = redisTemplate.keys(REDIS_HEADER + "*");
        redisTemplate.delete(keys);
        redisTemplate.delete(REDIS_TOTAL);
    }

    @Override
    public AdInfo getAdById(String id) {
        AdInfo adInfo = (AdInfo) redisTemplate.opsForValue().get(REDIS_HEADER + id);
        if (adInfo == null) {
            adInfo = adMapper.getAdById(id);
            redisTemplate.opsForValue().set(REDIS_HEADER + id, adInfo);
        }
        return adInfo;
    }

    @Override
    public AdServiceListVo getAdList() {
        Object total = redisTemplate.opsForValue().get(REDIS_TOTAL);
        if (total == null) {
            total = adMapper.countAdList();
            redisTemplate.opsForValue().set(REDIS_TOTAL, total);
        }
        AdServiceListVo adServiceListVo = new AdServiceListVo();
        adServiceListVo.setList(adMapper.getAdList());
        adServiceListVo.setTotal((Integer) total);
        return adServiceListVo;
    }

    @Override
    public AdServiceListVo getAdListByPage(int page, int size) {
        AdServiceListVo adServiceListVo = new AdServiceListVo();
        List<AdInfo> adInfos = (List<AdInfo>) redisTemplate.opsForValue().get(REDIS_LIST_HEADER + page + "_" + size);
        if (adInfos == null) {
            adInfos = adMapper.getAdListByPage((page - 1) * size, size);
            redisTemplate.opsForValue().set(REDIS_LIST_HEADER + page + "_" + size, adInfos);
        }
        Object total = redisTemplate.opsForValue().get(REDIS_TOTAL);
        if (total == null) {
            total = adMapper.countAdList();
            redisTemplate.opsForValue().set(REDIS_TOTAL, total);
        }
        adServiceListVo.setList(adInfos);
        adServiceListVo.setTotal((Integer) total);
        return adServiceListVo;
    }

    @Override
    public boolean addAd(String title, String description) {
        AdInfo AdInfo = new AdInfo();
        AdInfo.setTitle(title);
        AdInfo.setDescription(description);
        if (adMapper.addAd(AdInfo) == 1) {
            clearRedis();
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyAd(String id, String title, String description) {
        AdInfo AdInfo = new AdInfo();
        AdInfo.setId(id);
        AdInfo.setTitle(title);
        AdInfo.setDescription(description);
        if (adMapper.modifyAd(AdInfo) == 1) {
            clearRedis();
            return true;
        }
        return false;
    }

    @Override
    public boolean delAdById(String id) {
        if (adMapper.delAdById(id) == 1) {
            clearRedis();
            return true;
        }
        return false;
    }
}
