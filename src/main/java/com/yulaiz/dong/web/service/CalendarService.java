package com.yulaiz.dong.web.service;

import com.yulaiz.dong.web.model.entity.UserInfo;
import com.yulaiz.dong.web.model.vo.CalendarListVo;
import com.yulaiz.dong.web.model.vo.CalendarVo;

import java.util.Date;

/**
 * Created by YuLai on 2018/1/18.
 */
public interface CalendarService {

    CalendarVo getCalendarById(String id);

    CalendarListVo getCalendarList();

    CalendarListVo getCalendarListByPage(int page, int size);

    boolean addCalendar(Date days, String title, String description, String remark, UserInfo userInfo);

    boolean modifyCalendar(String id, Date days, String title, String description, String remark, UserInfo userInfo);

    boolean delCalendarById(String id, UserInfo userInfo);
}
