package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.webplatform.sdk.core.pojo.Fun;
import com.redare.devframework.webplatform.sdk.core.pojo.User;
import com.redare.shop.unifyworkbench.sdk.pojo.MenuRolePermission;
import com.redare.shop.unifyworkbench.sdk.pojo.form.MenuRolePermissionForm;

import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/6/13 13:41
 * @version: 1.1
 */
public interface MenuRolePermissionSdk {

    /**
     * @description  根据用户id查询可用菜单
     * @author zlx
     * @date 2020/6/13 13:42
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.MenuRolePermission>>
     */
    CommonResult<List<MenuRolePermission>> findMenuRolePermissionByUserId(MenuRolePermissionForm.Search form);

    /**
     * @description 手机端调用
     * @author zlx
     * @date 2020/6/13 18:31
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.MenuRolePermission>>
     */
    CommonResult<List<MenuRolePermission>> findMenuRolePermissionByUserIdForApp(MenuRolePermissionForm.Search form);

    /**
     * @description 根据用户id查询可用功能
     * @author zlx
     * @date 2020/7/11 14:40
     * @param user
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.devframework.webplatform.sdk.core.pojo.Fun>>
     */
    CommonResult<List<Fun>> findFunList(User user);
}
