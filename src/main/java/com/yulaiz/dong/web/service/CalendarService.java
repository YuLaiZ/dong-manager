package com.yulaiz.dong.web.service;

import com.yulaiz.dong.web.model.entity.CalendarInfo;

import java.util.List;

/**
 * Created by YuLai on 2018/1/18.
 */
public interface CalendarService {

    CalendarInfo getCalendarById(String id);

    List<CalendarInfo> getCalendarList();

    List<CalendarInfo> getCalendarListByPage(int page, int size);

    boolean addCalendar(String title, String description, String remark);

    boolean modifyCalendar(String id, String title, String description, String remark);

    boolean delCalendarById(String id);
}
