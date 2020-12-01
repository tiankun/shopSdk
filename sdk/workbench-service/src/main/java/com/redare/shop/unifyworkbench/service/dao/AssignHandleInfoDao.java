package com.redare.shop.unifyworkbench.service.dao;


import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.MySqlJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.AssignHandleInfo;
import com.redare.shop.unifyworkbench.sdk.pojo.form.AssignHandleInfoForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 交办办理情况表(AssignHandleInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-27 10:03:34
 */
@Repository
public class AssignHandleInfoDao {
    private static final String TABLE = "t_assign_handle_info";
    @Autowired
    MySqlJdbcHelper jdbcHelper;

    public long insertAssignHandleInfo(AssignHandleInfo form) {
        Sql sql = Sql.insert(TABLE)
                .field("assignId", form.getAssignId())
                .field("handleOrgId", form.getHandleOrgId())
                .field("handleOrgName", form.getHandleOrgName())
                .field("handleUserId", form.getHandleUserId())
                .field("handleUserName", form.getHandleUserName())
                .field("situation", form.getSituation())
                .field("assignStatus", form.getAssignStatus())
                .field("planEndDate",form.getPlanEndDate())
                .field("assignOrgId",form.getAssignOrgId())
                .field("assignOrgName",form.getAssignOrgName())
                .field("images", form.getImages())
                .field("files", form.getFiles())
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

    public Page<AssignHandleInfo> queryForPageAssignHandleInfo(AssignHandleInfoForm.Search form, int curPage, int pageSize, boolean calCount, boolean allList) {
        Sql sql = Sql.select()
                .field("id")
                .field("assignId")
                .field("handleOrgId")
                .field("handleOrgName")
                .field("handleUserId")
                .field("handleUserName")
                .field("situation")
                .field("assignStatus")
                .field("planEndDate")
                .field("assignOrgId")
                .field("assignOrgName")
                .field("status")
                .field("images")
                .field("files")
                .field("createTime")
                .field("updateTime")
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
                .andEqIfNotNull("assignId",form.getAssignId())
                .andEqIfNotBlank("assignOrgId",form.getAssignOrgId())
                .orderBy().desc("id");
        return jdbcHelper.queryForPageBean(sql.getSql().toString(), AssignHandleInfo.class, sql.getParams().toArray(), curPage, pageSize, calCount, allList);
    }

    public List<AssignHandleInfo> queryForListAssignHandleInfo(AssignHandleInfoForm.Search form) {
        Sql sql = Sql.select()
                .field("id")
                .field("assignId")
                .field("handleOrgId")
                .field("handleOrgName")
                .field("handleUserId")
                .field("handleUserName")
                .field("situation")
                .field("assignStatus")
                .field("status")
                .field("planEndDate")
                .field("assignOrgId")
                .field("assignOrgName")
                .field("images")
                .field("files")
                .field("createTime")
                .field("updateTime")
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
                .andEqIfNotNull("assignId",form.getAssignId())
                .andEqIfNotBlank("assignOrgId",form.getAssignOrgId())
                .andIf(StringUtils.isEmpty(form.getAssignOrgId()),()->Sql.sql("assignOrgId is not null"))
                .andEqIfNotBlank("handleOrgId",form.getHandleOrgId())
                .andInIfNotEmpty("assignStatus",form.getAssignStatusList())
                .orderBy().desc("id");
        return jdbcHelper.queryForListBean(sql.getSql().toString(), AssignHandleInfo.class, sql.getParams().toArray());
    }

    public AssignHandleInfo queryAssignHandleInfo(AssignHandleInfo form){
        Sql sql = Sql.select()
                .from(TABLE)
                .where()
                .andEqIfNotNull("id",form.getId())
                .andEqIfNotNull("assignId",form.getAssignId())
                .andEqIfNotBlank("handleOrgId",form.getHandleOrgId());
        return jdbcHelper.queryForBean(sql.getSql().toString(),AssignHandleInfo.class,sql.getParams().toArray());
    }

    public int updateAssignHandleInfo(AssignHandleInfo form) {
        Sql sql = Sql.update(TABLE)
                .setIfNotNull("assignId", form.getAssignId())
                .setIfNotBlank("handleOrgId", form.getHandleOrgId())
                .setIfNotBlank("handleOrgName", form.getHandleOrgName())
                .setIfNotNull("handleUserId", form.getHandleUserId())
                .setIfNotBlank("handleUserName", form.getHandleUserName())
                .setIfNotBlank("situation", form.getSituation())
                .setIfNotNull("assignStatus", form.getAssignStatus())
                .setIfNotNull("status", form.getStatus())
                .setIfNotNull("planEndDate",form.getPlanEndDate())
                .setIfNotBlank("assignOrgId",form.getAssignOrgId())
                .setIfNotBlank("assignOrgName",form.getAssignOrgName())
                .setIfNotBlank("images", form.getImages())
                .setIfNotBlank("files", form.getFiles())
                .setIfNotNull("createTime", form.getCreateTime())
                .setIfNotNull("updateTime", form.getUpdateTime())
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

    public int deleteAssignHandleInfo(CommonForm.Del form) {
        Sql sql = Sql.delete(TABLE)
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.update(sql);
    }

    public int batchDelAssignHandleInfo(CommonForm.BatchDel form) {
        Sql sql = Sql.delete(TABLE)
                .where()
                .andIn("id", form.getIds());
        return jdbcHelper.update(sql);
    }
}