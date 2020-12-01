package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.HjmallindOrder;
import com.redare.shop.unifyworkbench.sdk.pojo.form.HjmallindOrderForm;

import java.util.List;

/**
 * 订单表 sdk
 *
 * @author tiankun
 * @date 2020-12-01 16:21:27
 */
public interface HjmallindOrderSdk {

    /**
     * 新增订单表
     */
    CommonResult<Boolean> addHjmallindOrder(HjmallindOrderForm.Add form);

    /**
     * 编辑订单表
     */
    CommonResult<Boolean> editHjmallindOrder(HjmallindOrderForm.Edit form);

    /**
     * 删除订单表
     */
    CommonResult<Boolean> deleteHjmallindOrder(HjmallindOrderForm.Del form);

    /**
     * 查询订单表
     */
    CommonResult<List<HjmallindOrder>> findHjmallindOrderList(HjmallindOrderForm.Search form);

    /**
     * 分页查询订单表
     */
    CommonResult<List<HjmallindOrder>> findHjmallindOrderList(HjmallindOrderForm.Search form, int curPage, int pageSize);

    /**
     * 分页查询订单表
     */
    CommonResult<Page<HjmallindOrder>> findHjmallindOrderPage(HjmallindOrderForm.Search form, int curPage, int pageSize);

    /**
     * 获取订单表
     */
    CommonResult<HjmallindOrder> getHjmallindOrder(HjmallindOrderForm.Get form);


}

