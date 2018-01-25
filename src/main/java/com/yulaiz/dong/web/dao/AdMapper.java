package com.yulaiz.dong.web.dao;

import com.yulaiz.dong.web.model.entity.AdInfo;
import com.yulaiz.dong.web.model.vo.AdVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by YuLai on 2018/1/19.
 */
@Mapper
@Repository
public interface AdMapper {
    AdVo getAdById(@Param("id") String id);

    List<AdVo> getAdList();

    int countAdList();

    List<AdVo> getAdListByPage(@Param("offset") int offset, @Param("size") int size);

    int addAd(@Param("item") AdInfo adInfo);

    int modifyAd(@Param("item") AdInfo adInfo);

    int delAdById(@Param("item") AdInfo adInfo);
}
