package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.shop.unifyworkbench.sdk.SchoolCommentSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.SchoolComment;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.SchoolCommentForm;
import com.redare.shop.unifyworkbench.service.service.SchoolCommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 评论表(SchoolComment)SdkImpl
 *
 * @author dengchj
 * @since 2020-10-13 14:22:08
 */
@Service
public class SchoolCommentSdkImpl implements SchoolCommentSdk {
    private static final Logger LOGGER = LoggerFactory.getLogger(SchoolCommentSdkImpl.class);
    @Autowired
    SchoolCommentService schoolCommentService;

    @Override
    public CommonResult<Boolean> insertSchoolComment(SchoolComment form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        final long id = schoolCommentService.insertSchoolComment(form);
        return CommonResult.returnSuccessWrapper(id > 0);
    }

    @Override
    public CommonResult<Boolean> updateSchoolComment(SchoolComment form) {
        if (form.getId() == null) {
            return CommonResult.returnFailsWrapper("主键不能为空");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = schoolCommentService.updateSchoolComment(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }

    @Override
    public CommonResult<Boolean> deleteSchoolComment(CommonForm.Del form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = schoolCommentService.deleteSchoolComment(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }


    @Override
    public CommonResult<Boolean> updateSchoolCommentStatus(SchoolCommentForm.Edit form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        final SchoolComment targetForm = new SchoolComment();
        try {
            BeanUtils.copyProperties(form, targetForm);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return CommonResult.returnFailsWrapper(e.getMessage());
        }
        int row = schoolCommentService.updateSchoolComment(targetForm);
        return CommonResult.returnSuccessWrapper(row > 0);
    }

    @Override
    public CommonResult<Page<SchoolComment>> queryForPageSchoolComment(SchoolCommentForm.Search form, int curPage, int pageSize) {
        Page<SchoolComment> data = schoolCommentService.queryForPageSchoolComment(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(data);
    }

    @Override
    public CommonResult<List<SchoolComment>> queryForListSchoolComment(SchoolCommentForm.Search form) {
        List<SchoolComment> data = schoolCommentService.queryForListSchoolComment(form);
        return CommonResult.returnSuccessWrapper(data);
    }

    @Override
    public CommonResult<SchoolComment> querySchoolComment(SchoolCommentForm.Search form) {
        List<SchoolComment> data = schoolCommentService.queryForListSchoolComment(form);
        if (data.size() == 1) {
            return CommonResult.returnSuccessWrapper(data.get(0));
        }
        return CommonResult.returnFailsWrapper("无效的查询条件");
    }

    @Override
    public CommonResult<Boolean> batchDelSchoolComment(CommonForm.BatchDel form) {
        if (form == null) {
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        if (form.getIds() == null || form.getIds().size() <= 0) {
            return CommonResult.returnFailsWrapper("请传入主键id");
        }
        Boolean bool = schoolCommentService.batchDelSchoolComment(form);

        return CommonResult.returnBoolWrapper(bool, "批量删除失败");
    }
}