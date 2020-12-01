package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.SchoolMaterialAttachment;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.SchoolMaterialAttachmentForm;
import com.redare.shop.unifyworkbench.service.dao.SchoolMaterialAttachmentDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 素材附件管理(SchoolMaterialAttachment)表服务接口
 *
 * @author dengchj
 * @since 2020-10-13 14:23:01
 */
@Service
public class SchoolMaterialAttachmentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SchoolMaterialAttachmentService.class);
    @Autowired
    SchoolMaterialAttachmentDao schoolMaterialAttachmentDao;

    public long insertSchoolMaterialAttachment(SchoolMaterialAttachment form) {
        return schoolMaterialAttachmentDao.insertSchoolMaterialAttachment(form);
    }

    public int[] batchAddAttachment(SchoolMaterialAttachmentForm.BatchAdd form){
        return schoolMaterialAttachmentDao.batchAddAttachment(form);
    }


        public int updateSchoolMaterialAttachment(SchoolMaterialAttachment form) {
        return schoolMaterialAttachmentDao.updateSchoolMaterialAttachment(form);
    }

    public Page<SchoolMaterialAttachment> queryForPageSchoolMaterialAttachment(SchoolMaterialAttachmentForm.Search form, int curPage, int pageSize) {
        return schoolMaterialAttachmentDao.queryForPageSchoolMaterialAttachment(form, curPage, pageSize, true, false);
    }

    public List<SchoolMaterialAttachment> queryForListSchoolMaterialAttachment(SchoolMaterialAttachmentForm.Search form) {
        return schoolMaterialAttachmentDao.queryForListSchoolMaterialAttachment(form);
    }

    public SchoolMaterialAttachment queryForSchoolMaterialAttachment(SchoolMaterialAttachmentForm.Search form) {
        final List<SchoolMaterialAttachment> list = schoolMaterialAttachmentDao.queryForListSchoolMaterialAttachment(form);
        if (list != null && list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public int deleteSchoolMaterialAttachment(CommonForm.Del form) {
        return schoolMaterialAttachmentDao.deleteSchoolMaterialAttachment(form);
    }

    public Boolean batchDelSchoolMaterialAttachment(CommonForm.BatchDel form) {
        return schoolMaterialAttachmentDao.batchDelSchoolMaterialAttachment(form) > 0;
    }

    public Boolean batchDelAttachmentByMaterialId(SchoolMaterialAttachmentForm.BatchDel form){
        return  schoolMaterialAttachmentDao.batchDelAttachmentByMaterialId(form)>0;

    }
    public List<SchoolMaterialAttachment> findMaterialAttachmentListByMaterialId(SchoolMaterialAttachmentForm.GetByMaterialId form){
        return schoolMaterialAttachmentDao.findMaterialAttachmentListByMaterialId(form);
    }



    }