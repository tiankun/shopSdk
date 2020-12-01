package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.SchoolNumberposition;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.SchoolNumberpositionForm;
import com.redare.shop.unifyworkbench.service.dao.SchoolNumberpositionDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 学堂管理-数字阵地(SchoolNumberposition)表服务接口
 *
 * @author dengchj
 * @since 2020-10-13 14:23:12
 */
@Service
public class SchoolNumberpositionService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SchoolNumberpositionService.class);
    @Autowired
    SchoolNumberpositionDao schoolNumberpositionDao;

    public long insertSchoolNumberposition(SchoolNumberposition form) {
        return schoolNumberpositionDao.insertSchoolNumberposition(form);
    }

    public int updateSchoolNumberpositionStatus(SchoolNumberpositionForm.changeStatus form) {
        return schoolNumberpositionDao.updateSchoolNumberStatus(form);
    }

    public int updateSchoolNumberposition(SchoolNumberposition form) {
        return schoolNumberpositionDao.updateSchoolNumberposition(form);
    }

    public Page<SchoolNumberposition> queryForPageSchoolNumberposition(SchoolNumberpositionForm.Search form, int curPage, int pageSize) {
        return schoolNumberpositionDao.queryForPageSchoolNumberposition(form, curPage, pageSize, true, false);
    }

    public List<SchoolNumberposition> queryForListSchoolNumberposition(SchoolNumberpositionForm.Search form,int curPage, int pageSize) {
        return schoolNumberpositionDao.queryForListSchoolNumberposition(form,curPage, pageSize);
    }

    public SchoolNumberposition queryForSchoolNumberposition(SchoolNumberpositionForm.Get form) {
        return schoolNumberpositionDao.getSchoolNumberpositionInfo(form);
    }

    public int deleteSchoolNumberposition(CommonForm.Del form) {
        return schoolNumberpositionDao.deleteSchoolNumberposition(form);
    }

    public Boolean batchDelSchoolNumberposition(CommonForm.BatchDel form) {
        return schoolNumberpositionDao.batchDelSchoolNumberposition(form) > 0;
    }

}