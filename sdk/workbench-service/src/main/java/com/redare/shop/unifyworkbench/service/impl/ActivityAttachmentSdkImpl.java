package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.shop.unifyworkbench.sdk.ActivityAttachmentSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.ActivityAttachment;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ActivityAttachmentForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.service.service.ActivityAttachmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学堂管理-素材附件管理(ActivityAttachment)SdkImpl
 *
 * @author dengchj
 * @since 2020-10-19 18:04:07
 */
@Service
public class ActivityAttachmentSdkImpl implements ActivityAttachmentSdk {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityAttachmentSdkImpl.class);
    @Autowired
    ActivityAttachmentService activityAttachmentService;

    @Override
    public CommonResult<Boolean> insertActivityAttachment(ActivityAttachment form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        final long id = activityAttachmentService.insertActivityAttachment(form);
        return CommonResult.returnSuccessWrapper(id > 0);
    }

    @Override
    public CommonResult<Boolean> updateActivityAttachment(ActivityAttachment form) {
        if (form.getUid()== null) {
            return CommonResult.returnFailsWrapper("主键不能为空");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = activityAttachmentService.updateActivityAttachment(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }

    @Override
    public CommonResult<Boolean> deleteActivityAttachment(ActivityAttachmentForm.Del form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = activityAttachmentService.deleteActivityAttachment(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }


    @Override
    public CommonResult<Boolean> updateActivityAttachmentStatus(ActivityAttachmentForm.Edit form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        final ActivityAttachment targetForm = new ActivityAttachment();
        try {
            BeanUtils.copyProperties(form, targetForm);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return CommonResult.returnFailsWrapper(e.getMessage());
        }
        int row = activityAttachmentService.updateActivityAttachment(targetForm);
        return CommonResult.returnSuccessWrapper(row > 0);
    }

    @Override
    public CommonResult<Page<ActivityAttachment>> queryForPageActivityAttachment(ActivityAttachmentForm.Search form, int curPage, int pageSize) {
        Page<ActivityAttachment> data = activityAttachmentService.queryForPageActivityAttachment(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(data);
    }

    @Override
    public CommonResult<List<ActivityAttachment>> queryForListActivityAttachment(ActivityAttachmentForm.Search form) {
        List<ActivityAttachment> data = activityAttachmentService.queryForListActivityAttachment(form);
        return CommonResult.returnSuccessWrapper(data);
    }

    @Override
    public CommonResult<ActivityAttachment> queryActivityAttachment(ActivityAttachmentForm.Search form) {
        List<ActivityAttachment> data = activityAttachmentService.queryForListActivityAttachment(form);
        if (data.size() == 1) {
            return CommonResult.returnSuccessWrapper(data.get(0));
        }
        return CommonResult.returnFailsWrapper("无效的查询条件");
    }

    @Override
    public CommonResult<Boolean> batchDelActivityAttachment(CommonForm.BatchDel form) {
        if (form == null) {
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        if (form.getIds() == null || form.getIds().size() <= 0) {
            return CommonResult.returnFailsWrapper("请传入主键id");
        }
        Boolean bool = activityAttachmentService.batchDelActivityAttachment(form);

        return CommonResult.returnBoolWrapper(bool, "批量删除失败");
    }

    @Override
    public CommonResult<Boolean> batchDelAttachmentByActivityId(ActivityAttachmentForm.GetByActivityId form) {
        if (form == null) {
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        if (form.getActivityId() == null ) {
            return CommonResult.returnFailsWrapper("请传入主键id");
        }
        Boolean bool = activityAttachmentService.batchDelAttachmentByActivityId(form);

        return CommonResult.returnBoolWrapper(bool, "批量删除失败");
    }

    @Override
    public CommonResult<List<ActivityAttachment>> findActivityAttachmentListByActivityId(ActivityAttachmentForm.GetByActivityId form) {
        return CommonResult.returnSuccessWrapper(activityAttachmentService.findActivityAttachmentListByActivityId(form));
    }

    @Override
    public CommonResult<Boolean> batchAddAttachment(ActivityAttachmentForm.BatchAdd form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        Boolean bool = activityAttachmentService.batchAddAttachment(form).length>0;
        return CommonResult.returnBoolWrapper(bool,"批量添加失败");
    }
}