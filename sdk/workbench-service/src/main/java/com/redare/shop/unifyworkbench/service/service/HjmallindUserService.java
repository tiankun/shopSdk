package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.HjmallindUser;
import com.redare.shop.unifyworkbench.sdk.pojo.form.HjmallindUserForm;
import com.redare.shop.unifyworkbench.service.dao.HjmallindUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户 impl
 *
 * @date 2020-12-01 15:53:13
 * Created by tiankun
 */
@Service
public class HjmallindUserService {

    @Autowired
    HjmallindUserDao hjmallindUserDao;


    public boolean addHjmallindUser(HjmallindUserForm.Add form) {
        long id = hjmallindUserDao.addHjmallindUser(form);
        return id > 0;
    }

    public boolean editHjmallindUser(HjmallindUserForm.Edit form) {
        return hjmallindUserDao.editHjmallindUser(form) > 0;
    }

    public boolean deleteHjmallindUser(HjmallindUserForm.Del form) {
        return hjmallindUserDao.deleteHjmallindUser(form) > 0;
    }

    public List<HjmallindUser> findHjmallindUserList(HjmallindUserForm.Search form) {
        return hjmallindUserDao.findHjmallindUserPage(form, 1, 20, false, true).getResult();
    }

    public List<HjmallindUser> findHjmallindUserList(HjmallindUserForm.Search form, int curPage, int pageSize) {
        return hjmallindUserDao.findHjmallindUserPage(form, curPage, pageSize, false, false).getResult();
    }

    public Page<HjmallindUser> findHjmallindUserPage(HjmallindUserForm.Search form, int curPage, int pageSize) {
        return hjmallindUserDao.findHjmallindUserPage(form, curPage, pageSize, true, false);
    }

    public HjmallindUser getHjmallindUser(HjmallindUserForm.Get form) {
        return hjmallindUserDao.getHjmallindUser(form);

    }


}

