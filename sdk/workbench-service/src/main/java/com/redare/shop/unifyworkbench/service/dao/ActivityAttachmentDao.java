package com.redare.shop.unifyworkbench.service.dao;


import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.MySqlJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.ActivityAttachment;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ActivityAttachmentForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 学堂管理-素材附件管理(ActivityAttachment)表数据库访问层
 *
 * @author dengchj
 * @since 2020-10-19 18:04:05
 */
@Repository
public class ActivityAttachmentDao {
    private static final String TABLE = "t_activity_attachment";
    @Autowired
    MySqlJdbcHelper jdbcHelper;

    public long insertActivityAttachment(ActivityAttachment form) {
        Sql sql = Sql.insert(TABLE)
                .field("activityId", form.getMaterialId())
                .field("name", form.getName())
                .field("url", form.getUrl())
                .field("size", form.getSize())
                .field("createTime", form.getCreateTime())
                .field("status", form.getStatus())
                .field("fileType", form.getFileType());
        return jdbcHelper.insertReturnFieldNumber(sql).longValue();
    }


    /**
     * 批量添加附件
     * @author zlx
     * @date 2020/5/7 18:43
     * @param form
     * @return int[]
     */
    public int[] batchAddAttachment(ActivityAttachmentForm.BatchAdd form) {
        Sql sql = Sql.insert("t_activity_attachment")
                .field("activityId")
                .field("name")
                .field("url")
                .field("size")
                .field("createTime")
                .field("status")
                .field("fileType");
        List<Object[]> params = new ArrayList<>();
        for (ActivityAttachmentForm.Add item : form.getAddList()) {
            params.add(
                    new Object[]{
                            item.getActivityId(),
                            item.getName(),
                            item.getUrl(),
                            item.getSize(),
                            new Date(),
                            item.getStatus(),
                            item.getFileType()
                    }
            );
        }
        return jdbcHelper.batchUpdate(sql.toString(), params);
    }

    public Page<ActivityAttachment> queryForPageActivityAttachment(ActivityAttachmentForm.Search form, int curPage, int pageSize, boolean calCount, boolean allList) {
        Sql sql = Sql.select()
                .field("uid")
                .field("activityId")
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
        return jdbcHelper.queryForPageBean(sql.getSql().toString(), ActivityAttachment.class, sql.getParams().toArray(), curPage, pageSize, calCount, allList);
    }

    public List<ActivityAttachment> queryForListActivityAttachment(ActivityAttachmentForm.Search form) {
        Sql sql = Sql.select()
                .field("uid")
                .field("activityId")
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
        return jdbcHelper.queryForListBean(sql.getSql().toString(), ActivityAttachment.class, sql.getParams().toArray());
    }

    public int updateActivityAttachment(ActivityAttachment form) {
        Sql sql = Sql.update(TABLE)
                .setIfNotNull("activityId", form.getMaterialId())
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

    public int deleteActivityAttachment(ActivityAttachmentForm.Del form) {
        Sql sql = Sql.delete(TABLE)
                .where()
                .andEqIfNotNull("uid", form.getUid())
                .andEqIfNotNull("activityId",form.getActivityId())
                .andEqIfNotNull("fileType",form.getFileType());
        return jdbcHelper.update(sql);
    }

    public int batchDelActivityAttachment(CommonForm.BatchDel form) {
        Sql sql = Sql.delete(TABLE)
                .where()
                .andIn("uid", form.getIds());
        return jdbcHelper.update(sql);
    }

    /**
     * 根据活动Id删除数据
     * @param form
     * @return
     */
    public int batchDelAttachmentByActivityId(ActivityAttachmentForm.GetByActivityId form){
        Sql sql = Sql.delete(TABLE)
                .where()
                .andEqIfNotNull("activityId",form.getActivityId())
                .andEqIfNotNull("fileType",form.getFileType());
        return jdbcHelper.update(sql);
    }
    /**
     * 根据活动Id删除数据
     * @param form
     * @return
     */
    public int batchDelAttachmentByActivityIds(ActivityAttachmentForm.GetByActivityId form){
        Sql sql = Sql.delete(TABLE)
                .where()
                .andIn("activityId",form.getActivityIds());
        return jdbcHelper.update(sql);
    }



    /**
     * 根据活动id查询所有附件信息
     * @param form
     * @return
     */
    public List<ActivityAttachment> findActivityAttachmentListByActivityId(ActivityAttachmentForm.GetByActivityId form){
        Sql sql = Sql.select()
                .from(TABLE)
                .where()
                .andEq("activityId",form.getActivityId())
                .andEqIfNotNull("fileType",form.getFileType());
        return jdbcHelper.queryForListBean(sql,ActivityAttachment.class);
    }
}