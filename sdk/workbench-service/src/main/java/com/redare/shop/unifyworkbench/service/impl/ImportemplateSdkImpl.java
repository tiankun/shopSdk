package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;

import com.redare.shop.unifyworkbench.sdk.ImportemplateSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.Importemplate;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ImportemplateForm;
import com.redare.shop.unifyworkbench.service.service.ImportemplateService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Excel导入模板表：ImportemplateSdkImpl
 *
 * @author yj
 * @email yangj@redare.cn
 * @date 2020-03-17
 */
@Service
public class ImportemplateSdkImpl implements ImportemplateSdk {
    @Autowired
    ImportemplateService importemplateService;
    @Override
    public CommonResult<Page<Importemplate>> findImportemplatePage(ImportemplateForm.Search form, int curPage, int pageSize) {
        return CommonResult.returnSuccessWrapper(importemplateService.findImportemplatePage(form,curPage,pageSize));
    }

    @Override
    public CommonResult<List<Importemplate>> findImportemplateList(ImportemplateForm.Search form, int curPage, int pageSize) {
        return CommonResult.returnDataWrapper(importemplateService.findImportemplateList(form,curPage,pageSize));
    }

    @Override
    public CommonResult<List<Importemplate>> findImportemplateList(ImportemplateForm.Search form) {
        return CommonResult.returnDataWrapper(importemplateService.findImportemplateList(form));
    }

    @Override
    public CommonResult<Importemplate> getImportemplate(ImportemplateForm.Get form) {
        return CommonResult.returnSuccessWrapper(importemplateService.getImportemplate(form));
    }

    @Override
    public CommonResult<Boolean> addImportemplate(ImportemplateForm.Add form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return CommonResult.returnBoolWrapper(importemplateService.addImportemplate(form),"添加Excel导入模板表失败！");
    }

    @Override
    public CommonResult<Boolean> editImportemplate(ImportemplateForm.Edit form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return CommonResult.returnBoolWrapper(importemplateService.editImportemplate(form),"编辑Excel导入模板表失败！");
    }

    @Override
    public CommonResult<Boolean> deleteImportemplate(ImportemplateForm.Del form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return  CommonResult.returnBoolWrapper(importemplateService.deleteImportemplate(form),"删除Excel导入模板表失败！");
    }

    /**
     * @description 根据模板类型查询数据
     * @author zlx
     * @date 2020/11/21 11:01
     * @param type
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.Importemplate>
     */
    @Override
    public CommonResult<Importemplate> findImportTemplateByType(String type) {
        if (StringUtils.isBlank(type)){
            return CommonResult.returnFailsWrapper("模板类型不能为空");
        }
        return CommonResult.returnSuccessWrapper(importemplateService.findImportemplateByType(type));
    }
}
