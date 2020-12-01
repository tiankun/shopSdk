package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.devframework.webplatform.sdk.core.pojo.Fun;
import com.redare.devframework.webplatform.sdk.core.pojo.User;
import com.redare.shop.unifyworkbench.sdk.MenuRolePermissionSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.MenuRolePermission;
import com.redare.shop.unifyworkbench.sdk.pojo.form.MenuRolePermissionForm;
import com.redare.shop.unifyworkbench.service.service.MenuRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:MenuRolePermissionSdkImpl
 * @author: zlx
 * @date: Created in 2020/6/13 13:45
 * @version: 1.1
 */
@Service
public class MenuRolePermissionSdkImpl implements MenuRolePermissionSdk {

    @Autowired
    MenuRolePermissionService menuRolePermissionService;

    /**
     * @description 根据用户id查询可用菜单
     * @author zlx
     * @date 2020/6/13 13:48
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.MenuRolePermission>>
     */
    @Override
    public CommonResult<List<MenuRolePermission>> findMenuRolePermissionByUserId(MenuRolePermissionForm.Search form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        List<MenuRolePermission> list = menuRolePermissionService.findMenuRolePermissionByUserId(form);
        return CommonResult.returnSuccessWrapper(list);
    }

    @Override
    public CommonResult<List<MenuRolePermission>> findMenuRolePermissionByUserIdForApp(MenuRolePermissionForm.Search form) {
        if (form == null) {
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        List<MenuRolePermission> list = menuRolePermissionService.findMenuRolePermissionByUserIdForApp(form);
        return CommonResult.returnSuccessWrapper(list);
    }

    /**
     * @description 根据用户id查询可用功能
     * @author zlx
     * @date 2020/7/11 14:50
     * @param user
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.devframework.webplatform.sdk.core.pojo.Fun>>
     */
    @Override
    public CommonResult<List<Fun>> findFunList(User user) {
        if (user == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        List<Fun> list = menuRolePermissionService.findFunList(user);
        return CommonResult.returnSuccessWrapper(list);
    }
}
