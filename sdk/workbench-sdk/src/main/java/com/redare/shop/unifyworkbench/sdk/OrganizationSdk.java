package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.Organization;
import com.redare.shop.unifyworkbench.sdk.pojo.form.OrganizationForm;

import java.util.List;
import java.util.Map;

/**
 * 组织机构表(Organization)SDK
 *
 * @author zlx
 * @since 2020-10-16 11:48:29
 */
public interface OrganizationSdk {

    /**
     * 组织分类：hx-横向组织；
     */
    String ORG_CLASSIFY_HX = "hx";
    /**
     * 组织分类：zx-纵向组织
     */
    String ORG_CLASSIFY_ZX = "zx";

    /**
     * @description 分页查询列表
     * @author zlx
     * @date 2020/10/16 14:27
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.Organization>>
     */
    CommonResult<Page<Organization>> findOrganizationPage(OrganizationForm.Search form,int curPage,int pageSize);
    /**
     * @description 分页查询列表数据
     * @author zlx
     * @date 2020/10/16 14:27
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.Organization>>
     */
    CommonResult<List<Organization>> findOrganizationPageList(OrganizationForm.Search form,int curPage,int pageSize);
    /**
     * @description 查询所有数据，不分页
     * @author zlx
     * @date 2020/10/16 14:27
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.Organization>>
     */
    CommonResult<List<Organization>> findOrganizationList(OrganizationForm.Search form);
    /**
     * @description 根据主键id或orgId查询数据
     * @author zlx
     * @date 2020/10/16 14:28
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.Organization>
     */
    CommonResult<Organization> findOrganization(OrganizationForm.Get form);
    /**
     * @description 添加数据
     * @author zlx
     * @date 2020/10/16 14:29
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Long>
     */
    CommonResult<String> addOrganization(OrganizationForm.Add form);
    /**
     * @description 编辑数据
     * @author zlx
     * @date 2020/10/16 14:29
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    CommonResult<Boolean> editOrganization(OrganizationForm.Edit form);
    /**
     * @description 删除或批量删除数据
     * @author zlx
     * @date 2020/10/16 14:30
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    CommonResult<Boolean> delOrganization(OrganizationForm.BatchDel form);

//    /**
//     * 查询TreeNode
//     * @param form
//     * @return
//     */
//    CommonResult<List<TreeNode>> queryOrganizationTreeNode(OrganizationForm.Search form);

    /**
     * @description: 根据行政区划Id查询组织机构信息
     * @author: zhangsq
     * @date: Created in 2020-10-26 10:13
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.Organization>>
     * @exception:
     */
    CommonResult<List<Organization>> findByAreaCodeOrganization(OrganizationForm.Search form);

    /**
     * @description 统计横向组织和纵向组织所占百分比
     * @author zlx
     * @date 2020/11/2 16:38
     * @param
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.Map<java.lang.String,java.lang.Object>>
     */
    CommonResult<Map<String,Object>> findOrganizationStatistics();

    /**
     * @description 根据区域code和组织机构名称查询数据
     * @author zlx
     * @date 2020/11/10 10:22
     * @param
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.Organization>
     */
    CommonResult<Organization> findOrganizationByAreaCodeAndOrgName(OrganizationForm.Search form);
}
