package com.yulaiz.dong.web.controller;

import com.yulaiz.dong.web.common.annotation.CurrentUser;
import com.yulaiz.dong.web.common.annotation.IgnoreSecurity;
import com.yulaiz.dong.web.common.response.ExeResult;
import com.yulaiz.dong.web.controller.req.calendar.*;
import com.yulaiz.dong.web.model.entity.UserInfo;
import com.yulaiz.dong.web.service.CalendarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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

    @IgnoreSecurity
    @ApiOperation(value = "获取指定", notes = "获取指定日历")
    @RequestMapping(value = "/get-by-id", method = RequestMethod.POST)
    public ExeResult getCalendarById(@RequestBody @Validated CalendarGetByIdReq req) {
        return ExeResult.getInstance(calendarService.getCalendarById(req.getId()));
    }

    @IgnoreSecurity
    @ApiOperation(value = "获取所有", notes = "获取所有日历")
    @RequestMapping(value = "/get-list", method = RequestMethod.POST)
    public ExeResult getCalendarList() {
        return ExeResult.getInstance(calendarService.getCalendarList());
    }

    @IgnoreSecurity
    @ApiOperation(value = "根据周数获取", notes = "根据周数获取日历")
    @RequestMapping(value = "/get-list-by-weeks", method = RequestMethod.POST)
    public ExeResult getCalendarListByWeeks(@RequestBody @Validated CalendarGetByWeeksReq req) {
        return ExeResult.getInstance(calendarService.getCalendarListByWeeks(req.getWeeksBegin(), req.getWeeksSize()));
    }

    @ApiOperation(value = "新增", notes = "新增一条日历")
    @ApiImplicitParams({@ApiImplicitParam(name = "ACCESS_TOKEN", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ExeResult addCalendar(@RequestBody @Validated CalendarAddReq req, @CurrentUser UserInfo userInfo) {
        return ExeResult.getInstance(calendarService.addCalendar(req.getTitle(), req.getDescription(), req.getRemark(), userInfo));
    }

    @ApiOperation(value = "修改", notes = "修改指定日历")
    @ApiImplicitParams({@ApiImplicitParam(name = "ACCESS_TOKEN", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public ExeResult modifyCalendar(@RequestBody @Validated CalendarModifyReq req, @CurrentUser UserInfo userInfo) {
        return ExeResult.getInstance(
                calendarService.modifyCalendar(
                        req.getId(),
                        req.getTitle(),
                        req.getDescription(),
                        req.getRemark(),
                        userInfo));
    }

    @ApiOperation(value = "删除", notes = "删除指定日历")
    @ApiImplicitParams({@ApiImplicitParam(name = "ACCESS_TOKEN", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public ExeResult modifyCalendar(@RequestBody @Validated CalendarDelByIdReq req, @CurrentUser UserInfo userInfo) {
        return ExeResult.getInstance(calendarService.delCalendarById(req.getId(), userInfo));
    }
}
