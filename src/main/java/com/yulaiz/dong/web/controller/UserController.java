package com.yulaiz.dong.web.controller;

import com.yulaiz.dong.web.common.response.ExeResult;
import com.yulaiz.dong.web.controller.req.user.UserLoginReq;
import com.yulaiz.dong.web.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by YuLai on 2018/1/19.
 */
@Slf4j
@RestController
@RequestMapping("/user")
@Api(tags = "用户模块", value = "用户模块")
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "用户登录", notes = "用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ExeResult login(@RequestBody UserLoginReq req) {
        return ExeResult.getInstance(userService.login(req.getUserName(), req.getPassword()));
    }

    @ApiOperation(value = "校验用户", notes = "校验用户")
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ExeResult getUserByToken(@RequestParam String token) {
        return ExeResult.getInstance(userService.getUserByToken(token));
    }
}
