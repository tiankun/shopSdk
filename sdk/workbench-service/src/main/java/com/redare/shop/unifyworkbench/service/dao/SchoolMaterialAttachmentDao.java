package com.redare.shop.unifyworkbench.service.dao;


import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.MySqlJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.SchoolMaterialAttachment;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.SchoolMaterialAttachmentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 素材附件管理(SchoolMaterialAttachment)表数据库访问层
 *
 * @author dengchj
 * @since 2020-10-13 14:22:59
 */
@Repository
public class SchoolMaterialAttachmentDao {
    private static final String TABLE = "t_school_material_attachment";
    @Autowired
    MySqlJdbcHelper jdbcHelper;

    public long insertSchoolMaterialAttachment(SchoolMaterialAttachment form) {
        Sql sql = Sql.insert(TABLE)
                .field("materialId", form.getMaterialId())
                .field("name", form.getName())
                .field("url", form.getUrl())
                .field("size", form.getSize())
                .field("createTime", form.getCreateTime())
                .field("status", form.getStatus())
                .field("fileType", form.getFileType());
        return jdbcHelper.insertReturnFieldNumber(sql).longValue();
    }

    public int[] batchAddAttachment(SchoolMaterialAttachmentForm.BatchAdd form){
        Sql sql = Sql.insert("t_school_material_attachment")
                .field("materialId")
                .field("name")
                .field("url")
                .field("size")
                .field("createTime")
                .field("fileType")
                .field("status");
        List<Object[]> params = new ArrayList<>();
        for (SchoolMaterialAttachmentForm.Add item : form.getAddList()){
            params.add(
                    new Object[]{
                            item.getMaterialId(),
                            item.getName(),
                            item.getUrl(),
                            item.getSize(),
                            new Date(),
                            item.getFileType(),
                            item.getStatus()
                    }
            );
        }
        return jdbcHelper.batchUpdate(sql.toString(), params);
    }

    public Page<SchoolMaterialAttachment> queryForPageSchoolMaterialAttachment(SchoolMaterialAttachmentForm.Search form, int curPage, int pageSize, boolean calCount, boolean allList) {
        Sql sql = Sql.select()
                .field("uid")
                .field("materialId")
                .field("name")
                .field("url")
                .field("size")
                .field("createTime")
                .field("status")
                .field("fileType")
                .from(TABLE)
                .where()
                .andBetweenOptionIf(form.getBeginTime() != null && form.getEndTime() != null, "createTime", form.getBeginTime(), form.getEndTime())
                .andBlikeJoinByOrIfNotBlank(form.getKey(), "paperName", "journalTitle", "copyrightOwner", "author")
                .orderBy().desc("uid");
        return jdbcHelper.queryForPageBean(sql.getSql().toString(), SchoolMaterialAttachment.class, sql.getParams().toArray(), curPage, pageSize, calCount, allList);
    }

    public List<SchoolMaterialAttachment> queryForListSchoolMaterialAttachment(SchoolMaterialAttachmentForm.Search form) {
        Sql sql = Sql.select()
                .field("uid")
                .field("materialId")
                .field("name")
                .field("url")
                .field("size")
                .field("createTime")
                .field("status")
                .field("fileType")
                .from(TABLE)
                .where()
                .andEqIfNotNull("uid", form.getUid())
                .andBetweenOptionIf(form.getBeginTime() != null && form.getEndTime() != null, "awardTime", form.getBeginTime(), form.getEndTime())
                .orderBy().desc("uid");
        return jdbcHelper.queryForListBean(sql.getSql().toString(), SchoolMaterialAttachment.class, sql.getParams().toArray());
    }

    public int updateSchoolMaterialAttachment(SchoolMaterialAttachment form) {
        Sql sql = Sql.update(TABLE)
                .setIfNotNull("materialId", form.getMaterialId())
                .setIfNotBlank("name", form.getName())
                .setIfNotBlank("url", form.getUrl())
                .setIfNotNull("size", form.getSize())
                .setIfNotNull("createTime", form.getCreateTime())
                .setIfNotBlank("status", form.getStatus())
                .setIfNotBlank("fileType", form.getFileType())
                .where()
                .andEq("uid", form.getUid());
        return jdbcHelper.update(sql);
    }

    public int deleteSchoolMaterialAttachment(CommonForm.Del form) {
        Sql sql = Sql.delete(TABLE)
                .where()
                .andEq("uid", form.getId());
        return jdbcHelper.update(sql);
    }

    public int batchDelSchoolMaterialAttachment(CommonForm.BatchDel form) {
        Sql sql = Sql.delete(TABLE)
                .where()
                .andIn("uid", form.getIds());
        return jdbcHelper.update(sql);
    }

    /**
     * 根据材料Id批量删除数据
     * @param form
     * @return
     */
    public int batchDelAttachmentByMaterialId(SchoolMaterialAttachmentForm.BatchDel form){
        Sql sql = Sql.delete("t_school_material_attachment")
                .where()
                .andIn("materialId",form.getMaterialId());
        return jdbcHelper.update(sql);
    }

    /**
     * 根据材料id查询所有附件信息
     * @param form
     * @return
     */
    public List<SchoolMaterialAttachment> findMaterialAttachmentListByMaterialId(SchoolMaterialAttachmentForm.GetByMaterialId form){
        Sql sql = Sql.select()
                .from("t_school_material_attachment")
                .where()
                .andEq("materialId",form.getMaterialId());
        return jdbcHelper.queryForListBean(sql,SchoolMaterialAttachment.class);
    }
}