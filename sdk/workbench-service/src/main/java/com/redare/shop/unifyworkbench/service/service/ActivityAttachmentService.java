package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.ActivityAttachment;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ActivityAttachmentForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.service.dao.ActivityAttachmentDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 学堂管理-素材附件管理(ActivityAttachment)表服务接口
 *
 * @author dengchj
 * @since 2020-10-19 18:04:06
 */
@Service
public class ActivityAttachmentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityAttachmentService.class);
    @Autowired
    ActivityAttachmentDao activityAttachmentDao;

    public long insertActivityAttachment(ActivityAttachment form) {
        return activityAttachmentDao.insertActivityAttachment(form);
    }

    public int[] batchAddAttachment(ActivityAttachmentForm.BatchAdd form){
        return activityAttachmentDao.batchAddAttachment(form);
    }

    public int updateActivityAttachment(ActivityAttachment form) {
        return activityAttachmentDao.updateActivityAttachment(form);
    }

    public Page<ActivityAttachment> queryForPageActivityAttachment(ActivityAttachmentForm.Search form, int curPage, int pageSize) {
        return activityAttachmentDao.queryForPageActivityAttachment(form, curPage, pageSize, true, false);
    }

    public List<ActivityAttachment> queryForListActivityAttachment(ActivityAttachmentForm.Search form) {
        return activityAttachmentDao.queryForListActivityAttachment(form);
    }

    public ActivityAttachment queryForActivityAttachment(ActivityAttachmentForm.Search form) {
        final List<ActivityAttachment> list = activityAttachmentDao.queryForListActivityAttachment(form);
        if (list != null && list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public int deleteActivityAttachment(ActivityAttachmentForm.Del form) {
        return activityAttachmentDao.deleteActivityAttachment(form);
    }

    public Boolean batchDelActivityAttachment(CommonForm.BatchDel form) {
        return activityAttachmentDao.batchDelActivityAttachment(form) > 0;
    }

    /**
     * 根据活动id删除附件
     * @param form
     * @return
     */
    public Boolean batchDelAttachmentByActivityId(ActivityAttachmentForm.GetByActivityId form){
        return activityAttachmentDao.batchDelAttachmentByActivityId(form)>=0;
    }
    public int batchDelAttachmentByActivityIds(ActivityAttachmentForm.GetByActivityId form){
        return activityAttachmentDao.batchDelAttachmentByActivityIds(form);
    }


        /**
         * 根据活动id查询所有附件信息
         * @param form
         * @return
         */
    public List<ActivityAttachment> findActivityAttachmentListByActivityId(ActivityAttachmentForm.GetByActivityId form){
        return activityAttachmentDao.findActivityAttachmentListByActivityId(form);
    }


    }