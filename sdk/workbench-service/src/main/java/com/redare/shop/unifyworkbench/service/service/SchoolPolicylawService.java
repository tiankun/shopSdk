package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.SchoolPolicylaw;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.SchoolPolicylawForm;
import com.redare.shop.unifyworkbench.service.dao.SchoolPolicylawDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 学堂管理-政策法规(SchoolPolicylaw)表服务接口
 *
 * @author dengchj
 * @since 2020-10-13 14:23:23
 */
@Service
public class SchoolPolicylawService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SchoolPolicylawService.class);
    @Autowired
    SchoolPolicylawDao schoolPolicylawDao;

    public long insertSchoolPolicylaw(SchoolPolicylaw form) {
        return schoolPolicylawDao.insertSchoolPolicylaw(form);
    }

    public int updateSchoolPolicylaw(SchoolPolicylaw form) {
        return schoolPolicylawDao.updateSchoolPolicylaw(form);
    }

    public int updateSchoolPolicylawStatus(SchoolPolicylawForm.changeStatus form) {
        return schoolPolicylawDao.updateSchoolPolicylawStatus(form);
    }

    public Page<SchoolPolicylaw> queryForPageSchoolPolicylaw(SchoolPolicylawForm.Search form, int curPage, int pageSize) {
        return schoolPolicylawDao.queryForPageSchoolPolicylaw(form, curPage, pageSize, true, false);
    }

    public List<SchoolPolicylaw> queryForListSchoolPolicylaw(SchoolPolicylawForm.Search form, int curPage, int pageSize) {
        return schoolPolicylawDao.queryForListSchoolPolicylaw(form,curPage,pageSize);
    }

/*    public SchoolPolicylaw queryForSchoolPolicylaw(SchoolPolicylawForm.Search form) {
        final List<SchoolPolicylaw> list = schoolPolicylawDao.queryForListSchoolPolicylaw(form,1,1);
        if (list != null && list.size() == 1) {
            return list.get(0);
        }
        return null;
    }*/

    public int deleteSchoolPolicylaw(CommonForm.Del form) {
        return schoolPolicylawDao.deleteSchoolPolicylaw(form);
    }

    public Boolean batchDelSchoolPolicylaw(CommonForm.BatchDel form) {
        return schoolPolicylawDao.batchDelSchoolPolicylaw(form) > 0;
    }

    public SchoolPolicylaw getSchoolPolicylawInfo(SchoolPolicylawForm.Search form) {
        return schoolPolicylawDao.getSchoolPolicylawInfo(form);
    }

    public int updateTopStatus(SchoolPolicylawForm.Top form) {
        return schoolPolicylawDao.updateTopStatus(form);
    }


    }