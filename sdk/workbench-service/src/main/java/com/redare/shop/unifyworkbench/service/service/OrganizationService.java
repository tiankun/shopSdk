package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.Organization;
import com.redare.shop.unifyworkbench.sdk.pojo.OrganizationStatistics;
import com.redare.shop.unifyworkbench.sdk.pojo.form.OrganizationForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.TreeNode;
import com.redare.shop.unifyworkbench.service.dao.OrganizationDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 组织机构表(Organization)表服务接口
 *
 * @author zlx
 * @since 2020-10-16 11:58:36
 */
@Service
public class OrganizationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationService.class);

    @Autowired
    OrganizationDao organizationDao;

    /**
     * @description 分页查询
     * @author zlx
     * @date 2020/10/16 14:44
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.Organization>
     */
    public Page<Organization> findOrganizationPage(OrganizationForm.Search form,int curPage,int pageSize){
        return organizationDao.findOrganizationPage(form,curPage,pageSize,true,false);
    }

    /**
     * @description 分页查询数据
     * @author zlx
     * @date 2020/10/16 14:47
     * @param form
     * @param curPage
     * @param pageSize
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.Organization>
     */
    public List<Organization> findOrganizationPageList(OrganizationForm.Search form,int curPage,int pageSize){
        return organizationDao.findOrganizationPage(form,curPage,pageSize,false,false).getResult();
    }

    /**
     * @description 查询所有数据
     * @author zlx
     * @date 2020/10/16 14:48
     * @param form
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.Organization>
     */
    public List<Organization> findOrganizationList(OrganizationForm.Search form){
        return organizationDao.findOrganizationPage(form,0,0,false,true).getResult();
    }

    /**
     * @description 根据主键id或orgId查询数据
     * @author zlx
     * @date 2020/10/16 14:48
     * @param form
     * @return com.redare.shop.unifyworkbench.sdk.pojo.Organization
     */
    public Organization findOrganization(OrganizationForm.Get form){
        return organizationDao.findOrganization(form);
    }

    /**
     * @description 添加数据
     * @author zlx
     * @date 2020/10/16 14:50
     * @param form
     * @return java.lang.Long
     */
    public Long addOrganization(OrganizationForm.Add form){
        return organizationDao.insertOrganization(form);
    }

    /**
     * @description 编辑数据
     * @author zlx
     * @date 2020/10/16 14:51
     * @param form
     * @return boolean
     */
    public boolean editOrganization(OrganizationForm.Edit form){
        return organizationDao.updateOrganization(form)>0;
    }

    /**
     * @description 删除或批量删除数据
     * @author zlx
     * @date 2020/10/16 14:53
     * @param form
     * @return boolean
     */
    public boolean delOrganization(OrganizationForm.BatchDel form){
        return organizationDao.batchDelOrganization(form)>0;
    }

    public List<TreeNode> queryOrgTreeNode(OrganizationForm orgForm) {
        return organizationDao.queryOrgTreeNode(orgForm);
    }

    public List<Organization> findByAreaLevelOrganization(OrganizationForm.BatchDel form){
        return organizationDao.findByAreaLevelOrganization(form);
    }

    /**
     * @description: 根据行政区划Id查询组织机构信息
     * @author: zhangsq
     * @date: Created in 2020-10-26 10:16
     * @param form
     * @return: java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.Organization>
     * @exception:
     */
    public List<Organization> findByAreaCodeOrganization(OrganizationForm.Search form){
        return organizationDao.findOrganizationPage(form,0,0,false,true).getResult();
    }

    /**
     * @description 统计横向组织和纵向组织所占百分比
     * @author zlx
     * @date 2020/11/2 16:47
     * @param
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.OrganizationStatistics>
     */
    public List<OrganizationStatistics> findOrganizationStatistics(){
        return organizationDao.findOrganizationStatistics();
    }

    /**
     * @description 根据区域code和orgName查询数据
     * @author zlx
     * @date 2020/11/10 10:29
     * @param form
     * @return com.redare.shop.unifyworkbench.sdk.pojo.Organization
     */
    public Organization findOrganizationByAreaCodeAndOrgName(OrganizationForm.Search form){
        return organizationDao.findOrganizationByAreaCodeAndOrgName(form);
    }

    public List<Organization> generateOrganization(OrganizationForm.Search form){
        return organizationDao.generateOrganization(form);
    }

    public List<Organization> findByAreaCodeAndOrgClassify(OrganizationForm.Search form){
        return organizationDao.findByAreaCodeAndOrgClassify(form);
    }
}