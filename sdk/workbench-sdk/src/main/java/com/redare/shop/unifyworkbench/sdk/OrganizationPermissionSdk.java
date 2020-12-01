package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.webplatform.sdk.core.pojo.RoleMenu;
import com.redare.shop.unifyworkbench.sdk.pojo.OrganizationFun;
import com.redare.shop.unifyworkbench.sdk.pojo.OrganizationMenu;
import com.redare.shop.unifyworkbench.sdk.pojo.form.OrganizationFunForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.OrganizationMenuForm;

import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/7/3 11:18
 * @version: 1.1
 */
public interface OrganizationPermissionSdk {

    /**
     * @description 根据组织机构id查询所有菜单及机构有权限的菜单
     * @author zlx
     * @date 2020/7/3 11:28
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.OrganizationMenu>>
     */
    CommonResult<Page<OrganizationMenu>> findOrganizationMenuPage(OrganizationMenuForm.Search form, int curPage, int pageSize);

    /**
     * @description 分页查询数据
     * @author zlx
     * @date 2020/7/3 12:08
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.OrganizationMenu>>
     */
    CommonResult<List<OrganizationMenu>> findOrganizationMenuList(OrganizationMenuForm.Search form, int curPage, int pageSize);

    /**
     * @description 查询所有数据
     * @author zlx
     * @date 2020/7/3 12:08
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.OrganizationMenu>>
     */
    CommonResult<List<OrganizationMenu>> findOrganizationMenuList(OrganizationMenuForm.Search form);

    /**
     * @description 根据机构id和菜单id查询功能信息（分页）
     * @author zlx
     * @date 2020/7/3 14:25
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.OrganizationFun>>
     */
    CommonResult<Page<OrganizationFun>> findOrganizationFunPage(OrganizationFunForm.Search form, int curPage, int pageSize);

    /**
     * @description 根据机构id和菜单id查询功能信息（分页查询数据）
     * @author zlx
     * @date 2020/7/3 14:27
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.OrganizationFun>>
     */
    CommonResult<List<OrganizationFun>> findOrganizationFunList(OrganizationFunForm.Search form,int curPage,int pageSize);

    /**
     * @description 根据机构id和菜单id查询功能信息（查询所有数据）
     * @author zlx
     * @date 2020/7/3 14:27
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.OrganizationFun>>
     */
    CommonResult<List<OrganizationFun>> findOrganizationFunList(OrganizationFunForm.Search form);

    /**
     * @description 添加组织机构所拥有的菜单
     * @author zlx
     * @date 2020/7/3 15:22
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Void>
     */
    CommonResult<Void> addOrganizationMenu(OrganizationMenuForm.AddMenu form);
    /**
     * @description 删除机构所拥有的菜单
     * @author zlx
     * @date 2020/7/3 15:22
     * @param from
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Void>
     */
    CommonResult<Void> delOrganizationMenu(OrganizationMenuForm.DelMenu from);

    /**
     * @description 添加机构功能
     * @author zlx
     * @date 2020/7/3 16:04
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Void>
     */
    CommonResult<Void> addOrganizationFun(OrganizationFunForm.AddFun form);

    /**
     * @description 删除机构可用功能
     * @author zlx
     * @date 2020/7/3 16:05
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Void>
     */
    CommonResult<Void> delOrganizationFun(OrganizationFunForm.DelFun form);

    /**
     * 查询组织机构权限
     * @param form
     * @return
     */
    CommonResult<List<RoleMenu>> findOrgMenuList(OrganizationMenuForm.Search form);

}
