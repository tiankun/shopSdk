package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.SchoolMaterial;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.SchoolMaterialForm;
import com.redare.shop.unifyworkbench.service.dao.SchoolMaterialDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 学堂管理-素材管理(SchoolMaterial)表服务接口
 *
 * @author dengchj
 * @since 2020-10-15 15:04:43
 */
@Service
public class SchoolMaterialService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SchoolMaterialService.class);
    @Autowired
    SchoolMaterialDao schoolMaterialDao;

    public long insertSchoolMaterial(SchoolMaterialForm.Add form) {
        return schoolMaterialDao.insertSchoolMaterial(form);
    }

    public int updateSchoolMaterial(SchoolMaterialForm.Edit form) {
        return schoolMaterialDao.updateSchoolMaterial(form);
    }

    public Page<SchoolMaterial> queryForPageSchoolMaterial(SchoolMaterialForm.Search form, int curPage, int pageSize) {
        return schoolMaterialDao.queryForPageSchoolMaterial(form, curPage, pageSize, true, false);
    }

    public List<SchoolMaterial> queryForListSchoolMaterial(SchoolMaterialForm.Search form,int curPage,int pageSize) {
        return schoolMaterialDao.queryForListSchoolMaterial(form,curPage,pageSize);
    }

    public SchoolMaterial queryForSchoolMaterial(SchoolMaterialForm.Search form) {
      return schoolMaterialDao.getSchoolMaterialInfo(form);
    }
    public int updateMaterailStatus(SchoolMaterialForm.changeStatus form){
        return schoolMaterialDao.updateMaterailStatus(form);
    }

    public int deleteSchoolMaterial(CommonForm.Del form) {
        return schoolMaterialDao.deleteSchoolMaterial(form);
    }

    public Boolean batchDelSchoolMaterial(CommonForm.BatchDel form) {
        return schoolMaterialDao.batchDelSchoolMaterial(form) > 0;
    }
    public int autoPlusOneOnBrowse(SchoolMaterialForm.changeStatus form){
        return  schoolMaterialDao.autoPlusOneOnBrowse(form);
    }

    public int updateTopStatus(SchoolMaterialForm.Top form) {
        return schoolMaterialDao.updateTopStatus(form);
    }

    public int updateSort(SchoolMaterialForm.Sort form) {
        return schoolMaterialDao.updateSort(form);
    }

}