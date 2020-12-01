package com.redare.shop.unifyworkbench.service.dao;


import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.MySqlJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.SchoolNumberposition;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.SchoolNumberpositionForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 学堂管理-数字阵地(SchoolNumberposition)表数据库访问层
 *
 * @author dengchj
 * @since 2020-10-13 14:23:11
 */
@Repository
public class SchoolNumberpositionDao {
    private static final String TABLE = "t_school_numberposition";
    @Autowired
    MySqlJdbcHelper jdbcHelper;

    public long insertSchoolNumberposition(SchoolNumberposition form) {
        Sql sql = Sql.insert(TABLE)
                .field("title", form.getTitle())
                .field("orgId", form.getOrgId())
                .field("orgName", form.getOrgName())
                .field("content", form.getContent())
                .field("links", form.getLinks())
                .field("userId", form.getUserId())
                .field("userName", form.getUserName())
                .field("status", 0)
                .field("picture",form.getPicture())
                .field("createTime", new Date())
                .field("updateTime", new Date());
        return jdbcHelper.insertReturnFieldNumber(sql).longValue();
    }

    public Page<SchoolNumberposition> queryForPageSchoolNumberposition(SchoolNumberpositionForm.Search form, int curPage, int pageSize, boolean calCount, boolean allList) {
        Sql sql = Sql.select()
                .field("id")
                .field("title")
                .field("orgId")
                .field("orgName")
                .field("content")
                .field("links")
                .field("userId")
                .field("userName")
                .field("status")
                .field("createTime")
                .field("updateTime")
                .field("picture")
                .from(TABLE)
                .where()
                .andEqIfNotNull("orgId",form.getOrgId())
                .andEqIfNotNull("userId",form.getUserId())
                .andBlikeJoinByOrIfNotBlank(form.getKey(), "title")
                .orderBy().desc("updateTime");
        return jdbcHelper.queryForPageBean(sql.getSql().toString(), SchoolNumberposition.class, sql.getParams().toArray(), curPage, pageSize, calCount, allList);
    }

    public List<SchoolNumberposition> queryForListSchoolNumberposition(SchoolNumberpositionForm.Search form,int curPage, int pageSize) {
        Sql sql = Sql.select()
                .field("id")
                .field("title")
                .field("orgId")
                .field("orgName")
                .field("content")
                .field("links")
                .field("userId")
                .field("userName")
                .field("status")
                .field("picture")
                .field("createTime")
                .field("updateTime")
                .from(TABLE)
                .where()
                .andBlikeJoinByOrIfNotBlank(form.getKey(), "title","orgName")
                .andEqIfNotNull("orgId",form.getOrgId())
                .andEqIfNotNull("userId",form.getUserId())
                .andEq("status",1)
                .andEqIfNotNull("id", form.getId())
                .orderBy().desc("updateTime");
        return jdbcHelper.queryForListBean(sql.getSql().toString(), SchoolNumberposition.class, sql.getParams().toArray(),curPage, pageSize);
    }


    public SchoolNumberposition getSchoolNumberpositionInfo(SchoolNumberpositionForm.Get form) {
/*        Sql sql = Sql.select()
              .field("id")
                .field("title")
                .field("orgName")
                .field("content")
                .field("links")
                .field("userId")
                .field("userName")
                .field("status")
                .field("createTime")
                .from("t_school_numberposition")
                .where()
                .andEq("id", form.getId());*/
        String sql=" select * from t_school_numberposition where id="+form.getId()+"";

        return jdbcHelper.queryForBean(sql, SchoolNumberposition.class);
    }

    public int updateSchoolNumberposition(SchoolNumberposition form) {
        Sql sql = Sql.update(TABLE)
                .setIfNotBlank("title", form.getTitle())
                .setIfNotNull("orgId", form.getOrgId())
                .setIfNotBlank("orgName", form.getOrgName())
                .setIfNotBlank("content", form.getContent())
                .setIfNotBlank("links", form.getLinks())
                .setIfNotNull("userId", form.getUserId())
                .setIfNotBlank("userName", form.getUserName())
                .setIfNotBlank("picture",form.getPicture())
                .set("updateTime", new Date())
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.update(sql);
    }

    public int updateSchoolNumberStatus(SchoolNumberpositionForm.changeStatus form) {
       String sql=" update t_school_numberposition set status=? where id=?";
        List<Object> params=new ArrayList<>();
        params.add(form.getStatus());
        params.add(form.getId());
        return jdbcHelper.update(sql, params.toArray());
    }

    public int deleteSchoolNumberposition(CommonForm.Del form) {
        Sql sql = Sql.delete(TABLE)
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.update(sql);
    }

    public int batchDelSchoolNumberposition(CommonForm.BatchDel form) {
        Sql sql = Sql.delete(TABLE)
                .where()
                .andIn("id", form.getIds());
        return jdbcHelper.update(sql);
    }
}