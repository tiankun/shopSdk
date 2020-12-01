package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.shop.unifyworkbench.sdk.HjmallindCardSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.HjmallindCard;
import com.redare.shop.unifyworkbench.sdk.pojo.form.HjmallindCardForm;
import com.redare.shop.unifyworkbench.service.service.HjmallindCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * impl
 *
 * @author tiankun
 * @date 2020-12-01 13:50:14
 */
@Service
public class HjmallindCardSdkImpl implements HjmallindCardSdk {

    @Autowired
    HjmallindCardService hjmallindCardService;

    @Override
    public CommonResult<Boolean> addHjmallindCard(HjmallindCardForm.Add form) {
        CommonResult result = ValidationUtils.simpleValidate(form);
        if (result.isNotSuccess()) {
            return result;
        }
        boolean bool = hjmallindCardService.addHjmallindCard(form);
        return CommonResult.returnBoolWrapper(bool, "添加失败");
    }

    @Override
    public CommonResult<Boolean> editHjmallindCard(HjmallindCardForm.Edit form) {
        CommonResult result = ValidationUtils.simpleValidate(form);
        if (result.isNotSuccess()) {
            return result;
        }
        boolean bool = hjmallindCardService.editHjmallindCard(form);
        return CommonResult.returnBoolWrapper(bool, "编辑失败");
    }

    @Override
    public CommonResult<Boolean> deleteHjmallindCard(HjmallindCardForm.Del form) {
        CommonResult result = ValidationUtils.simpleValidate(form);
        if (result.isNotSuccess()) {
            return result;
        }
        boolean bool = hjmallindCardService.deleteHjmallindCard(form);
        return CommonResult.returnBoolWrapper(bool, "删除失败");
    }

    @Override
    public CommonResult<List<HjmallindCard>> findHjmallindCardList(HjmallindCardForm.Search form) {
        List<HjmallindCard> list = hjmallindCardService.findHjmallindCardList(form);
        return CommonResult.returnSuccessWrapper(list);
    }

    @Override
    public CommonResult<List<HjmallindCard>> findHjmallindCardList(HjmallindCardForm.Search form, int curPage, int pageSize) {
        List<HjmallindCard> list = hjmallindCardService.findHjmallindCardList(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(list);
    }

    @Override
    public CommonResult<Page<HjmallindCard>> findHjmallindCardPage(HjmallindCardForm.Search form, int curPage, int pageSize) {
        Page<HjmallindCard> page = hjmallindCardService.findHjmallindCardPage(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(page);
    }

    @Override
    public CommonResult<HjmallindCard> getHjmallindCard(HjmallindCardForm.Get form) {
        CommonResult result = ValidationUtils.simpleValidate(form);
        if (result.isNotSuccess()) {
            return result;
        }
        HjmallindCard info = hjmallindCardService.getHjmallindCard(form);
        if (info == null) {
            return CommonResult.returnFailsWrapper("数据不存在");
        }
        return CommonResult.returnSuccessWrapper(info);
    }


}

