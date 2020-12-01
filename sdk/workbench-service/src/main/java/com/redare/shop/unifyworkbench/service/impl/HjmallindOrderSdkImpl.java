package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.shop.unifyworkbench.sdk.HjmallindOrderSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.HjmallindOrder;
import com.redare.shop.unifyworkbench.sdk.pojo.form.HjmallindOrderForm;
import com.redare.shop.unifyworkbench.service.service.HjmallindOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单表 impl
 *
 * @author tiankun
 * @date 2020-12-01 16:21:27
 */
@Service
public class HjmallindOrderSdkImpl implements HjmallindOrderSdk {

    @Autowired
    HjmallindOrderService hjmallindOrderService;

    @Override
    public CommonResult<Boolean> addHjmallindOrder(HjmallindOrderForm.Add form) {
        CommonResult result = ValidationUtils.simpleValidate(form);
        if (result.isNotSuccess()) {
            return result;
        }
        boolean bool = hjmallindOrderService.addHjmallindOrder(form);
        return CommonResult.returnBoolWrapper(bool, "添加失败");
    }

    @Override
    public CommonResult<Boolean> editHjmallindOrder(HjmallindOrderForm.Edit form) {
        CommonResult result = ValidationUtils.simpleValidate(form);
        if (result.isNotSuccess()) {
            return result;
        }
        boolean bool = hjmallindOrderService.editHjmallindOrder(form);
        return CommonResult.returnBoolWrapper(bool, "编辑失败");
    }

    @Override
    public CommonResult<Boolean> deleteHjmallindOrder(HjmallindOrderForm.Del form) {
        CommonResult result = ValidationUtils.simpleValidate(form);
        if (result.isNotSuccess()) {
            return result;
        }
        boolean bool = hjmallindOrderService.deleteHjmallindOrder(form);
        return CommonResult.returnBoolWrapper(bool, "删除失败");
    }

    @Override
    public CommonResult<List<HjmallindOrder>> findHjmallindOrderList(HjmallindOrderForm.Search form) {
        List<HjmallindOrder> list = hjmallindOrderService.findHjmallindOrderList(form);
        return CommonResult.returnSuccessWrapper(list);
    }

    @Override
    public CommonResult<List<HjmallindOrder>> findHjmallindOrderList(HjmallindOrderForm.Search form, int curPage, int pageSize) {
        List<HjmallindOrder> list = hjmallindOrderService.findHjmallindOrderList(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(list);
    }

    @Override
    public CommonResult<Page<HjmallindOrder>> findHjmallindOrderPage(HjmallindOrderForm.Search form, int curPage, int pageSize) {
        Page<HjmallindOrder> page = hjmallindOrderService.findHjmallindOrderPage(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(page);
    }

    @Override
    public CommonResult<HjmallindOrder> getHjmallindOrder(HjmallindOrderForm.Get form) {
        CommonResult result = ValidationUtils.simpleValidate(form);
        if (result.isNotSuccess()) {
            return result;
        }
        HjmallindOrder info = hjmallindOrderService.getHjmallindOrder(form);
        if (info == null) {
            return CommonResult.returnFailsWrapper("数据不存在");
        }
        return CommonResult.returnSuccessWrapper(info);
    }


}

