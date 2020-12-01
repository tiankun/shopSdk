package com.redare.shop.unifyworkbench.service.dao;


import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.MySqlJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.SchoolComment;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.SchoolCommentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 评论表(SchoolComment)表数据库访问层
 *
 * @author dengchj
 * @since 2020-10-13 14:22:08
 */
@Repository
public class SchoolCommentDao {
    private static final String TABLE = "t_school_comment";
    @Autowired
    MySqlJdbcHelper jdbcHelper;

    public long insertSchoolComment(SchoolComment form) {
        Sql sql = Sql.insert(TABLE)
                .field("materialId", form.getMaterialId())
                .field("content", form.getContent())
                .field("userId", form.getUserId())
                .field("userName", form.getUserName())
                .field("createTime", form.getCreateTime())
                .field("updateTime", form.getUpdateTime())
                .field("status", form.getStatus());
        return jdbcHelper.insertReturnFieldNumber(sql).longValue();
    }

    public Page<SchoolComment> queryForPageSchoolComment(SchoolCommentForm.Search form, int curPage, int pageSize, boolean calCount, boolean allList) {
        Sql sql = Sql.select()
                .field("id")
                .field("materialId")
                .field("content")
                .field("userId")
                .field("userName")
                .field("createTime")
                .field("updateTime")
                .field("status")
                .from(TABLE)
                .where()
                .andBetweenOptionIf(form.getBeginTime() != null && form.getEndTime() != null, "createTime", form.getBeginTime(), form.getEndTime())
                .andBlikeJoinByOrIfNotBlank(form.getKey(), "paperName", "journalTitle", "copyrightOwner", "author")
                .orderBy().desc("id");
        return jdbcHelper.queryForPageBean(sql.getSql().toString(), SchoolComment.class, sql.getParams().toArray(), curPage, pageSize, calCount, allList);
    }

    public List<SchoolComment> queryForListSchoolComment(SchoolCommentForm.Search form) {
        Sql sql = Sql.select()
                .field("id")
                .field("materialId")
                .field("content")
                .field("userId")
                .field("userName")
                .field("createTime")
                .field("updateTime")
                .field("status")
                .from(TABLE)
                .where()
                .andEqIfNotNull("id", form.getId())
                .andBetweenOptionIf(form.getBeginTime() != null && form.getEndTime() != null, "awardTime", form.getBeginTime(), form.getEndTime())
                .orderBy().desc("id");
        return jdbcHelper.queryForListBean(sql.getSql().toString(), SchoolComment.class, sql.getParams().toArray());
    }

    public int updateSchoolComment(SchoolComment form) {
        Sql sql = Sql.update(TABLE)
                .setIfNotNull("materialId", form.getMaterialId())
                .setIfNotBlank("content", form.getContent())
                .setIfNotNull("userId", form.getUserId())
                .setIfNotBlank("userName", form.getUserName())
                .setIfNotNull("createTime", form.getCreateTime())
                .setIfNotNull("updateTime", form.getUpdateTime())
                .setIfNotNull("status", form.getStatus())
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.update(sql);
    }

    public int deleteSchoolComment(CommonForm.Del form) {
        Sql sql = Sql.delete(TABLE)
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.update(sql);
    }

    public int batchDelSchoolComment(CommonForm.BatchDel form) {
        Sql sql = Sql.delete(TABLE)
                .where()
                .andIn("id", form.getIds());
        return jdbcHelper.update(sql);
    }
}