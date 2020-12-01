package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.shop.unifyworkbench.sdk.HjmallindOrderDetailSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.HjmallindOrderDetail;
import com.redare.shop.unifyworkbench.sdk.pojo.form.HjmallindOrderDetailForm;
import com.redare.shop.unifyworkbench.service.service.HjmallindOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单明细 impl
 *
 * @author tiankun
 * @date 2020-12-01 16:21:41
 */
@Service
public class HjmallindOrderDetailSdkImpl implements HjmallindOrderDetailSdk {

    @Autowired
    HjmallindOrderDetailService hjmallindOrderDetailService;

    @Override
    public CommonResult<Boolean> addHjmallindOrderDetail(HjmallindOrderDetailForm.Add form) {
        CommonResult result = ValidationUtils.simpleValidate(form);
        if (result.isNotSuccess()) {
            return result;
        }
        boolean bool = hjmallindOrderDetailService.addHjmallindOrderDetail(form);
        return CommonResult.returnBoolWrapper(bool, "添加失败");
    }

    @Override
    public CommonResult<Boolean> editHjmallindOrderDetail(HjmallindOrderDetailForm.Edit form) {
        CommonResult result = ValidationUtils.simpleValidate(form);
        if (result.isNotSuccess()) {
            return result;
        }
        boolean bool = hjmallindOrderDetailService.editHjmallindOrderDetail(form);
        return CommonResult.returnBoolWrapper(bool, "编辑失败");
    }

    @Override
    public CommonResult<Boolean> deleteHjmallindOrderDetail(HjmallindOrderDetailForm.Del form) {
        CommonResult result = ValidationUtils.simpleValidate(form);
        if (result.isNotSuccess()) {
            return result;
        }
        boolean bool = hjmallindOrderDetailService.deleteHjmallindOrderDetail(form);
        return CommonResult.returnBoolWrapper(bool, "删除失败");
    }

    @Override
    public CommonResult<List<HjmallindOrderDetail>> findHjmallindOrderDetailList(HjmallindOrderDetailForm.Search form) {
        List<HjmallindOrderDetail> list = hjmallindOrderDetailService.findHjmallindOrderDetailList(form);
        return CommonResult.returnSuccessWrapper(list);
    }

    @Override
    public CommonResult<List<HjmallindOrderDetail>> findHjmallindOrderDetailList(HjmallindOrderDetailForm.Search form, int curPage, int pageSize) {
        List<HjmallindOrderDetail> list = hjmallindOrderDetailService.findHjmallindOrderDetailList(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(list);
    }

    @Override
    public CommonResult<Page<HjmallindOrderDetail>> findHjmallindOrderDetailPage(HjmallindOrderDetailForm.Search form, int curPage, int pageSize) {
        Page<HjmallindOrderDetail> page = hjmallindOrderDetailService.findHjmallindOrderDetailPage(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(page);
    }

    @Override
    public CommonResult<HjmallindOrderDetail> getHjmallindOrderDetail(HjmallindOrderDetailForm.Get form) {
        CommonResult result = ValidationUtils.simpleValidate(form);
        if (result.isNotSuccess()) {
            return result;
        }
        HjmallindOrderDetail info = hjmallindOrderDetailService.getHjmallindOrderDetail(form);
        if (info == null) {
            return CommonResult.returnFailsWrapper("数据不存在");
        }
        return CommonResult.returnSuccessWrapper(info);
    }


}

