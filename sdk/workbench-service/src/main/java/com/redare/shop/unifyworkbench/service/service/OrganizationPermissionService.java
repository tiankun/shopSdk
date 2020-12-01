package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.LevelTreeQuery;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.webplatform.sdk.core.pojo.RoleMenu;
import com.redare.shop.unifyworkbench.sdk.pojo.OrganizationFun;
import com.redare.shop.unifyworkbench.sdk.pojo.OrganizationMenu;
import com.redare.shop.unifyworkbench.sdk.pojo.form.OrganizationFunForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.OrganizationMenuForm;
import com.redare.shop.unifyworkbench.service.dao.OrganizationPermissionDao;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/7/3 11:49
 * @version: 1.1
 */
@Service
public class OrganizationPermissionService {

    @Autowired
    OrganizationPermissionDao organizationPermissionDao;

    public static LevelTreeQuery.SortAction<OrganizationMenu> organizationMenuSortAction = new LevelTreeQuery.SortAction<OrganizationMenu>() {
        public String getId(OrganizationMenu menu) {
            return menu.getMenuId();
        }

        public String getParentId(OrganizationMenu menu) {
            return menu.getParentMenuId();
        }

        public void initChildList(OrganizationMenu menu) {
            menu.setChildren(new ArrayList());
        }

        public void addChild(OrganizationMenu menu, OrganizationMenu t1) {
            menu.getChildren().add(t1);
        }

        public void setChildList(OrganizationMenu menu, List<OrganizationMenu> list) {
            menu.setChildren(list);
        }

        public void removeChild(OrganizationMenu menu) {
            menu.setChildren((List)null);
        }

        public List<OrganizationMenu> getChildList(OrganizationMenu menu) {
            return menu.getChildren();
        }
    };

    /**
     * @description 分页查询
     * @author zlx
     * @date 2020/7/3 11:58
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.OrganizationMenu>
     */
    public Page<OrganizationMenu> findOrganizationMenuPage(OrganizationMenuForm.Search form,int curPage,int pageSize){
        return organizationPermissionDao.findOrganizationMenuPage(form,curPage,pageSize,true,false);
    }

    /**
     * @description 分页查询数据
     * @author zlx
     * @date 2020/7/3 11:59
     * @param form
     * @param curPage
     * @param pageSize
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.OrganizationMenu>
     */
    public List<OrganizationMenu> findOrganizationMenuList(OrganizationMenuForm.Search form,int curPage,int pageSize){
        return organizationPermissionDao.findOrganizationMenuPage(form,curPage,pageSize,false,false).getResult();
    }

    /**
     * @description 查询所有数据
     * @author zlx
     * @date 2020/7/3 12:05
     * @param form
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.OrganizationMenu>
     */
    public List<OrganizationMenu> findOrganizationMenuList(OrganizationMenuForm.Search form){
        List<OrganizationMenu> list = organizationPermissionDao.findOrganizationMenuPage(form,0,0,false,true).getResult();
        if (CollectionUtils.isNotEmpty(list)) {
            if (CollectionUtils.isNotEmpty(list)) {
                if (form.getLevelTreeQuery() != null) {
                    if (form.getLevelTreeQuery().isSortToTree()) {
                        list = form.getLevelTreeQuery().sort(list, organizationMenuSortAction);
                    }
                } else if (form.isSortToTree()) {
                    list = LevelTreeQuery.sortDownToTree((String)Optional.ofNullable(form.getParentMenuId()).orElse(""), list, organizationMenuSortAction);
                }
            }
        }
        return list;
    }

    /**
     * @description 根据机构id和菜单id查询功能信息（分页）
     * @author zlx
     * @date 2020/7/3 14:37
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.OrganizationFun>
     */
    public Page<OrganizationFun> findOrganizationFunPage(OrganizationFunForm.Search form, int curPage, int pageSize){
        return organizationPermissionDao.findOrganizationFunPage(form,curPage,pageSize,true,false);
    }

    /**
     * @description 根据机构id和菜单id查询功能信息（分页查询数据）
     * @author zlx
     * @date 2020/7/3 14:39
     * @param form
     * @param curPage
     * @param pageSize
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.OrganizationFun>
     */
    public List<OrganizationFun> findOrganizationFunList(OrganizationFunForm.Search form,int curPage,int pageSize){
        return organizationPermissionDao.findOrganizationFunPage(form,curPage,pageSize,false,false).getResult();
    }

    /**
     * @description 根据机构id和菜单id查询功能信息（查询所有数据）
     * @author zlx
     * @date 2020/7/3 14:40
     * @param form
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.OrganizationFun>
     */
    public List<OrganizationFun> findOrganizationFunList(OrganizationFunForm.Search form){
        return organizationPermissionDao.findOrganizationFunPage(form,0,0,false,true).getResult();
    }

    /**
     * @description 添加组织机构可用菜单
     * @author zlx
     * @date 2020/7/3 15:37
     * @param form
     * @return boolean
     */
    @Transactional
    public boolean addOrganizationMenu(OrganizationMenuForm.AddMenu form){
        organizationPermissionDao.delOrganizationMenu(new OrganizationMenuForm.DelMenu().setOrgId(form.getOrgId()).setMenuIds(form.getMenuIds()));
        organizationPermissionDao.addOrganizationMenu(form);
        return true;
    }

    /**
     * @description 删除机构可用菜单
     * @author zlx
     * @date 2020/7/3 15:38
     * @param form
     * @return boolean
     */
    public boolean delOrganizationMenu(OrganizationMenuForm.DelMenu form){
        organizationPermissionDao.delOrganizationMenu(form);
        return true;
    }

    /**
     * @description 添加组织机构可用功能
     * @author zlx
     * @date 2020/7/3 16:12
     * @param form
     * @return boolean
     */
    @Transactional
    public boolean addOrganizationFun(OrganizationFunForm.AddFun form){
        organizationPermissionDao.delOrganizationFun(new OrganizationFunForm.DelFun().setOrgId(form.getOrgId()).setFunIds(form.getFunIds()));
        organizationPermissionDao.addOrganizationFun(form);
        return true;
    }

    /**
     * @description 删除机构可用功能
     * @author zlx
     * @date 2020/7/3 16:13
     * @param form
     * @return boolean
     */
    public boolean delOrganizationFun(OrganizationFunForm.DelFun form){
        organizationPermissionDao.delOrganizationFun(form);
        return true;
    }

    public List<RoleMenu> findOrgMenuList(OrganizationMenuForm.Search form) {
        return organizationPermissionDao.findOrgMenuList(form);
    }


}
