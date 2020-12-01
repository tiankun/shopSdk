package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.shop.unifyworkbench.sdk.OrganizeChangeTermSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.OrganizeChangeTerm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.OrganizeChangeTermForm;
import com.redare.shop.unifyworkbench.service.service.OrganizeChangeTermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/10/19 14:44
 * @version:
 */
@Service
public class OrganizeChangeTermSdkImpl implements OrganizeChangeTermSdk {

    @Autowired
    OrganizeChangeTermService organizeChangeTermService;

    @Override
    public CommonResult<Page<OrganizeChangeTerm>> findOrganizeChangeTermPage(OrganizeChangeTermForm.Search form, int curPage, int pageSize) {
        return CommonResult.returnSuccessWrapper(organizeChangeTermService.findOrganizeChangeTermPage(form, curPage, pageSize));
    }

    @Override
    public CommonResult<List<OrganizeChangeTerm>> findOrganizeChangeTermPageList(OrganizeChangeTermForm.Search form, int curPage, int pageSize) {
        return CommonResult.returnSuccessWrapper(organizeChangeTermService.findOrganizeChangeTermPageList(form, curPage, pageSize));
    }

    @Override
    public CommonResult<List<OrganizeChangeTerm>> findOrganizeChangeTermList(OrganizeChangeTermForm.Search form) {
        return CommonResult.returnSuccessWrapper(organizeChangeTermService.findOrganizeChangeTermList(form));
    }

    @Override
    public CommonResult<OrganizeChangeTerm> findOrganizeChangeTerm(OrganizeChangeTermForm.Get form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return CommonResult.returnSuccessWrapper(organizeChangeTermService.findOrganizeChangeTerm(form));
    }

    @Override
    public CommonResult<Boolean> addOrganizeChangeTerm(OrganizeChangeTermForm.Add form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        return CommonResult.returnBoolWrapper(organizeChangeTermService.addOrganizeChangeTerm(form),"添加失败");
    }

    @Override
    public CommonResult<Boolean> editOrganizeChangeTerm(OrganizeChangeTermForm.Edit form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return CommonResult.returnBoolWrapper(organizeChangeTermService.editOrganizeChangeTerm(form),"编辑失败");
    }

    @Override
    public CommonResult<Boolean> delOrganizeChangeTerm(OrganizeChangeTermForm.Del form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return CommonResult.returnBoolWrapper(organizeChangeTermService.delOrganizeChangeTerm(form),"删除失败");
    }
}
