package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.OrganizationExchangeSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.OrganizationExchange;
import com.redare.shop.unifyworkbench.sdk.pojo.form.OrganizationExchangeForm;
import com.redare.shop.unifyworkbench.service.service.OrganizationExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/10/29 16:52
 * @version:
 */
@Service
public class OrganizationExchangeSdkImpl implements OrganizationExchangeSdk {

    @Autowired
    OrganizationExchangeService organizationExchangeService;

    /**
     * @description 分页查询
     * @author zlx
     * @date 2020/10/29 16:55
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.OrganizationExchange>>
     */
    @Override
    public CommonResult<Page<OrganizationExchange>> findOrganizationExchangePage(OrganizationExchangeForm.Search form, int curPage, int pageSize) {
        return CommonResult.returnSuccessWrapper(organizationExchangeService.findOrganizationExchangePage(form, curPage, pageSize));
    }

    /**
     * @description 分页查询数据
     * @author zlx
     * @date 2020/10/29 16:55
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.OrganizationExchange>>
     */
    @Override
    public CommonResult<List<OrganizationExchange>> findOrganizationExchangePageList(OrganizationExchangeForm.Search form, int curPage, int pageSize) {
        return CommonResult.returnSuccessWrapper(organizationExchangeService.findOrganizationExchangePageList(form, curPage, pageSize));
    }

    /**
     * @description 查询所有数据
     * @author zlx
     * @date 2020/10/29 16:55
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.OrganizationExchange>>
     */
    @Override
    public CommonResult<List<OrganizationExchange>> findOrganizationExchangeList(OrganizationExchangeForm.Search form) {
        return CommonResult.returnSuccessWrapper(organizationExchangeService.findOrganizationExchangeList(form));
    }

    /**
     * @description 添加数据
     * @author zlx
     * @date 2020/10/29 16:55
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    @Override
    public CommonResult<Boolean> addOrganizationExchange(OrganizationExchangeForm.Add form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        return CommonResult.returnSuccessWrapper(organizationExchangeService.addOrganizationExchange(form));
    }
}
