package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.shop.unifyworkbench.sdk.ReportSdk;
import com.redare.shop.unifyworkbench.sdk.UserMessageSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.Report;
import com.redare.shop.unifyworkbench.sdk.pojo.ReportHandleRecord;
import com.redare.shop.unifyworkbench.sdk.pojo.UserMessage;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ReportForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ReportHandleRecordForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserMessageForm;
import com.redare.shop.unifyworkbench.service.service.ReportHandleRecordService;
import com.redare.shop.unifyworkbench.service.service.ReportService;
import com.redare.shop.unifyworkbench.service.service.UserMessageService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 上报表(Report)SdkImpl
 *
 * @author makejava
 * @since 2020-10-21 14:13:50
 */
@Service
public class ReportSdkImpl implements ReportSdk {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReportSdkImpl.class);
    @Autowired
    ReportService reportService;
    @Autowired
    ReportHandleRecordService reportHandleRecordService;
    @Autowired
    UserMessageService userMessageService;
    @Autowired
    UserMessageSdk userMessageSdk;

    @Override
    public CommonResult<Boolean> insertReport(Report form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        final long id = reportService.insertReport(form);
        return CommonResult.returnSuccessWrapper(id > 0);
    }

    @Override
    public CommonResult<Boolean> updateReport(Report form) {
        if (form.getId() == null) {
            return CommonResult.returnFailsWrapper("主键不能为空");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = reportService.updateReport(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }

    @Override
    @Transactional
    public CommonResult<Boolean> deleteReport(CommonForm.Del form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = reportService.deleteReport(form);
        ReportHandleRecordForm.Search search = new ReportHandleRecordForm.Search();
        search.setReportId(form.getId());
        List<ReportHandleRecord> list = reportHandleRecordService.queryForListReportHandleRecord(search);
        try {
            if(CollectionUtils.isNotEmpty(list)){
                for(ReportHandleRecord handleRecord:list){
                    CommonForm.Del del = new CommonForm.Del();
                    del.setId(handleRecord.getId());
                    reportHandleRecordService.deleteReportHandleRecord(del);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return CommonResult.returnSuccessWrapper(false);
        }
        return CommonResult.returnSuccessWrapper(row > 0);
    }


    @Override
    public CommonResult<Boolean> updateReportStatus(ReportForm.Edit form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        final Report targetForm = new Report();
        try {
            BeanUtils.copyProperties(form, targetForm);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return CommonResult.returnFailsWrapper(e.getMessage());
        }
        int row = reportService.updateReport(targetForm);
        return CommonResult.returnSuccessWrapper(row > 0);
    }

    @Override
    public CommonResult<Page<Report>> queryForPageReport(ReportForm.Search form, int curPage, int pageSize) {
        Page<Report> data = reportService.queryForPageReport(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(data);
    }

    @Override
    public CommonResult<List<Report>> queryForListReport(ReportForm.Search form) {
        List<Report> data = reportService.queryForListReport(form);
        return CommonResult.returnSuccessWrapper(data);
    }

    @Override
    public CommonResult<Report> queryReport(ReportForm.Search form) {
        List<Report> data = reportService.queryForListReport(form);
        if (data.size() == 1) {
            UserMessageForm.GetByUserId getForm = new UserMessageForm.GetByUserId();
            getForm.setUserId(form.getUserId());
            getForm.setBizId(form.getId().toString());
            getForm.setBizTable("t_report");
            List<UserMessage> list = userMessageService.getUserMessageByUserId(getForm);
            if(list.size()==1){
                UserMessageForm.Edit editForm = new UserMessageForm.Edit();
                editForm.setId(list.get(0).getId());
                userMessageSdk.editReadedAndreadTime(editForm);
            }
            return CommonResult.returnSuccessWrapper(data.get(0));
        }
        return CommonResult.returnFailsWrapper("无效的查询条件");
    }

    @Override
    public CommonResult<Boolean> batchDelReport(CommonForm.BatchDel form) {
        if (form == null) {
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        if (form.getIds() == null || form.getIds().size() <= 0) {
            return CommonResult.returnFailsWrapper("请传入主键id");
        }
        Boolean bool = reportService.batchDelReport(form);

        return CommonResult.returnBoolWrapper(bool, "批量删除失败");
    }

    @Override
    public CommonResult<Boolean> fillReport(Report form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return CommonResult.returnSuccessWrapper(reportService.fillReport(form));
    }
}