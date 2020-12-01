package com.redare.shop.unifyworkbench.sdk.common;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.shop.unifyworkbench.sdk.common.pojo.BaseUserInfo;

/**
 * @Author: guangrongyang
 * @Date: 2020/10/20 14:10
 */

public interface BaseUserInfoSdk {
    /**
     * 当前用户基本信息，包含组织信息，区域信息，部门等
     * @param form
     * @return
     */
    CommonResult<BaseUserInfo> queryBaseUserInfo(BaseUserInfo form);
}
