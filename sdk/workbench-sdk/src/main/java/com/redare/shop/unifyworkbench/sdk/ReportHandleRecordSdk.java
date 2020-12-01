package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.ReportHandleRecord;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ReportHandleRecordForm;

import java.util.List;

/**
 * 上报处理记录表(ReportHandleRecord)SDK
 *
 * @author makejava
 * @since 2020-10-21 14:14:24
 */
public interface ReportHandleRecordSdk {

    CommonResult<Boolean> insertReportHandleRecord(ReportHandleRecord form);

    CommonResult<Boolean> updateReportHandleRecord(ReportHandleRecord form);

    CommonResult<Boolean> deleteReportHandleRecord(CommonForm.Del form);

    CommonResult<Boolean> updateReportHandleRecordStatus(ReportHandleRecordForm.Edit form);

    CommonResult<Page<ReportHandleRecord>> queryForPageReportHandleRecord(ReportHandleRecordForm.Search form, int curPage, int pageSize);

    CommonResult<List<ReportHandleRecord>> queryForListReportHandleRecord(ReportHandleRecordForm.Search form);

    CommonResult<List<ReportHandleRecord>> queryForListReportRecord(ReportHandleRecordForm.Search form);

    CommonResult<ReportHandleRecord> queryReportHandleRecord(ReportHandleRecordForm.Search form);

    CommonResult<Boolean> batchDelReportHandleRecord(CommonForm.BatchDel form);

    /**
     * 上报
     * @param form
     * @return
     */
    CommonResult<Boolean> pushReport(ReportHandleRecord form);

    /**
     * 上报处理
     * @param form
     * @return
     */
    CommonResult<Boolean> handleReport(ReportHandleRecord form);

}