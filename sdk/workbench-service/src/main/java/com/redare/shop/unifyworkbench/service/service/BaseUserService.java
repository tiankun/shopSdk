package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.BaseUser;
import com.redare.shop.unifyworkbench.sdk.pojo.BaseUserDept;
import com.redare.shop.unifyworkbench.sdk.pojo.form.BaseUserForm;
import com.redare.shop.unifyworkbench.service.dao.BaseUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 人员信息业务实现类
 * @author: zhangsq
 * @date: Created in 2020-10-20 15:10
 * @return:
 * @exception:
 */
@Service
public class BaseUserService {

    @Autowired
    BaseUserDao baseUserDao;

    /**
     * @description: 根据用户姓名和手机号码查询用户信息
     * @author: zhangsq
     * @date: Created in 2020-10-20 11:31
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.BaseUser>
     * @exception:
     */
    public BaseUser getBaseUserByNameAndPhone(BaseUserForm.Search form){
        return baseUserDao.queryBaseUserByNameAndPhone(form);
    }

    /**
     * @description: 分页查询人员列表
     * @author: zhangsq
     * @date: Created in 2020-10-20 17:18
     * @param form
     * @param curPage
     * @param pageSize
     * @return: com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.BaseUser>
     * @exception:
     */
    public Page<BaseUser> findBaseUserPage (BaseUserForm.Search form,int curPage,int pageSize){
        return baseUserDao.findBaseUserPage(form,curPage,pageSize,true,false);
    }


    /**
     * @description: 分页查询人员列表数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 17:19
     * @param form
     * @param curPage
     * @param pageSize
     * @return: com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.BaseUser>
     * @exception:
     */
    public List<BaseUser> findBaseUserPageList(BaseUserForm.Search form, int curPage, int pageSize){
        return baseUserDao.findBaseUserPage(form,curPage,pageSize,false,false).getResult();
    }

    /**
     * @description: 查询所有人员数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 17:22
     * @param form
     * @return: java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.BaseUser>
     * @exception:
     */
    public List<BaseUser> findBaseUserList(BaseUserForm.Search form){
        return baseUserDao.findBaseUserPage(form,0,0,false,true).getResult();
    }

    public List<BaseUserDept> findBaseUserDept (BaseUserForm.Search form, int curPage, int pageSize){
        return baseUserDao.findBaseUserDept(form,0,0,false,true).getResult();
    }

    /**
     * @description: 根据主键id查询人员数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 17:23
     * @param form
     * @return: com.redare.shop.unifyworkbench.sdk.pojo.BaseUser
     * @exception:
     */
    public BaseUser findBaseUser(BaseUserForm.Get form){
        return baseUserDao.findBaseUser(form);
    }


    /**
     * @description: 根据身份证ID进行查询
     * @author: zhangsq
     * @date: Created in 2020-11-09 10:26
     * @param form
     * @return: com.redare.shop.unifyworkbench.sdk.pojo.BaseUser
     * @exception:
     */
    public BaseUser findByCardNoBaseUser(BaseUserForm.Get form){
        return baseUserDao.findByCardNoBaseUser(form);
    }

    /**
     * @description: 添加人员数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 17:24
     * @param form
     * @return: java.lang.Long
     * @exception:
     */
    public int addBaseUser(BaseUserForm.Add form){
        return baseUserDao.addBaseUser(form);
    }

    /**
     * @description: 编辑人员数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 17:25
     * @param form
     * @return: boolean
     * @exception:
     */
    public boolean editBaseUser(BaseUserForm.Edit form){
        return baseUserDao.editBaseUser(form)>0;
    }

    /**
     * @description: 删除人员信息
     * @author: zhangsq
     * @date: Created in 2020-10-20 17:26
     * @param form
     * @return: boolean
     * @exception:
     */
    public boolean delBaseUser(BaseUserForm.BatchDel form){
        return baseUserDao.delBaseUser(form)>0;
    }

}
