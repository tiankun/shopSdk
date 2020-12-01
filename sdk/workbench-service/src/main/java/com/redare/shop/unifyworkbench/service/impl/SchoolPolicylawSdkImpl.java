package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.shop.unifyworkbench.sdk.SchoolPolicylawSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.SchoolPolicylaw;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.SchoolPolicylawForm;
import com.redare.shop.unifyworkbench.service.service.SchoolPolicylawService;
import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学堂管理-政策法规(SchoolPolicylaw)SdkImpl
 *
 * @author dengchj
 * @since 2020-10-13 14:23:23
 */
@Service
public class SchoolPolicylawSdkImpl implements SchoolPolicylawSdk {
    private static final Logger LOGGER = LoggerFactory.getLogger(SchoolPolicylawSdkImpl.class);
    @Autowired
    SchoolPolicylawService schoolPolicylawService;

    @Override
    public CommonResult<Boolean> insertSchoolPolicylaw(SchoolPolicylaw form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        if (form.getContent() != null && !"".equals(form.getContent())){
            form.setContent(form.getContent().replaceAll(";lt&","&lt;").replaceAll(";gt&","&gt;"));
        }

        final long id = schoolPolicylawService.insertSchoolPolicylaw(form);
        return CommonResult.returnSuccessWrapper(id > 0);
    }

    @Override
    public CommonResult<Boolean> updateSchoolPolicylaw(SchoolPolicylaw form) {
        if (form.getId() == null) {
            return CommonResult.returnFailsWrapper("主键不能为空");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        if (form.getContent() != null && !"".equals(form.getContent())){
            form.setContent(form.getContent().replaceAll(";lt&","&lt;").replaceAll(";gt&","&gt;"));
        }

        int row = schoolPolicylawService.updateSchoolPolicylaw(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }

    @Override
    public CommonResult<Boolean> deleteSchoolPolicylaw(CommonForm.Del form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = schoolPolicylawService.deleteSchoolPolicylaw(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }


    @Override
    public CommonResult<Boolean> updateSchoolPolicylawStatus(SchoolPolicylawForm.changeStatus form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        int row = schoolPolicylawService.updateSchoolPolicylawStatus(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }

    @Override
    public CommonResult<Page<SchoolPolicylaw>> queryForPageSchoolPolicylaw(SchoolPolicylawForm.Search form, int curPage, int pageSize) {
        Page<SchoolPolicylaw> data = schoolPolicylawService.queryForPageSchoolPolicylaw(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(data);
    }

    @Override
    public CommonResult<List<SchoolPolicylaw>> queryForListSchoolPolicylaw(SchoolPolicylawForm.Search form,int curPage, int pageSize) {
        List<SchoolPolicylaw> data = schoolPolicylawService.queryForListSchoolPolicylaw(form,curPage, pageSize);
        return CommonResult.returnSuccessWrapper(data);
    }

    @Override
    public CommonResult<SchoolPolicylaw> querySchoolPolicylaw(SchoolPolicylawForm.Search form) {
        List<SchoolPolicylaw> data = schoolPolicylawService.queryForListSchoolPolicylaw(form,1,1);
        if (data.size() == 1) {
            return CommonResult.returnSuccessWrapper(data.get(0));
        }
        return CommonResult.returnFailsWrapper("无效的查询条件");
    }

    @Override
    public CommonResult<Boolean> batchDelSchoolPolicylaw(CommonForm.BatchDel form) {
        if (form == null) {
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        if (form.getIds() == null || form.getIds().size() <= 0) {
            return CommonResult.returnFailsWrapper("请传入主键id");
        }
        Boolean bool = schoolPolicylawService.batchDelSchoolPolicylaw(form);

        return CommonResult.returnBoolWrapper(bool, "批量删除失败");
    }

    @Override
    public CommonResult<SchoolPolicylaw> getSchoolPolicylawInfo(SchoolPolicylawForm.Search form) {
        if (form == null) {
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        SchoolPolicylaw schoolPolicylaw = schoolPolicylawService.getSchoolPolicylawInfo(form);
        if (schoolPolicylaw != null) {
            if (schoolPolicylaw.getContent() != null && !"".equals(schoolPolicylaw.getContent())) {
                String content = StringEscapeUtils.unescapeHtml4(schoolPolicylaw.getContent());
                schoolPolicylaw.setContent(content);
            }
        }
        return CommonResult.returnDataWrapper(schoolPolicylaw);
    }

    @Override
    public CommonResult<Boolean> updateTopStatus(SchoolPolicylawForm.Top form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = schoolPolicylawService.updateTopStatus(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }

}