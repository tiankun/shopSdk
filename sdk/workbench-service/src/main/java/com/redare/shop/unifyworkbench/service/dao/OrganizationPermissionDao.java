package com.redare.shop.unifyworkbench.service.dao;

import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.devframework.webplatform.sdk.core.pojo.RoleMenu;
import com.redare.shop.unifyworkbench.sdk.pojo.OrganizationFun;
import com.redare.shop.unifyworkbench.sdk.pojo.OrganizationMenu;
import com.redare.shop.unifyworkbench.sdk.pojo.form.OrganizationFunForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.OrganizationMenuForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/7/3 11:26
 * @version: 1.1
 */
@Repository
public class OrganizationPermissionDao {

    @Autowired
    SpringJdbcHelper springJdbcHelper;

    /**
     * @description 根据组织机构id分页查询可用菜单
     * @author zlx
     * @date 2020/7/3 11:41
     * @param form
     * @param curPage
     * @param pageSize
     * @param calCount
     * @param allList
     * @return com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.OrganizationMenu>
     */
    public Page<OrganizationMenu> findOrganizationMenuPage(OrganizationMenuForm.Search form,int curPage,int pageSize,boolean calCount,boolean allList){
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT a.*,IF ( b.menuId IS NULL,0, 1 ) AS hasPermission,'0' AS adminPermission");
        sql.append(" FROM( SELECT a.* FROM base_menu a WHERE a.platformMenuId = ? AND a.enabled = ? AND a.root = 0 ) a");
        sql.append(" LEFT JOIN ( SELECT a.orgId , b.menuId FROM t_organization a LEFT JOIN t_organization_menu b ON a.orgId = b.orgId");
        sql.append(" WHERE a.orgId = ? ) b ON ( a.menuId = b.menuId ) ORDER BY a.sort DESC, a.id ASC");
        Object [] arg = {form.getPlatformMenuId(),form.getEnabled(),form.getOrgId()};
        return springJdbcHelper.queryForPageBean(sql.toString(),OrganizationMenu.class,arg,curPage,pageSize,calCount,allList);
    }

    /**
     * @description 根据组织机构id和菜单id查询功能信息
     * @author zlx
     * @date 2020/7/3 14:34
     * @param form
     * @param curPage
     * @param pageSize
     * @param callCount
     * @param allList
     * @return com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.OrganizationFun>
     */
    public Page<OrganizationFun> findOrganizationFunPage(OrganizationFunForm.Search form,int curPage,int pageSize,boolean callCount,boolean allList){
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT a.*, IF (c.funId IS NULL,0,1) AS hasPermission, 0 AS adminPermission FROM base_fun a");
        sql.append(" JOIN (SELECT b.funId AS funId FROM base_menu a JOIN base_component_fun b ON a.componentId = b.componentId");
        sql.append(" AND a.menuId = ?  AND find_in_set(b.funId,ifnull(a.funBlackList, '')) = 0 ) b ON a.id = b.funId");
        sql.append(" LEFT JOIN ( SELECT a.orgId, b.funId FROM t_organization a LEFT JOIN t_organization_fun b ON a.orgId = b.orgId");
        sql.append(" WHERE a.orgId = ? ) c ON ( a.id = c.funId ) ORDER BY NAME ASC");
        Object[] arg = {form.getMenuId(),form.getOrgId()};
        return springJdbcHelper.queryForPageBean(sql.toString(),OrganizationFun.class,arg,curPage,pageSize,callCount,allList);
    }

    /**
     * @description 批量添加机构菜单
     * @author zlx
     * @date 2020/7/3 15:28
     * @param form
     * @return int[]
     */
    public int[] addOrganizationMenu(OrganizationMenuForm.AddMenu form){
        String sql = "insert into t_organization_menu(orgId,menuId) values(?,?)";
        List<Object[]> params = new ArrayList<>();
        Iterator<String> iterator = form.getMenuIds().iterator();
        while (iterator.hasNext()){
            String menuId = iterator.next();
            params.add(new Object[]{form.getOrgId(),menuId});
        }
        return springJdbcHelper.batchUpdate(sql,params);
    }

    /**
     * @description 批量删除机构可用菜单
     * @author zlx
     * @date 2020/7/3 15:33
     * @param form
     * @return int
     */
    public int delOrganizationMenu(OrganizationMenuForm.DelMenu form){
        Sql sql = Sql.delete("t_organization_menu")
                .where()
                .andEqIfNotNull("orgId",form.getOrgId())
                .andInIfNotEmpty("menuId",form.getMenuIds());
        return springJdbcHelper.update(sql);
    }

    /**
     * @description 添加组织机构可用功能
     * @author zlx
     * @date 2020/7/3 16:07
     * @param form
     * @return int[]
     */
    public int[] addOrganizationFun(OrganizationFunForm.AddFun form){
        String sql = "insert into t_organization_fun(orgId,funId) values(?,?)";
        List<Object[]> params = new ArrayList<>();
        Iterator<String> iterator = form.getFunIds().iterator();
        while (iterator.hasNext()){
            String funId = iterator.next();
            params.add(new Object[]{form.getOrgId(),funId});
        }
        return springJdbcHelper.batchUpdate(sql,params);
    }

    /**
     * @description 删除机构可用功能
     * @author zlx
     * @date 2020/7/3 16:10
     * @param form
     * @return int
     */
    public int delOrganizationFun(OrganizationFunForm.DelFun form){
        Sql sql = Sql.delete("t_organization_fun")
                .where()
                .andEqIfNotNull("orgId",form.getOrgId())
                .andInIfNotEmpty("funId",form.getFunIds());
        return springJdbcHelper.update(sql);
    }

    /**
     * 查询组织机构拥有的菜单
     * @param form
     * @return
     */
    public List<RoleMenu> findOrgMenuList(OrganizationMenuForm.Search form) {
        StringBuilder sql = new StringBuilder();

        sql.append(" select a.*, ");
        sql.append("        if(b.menuId is null, 0, 1) as hasPermission, ");
        sql.append("        false                      as adminPermission, ");
        sql.append("        c.classId                  as componentClassId, ");
        sql.append("        c.name                     as componentName, ");
        sql.append("        c.webPath                  as componentWebPath ");
        sql.append(" from (select * from base_menu where platformMenuId = ? and enabled = 1 and root = 0) a ");
        sql.append("          join (select distinct menuId as menuId ");
        sql.append("                from t_organization_menu ");
        sql.append("                where orgId = ?) b on a.menuId = b.menuId ");
        sql.append("          join base_component c on a.componentId = c.id ");
        sql.append(" order by a.sort desc, a.id asc ");

        Object[] arg = {form.getPlatformMenuId(),form.getOrgId()};

        return springJdbcHelper.queryForListBean(sql.toString(),RoleMenu.class,arg);    }
}
