package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.UserHonor;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserHonorForm;
import com.redare.shop.unifyworkbench.service.dao.UserHonorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : zhangsq
 * @version :
 * @description：人员荣誉信息业务实现类
 * @date ：Created in 2020-10-20 15:11
 */
@Service
public class UserHonorService {

    @Autowired
    UserHonorDao userHonorDao;

    /**
     * @description: 分页查询
     * @author: zhangsq
     * @date: Created in 2020-10-20 15:23
     * @param form
     * @param curPage
     * @param pageSize
     * @return: com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.UserHonor>
     * @exception:
     */
    public Page<UserHonor> findUserHonorPage(UserHonorForm.Search form, int curPage, int pageSize){
        return userHonorDao.findUserHonorPage(form,curPage,pageSize,true,false);
    }

    /**
     * @description: 分页查询列表数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 15:31
     * @param form
     * @param curPage
     * @param pageSize
     * @return: java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserHonor>
     * @exception:
     */
    public List<UserHonor> findUserHonorPageList(UserHonorForm.Search form, int curPage, int pageSize){
        return userHonorDao.findUserHonorPage(form,curPage,pageSize,false,false).getResult();
    }

    /**
     * @description: 查询所有数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 15:46
     * @param form
     * @return: java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserHonor>
     * @exception:
     */
    public List<UserHonor> findUserHonorList(UserHonorForm.Search form){
        return userHonorDao.findUserHonorPage(form,0,0,false,true).getResult();
    }

    /**
     * @description: 根据荣誉id查询数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 15:49
     * @param form
     * @return: com.redare.shop.unifyworkbench.sdk.pojo.UserHonor
     * @exception:
     */
    public UserHonor findUserHonor(UserHonorForm.Get form){
        return userHonorDao.findUserHonor(form);
    }

    /**
     * @description: 添加数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 15:54
     * @param form
     * @return: boolean
     * @exception:
     */
    public boolean addUserHonor(UserHonorForm.Add form){
        return userHonorDao.addUserHonor(form) > 0;
    }

    /**
     * @description: 批量添加
     * @author: zhangsq
     * @date: Created in 2020-10-21 11:20
     * @param form
     * @return: boolean
     * @exception:
     */
    public boolean batchAddUserHonor(UserHonorForm.BatchAdd form){
        return userHonorDao.batchAddUserHonor(form).length>0;
    }

    /**
     * @description: 编辑数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 15:56
     * @param form
     * @return: boolean
     * @exception:
     */
    public boolean editUserHonor(UserHonorForm.Edit form){
        return userHonorDao.editUserHonor(form) > 0;
    }

    /**
     * @description: 删除数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 16:01
     * @param form
     * @return: boolean
     * @exception:
     */
    public boolean delUserHonor(UserHonorForm.Del form){
        return userHonorDao.delUserHonor(form) > 0;
    }

    public boolean delByUserHonor(UserHonorForm.Del form){
        return userHonorDao.delByUserHonor(form) > 0;
    }

    /**
     * @description: 批量删除数据
     * @author: zhangsq
     * @date: Created in 2020-10-21 11:06
     * @param form
     * @return: int
     * @exception:
     */
    public int batchDelUserHonor(UserHonorForm.BatchDel form){
        return userHonorDao.batchDelUserHonor(form);
    }

    public int batchDelUserHonor(List<Long> userIdList){
        return userHonorDao.batchDelUserListHonor(userIdList);
    }

}
