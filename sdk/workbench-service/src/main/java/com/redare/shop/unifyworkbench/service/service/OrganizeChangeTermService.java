package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.OrganizeChangeTerm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.OrganizeChangeTermForm;
import com.redare.shop.unifyworkbench.service.dao.OrganizeChangeTermDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/10/19 14:10
 * @version:
 */
@Service
public class OrganizeChangeTermService {

    @Autowired
    OrganizeChangeTermDao organizeChangeTermDao;

    public Page<OrganizeChangeTerm> findOrganizeChangeTermPage(OrganizeChangeTermForm.Search form,int curPage,int pageSize){
        return organizeChangeTermDao.findOrganizeChangeTermPage(form,curPage,pageSize,true,false);
    }

    public List<OrganizeChangeTerm> findOrganizeChangeTermPageList(OrganizeChangeTermForm.Search form, int curPage, int pageSize){
        return organizeChangeTermDao.findOrganizeChangeTermPage(form,curPage,pageSize,false,false).getResult();
    }

    public List<OrganizeChangeTerm> findOrganizeChangeTermList(OrganizeChangeTermForm.Search form){
        return organizeChangeTermDao.findOrganizeChangeTermPage(form,0,0,false,true).getResult();
    }

    public OrganizeChangeTerm findOrganizeChangeTerm(OrganizeChangeTermForm.Get form){
        return organizeChangeTermDao.findOrganizeChangeTerm(form);
    }

    public boolean addOrganizeChangeTerm(OrganizeChangeTermForm.Add form){
        return organizeChangeTermDao.addOrganizeChangeTerm(form)>0;
    }

    public boolean editOrganizeChangeTerm(OrganizeChangeTermForm.Edit form){
        return organizeChangeTermDao.editOrganizeChangeTerm(form)>0;
    }

    public boolean delOrganizeChangeTerm(OrganizeChangeTermForm.Del form){
        return organizeChangeTermDao.delOrganizeChangeTerm(form)>0;
    }

    public boolean batchAddOrganizeChangeTerm(OrganizeChangeTermForm.BatchAdd form){
        return organizeChangeTermDao.batchAddOrganizeChangeTerm(form).length>0;
    }

    public int delByOrgId(OrganizeChangeTermForm.DelByOrgId form){
        return organizeChangeTermDao.delByOrgId(form);
    }

    public int batchDel(List<String> orgIdList){
        return organizeChangeTermDao.batchDel(orgIdList);
    }
}
