package com.yulaiz.dong.web.controller;

import com.yulaiz.dong.web.common.response.ExeResult;
import com.yulaiz.dong.web.controller.req.calendar.*;
import com.yulaiz.dong.web.service.CalendarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "日历模块", value = "日历模块")
public class CalendarController {
    @Autowired
    private CalendarService calendarService;

    @ApiOperation(value = "获取指定", notes = "获取指定日历")
    @RequestMapping(value = "/get-by-id", method = RequestMethod.POST)
    public ExeResult getCalendarById(@RequestBody CalendarGetByIdReq req) {
        return ExeResult.getInstance(calendarService.getCalendarById(req.getId()));
    }

    @ApiOperation(value = "获取所有", notes = "获取所有日历")
    @RequestMapping(value = "/get-list", method = RequestMethod.POST)
    public ExeResult getCalendarList() {
        return ExeResult.getInstance(calendarService.getCalendarList());
    }

    @ApiOperation(value = "分页获取", notes = "分页获取日历")
    @RequestMapping(value = "/get-list-by-page", method = RequestMethod.POST)
    public ExeResult getCalendarListByPage(@RequestBody CalendarGetByPageReq req) {
        return ExeResult.getInstance(calendarService.getCalendarListByPage(req.getPage(), req.getSize()));
    }

    @ApiOperation(value = "新增", notes = "新增一条日历")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ExeResult addCalendar(@RequestBody CalendarAddReq req) {
        return ExeResult.getInstance(calendarService.addCalendar(req.getTitle(), req.getDescription(), req.getRemark()));
    }

    @ApiOperation(value = "修改", notes = "修改指定日历")
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public ExeResult modifyCalendar(@RequestBody CalendarModifyReq req) {
        return ExeResult.getInstance(calendarService.modifyCalendar(req.getId(), req.getTitle(), req.getDescription(), req.getRemark()));
    }

    @ApiOperation(value = "删除", notes = "删除指定日历")
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public ExeResult modifyCalendar(@RequestBody CalendarDelByIdReq req) {
        return ExeResult.getInstance(calendarService.delCalendarById(req.getId()));
    }
}
