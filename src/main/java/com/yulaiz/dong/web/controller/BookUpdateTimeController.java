package com.yulaiz.dong.web.controller;

import com.yulaiz.dong.web.common.annotation.IgnoreSecurity;
import com.yulaiz.dong.web.common.response.ExeResult;
import com.yulaiz.dong.web.controller.req.bookUpdate.BookUpdateTimeReq;
import com.yulaiz.dong.web.service.BookUpdateTimeService;
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
 * Created by YuLai on 2018/1/19.
 */
@Slf4j
@RestController
@RequestMapping("/book-update")
@Api(tags = "书更新时间模块", value = "书更新时间模块")
public class BookUpdateTimeController {
    @Autowired
    private BookUpdateTimeService bookUpdateTimeService;

    @IgnoreSecurity
    @ApiOperation(value = "获取更新时间", notes = "获取最近一次的更新时间")
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ExeResult getNearestTime() {
        return ExeResult.getInstance(bookUpdateTimeService.getNearestTime());
    }

    @ApiOperation(value = "更新", notes = "更新最近一次的更新时间")
    @ApiImplicitParams({@ApiImplicitParam(name = "ACCESS_TOKEN", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ExeResult updateTime(@RequestBody @Validated BookUpdateTimeReq req) {
        return ExeResult.getInstance(bookUpdateTimeService.addBookUpdateTime(req.getUpdateTime()));
    }
}
