package com.yulaiz.dong.web.service.impl;

import com.yulaiz.dong.web.dao.CalendarMapper;
import com.yulaiz.dong.web.model.entity.CalendarInfo;
import com.yulaiz.dong.web.model.vo.CalendarListVo;
import com.yulaiz.dong.web.service.CalendarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by YuLai on 2018/1/18.
 */
@Service
@Slf4j
public class CalendarServiceImpl implements CalendarService {

    @Autowired
    private CalendarMapper calendarMapper;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private final static String REDIS_HEADER = "CALENDAR_";
    private final static String REDIS_LIST_HEADER = "CALENDAR_LIST_";
    private final static String REDIS_TOTAL = "CALENDAR_TOTAL";

    private void clearRedis() {
        Set<String> keys = redisTemplate.keys(REDIS_HEADER + "*");
        redisTemplate.delete(keys);
        redisTemplate.delete(REDIS_TOTAL);
    }

    @Override
    public CalendarInfo getCalendarById(String id) {
        CalendarInfo calendarInfo = (CalendarInfo) redisTemplate.opsForValue().get(REDIS_HEADER + id);
        if (calendarInfo == null) {
            calendarInfo = calendarMapper.getCalendarById(id);
            redisTemplate.opsForValue().set(REDIS_HEADER + id, calendarInfo);
        }
        return calendarInfo;
    }

    @Override
    public CalendarListVo getCalendarList() {
        Object total = redisTemplate.opsForValue().get(REDIS_TOTAL);
        if (total == null) {
            total = calendarMapper.countCalendarList();
            redisTemplate.opsForValue().set(REDIS_TOTAL, total);
        }
        CalendarListVo calendarListVo = new CalendarListVo();
        calendarListVo.setList(calendarMapper.getCalendarList());
        calendarListVo.setTotal((Integer) total);
        return calendarListVo;
    }

    @Override
    public CalendarListVo getCalendarListByWeeks(int weeksBegin, int weeksSize) {
        CalendarListVo calendarListVo = new CalendarListVo();
        List<CalendarInfo> calendarInfos = (List<CalendarInfo>) redisTemplate.opsForValue().get(REDIS_LIST_HEADER + weeksBegin + "_" + weeksSize);
        if (calendarInfos == null) {
            calendarInfos = calendarMapper.getCalendarListByWeeks(weeksBegin, weeksSize);
            redisTemplate.opsForValue().set(REDIS_LIST_HEADER + weeksBegin + "_" + weeksSize, calendarInfos);
        }
        Object total = redisTemplate.opsForValue().get(REDIS_TOTAL);
        if (total == null) {
            total = calendarMapper.countCalendarList();
            redisTemplate.opsForValue().set(REDIS_TOTAL, total);
        }
        calendarListVo.setList(calendarInfos);
        calendarListVo.setTotal((Integer) total);
        return calendarListVo;
    }

    @Override
    public boolean addCalendar(String title, String description, String remark) {
        CalendarInfo calendarInfo = new CalendarInfo();
        calendarInfo.setTitle(title);
        calendarInfo.setDescription(description);
        calendarInfo.setRemark(remark);
        if (calendarMapper.addCalendar(calendarInfo) == 1) {
            clearRedis();
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyCalendar(String id, String title, String description, String remark) {
        CalendarInfo calendarInfo = new CalendarInfo();
        calendarInfo.setId(id);
        calendarInfo.setTitle(title);
        calendarInfo.setDescription(description);
        calendarInfo.setRemark(remark);
        if (calendarMapper.modifyCalendar(calendarInfo) == 1) {
            clearRedis();
            return true;
        }
        return false;
    }

    @Override
    public boolean delCalendarById(String id) {
        if (calendarMapper.delCalendarById(id) == 1) {
            clearRedis();
            return true;
        }
        return false;
    }
}
