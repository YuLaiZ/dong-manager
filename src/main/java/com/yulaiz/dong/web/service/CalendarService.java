package com.yulaiz.dong.web.service;

import com.yulaiz.dong.web.model.entity.CalendarInfo;
import com.yulaiz.dong.web.model.vo.CalendarListVo;

/**
 * Created by YuLai on 2018/1/18.
 */
public interface CalendarService {

    CalendarInfo getCalendarById(String id);

    CalendarListVo getCalendarList();

    CalendarListVo getCalendarListByWeeks(int weeksBegin, int weeksSize);

    boolean addCalendar(String title, String description, String remark);

    boolean modifyCalendar(String id, String title, String description, String remark);

    boolean delCalendarById(String id);
}
