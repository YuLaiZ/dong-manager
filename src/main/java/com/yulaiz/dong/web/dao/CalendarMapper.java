package com.yulaiz.dong.web.dao;

import com.yulaiz.dong.web.model.entity.CalendarInfo;
import com.yulaiz.dong.web.model.vo.CalendarVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by YuLai on 2018/1/18.
 */
@Mapper
@Repository
public interface CalendarMapper {

    CalendarVo getCalendarById(@Param("id") String id);

    List<CalendarVo> getCalendarList();

    int countCalendarList();

    List<CalendarVo> getCalendarListByPage(@Param("offset") int offset, @Param("size") int size);

    List<CalendarVo> getCalendarListByWeeks(@Param("weeksBegin") int weeksBegin, @Param("weeksSize") int weeksSize);

    int addCalendar(@Param("item") CalendarInfo calendarInfo);

    int modifyCalendar(@Param("item") CalendarInfo calendarInfo);

    int delCalendarById(@Param("item") CalendarInfo calendarInfo);

}
