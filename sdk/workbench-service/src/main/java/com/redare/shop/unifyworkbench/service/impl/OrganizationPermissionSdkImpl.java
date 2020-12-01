package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.devframework.webplatform.sdk.core.pojo.RoleMenu;
import com.redare.shop.unifyworkbench.sdk.OrganizationPermissionSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.OrganizationFun;
import com.redare.shop.unifyworkbench.sdk.pojo.OrganizationMenu;
import com.redare.shop.unifyworkbench.sdk.pojo.form.OrganizationFunForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.OrganizationMenuForm;
import com.redare.shop.unifyworkbench.service.service.OrganizationPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/7/3 12:06
 * @version: 1.1
 */
@Service
public class OrganizationPermissionSdkImpl implements OrganizationPermissionSdk {

    @Autowired
    OrganizationPermissionService organizationPermissionService;

    /**
     * @description 分页查询
     * @author zlx
     * @date 2020/7/3 12:08
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.OrganizationMenu>>
     */
    @Override
    public CommonResult<Page<OrganizationMenu>> findOrganizationMenuPage(OrganizationMenuForm.Search form, int curPage, int pageSize) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        return CommonResult.returnSuccessWrapper(organizationPermissionService.findOrganizationMenuPage(form, curPage, pageSize));
    }

    /**
     * @description 分页查询数据
     * @author zlx
     * @date 2020/7/3 12:09
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.OrganizationMenu>>
     */
    @Override
    public CommonResult<List<OrganizationMenu>> findOrganizationMenuList(OrganizationMenuForm.Search form, int curPage, int pageSize) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        return CommonResult.returnSuccessWrapper(organizationPermissionService.findOrganizationMenuList(form, curPage, pageSize));
    }

    /**
     * @description 查询所有数据
     * @author zlx
     * @date 2020/7/3 12:09
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.OrganizationMenu>>
     */
    @Override
    public CommonResult<List<OrganizationMenu>> findOrganizationMenuList(OrganizationMenuForm.Search form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        return CommonResult.returnSuccessWrapper(organizationPermissionService.findOrganizationMenuList(form));
    }

    /**
     * @description 根据机构id和菜单id查询功能信息（分页）
     * @author zlx
     * @date 2020/7/3 14:44
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.OrganizationFun>>
     */
    @Override
    public CommonResult<Page<OrganizationFun>> findOrganizationFunPage(OrganizationFunForm.Search form, int curPage, int pageSize) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        return CommonResult.returnSuccessWrapper(organizationPermissionService.findOrganizationFunPage(form, curPage, pageSize));
    }

    /**
     * @description 根据机构id和菜单id查询功能信息（分页查询数据）
     * @author zlx
     * @date 2020/7/3 14:44
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.OrganizationFun>>
     */
    @Override
    public CommonResult<List<OrganizationFun>> findOrganizationFunList(OrganizationFunForm.Search form, int curPage, int pageSize) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        return CommonResult.returnSuccessWrapper(organizationPermissionService.findOrganizationFunList(form, curPage, pageSize));
    }

    /**
     * @description 根据机构id和菜单id查询功能信息（查询所有数据）
     * @author zlx
     * @date 2020/7/3 14:45
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.OrganizationFun>>
     */
    @Override
    public CommonResult<List<OrganizationFun>> findOrganizationFunList(OrganizationFunForm.Search form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        return CommonResult.returnSuccessWrapper(organizationPermissionService.findOrganizationFunList(form));
    }

    /**
     * @description 添加机构可用菜单
     * @author zlx
     * @date 2020/7/3 15:40
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Void>
     */
    @Override
    public CommonResult<Void> addOrganizationMenu(OrganizationMenuForm.AddMenu form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        boolean bool = organizationPermissionService.addOrganizationMenu(form);
        return CommonResult.returnBoolWrapper(bool,"操作失败");
    }

    /**
     * @description 删除机构可用菜单
     * @author zlx
     * @date 2020/7/3 15:41
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Void>
     */
    @Override
    public CommonResult<Void> delOrganizationMenu(OrganizationMenuForm.DelMenu form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        boolean bool = organizationPermissionService.delOrganizationMenu(form);
        return CommonResult.returnBoolWrapper(bool,"操作失败");
    }

    /**
     * @description 添加机构可用功能
     * @author zlx
     * @date 2020/7/3 16:15
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Void>
     */
    @Override
    public CommonResult<Void> addOrganizationFun(OrganizationFunForm.AddFun form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        boolean bool = organizationPermissionService.addOrganizationFun(form);
        return CommonResult.returnBoolWrapper(bool,"操作失败");
    }



    /**
     * @description 删除机构可用功能
     * @author zlx
     * @date 2020/7/3 16:15
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Void>
     */
    @Override
    public CommonResult<Void> delOrganizationFun(OrganizationFunForm.DelFun form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        boolean bool = organizationPermissionService.delOrganizationFun(form);
        return CommonResult.returnBoolWrapper(bool,"操作失败");
    }

    /**
     * 查询组织机构菜单权限
     * @param form
     * @return
     */
    @Override
    public CommonResult<List<RoleMenu>> findOrgMenuList(OrganizationMenuForm.Search form) {
        CommonResult result = ValidationUtils.simpleValidate(form);
        if (result.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(result.getMessage());
        }
        List<RoleMenu> orgMenuList  = this.organizationPermissionService.findOrgMenuList(form);


        return CommonResult.returnSuccessWrapper(orgMenuList);

    }
}
