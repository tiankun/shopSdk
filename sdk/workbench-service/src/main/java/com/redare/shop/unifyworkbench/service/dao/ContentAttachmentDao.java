package com.redare.shop.unifyworkbench.service.dao;

import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.ContentAttachment;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ContentAttachmentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ContentAttachmentDao
 *
 * @Author zlx
 * @Date 2020/5/7 18:36
 */
@Repository
public class ContentAttachmentDao {

    @Autowired
    SpringJdbcHelper springJdbcHelper;

    /**
     * 批量添加附件
     * @author zlx
     * @date 2020/5/7 18:43
     * @param form
     * @return int[]
     */
    public int[] batchAddAttachment(ContentAttachmentForm.BatchAdd form){
        Sql sql = Sql.insert("t_content_attachment")
                .field("contentId")
                .field("name")
                .field("url")
                .field("size")
                .field("createTime")
                .field("status");
        List<Object[]> params = new ArrayList<>();
        for (ContentAttachmentForm.Add item : form.getAddList()){
            params.add(
                    new Object[]{
                            item.getContentId(),
                            item.getName(),
                            item.getUrl(),
                            item.getSize(),
                            new Date(),
                            item.getStatus()
                    }
            );
        }
        return springJdbcHelper.batchUpdate(sql.toString(), params);
    }

    /**
     * 删除表数据
     * @author zlx
     * @date 2020/5/8 10:05
     * @param form
     * @return int
     */
    public int deleteAttachment(ContentAttachmentForm.Del form){
        Sql sql = Sql.delete("t_content_attachment")
                .where()
                .andEqIfNotNull("uid",form.getUid())
                .andEqIfNotNull("contentId",form.getContentId());
        return springJdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    /**
     * 根据内容id查询所有附件信息
     * @author zlx
     * @date 2020/5/8 11:18
     * @param form
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.ContentAttachment>
     */
    public List<ContentAttachment> findContentAttachmentList(ContentAttachmentForm.GetByContentId form){
        Sql sql = Sql.select()
                .from("t_content_attachment")
                .where()
                .andEq("contentId",form.getContentId());
        return springJdbcHelper.queryForListBean(sql,ContentAttachment.class);
    }

    /**
     * 根据内容id批量删除数据
     * @author zlx
     * @date 2020/5/9 11:19
     * @param form
     * @return int
     */
    public int batchDelAttachmentByContentId(ContentAttachmentForm.BatchDel form){
        Sql sql = Sql.delete("t_content_attachment")
                .where()
                .andIn("contentId",form.getContentId());
        return springJdbcHelper.update(sql);
    }
}
