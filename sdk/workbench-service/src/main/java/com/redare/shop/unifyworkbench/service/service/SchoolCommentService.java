package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.SchoolComment;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.SchoolCommentForm;
import com.redare.shop.unifyworkbench.service.dao.SchoolCommentDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 评论表(SchoolComment)表服务接口
 *
 * @author dengchj
 * @since 2020-10-13 14:22:08
 */
@Service
public class SchoolCommentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SchoolCommentService.class);
    @Autowired
    SchoolCommentDao schoolCommentDao;

    public long insertSchoolComment(SchoolComment form) {
        return schoolCommentDao.insertSchoolComment(form);
    }

    public int updateSchoolComment(SchoolComment form) {
        return schoolCommentDao.updateSchoolComment(form);
    }

    public Page<SchoolComment> queryForPageSchoolComment(SchoolCommentForm.Search form, int curPage, int pageSize) {
        return schoolCommentDao.queryForPageSchoolComment(form, curPage, pageSize, true, false);
    }

    public List<SchoolComment> queryForListSchoolComment(SchoolCommentForm.Search form) {
        return schoolCommentDao.queryForListSchoolComment(form);
    }

    public SchoolComment queryForSchoolComment(SchoolCommentForm.Search form) {
        final List<SchoolComment> list = schoolCommentDao.queryForListSchoolComment(form);
        if (list != null && list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public int deleteSchoolComment(CommonForm.Del form) {
        return schoolCommentDao.deleteSchoolComment(form);
    }

    public Boolean batchDelSchoolComment(CommonForm.BatchDel form) {
        return schoolCommentDao.batchDelSchoolComment(form) > 0;
    }

}