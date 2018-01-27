package com.yulaiz.dong.web.service.impl;

import com.yulaiz.dong.web.common.exception.ExeResultException;
import com.yulaiz.dong.web.dao.CalendarMapper;
import com.yulaiz.dong.web.model.entity.CalendarInfo;
import com.yulaiz.dong.web.model.entity.UserInfo;
import com.yulaiz.dong.web.model.vo.CalendarListVo;
import com.yulaiz.dong.web.model.vo.CalendarVo;
import com.yulaiz.dong.web.service.CalendarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    @Resource
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
    public CalendarVo getCalendarById(String id) {
        CalendarVo calendarVo = (CalendarVo) redisTemplate.opsForValue().get(REDIS_HEADER + id);
        if (calendarVo == null) {
            calendarVo = calendarMapper.getCalendarById(id);
            redisTemplate.opsForValue().set(REDIS_HEADER + id, calendarVo);
        }
        return calendarVo;
    }

    @Override
    public CalendarListVo getCalendarList() {
        List<CalendarVo> calendarVos = (List<CalendarVo>) redisTemplate.opsForValue().get(REDIS_LIST_HEADER + "ALL");
        if (calendarVos == null) {
            calendarVos = calendarMapper.getCalendarList();
            redisTemplate.opsForValue().set(REDIS_LIST_HEADER + "ALL", calendarVos);
        }
        CalendarListVo calendarListVo = new CalendarListVo();
        calendarListVo.setList(calendarVos);
        calendarListVo.setTotal(getTotal());
        return calendarListVo;
    }

    @Override
    public CalendarListVo getCalendarListByWeeks(int weeksBegin, int weeksSize) {
        List<CalendarVo> calendarVos = (List<CalendarVo>) redisTemplate.opsForValue().get(REDIS_LIST_HEADER + weeksBegin + "_" + weeksSize);
        if (calendarVos == null) {
            calendarVos = calendarMapper.getCalendarListByWeeks(weeksBegin, weeksSize);
            redisTemplate.opsForValue().set(REDIS_LIST_HEADER + weeksBegin + "_" + weeksSize, calendarVos);
        }
        CalendarListVo calendarListVo = new CalendarListVo();
        calendarListVo.setList(calendarVos);
        calendarListVo.setTotal(getTotal());
        return calendarListVo;
    }

    private int getTotal() {
        Object total = redisTemplate.opsForValue().get(REDIS_TOTAL);
        if (total == null) {
            total = calendarMapper.countCalendarList();
            redisTemplate.opsForValue().set(REDIS_TOTAL, total);
        }
        return (Integer) total;
    }

    @Override
    public synchronized boolean addCalendar(String days, String title, String description, String remark, UserInfo userInfo) {
        if (calendarMapper.hasExistCalendarByDays(days)) {
            throw new ExeResultException("已存在相同的日历天数，请检查后重试");
        }
        CalendarInfo calendarInfo = new CalendarInfo();
        calendarInfo.setDays(days);
        calendarInfo.setTitle(title);
        calendarInfo.setDescription(description);
        calendarInfo.setRemark(remark);
        calendarInfo.setUserId(userInfo.getId());
        if (calendarMapper.addCalendar(calendarInfo) == 1) {
            clearRedis();
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyCalendar(String id, String days, String title, String description, String remark, UserInfo userInfo) {
        CalendarInfo calendarInfo = new CalendarInfo();
        calendarInfo.setId(id);
        calendarInfo.setDays(days);
        calendarInfo.setTitle(title);
        calendarInfo.setDescription(description);
        calendarInfo.setRemark(remark);
        calendarInfo.setUserId(userInfo.getId());
        if (calendarMapper.modifyCalendar(calendarInfo) == 1) {
            clearRedis();
            return true;
        }
        return false;
    }

    @Override
    public boolean delCalendarById(String id, UserInfo userInfo) {
        CalendarInfo calendarInfo = new CalendarInfo();
        calendarInfo.setId(id);
        calendarInfo.setUserId(userInfo.getId());
        if (calendarMapper.delCalendarById(calendarInfo) == 1) {
            clearRedis();
            return true;
        }
        return false;
    }
}
