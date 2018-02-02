package com.yulaiz.dong.web.service.impl;

import com.yulaiz.dong.web.common.exception.ExeResultException;
import com.yulaiz.dong.web.common.utils.StringUtil;
import com.yulaiz.dong.web.dao.BookUpdateTimeMapper;
import com.yulaiz.dong.web.model.entity.BookUpdateTimeInfo;
import com.yulaiz.dong.web.model.entity.UserInfo;
import com.yulaiz.dong.web.model.vo.BookUpdateTimeVo;
import com.yulaiz.dong.web.service.BookUpdateTimeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;

/**
 * Created by YuLai on 2018/1/19.
 */
@Service
@Slf4j
public class BookUpdateTimeServiceImpl implements BookUpdateTimeService {

    @Autowired
    private BookUpdateTimeMapper bookUpdateTimeMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    private final static String REDIS_KEY = "BOOK_UPDATE_TIME";

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public boolean addBookUpdateTime(String updateTime, UserInfo userInfo) {
        BookUpdateTimeInfo bookUpdateTimeInfo = new BookUpdateTimeInfo();
        try {
            bookUpdateTimeInfo.setUpdateTime(DATE_FORMAT.parse(updateTime));
        } catch (Exception e) {
            throw new ExeResultException("日期格式有误");
        }
        bookUpdateTimeInfo.setUserId(userInfo.getId());
        if (bookUpdateTimeMapper.addBookUpdateTime(bookUpdateTimeInfo) == 1) {
            stringRedisTemplate.delete(REDIS_KEY);
            return true;
        }
        return false;
    }

    @Override
    public String getNearestTime() {
        String nearestTime = stringRedisTemplate.opsForValue().get(REDIS_KEY);
        if (StringUtil.isEmpty(nearestTime)) {
            BookUpdateTimeVo bookUpdateTimeVo = bookUpdateTimeMapper.getNearestTime();
            if (bookUpdateTimeVo == null) {
                throw new ExeResultException("无最近更新日期");
            }
            nearestTime = DATE_FORMAT.format(bookUpdateTimeVo.getUpdateTime());
            stringRedisTemplate.opsForValue().set(REDIS_KEY, nearestTime);
        }
        return nearestTime;
    }
}
