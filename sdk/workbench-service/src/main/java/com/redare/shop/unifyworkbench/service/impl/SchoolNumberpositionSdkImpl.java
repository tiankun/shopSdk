package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.shop.unifyworkbench.sdk.SchoolNumberpositionSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.SchoolNumberposition;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.SchoolNumberpositionForm;
import com.redare.shop.unifyworkbench.service.service.SchoolNumberpositionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学堂管理-数字阵地(SchoolNumberposition)SdkImpl
 *
 * @author dengchj
 * @since 2020-10-13 14:23:12
 */
@Service
public class SchoolNumberpositionSdkImpl implements SchoolNumberpositionSdk {
    private static final Logger LOGGER = LoggerFactory.getLogger(SchoolNumberpositionSdkImpl.class);
    @Autowired
    SchoolNumberpositionService schoolNumberpositionService;

    @Override
    public CommonResult<Boolean> insertSchoolNumberposition(SchoolNumberposition form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        final long id = schoolNumberpositionService.insertSchoolNumberposition(form);
        return CommonResult.returnSuccessWrapper(id > 0);
    }

    @Override
    public CommonResult<Boolean> updateSchoolNumberposition(SchoolNumberposition form) {
        if (form.getId() == null) {
            return CommonResult.returnFailsWrapper("主键不能为空");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = schoolNumberpositionService.updateSchoolNumberposition(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }

    @Override
    public CommonResult<Boolean> deleteSchoolNumberposition(CommonForm.Del form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = schoolNumberpositionService.deleteSchoolNumberposition(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }


    @Override
    public CommonResult<Boolean> updateSchoolNumberpositionStatus(SchoolNumberpositionForm.changeStatus form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = schoolNumberpositionService.updateSchoolNumberpositionStatus(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }

    @Override
    public CommonResult<Page<SchoolNumberposition>> queryForPageSchoolNumberposition(SchoolNumberpositionForm.Search form, int curPage, int pageSize) {
        Page<SchoolNumberposition> data = schoolNumberpositionService.queryForPageSchoolNumberposition(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(data);
    }

    @Override
    public CommonResult<List<SchoolNumberposition>> queryForListSchoolNumberposition(SchoolNumberpositionForm.Search form,int curPage, int pageSize) {
        List<SchoolNumberposition> data = schoolNumberpositionService.queryForListSchoolNumberposition(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(data);
    }

    @Override
    public CommonResult<SchoolNumberposition> querySchoolNumberposition(SchoolNumberpositionForm.Get form) {
        SchoolNumberposition data = schoolNumberpositionService.queryForSchoolNumberposition(form);

        return CommonResult.returnSuccessWrapper(data);
    }

    @Override
    public CommonResult<Boolean> batchDelSchoolNumberposition(CommonForm.BatchDel form) {
        if (form == null) {
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        if (form.getIds() == null || form.getIds().size() <= 0) {
            return CommonResult.returnFailsWrapper("请传入主键id");
        }
        Boolean bool = schoolNumberpositionService.batchDelSchoolNumberposition(form);

        return CommonResult.returnBoolWrapper(bool, "批量删除失败");
    }
}