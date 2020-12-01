package com.redare.shop.unifyworkbench.service.dao;


import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.MySqlJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.Assign;
import com.redare.shop.unifyworkbench.sdk.pojo.AssignStatistics;
import com.redare.shop.unifyworkbench.sdk.pojo.form.AssignForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * 交办表(Assign)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-22 14:32:11
 */
@Repository
public class AssignDao {
    private static final String TABLE = "t_assign";
    @Autowired
    MySqlJdbcHelper jdbcHelper;

    public long insertAssign(Assign form) {
        Sql sql = Sql.insert(TABLE)
                .field("pid", form.getPid())
                .field("assignCode",form.getAssignCode())
                .field("title", form.getTitle())
                .field("typeCode",form.getTypeCode())
                .field("typeName",form.getTypeName())
                .field("content", form.getContent())
                .field("attention", form.getAttention())
                .field("beginDate", form.getBeginDate())
                .field("endDate", form.getEndDate())
                .field("assignUserId", form.getAssignUserId())
                .field("assignUserName", form.getAssignUserName())
                .field("assignOrgId", form.getAssignOrgId())
                .field("assignOrgName", form.getAssignOrgName())
                .field("sendMsg",form.getSendMsg())
                .field("postIds",form.getPostIds())
                .field("underTakeOrgIds", form.getUnderTakeOrgIds())
                .field("images", form.getImages())
                .field("files", form.getFiles())
                .field("updateTime", form.getUpdateTime())
                .field("parentAreaCode", form.getParentAreaCode())
                .field("parentAreaName", form.getParentAreaName())
                .field("parentOrgId", form.getParentOrgId())
                .field("parentOrgName", form.getParentOrgName())
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

    public Page<Assign> queryForPageAssign(AssignForm.Search form, int curPage, int pageSize, boolean calCount, boolean allList) {
        Sql sql = Sql.select()
                .field("id")
                .field("pid")
                .field("assignCode")
                .field("title")
                .field("typeCode")
                .field("typeName")
                .field("content")
                .field("attention")
                .field("beginDate")
                .field("endDate")
                .field("assignUserId")
                .field("assignUserName")
                .field("assignOrgId")
                .field("assignOrgName")
                .field("sendMsg")
                .field("postIds")
                .field("underTakeOrgIds")
                .field("images")
                .field("files")
                .field("createTime")
                .field("updateTime")
                .field("status")
                .field("assignStatus")
                .field("assignTime")
                .field("finishTime")
                .field("parentAreaCode")
                .field("parentAreaName")
                .field("parentOrgId")
                .field("parentOrgName")
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
                .andIsNull("pid")
                .andBetweenOptionIf(form.getBeginTime() != null && form.getEndTime() != null, "createTime", form.getBeginTime(), form.getEndTime())
                .andJoinByOrIf(StringUtils.isNotBlank(form.getOrgId()),()->{
                    List<Sql> sqls = new ArrayList<>();
                    sqls.add(Sql.sql("orgId=?",form.getOrgId()));
                    sqls.add(Sql.sql("find_in_set(?,underTakeOrgIds)",form.getOrgId()));
                    return sqls;
                })
                .orderBy().desc("id");
        return jdbcHelper.queryForPageBean(sql.getSql().toString(), Assign.class, sql.getParams().toArray(), curPage, pageSize, calCount, allList);
    }

    /**
     * 分页列表
     * @param form
     * @param curPage
     * @param pageSize
     * @param calCount
     * @param allList
     * @return
     */
    public Page<Assign> queryAssignPage(AssignForm.Search form, int curPage, int pageSize, boolean calCount, boolean allList){
        Sql sql = Sql.select()
                .fields("t1.*")
                .field("t2.assignStatus","handleStatus")
                .field("t2.status","state")
                .from("t_assign","t1")
                .join("t_assign_handle_info","t2").on("t1.id","t2.assignId")
                .where()
                .andEqIfNotBlank("t2.handleOrgId",form.getOrgId())
                .andIf(StringUtils.isEmpty(form.getOrgId()),()->Sql.sql("t1.assignOrgId = t2.handleOrgId"))
                .andEqIfNotBlank("t1.typeCode",form.getTypeCode())
                .andLikeIfNotBlank("t1.title",form.getTitle())
                .andEqIfNotNull("t2.assignStatus",form.getAssignStatus())
                .orderBy().desc("t2.createTime");
        return jdbcHelper.queryForPageBean(sql.getSql().toString(),Assign.class,sql.getParams().toArray(),curPage,pageSize,calCount,allList);
    }

    public List<Assign> queryForListAssign(AssignForm.Search form) {
        Sql sql = Sql.select()
                .field("id")
                .field("pid")
                .field("assignCode")
                .field("title")
                .field("typeCode")
                .field("typeName")
                .field("content")
                .field("attention")
                .field("beginDate")
                .field("endDate")
                .field("assignUserId")
                .field("assignUserName")
                .field("assignOrgId")
                .field("assignOrgName")
                .field("sendMsg")
                .field("postIds")
                .field("underTakeOrgIds")
                .field("images")
                .field("files")
                .field("createTime")
                .field("updateTime")
                .field("status")
                .field("assignStatus")
                .field("assignTime")
                .field("finishTime")
                .field("parentAreaCode")
                .field("parentAreaName")
                .field("parentOrgId")
                .field("parentOrgName")
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
                .andJoinByOrIf(form.getPid()!=null && StringUtils.isNotBlank(form.getAreaCode()),()->{
                    List<Sql> sqls = new ArrayList<>();
                    sqls.add(Sql.sql("id=?",form.getPid()));
                    sqls.add(Sql.sql("(pid=? and areaCode like ?)",form.getPid(),form.getAreaCode()));
                    return sqls;
                })
                .orderBy().asc("id");
        return jdbcHelper.queryForListBean(sql.getSql().toString(), Assign.class, sql.getParams().toArray());
    }

    public int updateAssign(Assign form) {
        Sql sql = Sql.update(TABLE)
                .setIfNotNull("pid", form.getPid())
                .setIfNotBlank("assignCode",form.getAssignCode())
                .setIfNotBlank("title", form.getTitle())
                .setIfNotBlank("typeCode",form.getTypeCode())
                .setIfNotBlank("typeName",form.getTypeName())
                .setIfNotBlank("content", form.getContent())
                .setIfNotBlank("attention", form.getAttention())
                .setIfNotNull("beginDate", form.getBeginDate())
                .setIfNotNull("endDate", form.getEndDate())
                .setIfNotNull("assignUserId", form.getAssignUserId())
                .setIfNotBlank("assignUserName", form.getAssignUserName())
                .setIfNotBlank("assignOrgId", form.getAssignOrgId())
                .setIfNotBlank("assignOrgName", form.getAssignOrgName())
                .setIfNotNull("sendMsg",form.getSendMsg())
                .setIfNotBlank("postIds",form.getPostIds())
                .setIfNotNull("underTakeOrgIds", form.getUnderTakeOrgIds())
                .setIfNotBlank("images", form.getImages())
                .setIfNotBlank("files", form.getFiles())
                .setIfNotNull("createTime", form.getCreateTime())
                .setIfNotNull("updateTime", form.getUpdateTime())
                .setIfNotNull("status", form.getStatus())
                .setIfNotNull("assignStatus", form.getAssignStatus())
                .setIfNotNull("assignTime", form.getAssignTime())
                .setIfNotNull("finishTime",form.getFinishTime())
                .setIfNotBlank("parentAreaCode", form.getParentAreaCode())
                .setIfNotBlank("parentAreaName", form.getParentAreaName())
                .setIfNotBlank("parentOrgId", form.getParentOrgId())
                .setIfNotBlank("parentOrgName", form.getParentOrgName())
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

    public Assign queryAssign(CommonForm.Del form){
        Sql sql = Sql.select()
                .fields("*")
                .from(TABLE)
                .where()
                .andEqIfNotNull("id",form.getId());
        return jdbcHelper.queryForBean(sql.getSql().toString(),Assign.class,sql.getParams().toArray());
    }

    public int deleteAssign(CommonForm.Del form) {
        Sql sql = Sql.delete(TABLE)
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.update(sql);
    }

    public int deleteAssignByPid(Assign form){
        Sql sql = Sql.delete(TABLE)
                .where()
                .andEq("pid",form.getPid());
        return jdbcHelper.update(sql);
    }

    public int batchDelAssign(CommonForm.BatchDel form) {
        Sql sql = Sql.delete(TABLE)
                .where()
                .andIn("id", form.getIds());
        return jdbcHelper.update(sql);
    }

    /**
     * 根据交办组织及所在区域编码查询承办组织完成情况
     * @param form
     * @return
     */
    public Page<AssignStatistics> queryAssignCompletionRatePage(AssignStatistics form,int curPage, int pageSize, boolean calCount, boolean allList){
        Sql subSql = Sql.select()
                .field("t2.areaCode")
                .field("t2.orgName")
                .field("ROUND(IF(count( DISTINCT t4.id )= 0,100,count(DISTINCT t3.id )*100/count( DISTINCT t4.id )))","completionRate")
                .field("count(DISTINCT t3.id)","completionCount")
                .field("count(DISTINCT t4.id)","totalCount")
                .from("t_area","t1")
                .leftJoin("t_organization","t2").on("t1.areaCode","t2.areaCode")
                .leftJoin("t_assign_handle_info","t3").on("t2.orgId","t3.handleOrgId")
                .and(Sql.sql("t3.assignOrgId = ?",form.getOrgId()))
                .and(Sql.sql("t3.assignStatus = 2"))
                .leftJoin("t_assign_handle_info","t4").on("t2.orgId","t4.handleOrgId")
                .and(Sql.sql("t4.assignOrgId = ?",form.getOrgId()))
                .where()
                .andEqIfNotBlank("t1.parentCode",form.getAreaCode())
                .andEq("t2.status",1)
                .andEq("t2.orgClassify","zx")
                .groupBy("t2.areaCode,t2.orgName")
                .orderBy().ifDesc("workload".equals(form.getSort().trim()),"completionCount")
                .ifDesc(!"workload".equals(form.getSort().trim()),"completionRate");
        Sql sql = Sql.select()
                .field("areaCode")
                .field("orgName")
                .field("CONCAT(completionRate,'%')","completionRate")
                .field("completionCount")
                .field("totalCount")
                .from(subSql,"v");
        return jdbcHelper.queryForPageBean(sql.getSql().toString(),AssignStatistics.class,sql.getParams().toArray(),curPage,pageSize,calCount,allList);
    }
}