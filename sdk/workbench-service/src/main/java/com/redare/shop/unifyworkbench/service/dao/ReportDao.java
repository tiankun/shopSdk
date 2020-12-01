package com.redare.shop.unifyworkbench.service.dao;


import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.MySqlJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.Report;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ReportForm;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 上报表(Report)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-21 14:13:49
 */
@Repository
public class ReportDao {
    private static final String TABLE = "t_report";
    @Autowired
    MySqlJdbcHelper jdbcHelper;

    public long insertReport(Report form) {
        Sql sql = Sql.insert(TABLE)
                .field("title", form.getTitle())
                .field("reportTypeCode", form.getReportTypeCode())
                .field("reportTypeName",form.getReportTypeName())
                .field("reportUserId", form.getReportUserId())
                .field("reportUserName", form.getReportUserName())
                .field("description", form.getDescription())
                .field("images", form.getImages())
                .field("files", form.getFiles())
                .field("updateTime", form.getUpdateTime())
                .field("reportStatus", form.getReportStatus())
                .field("areaCode", form.getAreaCode())
                .field("areaName", form.getAreaName())
                .field("orgId", form.getOrgId())
                .field("orgName", form.getOrgName())
                .field("departmentId", form.getDepartmentId())
                .field("deptName", form.getDeptName())
                .field("userId", form.getUserId())
                .field("userName", form.getUserName());
        return jdbcHelper.insertReturnFieldNumber(sql).longValue();
    }

    public Page<Report> queryForPageReport(ReportForm.Search form, int curPage, int pageSize, boolean calCount, boolean allList) {
        Sql sql = Sql.select()
                .fields("t1.*")
                .field("t2.handleOrgId")
                .field("t2.handleState")
                .from(TABLE,"t1")
                .leftJoin("t_report_handle_record","t2").on("t1.id","t2.reportId")
                .where()
                .andEqIfNotBlank("t2.handleOrgId",form.getOrgId())
                .andIf(StringUtils.isEmpty(form.getOrgId()),()->Sql.sql("t1.orgId = t2.handleOrgId"))
                .andBetweenOptionIf(form.getBeginTime() != null && form.getEndTime() != null, "createTime", form.getBeginTime(), form.getEndTime())
                .andLikeIfNotBlank("title",form.getTitle())
                .andEqIfNotBlank("reportTypeCode",form.getReportTypeCode())
                .andEqIfNotNull("status",form.getStatus())
                .orderBy().desc("id");
        return jdbcHelper.queryForPageBean(sql.getSql().toString(), Report.class, sql.getParams().toArray(), curPage, pageSize, calCount, allList);
    }

    public List<Report> queryForListReport(ReportForm.Search form) {
        Sql sql = Sql.select()
                .field("id")
                .field("title")
                .field("reportTypeCode")
                .field("reportTypeName")
                .field("reportUserId")
                .field("reportUserName")
                .field("description")
                .field("images")
                .field("files")
                .field("createTime")
                .field("updateTime")
                .field("status")
                .field("reportStatus")
                .field("reportTime")
                .field("areaCode")
                .field("areaName")
                .field("orgId")
                .field("orgName")
                .field("departmentId")
                .field("deptName")
                .field("userId")
                .field("userName")
                .from(TABLE)
                .where()
                .andEqIfNotNull("id", form.getId())
                .andBetweenOptionIf(form.getBeginTime() != null && form.getEndTime() != null, "awardTime", form.getBeginTime(), form.getEndTime())
                .orderBy().desc("id");
        return jdbcHelper.queryForListBean(sql.getSql().toString(), Report.class, sql.getParams().toArray());
    }

    public Report queryReport(CommonForm.Del form){
        Sql sql = Sql.select()
                .fields("*")
                .from(TABLE)
                .where()
                .andEqIfNotNull("id",form.getId());
        return jdbcHelper.queryForBean(sql.getSql().toString(),Report.class,sql.getParams().toArray());
    }

    public int updateReport(Report form) {
        Sql sql = Sql.update(TABLE)
                .setIfNotBlank("title", form.getTitle())
                .setIfNotBlank("reportTypeCode", form.getReportTypeCode())
                .setIfNotBlank("reportTypeName",form.getReportTypeName())
                .setIfNotNull("reportUserId", form.getReportUserId())
                .setIfNotBlank("reportUserName", form.getReportUserName())
                .setIfNotBlank("description", form.getDescription())
                .setIfNotBlank("images", form.getImages())
                .setIfNotBlank("files", form.getFiles())
                .setIfNotNull("createTime", form.getCreateTime())
                .setIfNotNull("updateTime", form.getUpdateTime())
                .setIfNotNull("status", form.getStatus())
                .setIfNotNull("reportStatus", form.getReportStatus())
                .setIfNotBlank("areaCode", form.getAreaCode())
                .setIfNotBlank("areaName", form.getAreaName())
                .setIfNotBlank("orgId", form.getOrgId())
                .setIfNotBlank("orgName", form.getOrgName())
                .setIfNotBlank("departmentId", form.getDepartmentId())
                .setIfNotBlank("deptName", form.getDeptName())
                .setIfNotNull("userId", form.getUserId())
                .setIfNotBlank("userName", form.getUserName())
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.update(sql);
    }

    public int deleteReport(CommonForm.Del form) {
        Sql sql = Sql.delete(TABLE)
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.update(sql);
    }

    public int batchDelReport(CommonForm.BatchDel form) {
        Sql sql = Sql.delete(TABLE)
                .where()
                .andIn("id", form.getIds());
        return jdbcHelper.update(sql);
    }
}