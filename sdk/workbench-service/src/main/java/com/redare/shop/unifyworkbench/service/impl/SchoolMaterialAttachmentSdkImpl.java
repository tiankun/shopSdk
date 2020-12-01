package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.shop.unifyworkbench.sdk.SchoolMaterialAttachmentSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.SchoolMaterialAttachment;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.SchoolMaterialAttachmentForm;
import com.redare.shop.unifyworkbench.service.service.SchoolMaterialAttachmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 素材附件管理(SchoolMaterialAttachment)SdkImpl
 *
 * @author dengchj
 * @since 2020-10-13 14:23:01
 */
@Service
public class SchoolMaterialAttachmentSdkImpl implements SchoolMaterialAttachmentSdk {
    private static final Logger LOGGER = LoggerFactory.getLogger(SchoolMaterialAttachmentSdkImpl.class);
    @Autowired
    SchoolMaterialAttachmentService schoolMaterialAttachmentService;

    @Override
    public CommonResult<Boolean> insertSchoolMaterialAttachment(SchoolMaterialAttachment form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        final long id = schoolMaterialAttachmentService.insertSchoolMaterialAttachment(form);
        return CommonResult.returnSuccessWrapper(id > 0);
    }

    @Override
    public CommonResult<Boolean> updateSchoolMaterialAttachment(SchoolMaterialAttachment form) {
        if (form.getUid() == null) {
            return CommonResult.returnFailsWrapper("主键不能为空");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = schoolMaterialAttachmentService.updateSchoolMaterialAttachment(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }

    @Override
    public CommonResult<Boolean> deleteSchoolMaterialAttachment(CommonForm.Del form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = schoolMaterialAttachmentService.deleteSchoolMaterialAttachment(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }


    @Override
    public CommonResult<Boolean> updateSchoolMaterialAttachmentStatus(SchoolMaterialAttachmentForm.Edit form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        final SchoolMaterialAttachment targetForm = new SchoolMaterialAttachment();
        try {
            BeanUtils.copyProperties(form, targetForm);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return CommonResult.returnFailsWrapper(e.getMessage());
        }
        int row = schoolMaterialAttachmentService.updateSchoolMaterialAttachment(targetForm);
        return CommonResult.returnSuccessWrapper(row > 0);
    }

    @Override
    public CommonResult<Page<SchoolMaterialAttachment>> queryForPageSchoolMaterialAttachment(SchoolMaterialAttachmentForm.Search form, int curPage, int pageSize) {
        Page<SchoolMaterialAttachment> data = schoolMaterialAttachmentService.queryForPageSchoolMaterialAttachment(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(data);
    }

    @Override
    public CommonResult<List<SchoolMaterialAttachment>> queryForListSchoolMaterialAttachment(SchoolMaterialAttachmentForm.Search form) {
        List<SchoolMaterialAttachment> data = schoolMaterialAttachmentService.queryForListSchoolMaterialAttachment(form);
        return CommonResult.returnSuccessWrapper(data);
    }

    @Override
    public CommonResult<SchoolMaterialAttachment> querySchoolMaterialAttachment(SchoolMaterialAttachmentForm.Search form) {
        List<SchoolMaterialAttachment> data = schoolMaterialAttachmentService.queryForListSchoolMaterialAttachment(form);
        if (data.size() == 1) {
            return CommonResult.returnSuccessWrapper(data.get(0));
        }
        return CommonResult.returnFailsWrapper("无效的查询条件");
    }

    @Override
    public CommonResult<Boolean> batchDelSchoolMaterialAttachment(CommonForm.BatchDel form) {
        if (form == null) {
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        if (form.getIds() == null || form.getIds().size() <= 0) {
            return CommonResult.returnFailsWrapper("请传入主键id");
        }
        Boolean bool = schoolMaterialAttachmentService.batchDelSchoolMaterialAttachment(form);

        return CommonResult.returnBoolWrapper(bool, "批量删除失败");
    }

    @Override
    public CommonResult<Boolean> batchDelAttachmentByMaterialId(SchoolMaterialAttachmentForm.BatchDel form) {
        if (form == null) {
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        if (form.getMaterialId() == null || form.getMaterialId().size() <= 0) {
            return CommonResult.returnFailsWrapper("请传入主键id");
        }
        Boolean bool = schoolMaterialAttachmentService.batchDelAttachmentByMaterialId(form);

        return CommonResult.returnBoolWrapper(bool, "批量删除失败");
    }

    @Override
    public CommonResult<List<SchoolMaterialAttachment>> findMaterialAttachmentListByMaterialId(SchoolMaterialAttachmentForm.GetByMaterialId form) {
        return CommonResult.returnSuccessWrapper(schoolMaterialAttachmentService.findMaterialAttachmentListByMaterialId(form));
    }

    @Override
    public CommonResult<Boolean> batchAddAttachment(SchoolMaterialAttachmentForm.BatchAdd form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        Boolean bool = schoolMaterialAttachmentService.batchAddAttachment(form).length>0;
        return CommonResult.returnBoolWrapper(bool,"批量添加失败");
    }
}