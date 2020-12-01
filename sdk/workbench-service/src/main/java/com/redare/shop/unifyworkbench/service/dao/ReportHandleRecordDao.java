package com.redare.shop.unifyworkbench.service.dao;


import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.MySqlJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.ReportHandleRecord;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ReportHandleRecordForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 上报处理记录表(ReportHandleRecord)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-21 14:15:35
 */
@Repository
public class ReportHandleRecordDao {
    private static final String TABLE = "t_report_handle_record";
    @Autowired
    MySqlJdbcHelper jdbcHelper;

    public long insertReportHandleRecord(ReportHandleRecord form) {
        Sql sql = Sql.insert(TABLE)
                .field("reportId", form.getReportId())
                .field("handleOrgId", form.getHandleOrgId())
                .field("handleOrgName", form.getHandleOrgName())
                .field("handleUserId", form.getHandleUserId())
                .field("handleUserName", form.getHandleUserName())
                .field("handleState",form.getHandleState())
                .field("comment", form.getComment())
                .field("handleResult", form.getHandleResult())
                .field("attachments", form.getAttachments())
                .field("updateTime", form.getUpdateTime())
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

    public Page<ReportHandleRecord> queryForPageReportHandleRecord(ReportHandleRecordForm.Search form, int curPage, int pageSize, boolean calCount, boolean allList) {
        Sql sql = Sql.select()
                .field("id")
                .field("reportId")
                .field("handleOrgId")
                .field("handleOrgName")
                .field("handleUserId")
                .field("handleUserName")
                .field("handleState")
                .field("comment")
                .field("handleResult")
                .field("attachments")
                .field("createTime")
                .field("updateTime")
                .field("status")
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
                .andBetweenOptionIf(form.getBeginTime() != null && form.getEndTime() != null, "createTime", form.getBeginTime(), form.getEndTime())
                .andBlikeJoinByOrIfNotBlank(form.getKey(), "paperName", "journalTitle", "copyrightOwner", "author")
                .orderBy().desc("id");
        return jdbcHelper.queryForPageBean(sql.getSql().toString(), ReportHandleRecord.class, sql.getParams().toArray(), curPage, pageSize, calCount, allList);
    }

    /**
     * 查询处理记录
     * @param form
     * @return
     */
    public List<ReportHandleRecord> queryForListReportHandleRecord(ReportHandleRecordForm.Search form) {
        Sql sql = Sql.select()
                .field("id")
                .field("reportId")
                .field("handleOrgId")
                .field("handleOrgName")
                .field("handleUserId")
                .field("handleUserName")
                .field("handleState")
                .field("comment")
                .field("handleResult")
                .field("attachments")
                .field("createTime")
                .field("updateTime")
                .field("status")
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
                .andEqIfNotNull("reportId",form.getReportId())
                .andNotEqIfNotBlank("handleOrgId",form.getHandleOrgId())
                .orderBy().desc("id");
        return jdbcHelper.queryForListBean(sql.getSql().toString(), ReportHandleRecord.class, sql.getParams().toArray());
    }

    /**
     * 查询上报记录
     * @param form
     * @return
     */
    public List<ReportHandleRecord> queryForListReportRecord(ReportHandleRecordForm.Search form){
        Sql sql = Sql.select()
                .field("id")
                .field("reportId")
                .field("handleOrgId")
                .field("handleOrgName")
                .field("handleUserId")
                .field("handleUserName")
                .field("handleState")
                .field("comment")
                .field("handleResult")
                .field("attachments")
                .field("createTime")
                .field("updateTime")
                .field("status")
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
                .andEqIfNotNull("reportId",form.getReportId())
                .andEq("handleState",1)
                .orderBy().asc("id");
        return jdbcHelper.queryForListBean(sql.getSql().toString(), ReportHandleRecord.class, sql.getParams().toArray());
    }



    public ReportHandleRecord queryReportHandleRecord(ReportHandleRecordForm.Search form){
        Sql sql = Sql.select()
                .from(TABLE)
                .where()
                .andEqIfNotNull("id",form.getId())
                .andEqIfNotNull("reportId",form.getReportId())
                .andEqIfNotBlank("handleOrgId",form.getHandleOrgId());
        return jdbcHelper.queryForBean(sql.getSql().toString(),ReportHandleRecord.class,sql.getParams().toArray());
    }

    public int updateReportHandleRecord(ReportHandleRecord form) {
        Sql sql = Sql.update(TABLE)
                .setIfNotNull("reportId", form.getReportId())
                .setIfNotBlank("handleOrgId", form.getHandleOrgId())
                .setIfNotBlank("handleOrgName", form.getHandleOrgName())
                .setIfNotNull("handleUserId", form.getHandleUserId())
                .setIfNotBlank("handleUserName", form.getHandleUserName())
                .setIfNotNull("handleState", form.getHandleState())
                .setIfNotBlank("comment", form.getComment())
                .setIfNotBlank("handleResult", form.getHandleResult())
                .setIfNotBlank("attachments", form.getAttachments())
                .setIfNotNull("createTime", form.getCreateTime())
                .setIfNotNull("updateTime", form.getUpdateTime())
                .setIfNotNull("status", form.getStatus())
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

    public int deleteReportHandleRecord(CommonForm.Del form) {
        Sql sql = Sql.delete(TABLE)
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.update(sql);
    }

    public int batchDelReportHandleRecord(CommonForm.BatchDel form) {
        Sql sql = Sql.delete(TABLE)
                .where()
                .andIn("id", form.getIds());
        return jdbcHelper.update(sql);
    }
}