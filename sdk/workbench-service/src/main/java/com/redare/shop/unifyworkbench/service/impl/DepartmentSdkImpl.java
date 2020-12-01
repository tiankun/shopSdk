package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.shop.unifyworkbench.sdk.DepartmentSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.Department;
import com.redare.shop.unifyworkbench.sdk.pojo.form.DepartmentForm;
import com.redare.shop.unifyworkbench.service.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/10/16 18:21
 * @version:
 */
@Service
public class DepartmentSdkImpl implements DepartmentSdk {

    @Autowired
    DepartmentService departmentService;

    @Override
    public CommonResult<Page<Department>> findDepartmentPage(DepartmentForm.Search form, int curPage, int pageSize) {
        return CommonResult.returnSuccessWrapper(departmentService.findDepartmentPage(form, curPage, pageSize));
    }

    @Override
    public CommonResult<List<Department>> findDepartmentPageList(DepartmentForm.Search form, int curPage, int pageSize) {
        return CommonResult.returnSuccessWrapper(departmentService.findDepartmentPageList(form, curPage, pageSize));
    }

    @Override
    public CommonResult<List<Department>> findDepartmentList(DepartmentForm.Search form) {
        return CommonResult.returnSuccessWrapper(departmentService.findDepartmentList(form));
    }

    @Override
    public CommonResult<Department> findDepartment(DepartmentForm.Get form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        return CommonResult.returnSuccessWrapper(departmentService.findDepartment(form));
    }

    @Override
    public CommonResult<Boolean> addDepartment(DepartmentForm.Add form) {
        return null;
    }

    @Override
    public CommonResult<Boolean> editDepartment(DepartmentForm.Edit form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return CommonResult.returnBoolWrapper(departmentService.editDepartment(form),"编辑失败");
    }

    @Override
    public CommonResult<Boolean> delDepartment(DepartmentForm.Del form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return CommonResult.returnBoolWrapper(departmentService.delDepartment(form),"删除失败");
    }
}
