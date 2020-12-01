package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.shop.unifyworkbench.sdk.common.BaseUserInfoSdk;
import com.redare.shop.unifyworkbench.sdk.common.pojo.BaseUserInfo;
import com.redare.shop.unifyworkbench.service.service.BaseUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: guangrongyang
 * @Date: 2020/10/20 14:14
 */

@Service
public class BaseUserInfoSdkImpl implements BaseUserInfoSdk {
    @Autowired
    BaseUserInfoService baseUserInfoService;

    @Override
    public CommonResult<BaseUserInfo> queryBaseUserInfo(BaseUserInfo form) {
        BaseUserInfo data = baseUserInfoService.queryBaseUserInfo(form);
        return CommonResult.returnDataWrapper(data);
    }

}
