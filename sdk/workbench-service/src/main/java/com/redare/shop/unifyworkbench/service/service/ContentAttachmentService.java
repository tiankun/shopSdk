package com.redare.shop.unifyworkbench.service.service;

import com.redare.shop.unifyworkbench.sdk.pojo.ContentAttachment;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ContentAttachmentForm;
import com.redare.shop.unifyworkbench.service.dao.ContentAttachmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ContentAttachmentService
 *
 * @Author zlx
 * @Date 2020/5/7 18:48
 */
@Service
public class ContentAttachmentService {

    @Autowired
    ContentAttachmentDao contentAttachmentDao;

    /**
     * 批量新增附件
     * @author zlx
     * @date 2020/5/7 18:50
     * @param form
     * @return int[]
     */
    public int[] batchAddAttachment(ContentAttachmentForm.BatchAdd form){
        return contentAttachmentDao.batchAddAttachment(form);
    }

    /**
     * 删除表数据
     * @author zlx
     * @date 2020/5/8 10:06
     * @param form
     * @return java.lang.Boolean
     */
    public Boolean deleteAttachment(ContentAttachmentForm.Del form){
        return contentAttachmentDao.deleteAttachment(form)>0;
    }

    /**
     * 根据内容id查询所有附件
     * @author zlx
     * @date 2020/5/8 11:20
     * @param form
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.ContentAttachment>
     */
    public List<ContentAttachment> findContentAttachmentList(ContentAttachmentForm.GetByContentId form){
        return contentAttachmentDao.findContentAttachmentList(form);
    }

    /**
     * 根据内容id批量删除数据
     * @author zlx
     * @date 2020/5/9 11:20
     * @param form
     * @return java.lang.Boolean
     */
    public Boolean batchDelAttachmentByContentId(ContentAttachmentForm.BatchDel form){
        return contentAttachmentDao.batchDelAttachmentByContentId(form)>0;
    }
}
