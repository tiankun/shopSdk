package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.shop.unifyworkbench.sdk.ReportHandleRecordSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.ReportHandleRecord;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ReportHandleRecordForm;
import com.redare.shop.unifyworkbench.service.service.ReportHandleRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 上报处理记录表(ReportHandleRecord)SdkImpl
 *
 * @author makejava
 * @since 2020-10-21 14:15:35
 */
@Service
public class ReportHandleRecordSdkImpl implements ReportHandleRecordSdk {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReportHandleRecordSdkImpl.class);
    @Autowired
    ReportHandleRecordService reportHandleRecordService;

    @Override
    public CommonResult<Boolean> insertReportHandleRecord(ReportHandleRecord form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        final long id = reportHandleRecordService.insertReportHandleRecord(form);
        return CommonResult.returnSuccessWrapper(id > 0);
    }

    @Override
    public CommonResult<Boolean> updateReportHandleRecord(ReportHandleRecord form) {
        if (form.getId() == null) {
            return CommonResult.returnFailsWrapper("主键不能为空");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = reportHandleRecordService.updateReportHandleRecord(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }

    @Override
    public CommonResult<Boolean> deleteReportHandleRecord(CommonForm.Del form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = reportHandleRecordService.deleteReportHandleRecord(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }


    @Override
    public CommonResult<Boolean> updateReportHandleRecordStatus(ReportHandleRecordForm.Edit form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        final ReportHandleRecord targetForm = new ReportHandleRecord();
        try {
            BeanUtils.copyProperties(form, targetForm);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return CommonResult.returnFailsWrapper(e.getMessage());
        }
        int row = reportHandleRecordService.updateReportHandleRecord(targetForm);
        return CommonResult.returnSuccessWrapper(row > 0);
    }

    @Override
    public CommonResult<Page<ReportHandleRecord>> queryForPageReportHandleRecord(ReportHandleRecordForm.Search form, int curPage, int pageSize) {
        Page<ReportHandleRecord> data = reportHandleRecordService.queryForPageReportHandleRecord(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(data);
    }

    @Override
    public CommonResult<List<ReportHandleRecord>> queryForListReportHandleRecord(ReportHandleRecordForm.Search form) {
        if (form == null) {
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        List<ReportHandleRecord> data = reportHandleRecordService.queryForListReportHandleRecord(form);
        return CommonResult.returnSuccessWrapper(data);
    }

    @Override
    public CommonResult<List<ReportHandleRecord>> queryForListReportRecord(ReportHandleRecordForm.Search form) {
        if(form==null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        List<ReportHandleRecord> data = reportHandleRecordService.queryForListReportRecord(form);
        return CommonResult.returnSuccessWrapper(data);
    }

    @Override
    public CommonResult<ReportHandleRecord> queryReportHandleRecord(ReportHandleRecordForm.Search form) {
        if (form == null) {
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        return CommonResult.returnSuccessWrapper(reportHandleRecordService.queryForReportHandleRecord(form));
    }

    @Override
    public CommonResult<Boolean> batchDelReportHandleRecord(CommonForm.BatchDel form) {
        if (form == null) {
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        if (form.getIds() == null || form.getIds().size() <= 0) {
            return CommonResult.returnFailsWrapper("请传入主键id");
        }
        Boolean bool = reportHandleRecordService.batchDelReportHandleRecord(form);

        return CommonResult.returnBoolWrapper(bool, "批量删除失败");
    }

    @Override
    public CommonResult<Boolean> pushReport(ReportHandleRecord form) {
        if (form.getId() == null) {
            return CommonResult.returnFailsWrapper("主键不能为空");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return CommonResult.returnSuccessWrapper(reportHandleRecordService.pushReport(form));
    }

    @Override
    public CommonResult<Boolean> handleReport(ReportHandleRecord form) {
        if (form.getId() == null) {
            return CommonResult.returnFailsWrapper("主键不能为空");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return CommonResult.returnSuccessWrapper(reportHandleRecordService.handleReport(form));
    }
}