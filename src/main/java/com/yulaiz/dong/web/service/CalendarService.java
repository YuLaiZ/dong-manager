package com.yulaiz.dong.web.service;

import com.yulaiz.dong.web.model.entity.UserInfo;
import com.yulaiz.dong.web.model.vo.CalendarListVo;
import com.yulaiz.dong.web.model.vo.CalendarVo;

/**
 * Created by YuLai on 2018/1/18.
 */
public interface CalendarService {

    CalendarVo getCalendarById(String id);

    CalendarListVo getCalendarList();

    CalendarListVo getCalendarListByWeeks(int weeksBegin, int weeksSize);

    boolean addCalendar(String days, String title, String description, String remark, UserInfo userInfo);

    boolean modifyCalendar(String id, String days, String title, String description, String remark, UserInfo userInfo);

    boolean delCalendarById(String id, UserInfo userInfo);
}
