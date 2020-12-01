package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.shop.unifyworkbench.sdk.OrganizeHonorSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.OrganizeHonor;
import com.redare.shop.unifyworkbench.sdk.pojo.form.OrganizeHonorForm;
import com.redare.shop.unifyworkbench.service.service.OrganizeHonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/10/19 16:16
 * @version:
 */
@Service
public class OrganizeHonorSdkImpl implements OrganizeHonorSdk {

    @Autowired
    OrganizeHonorService organizeHonorService;

    @Override
    public CommonResult<Page<OrganizeHonor>> findOrganizeHonorPage(OrganizeHonorForm.Search form, int curPage, int pageSize) {
        return CommonResult.returnSuccessWrapper(organizeHonorService.findOrganizeHonorPage(form, curPage, pageSize));
    }

    @Override
    public CommonResult<List<OrganizeHonor>> findOrganizeHonorPageList(OrganizeHonorForm.Search form, int curPage, int pageSize) {
        return CommonResult.returnSuccessWrapper(organizeHonorService.findOrganizeHonorPageList(form, curPage, pageSize));
    }

    @Override
    public CommonResult<List<OrganizeHonor>> findOrganizeHonorList(OrganizeHonorForm.Search form) {
        return CommonResult.returnSuccessWrapper(organizeHonorService.findOrganizeHonorList(form));
    }

    @Override
    public CommonResult<OrganizeHonor> findOrganizeHonor(OrganizeHonorForm.Get form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return CommonResult.returnSuccessWrapper(organizeHonorService.findOrganizeHonor(form));
    }

    @Override
    public CommonResult<Boolean> addOrganizeHonor(OrganizeHonorForm.Add form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        return CommonResult.returnBoolWrapper(organizeHonorService.addOrganizeHonor(form),"添加失败");
    }

    @Override
    public CommonResult<Boolean> editOrganizeHonor(OrganizeHonorForm.Edit form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return CommonResult.returnBoolWrapper(organizeHonorService.editOrganizeHonor(form),"编辑失败");
    }

    @Override
    public CommonResult<Boolean> delOrganizeHonor(OrganizeHonorForm.Del form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return CommonResult.returnBoolWrapper(organizeHonorService.delOrganizeHonor(form),"删除失败");
    }
}
