package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.Report;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ReportForm;

import java.util.List;

/**
 * 上报表(Report)SDK
 *
 * @author makejava
 * @since 2020-10-21 14:12:53
 */
public interface ReportSdk {

    CommonResult<Boolean> insertReport(Report form);

    CommonResult<Boolean> updateReport(Report form);

    CommonResult<Boolean> deleteReport(CommonForm.Del form);

    CommonResult<Boolean> updateReportStatus(ReportForm.Edit form);

    CommonResult<Page<Report>> queryForPageReport(ReportForm.Search form, int curPage, int pageSize);

    CommonResult<List<Report>> queryForListReport(ReportForm.Search form);

    CommonResult<Report> queryReport(ReportForm.Search form);

    CommonResult<Boolean> batchDelReport(CommonForm.BatchDel form);

    /**
     * 上报填报
     * @param form
     * @return
     */
    CommonResult<Boolean> fillReport(Report form);

}