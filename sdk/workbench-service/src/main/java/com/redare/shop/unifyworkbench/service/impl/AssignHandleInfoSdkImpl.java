package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.shop.unifyworkbench.sdk.AssignHandleInfoSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.AssignHandleInfo;
import com.redare.shop.unifyworkbench.sdk.pojo.form.AssignHandleInfoForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.service.service.AssignHandleInfoService;
import com.redare.shop.unifyworkbench.service.service.AssignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 交办办理情况表(AssignHandleInfo)SdkImpl
 *
 * @author makejava
 * @since 2020-10-21 14:11:41
 */
@Service
public class AssignHandleInfoSdkImpl implements AssignHandleInfoSdk {
    private static final Logger LOGGER = LoggerFactory.getLogger(AssignHandleInfoSdkImpl.class);
    @Autowired
    AssignHandleInfoService assignHandleInfoService;
    @Autowired
    AssignService assignService;

    @Override
    public CommonResult<Boolean> insertAssignHandleInfo(AssignHandleInfo form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        final long id = assignHandleInfoService.insertAssignHandleInfo(form);
        return CommonResult.returnSuccessWrapper(id > 0);
    }

    @Override
    public CommonResult<Boolean> updateAssignHandleInfo(AssignHandleInfo form) {
        if (form.getId() == null) {
            return CommonResult.returnFailsWrapper("主键不能为空");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = assignHandleInfoService.updateAssignHandleInfo(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }

    @Override
    public CommonResult<Boolean> deleteAssignHandleInfo(CommonForm.Del form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = assignHandleInfoService.deleteAssignHandleInfo(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }


    @Override
    public CommonResult<Boolean> updateAssignHandleInfoStatus(AssignHandleInfoForm.Edit form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        final AssignHandleInfo targetForm = new AssignHandleInfo();
        try {
            BeanUtils.copyProperties(form, targetForm);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return CommonResult.returnFailsWrapper(e.getMessage());
        }
        int row = assignHandleInfoService.updateAssignHandleInfo(targetForm);
        return CommonResult.returnSuccessWrapper(row > 0);
    }

    @Override
    public CommonResult<Page<AssignHandleInfo>> queryForPageAssignHandleInfo(AssignHandleInfoForm.Search form, int curPage, int pageSize) {
        Page<AssignHandleInfo> data = assignHandleInfoService.queryForPageAssignHandleInfo(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(data);
    }

    @Override
    public CommonResult<List<AssignHandleInfo>> queryForListAssignHandleInfo(AssignHandleInfoForm.Search form) {
        List<AssignHandleInfo> data = assignHandleInfoService.queryForListAssignHandleInfo(form);
        return CommonResult.returnSuccessWrapper(data);
    }

    @Override
    public CommonResult<AssignHandleInfo> queryAssignHandleInfo(AssignHandleInfoForm.Search form) {
        List<AssignHandleInfo> data = assignHandleInfoService.queryForListAssignHandleInfo(form);
        if (data.size() == 1) {
            return CommonResult.returnSuccessWrapper(data.get(0));
        }
        return CommonResult.returnFailsWrapper("无效的查询条件");
    }

    @Override
    public CommonResult<Boolean> batchDelAssignHandleInfo(CommonForm.BatchDel form) {
        if (form == null) {
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        if (form.getIds() == null || form.getIds().size() <= 0) {
            return CommonResult.returnFailsWrapper("请传入主键id");
        }
        Boolean bool = assignHandleInfoService.batchDelAssignHandleInfo(form);

        return CommonResult.returnBoolWrapper(bool, "批量删除失败");
    }

    @Override
    public CommonResult<Boolean> handleAssign(AssignHandleInfo form) {
        if (form.getId() == null) {
            return CommonResult.returnFailsWrapper("主键不能为空");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return CommonResult.returnSuccessWrapper(assignHandleInfoService.handleAssign(form));
    }

    @Override
    public CommonResult<Boolean> finishAssign(AssignHandleInfo form) {
        if (form.getId() == null) {
            return CommonResult.returnFailsWrapper("主键不能为空");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return CommonResult.returnSuccessWrapper(assignHandleInfoService.finishAssign(form));
    }

    @Override
    public CommonResult<AssignHandleInfo> getAssignHandleInfo(AssignHandleInfo form) {
        if (form == null) {
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        return CommonResult.returnSuccessWrapper(assignHandleInfoService.queryAssignHandleInfo(form));
    }
}