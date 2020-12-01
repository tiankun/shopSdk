package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.HjmallindOrderDetail;
import com.redare.shop.unifyworkbench.sdk.pojo.form.HjmallindOrderDetailForm;

import java.util.List;

/**
 * 订单明细 sdk
 *
 * @author tiankun
 * @date 2020-12-01 16:21:41
 */
public interface HjmallindOrderDetailSdk {

    /**
     * 新增订单明细
     */
    CommonResult<Boolean> addHjmallindOrderDetail(HjmallindOrderDetailForm.Add form);

    /**
     * 编辑订单明细
     */
    CommonResult<Boolean> editHjmallindOrderDetail(HjmallindOrderDetailForm.Edit form);

    /**
     * 删除订单明细
     */
    CommonResult<Boolean> deleteHjmallindOrderDetail(HjmallindOrderDetailForm.Del form);

    /**
     * 查询订单明细
     */
    CommonResult<List<HjmallindOrderDetail>> findHjmallindOrderDetailList(HjmallindOrderDetailForm.Search form);

    /**
     * 分页查询订单明细
     */
    CommonResult<List<HjmallindOrderDetail>> findHjmallindOrderDetailList(HjmallindOrderDetailForm.Search form, int curPage, int pageSize);

    /**
     * 分页查询订单明细
     */
    CommonResult<Page<HjmallindOrderDetail>> findHjmallindOrderDetailPage(HjmallindOrderDetailForm.Search form, int curPage, int pageSize);

    /**
     * 获取订单明细
     */
    CommonResult<HjmallindOrderDetail> getHjmallindOrderDetail(HjmallindOrderDetailForm.Get form);


}

