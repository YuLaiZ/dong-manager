package com.yulaiz.dong.web.controller;

import com.yulaiz.dong.web.common.response.ExeResult;
import com.yulaiz.dong.web.controller.req.ad.*;
import com.yulaiz.dong.web.service.AdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @ApiOperation(value = "获取指定", notes = "获取指定广告")
    @RequestMapping(value = "/get-by-id", method = RequestMethod.POST)
    public ExeResult getAdById(@RequestBody AdGetByIdReq req) {
        return ExeResult.getInstance(adService.getAdById(req.getId()));
    }

    @ApiOperation(value = "获取所有", notes = "获取所有广告")
    @RequestMapping(value = "/get-list", method = RequestMethod.POST)
    public ExeResult getAdList() {
        return ExeResult.getInstance(adService.getAdList());
    }

    @ApiOperation(value = "分页获取", notes = "分页获取广告")
    @RequestMapping(value = "/get-list-by-page", method = RequestMethod.POST)
    public ExeResult getAdListByPage(@RequestBody AdGetByPageReq req) {
        return ExeResult.getInstance(adService.getAdListByPage(req.getPage(), req.getSize()));
    }

    @ApiOperation(value = "新增", notes = "新增一条广告")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ExeResult addAd(@RequestBody AdAddReq req) {
        return ExeResult.getInstance(adService.addAd(req.getTitle(), req.getDescription()));
    }

    @ApiOperation(value = "修改", notes = "修改指定广告")
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public ExeResult modifyAd(@RequestBody AdModifyReq req) {
        return ExeResult.getInstance(adService.modifyAd(req.getId(), req.getTitle(), req.getDescription()));
    }

    @ApiOperation(value = "删除", notes = "删除指定广告")
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public ExeResult modifyAd(@RequestBody AdDelByIdReq req) {
        return ExeResult.getInstance(adService.delAdById(req.getId()));
    }
}
