package com.redare.shop.unifyworkbench.service.dao;


import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.MySqlJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.SchoolMaterial;
import com.redare.shop.unifyworkbench.sdk.pojo.form.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 学堂管理-素材管理(SchoolMaterial)表数据库访问层
 *
 * @author dengchj
 * @since 2020-10-15 15:04:42
 */
@Repository
public class SchoolMaterialDao {
    private static final String TABLE = "t_school_material";
    @Autowired
    MySqlJdbcHelper jdbcHelper;

    public long insertSchoolMaterial(SchoolMaterialForm.Add form) {
        Sql sql = Sql.insert(TABLE)
                .field("title", form.getTitle())
                .field("markId", form.getMarkId())
                .field("markName", form.getMarkName())
                .field("description", form.getDescription())
                .field("picture", form.getPicture())
                .field("status", 0)
                .field("createTime", new Date())
                .field("updateTime", new Date())
                .field("orgId", form.getOrgId())
                .field("orgName", form.getOrgName())
                .field("publishUserId", form.getPublishUserId())
                .field("publishUserName", form.getPublishUserName())
                .field("readCount", 0)
                .field("commentCount", 0)
                .field("shareCount", 0)
                .field("advice", form.getAdvice())
                .field("areaCode", form.getAreaCode())
                .field("areaName", form.getAreaName())
                .field("departmentId", form.getDepartmentId())
                .field("deptName", form.getDeptName())
                .field("fileName",form.getFileName())
                .field("fileUrl",form.getFileUrl())
                .field("fileType",form.getFileType())
                .field("fileSize",form.getFileSize());
        return jdbcHelper.insertReturnFieldNumber(sql).longValue();
    }

    public Page<SchoolMaterial> queryForPageSchoolMaterial(SchoolMaterialForm.Search form, int curPage, int pageSize, boolean calCount, boolean allList) {
        Sql sql = Sql.select()
                .field("id")
                .field("title")
                .field("markId")
                .field("markName")
                .field("description")
                .field("picture")
                .field("status")
                .field("top")
                .field("sort")
                .field("createTime")
                .field("updateTime")
                .field("orgId")
                .field("orgName")
                .field("publishUserId")
                .field("publishUserName")
                .field("readCount")
                .field("commentCount")
                .field("shareCount")
                .field("advice")
                .field("areaCode")
                .field("areaName")
                .field("departmentId")
                .field("deptName")
                .field("fileName")
                .field("fileUrl")
                .field("fileType")
                .field("fileSize")
                .from(TABLE)
                .where()
                .andEqIfNotNull("markId", form.getMarkId())
                .andEqIfNotNull("fileType",form.getFileType())
                .andEqIfNotNull("orgId",form.getOrgId())
                .andEqIfNotNull("top",form.getTop())
                .andEqIfNotNull("status",form.getStatus())
                .andEqIfNotNull("publishUserId",form.getUserId())
                .andBlikeJoinByOrIfNotBlank(form.getKey(), "title", "fileName")
                .orderBy()
                .desc("top","updateTime");
        return jdbcHelper.queryForPageBean(sql.getSql().toString(), SchoolMaterial.class, sql.getParams().toArray(), curPage, pageSize, calCount, allList);
    }

    public List<SchoolMaterial> queryForListSchoolMaterial(SchoolMaterialForm.Search form,int curPage,int pageSize) {
        Sql sql = Sql.select()
                .field("id")
                .field("title")
                .field("markId")
                .field("markName")
                .field("description")
                .field("picture")
                .field("status")
                .field("top")
                .field("sort")
                .field("createTime")
                .field("updateTime")
                .field("orgId")
                .field("orgName")
                .field("publishUserId")
                .field("publishUserName")
                .field("readCount")
                .field("commentCount")
                .field("shareCount")
                .field("advice")
                .field("areaCode")
                .field("areaName")
                .field("departmentId")
                .field("deptName")
                .field("fileName")
                .field("fileUrl")
                .field("fileType")
                .field("fileSize")
                .from(TABLE)
                .where()
                .andEqIfNotNull("id", form.getId())
                .andEqIfNotNull("markId", form.getMarkId())
                .andEqIfNotNull("fileType",form.getFileType())
                .andEqIfNotNull("top",form.getTop())
                .andEq("status",1)
                .andEqIfNotNull("orgId",form.getOrgId())
                .andEqIfNotNull("publishUserId",form.getUserId())
                .andBlikeJoinByOrIfNotBlank(form.getKey(), "title", "fileName")
                .orderBy()
                .desc("top","updateTime");

        return jdbcHelper.queryForListBean(sql.getSql().toString(), SchoolMaterial.class, sql.getParams().toArray(),curPage,pageSize);
    }

