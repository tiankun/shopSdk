package com.redare.shop.unifyworkbench.service.dao;


import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.MySqlJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.SchoolPolicylaw;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.SchoolPolicylawForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 学堂管理-政策法规(SchoolPolicylaw)表数据库访问层
 *
 * @author dengchj
 * @since 2020-10-13 14:23:22
 */
@Repository
public class SchoolPolicylawDao {
    private static final String TABLE = "t_school_policylaw";
    @Autowired
    MySqlJdbcHelper jdbcHelper;

    public long insertSchoolPolicylaw(SchoolPolicylaw form) {
        Sql sql = Sql.insert(TABLE)
                .field("title", form.getTitle())
                .field("content", form.getContent())
                .field("userId", form.getUserId())
                .field("userName", form.getUserName())
                .field("status", 0)
                .field("top", 0)
                .field("createTime", new Date())
                .field("updateTime", new Date());
        return jdbcHelper.insertReturnFieldNumber(sql).longValue();
    }

    public Page<SchoolPolicylaw> queryForPageSchoolPolicylaw(SchoolPolicylawForm.Search form, int curPage, int pageSize, boolean calCount, boolean allList) {
        Sql sql = Sql.select()
                .field("id")
                .field("title")
                .field("content")
                .field("userId")
                .field("userName")
                .field("status")
                .field("top")
                .field("createTime")
                .field("updateTime")
                .from(TABLE)
                .where()
                .andEqIfNotNull("top",form.getTop())
                .andEqIfNotNull("status",form.getStatus())
                .andBlikeJoinByOrIfNotBlank(form.getKey(), "title","content")
                .orderBy().desc("top","updateTime");
        return jdbcHelper.queryForPageBean(sql.getSql().toString(), SchoolPolicylaw.class, sql.getParams().toArray(), curPage, pageSize, calCount, allList);
    }

    public List<SchoolPolicylaw> queryForListSchoolPolicylaw(SchoolPolicylawForm.Search form,int curPage, int pageSize) {
        Sql sql = Sql.select()
                .field("id")
                .field("title")
                .field("content")
                .field("userId")
                .field("status")
                .field("userName")
                .field("top")
                .field("createTime")
                .field("updateTime")
                .from(TABLE)
                .where()
                .andBlikeJoinByOrIfNotBlank(form.getKey(), "title","content")
                .andEq("status",1)
                .andEqIfNotNull("top",form.getTop())

                .orderBy().desc("top","updateTime");
        return jdbcHelper.queryForListBean(sql.getSql().toString(), SchoolPolicylaw.class, sql.getParams().toArray(),curPage,pageSize);
    }

    /**
     * 获取政策法规信息
     * @param form
     * @return
     */
    public SchoolPolicylaw getSchoolPolicylawInfo(SchoolPolicylawForm.Search form) {
        Sql sql = Sql.select()
                .field("id")
                .field("title")
                .field("content")
                .field("userId")
                .field("status")
                .field("top")
                .field("userName")
                .field("createTime")
                .field("updateTime")
                .from(TABLE)
                .where()
                .andEqIfNotNull("id", form.getId())
                .orderBy().desc("updateTime");
        return jdbcHelper.queryForBean(sql.getSql().toString(), SchoolPolicylaw.class, sql.getParams().toArray());
    }

    public int updateSchoolPolicylaw(SchoolPolicylaw form) {
        Sql sql = Sql.update(TABLE)
                .setIfNotBlank("title", form.getTitle())
                .setIfNotBlank("content", form.getContent())
                .setIfNotNull("userId", form.getUserId())
                .setIfNotBlank("userName", form.getUserName())
                .set("updateTime", new Date())
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.update(sql);
    }

    public int updateSchoolPolicylawStatus(SchoolPolicylawForm.changeStatus form) {
        String sql=" update t_school_policylaw set status=? where id=?";
        List<Object> params=new ArrayList<>();
        params.add(form.getStatus());
        params.add(form.getId());
        return jdbcHelper.update(sql, params.toArray());
    }

    public int deleteSchoolPolicylaw(CommonForm.Del form) {
        Sql sql = Sql.delete(TABLE)
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.update(sql);
    }

    public int batchDelSchoolPolicylaw(CommonForm.BatchDel form) {
        Sql sql = Sql.delete(TABLE)
                .where()
                .andIn("id", form.getIds());
        return jdbcHelper.update(sql);
    }

    /**
     * 置顶
     * @param form
     * @return
     */
    public int updateTopStatus(SchoolPolicylawForm.Top form) {
        Sql sql = Sql.update("t_school_policylaw")
                .set("top", form.getTop())
                .where().andEq("id", form.getId());
        return jdbcHelper.update(sql);
    }
}