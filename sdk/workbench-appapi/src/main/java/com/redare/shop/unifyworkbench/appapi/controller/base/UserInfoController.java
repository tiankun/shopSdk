package com.redare.shop.unifyworkbench.appapi.controller.base;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.shop.unifyworkbench.sdk.UserInfoLinkmanSdk;
import com.redare.shop.unifyworkbench.sdk.UserInfoSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.UserInfo;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserInfoForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserInfoLinkmanForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tiankun on 2020-08-21
 */
@Controller
@RequestMapping("/base/user/info")
public class UserInfoController {

    @Autowired
    UserInfoSdk userInfoSdk;

    @Autowired
    UserInfoLinkmanSdk userInfoLinkmanSdk;

    @ResponseBody
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public CommonResult<List<UserInfo>> findUserInfoPage(
            @RequestBody UserInfoForm.Search form,
            @RequestParam(value = "curPage", required = false, defaultValue = "1") int curPage,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        return userInfoSdk.findUserInfoList(form,curPage,pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public CommonResult<List<UserInfo>> findUserInfoList(
            @RequestBody UserInfoForm.Search form
    ) {
        return userInfoSdk.findUserInfoList(form);
    }

    @ResponseBody
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public CommonResult<UserInfo> getUserInfo(
            @RequestBody UserInfoForm.Get form
    ) {
        return userInfoSdk.getUserInfoByUserId(form);
    }

    @ResponseBody
    @RequestMapping(value = "/user/info/by/login/info", method = RequestMethod.POST)
    public CommonResult<UserInfo> getUserInfoByLoginUserId(
            @RequestBody UserInfoForm.Get form
    ) {
        return userInfoSdk.getUserInfoByLoginUserId(form);
    }

    @ResponseBody
    @RequestMapping(value = "/link/man/list", method = RequestMethod.POST)
    public CommonResult<List<UserInfo>> findLinkmanList(
            @RequestBody UserInfoLinkmanForm.Search form
    ) {
        return userInfoLinkmanSdk.findUserInfoLinkmanList(form);
    }

    @ResponseBody
    @RequestMapping(value = "/add/link/man", method = RequestMethod.POST)
    public CommonResult<Boolean> addOrUpdateLinkman(
            @RequestBody UserInfoLinkmanForm.Add form
    ) {
        return userInfoLinkmanSdk.addOrUpdateLinkman(form);
    }

}
