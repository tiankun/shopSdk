package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.UserInfo;
import com.redare.shop.unifyworkbench.sdk.pojo.UserInfoLinkman;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserInfoLinkmanForm;
import com.redare.shop.unifyworkbench.service.dao.UserInfoLinkmanDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * ：UserInfoLinkmanService
 *
 * @author yj
 * @email yangj@redare.cn
 * @date 2020-08-25
 */
@Service
public class UserInfoLinkmanService {
    @Autowired
    UserInfoLinkmanDao userInfoLinkmanDao;
    public Page<UserInfo> findUserInfoLinkmanPage(UserInfoLinkmanForm.Search form, int curPage, int pageSize){
        return userInfoLinkmanDao.findUserInfoLinkmanPage(form, curPage, pageSize, true, false);
    }
    public List<UserInfo> findUserInfoLinkmanList(UserInfoLinkmanForm.Search form, int curPage, int pageSize){
        return  userInfoLinkmanDao.findUserInfoLinkmanPage(form, curPage, pageSize, false, false).getResult();
    }
    public List<UserInfo> findUserInfoLinkmanList(UserInfoLinkmanForm.Search form){
        return  userInfoLinkmanDao.findUserInfoLinkmanPage(form, 0, 0, false, true).getResult();
    }
    public UserInfoLinkman getUserInfoLinkman(UserInfoLinkmanForm.Get form){
        return userInfoLinkmanDao.getUserInfoLinkman(form);
    }
    public Boolean addUserInfoLinkman(UserInfoLinkmanForm.Add form){
        return userInfoLinkmanDao.addUserInfoLinkman(form);
    }
    public Boolean editUserInfoLinkman(UserInfoLinkmanForm.Edit form){
        return userInfoLinkmanDao.editUserInfoLinkman(form);
    }
    public Boolean deleteUserInfoLinkman(UserInfoLinkmanForm.Del form){
        return userInfoLinkmanDao.deleteUserInfoLinkman(form);
    }
}
