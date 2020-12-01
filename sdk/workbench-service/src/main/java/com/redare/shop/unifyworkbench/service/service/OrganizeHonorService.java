package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.OrganizeHonor;
import com.redare.shop.unifyworkbench.sdk.pojo.form.OrganizeHonorForm;
import com.redare.shop.unifyworkbench.service.dao.OrganizeHonorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/10/19 16:11
 * @version:
 */
@Service
public class OrganizeHonorService {

    @Autowired
    OrganizeHonorDao organizeHonorDao;

    public Page<OrganizeHonor> findOrganizeHonorPage(OrganizeHonorForm.Search form,int curPage,int pageSize){
        return organizeHonorDao.findOrganizeHonorPage(form,curPage,pageSize,true,false);
    }

    public List<OrganizeHonor> findOrganizeHonorPageList(OrganizeHonorForm.Search form, int curPage, int pageSize){
        return organizeHonorDao.findOrganizeHonorPage(form,curPage,pageSize,false,false).getResult();
    }

    public List<OrganizeHonor> findOrganizeHonorList(OrganizeHonorForm.Search form){
        return organizeHonorDao.findOrganizeHonorPage(form,0,0,false,true).getResult();
    }

    public OrganizeHonor findOrganizeHonor(OrganizeHonorForm.Get form){
        return organizeHonorDao.findOrganizeHonor(form);
    }

    public boolean addOrganizeHonor(OrganizeHonorForm.Add form){
        return organizeHonorDao.addOrganizeHonor(form)>0;
    }

    public boolean editOrganizeHonor(OrganizeHonorForm.Edit form){
        return organizeHonorDao.editOrganizeHonor(form)>0;
    }

    public boolean delOrganizeHonor(OrganizeHonorForm.Del form){
        return organizeHonorDao.delOrganizeHonor(form)>0;
    }

    public boolean batchAddOrganizeHonor(OrganizeHonorForm.BatchAdd form){
        return organizeHonorDao.batchAddOrganizeHonor(form).length>0;
    }

    public int delByOrgId(OrganizeHonorForm.DelByOrgId form){
        return organizeHonorDao.delByOrgId(form);
    }

    public int batchDel(List<String> orgIdList){
        return organizeHonorDao.batchDel(orgIdList);
    }
}
