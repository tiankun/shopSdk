package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.shop.unifyworkbench.sdk.HjmallindLevelSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.HjmallindLevel;
import com.redare.shop.unifyworkbench.sdk.pojo.form.HjmallindLevelForm;
import com.redare.shop.unifyworkbench.service.service.HjmallindLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会员等级 impl
 *
 * @author tiankun
 * @date 2020-12-01 16:56:53
 */
@Service
public class HjmallindLevelSdkImpl implements HjmallindLevelSdk {

    @Autowired
    HjmallindLevelService hjmallindLevelService;

    @Override
    public CommonResult<Boolean> addHjmallindLevel(HjmallindLevelForm.Add form) {
        CommonResult result = ValidationUtils.simpleValidate(form);
        if (result.isNotSuccess()) {
            return result;
        }
        boolean bool = hjmallindLevelService.addHjmallindLevel(form);
        return CommonResult.returnBoolWrapper(bool, "添加失败");
    }

    @Override
    public CommonResult<Boolean> editHjmallindLevel(HjmallindLevelForm.Edit form) {
        CommonResult result = ValidationUtils.simpleValidate(form);
        if (result.isNotSuccess()) {
            return result;
        }
        boolean bool = hjmallindLevelService.editHjmallindLevel(form);
        return CommonResult.returnBoolWrapper(bool, "编辑失败");
    }

    @Override
    public CommonResult<Boolean> deleteHjmallindLevel(HjmallindLevelForm.Del form) {
        CommonResult result = ValidationUtils.simpleValidate(form);
        if (result.isNotSuccess()) {
            return result;
        }
        boolean bool = hjmallindLevelService.deleteHjmallindLevel(form);
        return CommonResult.returnBoolWrapper(bool, "删除失败");
    }

    @Override
    public CommonResult<List<HjmallindLevel>> findHjmallindLevelList(HjmallindLevelForm.Search form) {
        List<HjmallindLevel> list = hjmallindLevelService.findHjmallindLevelList(form);
        return CommonResult.returnSuccessWrapper(list);
    }

    @Override
    public CommonResult<List<HjmallindLevel>> findHjmallindLevelList(HjmallindLevelForm.Search form, int curPage, int pageSize) {
        List<HjmallindLevel> list = hjmallindLevelService.findHjmallindLevelList(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(list);
    }

    @Override
    public CommonResult<Page<HjmallindLevel>> findHjmallindLevelPage(HjmallindLevelForm.Search form, int curPage, int pageSize) {
        Page<HjmallindLevel> page = hjmallindLevelService.findHjmallindLevelPage(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(page);
    }

    @Override
    public CommonResult<HjmallindLevel> getHjmallindLevel(HjmallindLevelForm.Get form) {
        CommonResult result = ValidationUtils.simpleValidate(form);
        if (result.isNotSuccess()) {
            return result;
        }
        HjmallindLevel info = hjmallindLevelService.getHjmallindLevel(form);
        if (info == null) {
            return CommonResult.returnFailsWrapper("数据不存在");
        }
        return CommonResult.returnSuccessWrapper(info);
    }


}

