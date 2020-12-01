package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.OrganizationExchange;
import com.redare.shop.unifyworkbench.sdk.pojo.form.OrganizationExchangeForm;
import com.redare.shop.unifyworkbench.service.dao.OrganizationExchangeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/10/29 16:46
 * @version:
 */
@Service
public class OrganizationExchangeService {

    @Autowired
    OrganizationExchangeDao organizationExchangeDao;

    /**
     * @description 分页查询
     * @author zlx
     * @date 2020/10/29 16:48
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.OrganizationExchange>
     */
    public Page<OrganizationExchange> findOrganizationExchangePage(OrganizationExchangeForm.Search form,int curPage,int pageSize){
        return organizationExchangeDao.findOrganizationExchangePage(form,curPage,pageSize,true,false);
    }

    /**
     * @description 分页查询数据
     * @author zlx
     * @date 2020/10/29 16:50
     * @param form
     * @param curPage
     * @param pageSize
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.OrganizationExchange>
     */
    public List<OrganizationExchange> findOrganizationExchangePageList(OrganizationExchangeForm.Search form,int curPage,int pageSize){
        return organizationExchangeDao.findOrganizationExchangePage(form,curPage,pageSize,false,false).getResult();
    }

    /**
     * @description 查询所有数据
     * @author zlx
     * @date 2020/10/29 16:51
     * @param form
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.OrganizationExchange>
     */
    public List<OrganizationExchange> findOrganizationExchangeList(OrganizationExchangeForm.Search form){
        return organizationExchangeDao.findOrganizationExchangePage(form,0,0,false,true).getResult();
    }

    /**
     * @description 添加数据
     * @author zlx
     * @date 2020/10/29 16:51
     * @param form
     * @return java.lang.Boolean
     */
    public Boolean addOrganizationExchange(OrganizationExchangeForm.Add form){
        return organizationExchangeDao.addOrganizationExchange(form)>0;
    }
}
