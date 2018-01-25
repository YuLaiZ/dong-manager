package com.yulaiz.dong.web.dao;

import com.yulaiz.dong.web.model.entity.BookUpdateTimeInfo;
import com.yulaiz.dong.web.model.vo.BookUpdateTimeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by YuLai on 2018/1/19.
 */
@Mapper
@Repository
public interface BookUpdateTimeMapper {

    int addBookUpdateTime(@Param("item") BookUpdateTimeInfo bookUpdateTimeInfo);

    BookUpdateTimeVo getNearestTime();
}