    public SchoolMaterial getSchoolMaterialInfo(SchoolMaterialForm.Search form) {
        Sql sql = Sql.select()
                .field("id")
                .field("title")
                .field("markId")
                .field("markName")
                .field("description")
                .field("picture")
                .field("status")
                .field("top")
                .field("sort")
                .field("createTime")
                .field("updateTime")
                .field("orgId")
                .field("orgName")
                .field("publishUserId")
                .field("publishUserName")
                .field("readCount")
                .field("commentCount")
                .field("shareCount")
                .field("advice")
                .field("areaCode")
                .field("areaName")
                .field("departmentId")
                .field("deptName")
                .field("fileName")
                .field("fileUrl")
                .field("fileType")
                .field("fileSize")
                .from(TABLE)
                .where()
                .andEqIfNotNull("id", form.getId())
                .andEqIfNotNull("markId", form.getMarkId())
                .andEqIfNotNull("fileType", form.getFileType())
                .andBlikeJoinByOrIfNotBlank(form.getKey(), "title", "fileName")
                .orderBy().desc("id");
        return jdbcHelper.queryForBean(sql.getSql().toString(), SchoolMaterial.class, sql.getParams().toArray());
    }

    public int updateSchoolMaterial(SchoolMaterialForm.Edit form) {
        Sql sql = Sql.update(TABLE)
                .setIfNotBlank("title", form.getTitle())
                .setIfNotNull("markId", form.getMarkId())
                .setIfNotBlank("markName", form.getMarkName())
                .setIfNotBlank("description", form.getDescription())
                .setIfNotBlank("picture", form.getPicture())
                .setIfNotNull("status", form.getStatus())
                .set("updateTime", new Date())
                .setIfNotNull("orgId", form.getOrgId())
                .setIfNotBlank("orgName", form.getOrgName())
                .setIfNotNull("publishUserId", form.getPublishUserId())
                .setIfNotBlank("publishUserName", form.getPublishUserName())
                .setIfNotNull("readCount", form.getReadCount())
                .setIfNotNull("commentCount", form.getCommentCount())
                .setIfNotNull("shareCount", form.getShareCount())
                .setIfNotBlank("advice", form.getAdvice())
                .setIfNotBlank("areaCode", form.getAreaCode())
                .setIfNotBlank("areaName", form.getAreaName())
                .setIfNotNull("departmentId", form.getDepartmentId())
                .setIfNotBlank("deptName", form.getDeptName())
                .setIfNotNull("fileName",form.getFileName())
                .setIfNotNull("fileUrl",form.getFileUrl())
                .setIfNotNull("fileType",form.getFileType())
                .setIfNotNull("fileSize",form.getFileSize())
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.update(sql);
    }

    public int deleteSchoolMaterial(CommonForm.Del form) {
        Sql sql = Sql.delete(TABLE)
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.update(sql);
    }

    public int updateMaterailStatus(SchoolMaterialForm.changeStatus form) {
        String sql=" update t_school_material set status=? where id=?";
        List<Object> params=new ArrayList<>();
        params.add(form.getStatus());
        params.add(form.getId());
        return jdbcHelper.update(sql, params.toArray());
    }

    public int batchDelSchoolMaterial(CommonForm.BatchDel form) {
        Sql sql = Sql.delete(TABLE)
                .where()
                .andIn("id", form.getIds());
        return jdbcHelper.update(sql);
    }

    public int autoPlusOneOnBrowse(SchoolMaterialForm.changeStatus form){
        StringBuilder stringBuilder = new StringBuilder("update t_school_material ");
        stringBuilder.append("set readCount = readCount+1 ")
                .append("where id =?");
        Object[] args = {form.getId()};
        return jdbcHelper.update(stringBuilder.toString(),args);
    }

    /**
     * 置顶
     * @param form
     * @return
     */
    public int updateTopStatus(SchoolMaterialForm.Top form) {
        Sql sql = Sql.update("t_school_material")
                .set("top", form.getTop())
                .where().andEq("id", form.getId());
        return jdbcHelper.update(sql);
    }


    //设置排序
    public int updateSort(SchoolMaterialForm.Sort form) {
        Sql sql = Sql.update("t_school_material")
                .set("sort", form.getSort())
                .where().andEq("id", form.getId());
        return jdbcHelper.update(sql);
    }
}