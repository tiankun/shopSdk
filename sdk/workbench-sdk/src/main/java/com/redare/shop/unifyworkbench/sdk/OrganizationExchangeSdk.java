package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.OrganizationExchange;
import com.redare.shop.unifyworkbench.sdk.pojo.form.OrganizationExchangeForm;

import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/10/29 16:31
 * @version:
 */
public interface OrganizationExchangeSdk {

    /**
     * @description 分页查询
     * @author zlx
     * @date 2020/10/29 16:33
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.OrganizationExchange>>
     */
    CommonResult<Page<OrganizationExchange>> findOrganizationExchangePage(OrganizationExchangeForm.Search form,int curPage,int pageSize);
    /**
     * @description 分页查询列表数据
     * @author zlx
     * @date 2020/10/29 16:34
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.OrganizationExchange>>
     */
    CommonResult<List<OrganizationExchange>> findOrganizationExchangePageList(OrganizationExchangeForm.Search form, int curPage, int pageSize);

    /**
     * @description 查询所有数据
     * @author zlx
     * @date 2020/10/29 16:34
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.OrganizationExchange>>
     */
    CommonResult<List<OrganizationExchange>> findOrganizationExchangeList(OrganizationExchangeForm.Search form);

    /**
     * @description 添加数据
     * @author zlx
     * @date 2020/10/29 16:35
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    CommonResult<Boolean> addOrganizationExchange(OrganizationExchangeForm.Add form);
}
