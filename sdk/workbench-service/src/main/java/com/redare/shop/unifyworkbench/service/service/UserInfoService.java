package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.UserInfo;
import com.redare.shop.unifyworkbench.service.dao.UserInfoDao;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserInfoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;

    public Page<UserInfo> findUserInfoPage(UserInfoForm.Search form, int curPage, int pageSize){
        return userInfoDao.findUserInfoPage(form,curPage,pageSize,true,false);
    }

    public List<UserInfo> findUserInfoList(UserInfoForm.Search form,int curPage,int pageSize){
        return userInfoDao.findUserInfoPage(form,curPage,pageSize,false,false).getResult();
    }

    public List<UserInfo> findUserInfoList(UserInfoForm.Search form){
        return userInfoDao.findUserInfoPage(form,0,0,false,true).getResult();
    }

    public UserInfo getUserInfoByUserId(UserInfoForm.Get form){
        return userInfoDao.getUserInfoByUserId(form);
    }

    public Boolean addUserInfo(UserInfoForm.Add form){
        return userInfoDao.addUserInfo(form)>0;
    }

    public Boolean editUserInfo(UserInfoForm.Edit form){
        return userInfoDao.editUserInfo(form)>0;
    }

    public Boolean truncateTable(){
        return userInfoDao.truncateTable()>-1;
    }

    public UserInfo getUserInfoByLoginUserId(UserInfoForm.Get form){
        return userInfoDao.getUserInfoByLoginUserId(form);
    }


    /**
     * @description: 通讯录中根据组织机构id或ParentId查询机构下的用户信息
     * @author: zhangsq
     * @date: Created in 2020-08-24 11:13
     * @param form
     * @param curPage
     * @param pageSize
     * @return: com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.UserInfo>
     * @exception:
     */
    public Page<UserInfo> findContactsBookUserListByOgrId(UserInfo form , int curPage, int pageSize){
        return userInfoDao.findContactsBookUserListByOgrId(form, curPage, pageSize, true, false);
    }
}
