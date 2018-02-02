package com.yulaiz.dong.web.controller;

import com.yulaiz.dong.web.common.annotation.CurrentToken;
import com.yulaiz.dong.web.common.annotation.CurrentUser;
import com.yulaiz.dong.web.common.annotation.IgnoreSecurity;
import com.yulaiz.dong.web.common.annotation.IgnoreUser;
import com.yulaiz.dong.web.common.response.ExeResult;
import com.yulaiz.dong.web.controller.req.user.UserLinkReq;
import com.yulaiz.dong.web.controller.req.user.UserLoginReq;
import com.yulaiz.dong.web.model.entity.UserInfo;
import com.yulaiz.dong.web.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

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

    @IgnoreUser
    @ApiOperation(value = "用户登出", notes = "用户登出")
    @ApiImplicitParams({@ApiImplicitParam(name = "ACCESS_TOKEN", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ExeResult logout(@CurrentToken String token) {
        boolean isLogout = userService.logout(token);
        if (isLogout) {
            return ExeResult.getInstance(true);
        } else {
            return ExeResult.getInstance(false, "登出失败");
        }
    }

    @IgnoreUser
    @ApiOperation(value = "查询登录状态", notes = "查询登录状态")
    @ApiImplicitParams({@ApiImplicitParam(name = "ACCESS_TOKEN", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @RequestMapping(value = "/checkToken", method = RequestMethod.POST)
    public ExeResult checkToken(@CurrentToken String token) {
        boolean hasToken = userService.checkToken(token);
        if (hasToken) {
            return ExeResult.getInstance(true);
        } else {
            return ExeResult.getInstance(false, "未登录");
        }
    }

    @ApiIgnore
    @ApiOperation(value = "获取邀请注册链接", notes = "获取邀请注册链接")
    @RequestMapping(value = "/link", method = RequestMethod.POST)
    public ExeResult getRegisterLink(@RequestBody @Validated UserLinkReq req,
                                     @CurrentUser UserInfo userInfo,
                                     HttpServletRequest request) {
//        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        //项目使用二级域名，由nginx进行转发
        String url = request.getScheme() + "://" + request.getServerName();
        return ExeResult.getInstance(userService.getRegisterLink(req.getRemark(), userInfo, url));
    }

    @IgnoreSecurity
    @ApiIgnore
    @ApiOperation(value = "通过注册链接注册", notes = "通过注册链接注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ExeResult register(
            @RequestParam @NotBlank(message = "token不能为空") String token,
            @RequestParam @NotBlank(message = "用户名不能为空") String userName,
            @RequestParam @NotBlank(message = "密码不能为空") String password) {
        return ExeResult.getInstance(userService.register(token, userName, password));
    }
}
