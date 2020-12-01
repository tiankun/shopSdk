package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.webplatform.sdk.core.pojo.Fun;
import com.redare.devframework.webplatform.sdk.core.pojo.User;
import com.redare.shop.unifyworkbench.sdk.pojo.MenuRolePermission;
import com.redare.shop.unifyworkbench.service.dao.MenuRolePermissionDao;
import com.redare.shop.unifyworkbench.sdk.pojo.form.MenuRolePermissionForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/6/13 13:42
 * @version: 1.1
 */
@Service
public class MenuRolePermissionService {

    @Autowired
    MenuRolePermissionDao menuRolePermissionDao;

    /**
     * @description 根据用户id查询可用菜单
     * @author zlx
     * @date 2020/6/13 13:44
     * @param form
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.MenuRolePermission>
     */
    public List<MenuRolePermission> findMenuRolePermissionByUserId(MenuRolePermissionForm.Search form){
        return menuRolePermissionDao.findMenuRolePermissionByUserId(form);
    }

    public List<MenuRolePermission> findMenuRolePermissionByUserIdForApp(MenuRolePermissionForm.Search form){
        return menuRolePermissionDao.findMenuRolePermissionByUserIdForApp(form);
    }

    /**
     * @description 根据用户id查询可用功能
     * @author zlx
     * @date 2020/7/11 14:48
     * @param user
     * @return java.util.List<com.redare.devframework.webplatform.sdk.core.pojo.Fun>
     */
    public List<Fun> findFunList(User user){
        return menuRolePermissionDao.findFunList(user);
    }
}
