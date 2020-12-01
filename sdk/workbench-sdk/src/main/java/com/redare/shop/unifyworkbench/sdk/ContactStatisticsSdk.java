package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;

import java.util.Map;

public interface ContactStatisticsSdk {

    /**
     * APP首页联系群众数据统计
     * @return
     */
    CommonResult<Map<String,Object>> contactStatistics();
}
