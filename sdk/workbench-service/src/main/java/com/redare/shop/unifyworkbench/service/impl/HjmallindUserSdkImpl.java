package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.shop.unifyworkbench.sdk.HjmallindUserSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.HjmallindUser;
import com.redare.shop.unifyworkbench.sdk.pojo.form.HjmallindUserForm;
import com.redare.shop.unifyworkbench.service.service.HjmallindUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户 impl
 *
 * @author tiankun
 * @date 2020-12-01 15:53:13
 */
@Service
public class HjmallindUserSdkImpl implements HjmallindUserSdk {

    @Autowired
    HjmallindUserService hjmallindUserService;

    @Override
    public CommonResult<Boolean> addHjmallindUser(HjmallindUserForm.Add form) {
        CommonResult result = ValidationUtils.simpleValidate(form);
        if (result.isNotSuccess()) {
            return result;
        }
        boolean bool = hjmallindUserService.addHjmallindUser(form);
        return CommonResult.returnBoolWrapper(bool, "添加失败");
    }

    @Override
    public CommonResult<Boolean> editHjmallindUser(HjmallindUserForm.Edit form) {
        CommonResult result = ValidationUtils.simpleValidate(form);
        if (result.isNotSuccess()) {
            return result;
        }
        boolean bool = hjmallindUserService.editHjmallindUser(form);
        return CommonResult.returnBoolWrapper(bool, "编辑失败");
    }

    @Override
    public CommonResult<Boolean> deleteHjmallindUser(HjmallindUserForm.Del form) {
        CommonResult result = ValidationUtils.simpleValidate(form);
        if (result.isNotSuccess()) {
            return result;
        }
        boolean bool = hjmallindUserService.deleteHjmallindUser(form);
        return CommonResult.returnBoolWrapper(bool, "删除失败");
    }

    @Override
    public CommonResult<List<HjmallindUser>> findHjmallindUserList(HjmallindUserForm.Search form) {
        List<HjmallindUser> list = hjmallindUserService.findHjmallindUserList(form);
        return CommonResult.returnSuccessWrapper(list);
    }

    @Override
    public CommonResult<List<HjmallindUser>> findHjmallindUserList(HjmallindUserForm.Search form, int curPage, int pageSize) {
        List<HjmallindUser> list = hjmallindUserService.findHjmallindUserList(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(list);
    }

    @Override
    public CommonResult<Page<HjmallindUser>> findHjmallindUserPage(HjmallindUserForm.Search form, int curPage, int pageSize) {
        Page<HjmallindUser> page = hjmallindUserService.findHjmallindUserPage(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(page);
    }

    @Override
    public CommonResult<HjmallindUser> getHjmallindUser(HjmallindUserForm.Get form) {
        CommonResult result = ValidationUtils.simpleValidate(form);
        if (result.isNotSuccess()) {
            return result;
        }
        HjmallindUser info = hjmallindUserService.getHjmallindUser(form);
        if (info == null) {
            return CommonResult.returnFailsWrapper("数据不存在");
        }
        return CommonResult.returnSuccessWrapper(info);
    }


}

