package com.yulaiz.dong.web.controller;

import com.yulaiz.dong.web.common.annotation.CurrentUser;
import com.yulaiz.dong.web.common.annotation.IgnoreSecurity;
import com.yulaiz.dong.web.common.response.ExeResult;
import com.yulaiz.dong.web.controller.req.ad.*;
import com.yulaiz.dong.web.model.entity.UserInfo;
import com.yulaiz.dong.web.service.AdService;
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
@RequestMapping("/ad")
@Api(tags = "广告模块", value = "广告模块")
public class AdController {
    @Autowired
    private AdService adService;

    @IgnoreSecurity
    @ApiOperation(value = "获取指定", notes = "获取指定广告")
    @RequestMapping(value = "/get-by-id", method = RequestMethod.POST)
    public ExeResult getAdById(@RequestBody @Validated AdGetByIdReq req) {
        return ExeResult.getInstance(adService.getAdById(req.getId()));
    }

    @IgnoreSecurity
    @ApiOperation(value = "获取所有", notes = "获取所有广告")
    @RequestMapping(value = "/get-list", method = RequestMethod.POST)
    public ExeResult getAdList() {
        return ExeResult.getInstance(adService.getAdList());
    }

    @IgnoreSecurity
    @ApiOperation(value = "分页获取", notes = "分页获取广告")
    @RequestMapping(value = "/get-list-by-page", method = RequestMethod.POST)
    public ExeResult getAdListByPage(@RequestBody @Validated AdGetByPageReq req) {
        return ExeResult.getInstance(adService.getAdListByPage(req.getPage(), req.getSize()));
    }

    @ApiOperation(value = "新增", notes = "新增一条广告")
    @ApiImplicitParams({@ApiImplicitParam(name = "ACCESS_TOKEN", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ExeResult addAd(@RequestBody @Validated AdAddReq req, @CurrentUser UserInfo userInfo) {
        return ExeResult.getInstance(adService.addAd(req.getTitle(), req.getDescription()));
    }

    @ApiOperation(value = "修改", notes = "修改指定广告")
    @ApiImplicitParams({@ApiImplicitParam(name = "ACCESS_TOKEN", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public ExeResult modifyAd(@RequestBody @Validated AdModifyReq req, @CurrentUser UserInfo userInfo) {
        return ExeResult.getInstance(adService.modifyAd(req.getId(), req.getTitle(), req.getDescription()));
    }

    @ApiOperation(value = "删除", notes = "删除指定广告")
    @ApiImplicitParams({@ApiImplicitParam(name = "ACCESS_TOKEN", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public ExeResult modifyAd(@RequestBody @Validated AdDelByIdReq req, @CurrentUser UserInfo userInfo) {
        return ExeResult.getInstance(adService.delAdById(req.getId()));
    }
}
