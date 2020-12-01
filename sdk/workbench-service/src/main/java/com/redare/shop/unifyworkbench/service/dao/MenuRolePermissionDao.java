package com.redare.shop.unifyworkbench.service.dao;

import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.devframework.webplatform.sdk.core.pojo.Fun;
import com.redare.devframework.webplatform.sdk.core.pojo.User;
import com.redare.shop.unifyworkbench.sdk.pojo.MenuRolePermission;
import com.redare.shop.unifyworkbench.sdk.pojo.form.MenuRolePermissionForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:MenuRolePermissionDao
 * @author: zlx
 * @date: Created in 2020/6/13 13:34
 * @version: 1.1
 */
@Repository
public class MenuRolePermissionDao {

    @Autowired
    SpringJdbcHelper springJdbcHelper;

    /**
     * @description 根据用户id查询用户可用菜单
     * @author zlx
     * @date 2020/6/13 13:40
     * @param form
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.MenuRolePermission>
     */
    public List<MenuRolePermission> findMenuRolePermissionByUserId(MenuRolePermissionForm.Search form){
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT DISTINCT(a.`menuId`),b. NAME,b.urlPath,b.`componentId`,c.`webPath`")
                .append(" FROM base_role_menu a JOIN base_menu b ON a.`menuId` = b.`menuId`")
                .append(" LEFT JOIN base_component c ON b.`componentId` = c.id")
                .append(" JOIN (SELECT e.* FROM base_account e WHERE e.id=?) d ON FIND_IN_SET(a.roleId,d.roleIds)")
                .append(" union ")
                .append(" SELECT DISTINCT(a.`menuId`),b. NAME,b.urlPath,b.`componentId`,c.`webPath`")
                .append(" FROM t_organization_menu a JOIN base_menu b ON a.`menuId` = b.`menuId`")
                .append(" LEFT JOIN base_component c ON b.`componentId` = c.id")
                .append(" JOIN (SELECT e.* FROM base_user e WHERE e.userId=?) d ON a.orgId=d.orgId");
        Object [] args={form.getUserId(),form.getUserId()};
        return springJdbcHelper.queryForListBean(sql.toString(),MenuRolePermission.class,args);
    }


    public List<MenuRolePermission> findMenuRolePermissionByUserIdForApp(MenuRolePermissionForm.Search form){
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT DISTINCT a.menuId,a.`name` AS menuName,a.componentId,f.webPath,l.id,l.`name`,l.url,l.needPermission FROM base_menu a ")
                .append(" JOIN (SELECT b.* FROM base_role_menu b JOIN (SELECT c.* FROM base_account c WHERE c.id=?) d ON FIND_IN_SET(b.roleId,d.roleIds)) e")
                .append(" ON a.menuId = e.menuId JOIN base_component f ON a.componentId=f.id JOIN base_component_fun k ON k.componentId = f.id")
                .append(" JOIN (SELECT g.roleId,g.funId FROM base_role_fun g JOIN (SELECT h.* FROM base_account h WHERE h.id=?) i ON FIND_IN_SET(g.roleId,i.roleIds)) j")
                .append(" ON k.funId=j.funId JOIN base_fun l ON j.funId = l.id")
                .append(" union ")
                .append(" SELECT DISTINCT a.menuId,a.`name` AS menuName,a.componentId,f.webPath,l.id,l.`name`,l.url,l.needPermission FROM base_menu a ")
                .append(" JOIN (SELECT b.* FROM t_organization_menu b WHERE b.orgId = (SELECT d.orgId FROM base_user d WHERE d.userId=?)) e")
                .append(" ON a.menuId = e.menuId")
                .append(" JOIN base_component f ON a.componentId=f.id JOIN base_component_fun k ON k.componentId = f.id")
                .append(" JOIN (SELECT g.orgId,g.funId FROM t_organization_fun g WHERE g.orgId = (SELECT h.orgId FROM base_user h WHERE h.userId=?)) j")
                .append(" ON k.funId=j.funId JOIN base_fun l ON j.funId = l.id");
        Object [] args={form.getUserId(),form.getUserId(),form.getUserId(),form.getUserId()};
        return springJdbcHelper.queryForListBean(sql.toString(),MenuRolePermission.class,args);
    }

    /**
     * @description 根据用户id查询可用功能
     * @author zlx
     * @date 2020/7/11 14:48
     * @param user
     * @return java.util.List<com.redare.devframework.webplatform.sdk.core.pojo.Fun>
     */
    public List<Fun> findFunList(User user){
        StringBuilder sql = new StringBuilder();
        Object [] arg = new Object[]{};
        if (user.getUserId() == 0){
            sql.append("select * from base_fun");
        }else {
            sql.append("SELECT t1.* FROM base_fun t1");
            sql.append(" JOIN (SELECT t2.funId,t2.roleId FROM base_role_fun t2 WHERE FIND_IN_SET(t2.roleId,(SELECT t3.roleIds FROM base_account t3 WHERE t3.id = ?)))t4");
            sql.append(" ON t1.id=t4.funId");
            sql.append(" UNION");
            sql.append(" SELECT t1.* FROM base_fun t1");
            sql.append(" JOIN (SELECT t2.funId,t2.orgId FROM t_organization_fun t2 WHERE t2.orgId= ?) t4");
            sql.append(" ON t1.id = t4.funId");
            arg = new Object[]{user.getUserId(),user.getUserPlatform()};
        }
        return springJdbcHelper.queryForListBean(sql.toString(),Fun.class,arg);
    }
}
