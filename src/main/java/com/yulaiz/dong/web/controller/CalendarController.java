package com.yulaiz.dong.web.controller;

import com.yulaiz.dong.web.common.response.ExeResult;
import com.yulaiz.dong.web.controller.req.*;
import com.yulaiz.dong.web.service.CalendarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YuLai on 2018/1/18.
 */
@Slf4j
@RestController
@RequestMapping("/calendar")
public class CalendarController {
    @Autowired
    private CalendarService calendarService;

    @RequestMapping(value = "/get-by-id", method = RequestMethod.POST)
    public ExeResult getCalendarById(@RequestBody CalendarGetByIdReq req) {
        return ExeResult.getInstance(calendarService.getCalendarById(req.getId()));
    }

    @RequestMapping(value = "/get-list", method = RequestMethod.POST)
    public ExeResult getCalendarList() {
        return ExeResult.getInstance(calendarService.getCalendarList());
    }

    @RequestMapping(value = "/get-list-by-page", method = RequestMethod.POST)
    public ExeResult getCalendarListByPage(@RequestBody CalendarGetByPageReq req) {
        return ExeResult.getInstance(calendarService.getCalendarListByPage(req.getPage(), req.getSize()));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ExeResult addCalendar(@RequestBody CalendarAddReq req) {
        return ExeResult.getInstance(calendarService.addCalendar(req.getTitle(), req.getDescription(), req.getRemark()));
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public ExeResult modifyCalendar(@RequestBody CalendarModifyReq req) {
        return ExeResult.getInstance(calendarService.modifyCalendar(req.getId(), req.getTitle(), req.getDescription(), req.getRemark()));
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public ExeResult modifyCalendar(@RequestBody CalendarDelByIdReq req) {
        return ExeResult.getInstance(calendarService.delCalendarById(req.getId()));
    }
}
