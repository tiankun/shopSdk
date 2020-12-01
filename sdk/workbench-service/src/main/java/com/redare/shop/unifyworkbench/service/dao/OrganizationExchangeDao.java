package com.redare.shop.unifyworkbench.service.dao;

import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.OrganizationExchange;
import com.redare.shop.unifyworkbench.sdk.pojo.form.OrganizationExchangeForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/10/29 16:35
 * @version:
 */
@Repository
public class OrganizationExchangeDao {

    @Autowired
    SpringJdbcHelper springJdbcHelper;

    /**
     * @description 分页查询
     * @author zlx
     * @date 2020/10/29 16:40
     * @param form
     * @param curPage
     * @param pageSize
     * @param calCount
     * @param allList
     * @return com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.OrganizationExchange>
     */
    public Page<OrganizationExchange> findOrganizationExchangePage(OrganizationExchangeForm.Search form,int curPage,int pageSize,boolean calCount,boolean allList){
        Sql sql = Sql.select()
                .from("t_organization_exchange")
                .where()
                .andEqIfNotBlank("orgId",form.getOrgId())
                .andEqIfNotNull("userId",form.getUserId())
                .andBlikeJoinByOrIfNotBlank(form.getKey(),"orgName","userName","exchangeInfo")
                .andEq("status",1);
        return springJdbcHelper.queryForPageBean(sql.getSql().toString(),OrganizationExchange.class,sql.getParams().toArray(),curPage,pageSize,calCount,allList);
    }

    /**
     * @description 添加数据
     * @author zlx
     * @date 2020/10/29 16:44
     * @param form
     * @return java.lang.Long
     */
    public Long addOrganizationExchange(OrganizationExchangeForm.Add form){
        Sql sql = Sql.insert("t_organization_exchange")
                .field("orgId",form.getOrgId())
                .field("orgName",form.getOrgName())
                .field("userId",form.getUserId())
                .field("userName",form.getUserName())
                .field("exchangeInfo",form.getExchangeInfo())
                .field("attachment",form.getAttachment())
                .field("createTime",new Date())
                .field("updateTime",new Date())
                .field("status",1);
        return springJdbcHelper.insertReturnFieldNumber(sql.getSql().toString(),sql.getParams().toArray()).longValue();

    }
}
