package com.redare.shop.unifyworkbench.service.dao;


import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.MySqlJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.DelegateRosterUser;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.DelegateRosterUserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 代表名册人员列表(DelegateRosterUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-19 17:18:55
 */
@Repository
public class DelegateRosterUserDao {
    private static final String TABLE = "t_delegate_roster_user";
    @Autowired
    MySqlJdbcHelper jdbcHelper;

    public long insertDelegateRosterUser(DelegateRosterUserForm.Add form) {
        Sql sql = Sql.insert(TABLE)
                .field("rosterId", form.getRosterId())
                .field("recordId", form.getRecordId())
                .field("name", form.getName())
                .field("workUnit", form.getWorkUnit())
                .field("nationDictId",form.getNationDictId())
                .field("nation", form.getNation())
                .field("nativePlace", form.getNativePlace())
                .field("birthday", form.getBirthday())
                .field("idCardNo", form.getIdCardNo())
                .field("workDate", form.getWorkDate())
                .field("educationDictId",form.getEducationDictId())
                .field("education", form.getEducation())
                .field("partiesDictId",form.getPartiesDictId())
                .field("parties", form.getParties())
                .field("title", form.getTitle())
                .field("mobile", form.getMobile())
                .field("remark", form.getRemark())
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

    public long insertDelegateRosterUser(DelegateRosterUserForm.Add form,Long recordId) {
        Sql sql = Sql.insert(TABLE)
                .field("rosterId", form.getRosterId())
                .field("recordId", recordId)
                .field("name", form.getName())
                .field("workUnit", form.getWorkUnit())
                .field("nationDictId",form.getNationDictId())
                .field("nation", form.getNation())
                .field("nativePlace", form.getNativePlace())
                .field("birthday", form.getBirthday())
                .field("idCardNo", form.getIdCardNo())
                .field("workDate", form.getWorkDate())
                .field("educationDictId",form.getEducationDictId())
                .field("education", form.getEducation())
                .field("partiesDictId",form.getPartiesDictId())
                .field("parties", form.getParties())
                .field("title", form.getTitle())
                .field("mobile", form.getMobile())
                .field("remark", form.getRemark())
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

    public Page<DelegateRosterUser> queryForPageDelegateRosterUser(DelegateRosterUserForm.Search form, int curPage, int pageSize, boolean calCount, boolean allList) {
        Sql sql = Sql.select()
                .field("id")
                .field("rosterId")
                .field("recordId")
                .field("name")
                .field("workUnit")
                .field("nation")
                .field("nativePlace")
                .field("birthday")
                .field("idCardNo")
                .field("workDate")
                .field("education")
                .field("parties")
                .field("title")
                .field("mobile")
                .field("remark")
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
                .andLikeIfNotBlank("name",form.getName())
                .andLikeIfNotBlank("mobile",form.getMobile())
                .andEq("rosterId",form.getRosterId())
                .andEq("status",0)
                .orderBy().desc("id");
        return jdbcHelper.queryForPageBean(sql.getSql().toString(), DelegateRosterUser.class, sql.getParams().toArray(), curPage, pageSize, calCount, allList);
    }

    public List<DelegateRosterUser> queryForListDelegateRosterUser(DelegateRosterUserForm.Search form) {
        Sql sql = Sql.select()
                .field("id")
                .field("rosterId")
                .field("recordId")
                .field("name")
                .field("workUnit")
                .field("nation")
                .field("nativePlace")
                .field("birthday")
                .field("idCardNo")
                .field("workDate")
                .field("education")
                .field("parties")
                .field("title")
                .field("mobile")
                .field("remark")
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
                .andBetweenOptionIf(form.getBeginTime() != null && form.getEndTime() != null, "awardTime", form.getBeginTime(), form.getEndTime())
                .orderBy().desc("id");
        return jdbcHelper.queryForListBean(sql.getSql().toString(), DelegateRosterUser.class, sql.getParams().toArray());
    }

    public int updateDelegateRosterUser(DelegateRosterUserForm.Edit form) {
        Sql sql = Sql.update(TABLE)
                .setIfNotNull("rosterId", form.getRosterId())
                .setIfNotNull("recordId", form.getRecordId())
                .setIfNotBlank("name", form.getName())
                .setIfNotBlank("workUnit", form.getWorkUnit())
                .setIfNotBlank("nation", form.getNation())
                .setIfNotBlank("nativePlace", form.getNativePlace())
                .setIfNotNull("birthday", form.getBirthday())
                .setIfNotBlank("idCardNo", form.getIdCardNo())
                .setIfNotNull("workDate", form.getWorkDate())
                .setIfNotBlank("education", form.getEducation())
                .setIfNotBlank("parties", form.getParties())
                .setIfNotBlank("title", form.getTitle())
                .setIfNotBlank("mobile", form.getMobile())
                .setIfNotBlank("remark", form.getRemark())
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

    public int deleteDelegateRosterUser(CommonForm.Del form) {
        Sql sql = Sql.update(TABLE)
                .set("status",-1)
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.update(sql);
    }

    public DelegateRosterUser queryDelegateRosterUser(DelegateRosterUserForm.Get form){
        Sql sql = Sql.select()
                .from(TABLE)
                .where()
                .andEqIfNotNull("id",form.getId())
                .andEqIfNotNull("rosterId",form.getRosterId())
                .andEqIfNotBlank("mobile",form.getMobile())
                .andEqIfNotBlank("idCardNo",form.getIdCardNo())
                .andEq("status","0");
        return jdbcHelper.queryForBean(sql.getSql().toString(),DelegateRosterUser.class,sql.getParams().toArray());
    }

    public int batchDelDelegateRosterUser(DelegateRosterUserForm.BatchDel form) {
        Sql sql = Sql.update(TABLE)
                .set("status",-1)
                .where()
                .andIn("id", form.getIds())
                .andEqIfNotNull("rosterId",form.getRosterId());
        return jdbcHelper.update(sql);
    }
}