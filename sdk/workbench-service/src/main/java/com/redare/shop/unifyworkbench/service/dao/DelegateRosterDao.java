package com.redare.shop.unifyworkbench.service.dao;


import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.MySqlJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.DelegateRoster;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.DelegateRosterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (DelegateRoster)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-19 17:14:34
 */
@Repository
public class DelegateRosterDao {
    private static final String TABLE = "t_delegate_roster";
    @Autowired
    MySqlJdbcHelper jdbcHelper;

    public long insertDelegateRoster(DelegateRosterForm.Add form) {
        Sql sql = Sql.insert(TABLE)
                .field("name", form.getName())
                .field("remark", form.getRemark())
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

    public Page<DelegateRoster> queryForPageDelegateRoster(DelegateRosterForm.Search form, int curPage, int pageSize, boolean calCount, boolean allList) {
        Sql sql = Sql.select()
                .field("id")
                .field("name")
                .field("remark")
                .field("files")
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
                .andEqIfNotBlank("orgId",form.getOrgId())
                .andEq("status",0)
                .orderBy().desc("id");
        return jdbcHelper.queryForPageBean(sql.getSql().toString(), DelegateRoster.class, sql.getParams().toArray(), curPage, pageSize, calCount, allList);
    }

    public List<DelegateRoster> queryForListDelegateRoster(DelegateRosterForm.Search form) {
        Sql sql = Sql.select()
                .field("id")
                .field("name")
                .field("remark")
                .field("files")
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
                //.andEqIfNotNull("id",form.getId())
                .andEqIfNotBlank("orgId",form.getOrgId())
                .andLikeIfNotBlank("areaCode",form.getAreaCode())
                .andEq("status",0)
                .andBetweenOptionIf(form.getBeginTime() != null && form.getEndTime() != null, "awardTime", form.getBeginTime(), form.getEndTime())
                .orderBy().desc("id");
        return jdbcHelper.queryForListBean(sql.getSql().toString(), DelegateRoster.class, sql.getParams().toArray());
    }

    public int updateDelegateRoster(DelegateRosterForm.Edit form) {
        Sql sql = Sql.update(TABLE)
                .setIfNotBlank("name", form.getName())
                .setIfNotBlank("remark", form.getRemark())
                .setIfNotBlank("files", form.getFiles())
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

    public int deleteDelegateRoster(CommonForm.Del form) {
        Sql sql = Sql.update(TABLE)
                .set("status",-1)
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.update(sql);
    }

    public int batchDelDelegateRoster(CommonForm.BatchDel form) {
        Sql sql = Sql.update(TABLE)
                .set("status",-1)
                .where()
                .andIn("id", form.getIds());
        return jdbcHelper.update(sql);
    }
}