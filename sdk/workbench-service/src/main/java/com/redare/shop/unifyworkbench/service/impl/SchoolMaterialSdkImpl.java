package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.shop.unifyworkbench.sdk.SchoolMaterialSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.SchoolMaterial;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.SchoolMaterialForm;
import com.redare.shop.unifyworkbench.service.service.SchoolMaterialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学堂管理-素材管理(SchoolMaterial)SdkImpl
 *
 * @author dengchj
 * @since 2020-10-15 15:04:44
 */
@Service
public class SchoolMaterialSdkImpl implements SchoolMaterialSdk {
    private static final Logger LOGGER = LoggerFactory.getLogger(SchoolMaterialSdkImpl.class);
    @Autowired
    SchoolMaterialService schoolMaterialService;

    @Override
    public CommonResult<Boolean> insertSchoolMaterial(SchoolMaterialForm.Add form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        final long id = schoolMaterialService.insertSchoolMaterial(form);
        return CommonResult.returnSuccessWrapper(id > 0);
    }

    @Override
    public CommonResult<Boolean> updateSchoolMaterial(SchoolMaterialForm.Edit form) {
        if (form.getId() == null) {
            return CommonResult.returnFailsWrapper("主键不能为空");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = schoolMaterialService.updateSchoolMaterial(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }

    @Override
    public CommonResult<Boolean> deleteSchoolMaterial(CommonForm.Del form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = schoolMaterialService.deleteSchoolMaterial(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }


    @Override
    public CommonResult<Boolean> updateSchoolMaterialStatus(SchoolMaterialForm.changeStatus form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        int row = schoolMaterialService.updateMaterailStatus(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }

    @Override
    public CommonResult<Page<SchoolMaterial>> queryForPageSchoolMaterial(SchoolMaterialForm.Search form, int curPage, int pageSize) {
        Page<SchoolMaterial> data = schoolMaterialService.queryForPageSchoolMaterial(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(data);
    }

    @Override
    public CommonResult<List<SchoolMaterial>> queryForListSchoolMaterial(SchoolMaterialForm.Search form,int curPage,int pageSize) {
        List<SchoolMaterial> data = schoolMaterialService.queryForListSchoolMaterial(form,curPage,pageSize);
        return CommonResult.returnSuccessWrapper(data);
    }

    @Override
    public CommonResult<SchoolMaterial> querySchoolMaterial(SchoolMaterialForm.Search form) {
        schoolMaterialService.autoPlusOneOnBrowse(new SchoolMaterialForm.changeStatus().setId(Long.valueOf(form.getId())));
       SchoolMaterial data = schoolMaterialService.queryForSchoolMaterial(form);
        return CommonResult.returnDataWrapper(data);
    }

    @Override
    public CommonResult<Boolean> batchDelSchoolMaterial(CommonForm.BatchDel form) {
        if (form == null) {
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        if (form.getIds() == null || form.getIds().size() <= 0) {
            return CommonResult.returnFailsWrapper("请传入主键id");
        }
        Boolean bool = schoolMaterialService.batchDelSchoolMaterial(form);

        return CommonResult.returnBoolWrapper(bool, "批量删除失败");
    }

    @Override
    public CommonResult<Boolean> updateTopStatus(SchoolMaterialForm.Top form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = schoolMaterialService.updateTopStatus(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }

    @Override
    public CommonResult<Boolean> updateSort(SchoolMaterialForm.Sort form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = schoolMaterialService.updateSort(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }
}