package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.UserOrg;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserOrgForm;
import com.redare.shop.unifyworkbench.service.dao.UserOrgDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author : zhangsq
 * @version :
 * @description：人员组织机构业务实现类
 * @date ：Created in 2020-10-20 15:09
 */
@Service
public class UserOrgService {

    @Autowired
    UserOrgDao userOrgDao;

    /**
     * @description: 分页查询
     * @author: zhangsq
     * @date: Created in 2020-10-20 17:02
     * @param form
     * @param curPage
     * @param pageSize
     * @return: com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.UserOrg>
     * @exception:
     */
    public Page<UserOrg> findUserOrgPage(UserOrgForm.Search form, int curPage, int pageSize){
        return userOrgDao.findUserOrgPage(form,curPage,pageSize,true,false);
    }

    /**
     * @description: 分页查询列表数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 17:01
     * @param form
     * @param curPage
     * @param pageSize
     * @return: java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserOrg>
     * @exception:
     */
    public List<UserOrg> findUserOrgPageList(UserOrgForm.Search form, int curPage, int pageSize){
        return userOrgDao.findUserOrgPage(form,curPage,pageSize,false,false).getResult();
    }

    /**
     * @description: 查询所有数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 17:01
     * @param form
     * @return: java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserOrg>
     * @exception:
     */
    public List<UserOrg> findUserOrgList(UserOrgForm.Search form){
        return userOrgDao.findUserOrgPage(form,0,0,false,true).getResult();
    }

    /**
     * @description: 根据主键id查询数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 17:00
     * @param form
     * @return: com.redare.shop.unifyworkbench.sdk.pojo.UserOrg
     * @exception:
     */
    public UserOrg findUserOrg(UserOrgForm.Get form){
        return userOrgDao.findUserOrg(form);
    }

    /**
     * @description: 添加数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 16:59
     * @param form
     * @return: boolean
     * @exception:
     */
    public boolean addUserOrg(UserOrgForm.Add form){
        return userOrgDao.addUserOrg(form)>0;
    }

    /**
     * @description: 批量添加
     * @author: zhangsq
     * @date: Created in 2020-10-21 11:31
     * @param form
     * @return: boolean
     * @exception:
     */
    public boolean batchAddUserOrg(UserOrgForm.BatchAdd form){
        return userOrgDao.batchAddUserOrg(form).length>0;
    }

    /**
     * @description: 编辑数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 16:59
     * @param form
     * @return: boolean
     * @exception:
     */
    public boolean editUserOrg(UserOrgForm.Edit form){
        return userOrgDao.editUserOrg(form)>0;
    }

    /**
     * @description: 删除数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 16:18
     * @param form
     * @return: boolean
     * @exception:
     */
    public boolean delUserOrg(UserOrgForm.Del form){
        return userOrgDao.delUserOrg(form)>0;
    }

    public boolean delById(UserOrgForm.Del form){
        return userOrgDao.delById(form)>0;
    }

    /**
     * @description: 批量删除数据
     * @author: zhangsq
     * @date: Created in 2020-10-21 11:09
     * @param userIdList
     * @return: int
     * @exception:
     */
    public int batchDelUserOrg(List<Long> userIdList){
        return userOrgDao.batchDelUserOrg(userIdList);
    }

    /**
     * @description 根据用户id查询用户所在的机构
     * @author zlx
     * @date 2020/10/24 14:07
     * @param form
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserOrg>
     */
    public List<UserOrg> findUserOrgByUserId(UserOrgForm.Search form){
        return userOrgDao.findUserOrgByUserId(form);
    }

    /**
     * @description 根据组织机构id进行统计
     * @author zlx
     * @date 2020/10/28 15:22
     * @param form
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public Map<String,Object> findStatistics(UserOrgForm.Get form){
        return userOrgDao.findStatistics(form);
    }

    /**
     * @description 据机构id分页查询人员数据分页
     * @author zlx
     * @date 2020/10/28 18:01
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.UserOrg>
     */
    public Page<UserOrg> findUserOrgPageByOrgId(UserOrgForm.Get form,int curPage,int pageSize){
        return userOrgDao.findUserOrgPageByOrgId(form,curPage,pageSize,true,false);
    }

    /**
     * @description 据机构id分页查询人员数据
     * @author zlx
     * @date 2020/11/12 16:38
     * @param form
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserOrg>
     */
    public List<UserOrg> findUserOrgListByOrgId(UserOrgForm.Get form){
        return userOrgDao.findUserOrgPageByOrgId(form,0,0,false,true).getResult();
    }

    /**
     * @description 根据组织机构id和部门id判断是否存在人员
     * @author zlx
     * @date 2020/11/23 16:15
     * @param form
     * @return boolean
     */
    public boolean checkUserOrgByOrgIdAndDeptId(UserOrgForm.Get form){
        return userOrgDao.checkUserOrgByOrgIdAndDeptId(form).size()>0;
    }
}
