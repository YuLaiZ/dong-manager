package com.yulaiz.dong.web.service.impl;

import com.yulaiz.dong.web.dao.CalendarMapper;
import com.yulaiz.dong.web.model.entity.CalendarInfo;
import com.yulaiz.dong.web.service.CalendarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YuLai on 2018/1/18.
 */
@Service
@Slf4j
public class CalendarServiceImpl implements CalendarService {

    @Autowired
    private CalendarMapper calendarMapper;

    @Override
    public CalendarInfo getCalendarById(String id) {
        return calendarMapper.getCalendarById(id);
    }

    @Override
    public List<CalendarInfo> getCalendarList() {
        return calendarMapper.getCalendarList();
    }

    @Override
    public List<CalendarInfo> getCalendarListByPage(int page, int size) {
        return calendarMapper.getCalendarListByPage(page * size, size);
    }

    @Override
    public boolean addCalendar(String title, String description, String remark) {
        CalendarInfo calendarInfo = new CalendarInfo();
        calendarInfo.setTitle(title);
        calendarInfo.setDescription(description);
        calendarInfo.setRemark(remark);
        return calendarMapper.addCalendar(calendarInfo) == 1;
    }

    @Override
    public boolean modifyCalendar(String id, String title, String description, String remark) {
        CalendarInfo calendarInfo = new CalendarInfo();
        calendarInfo.setId(id);
        calendarInfo.setTitle(title);
        calendarInfo.setDescription(description);
        calendarInfo.setRemark(remark);
        return calendarMapper.modifyCalendar(calendarInfo) == 1;
    }

    @Override
    public boolean delCalendarById(String id) {
        return calendarMapper.delCalendarById(id) == 1;
    }
}
