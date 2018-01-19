package com.yulaiz.dong.web.controller;

import com.yulaiz.dong.web.common.annotation.IgnoreSecurity;
import com.yulaiz.dong.web.common.response.ExeResult;
import com.yulaiz.dong.web.controller.req.user.UserLoginReq;
import com.yulaiz.dong.web.service.UserService;
import io.swagger.annotations.Api;
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
@RequestMapping("/user")
@Api(tags = "用户模块", value = "用户模块")
public class UserController {

    @Autowired
    private UserService userService;

    @IgnoreSecurity
    @ApiOperation(value = "用户登录", notes = "用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ExeResult login(@RequestBody @Validated UserLoginReq req) {
        return ExeResult.getInstance(userService.login(req.getUserName(), req.getPassword()));
    }
}
