package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.LoginLog;
import com.redare.shop.unifyworkbench.sdk.pojo.form.LoginLogForm;
import com.redare.shop.unifyworkbench.service.dao.LoginLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/7/29 10:36
 * @version:
 */
@Service
public class LoginLogService {

    @Autowired
    LoginLogDao loginLogDao;

    /**
     * @description 分页查询
     * @author zlx
     * @date 2020/7/29 10:38
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.LoginLog>
     */
    public Page<LoginLog> findLoginLogPage(LoginLogForm.Search form, int curPage, int pageSize){
        return loginLogDao.findLoginLogPage(form,curPage,pageSize,true,false);
    }

    /**
     * @description 分页查询列表数据
     * @author zlx
     * @date 2020/7/29 10:40
     * @param form
     * @param curPage
     * @param pageSize
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.LoginLog>
     */
    public List<LoginLog> findLoginLogPageList(LoginLogForm.Search form,int curPage,int pageSize){
        return loginLogDao.findLoginLogPage(form,curPage,pageSize,false,false).getResult();
    }

    /**
     * @description 查询所有数据
     * @author zlx
     * @date 2020/7/29 10:41
     * @param form
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.LoginLog>
     */
    public List<LoginLog> findLoginLogList(LoginLogForm.Search form){
        return loginLogDao.findLoginLogPage(form,0,0,false,true).getResult();
    }

    /**
     * @description 添加数据
     * @author zlx
     * @date 2020/7/29 14:30
     * @param form
     * @return boolean
     */
    public boolean addLoginLog(LoginLogForm.Add form){
        return loginLogDao.addLoginLog(form)>0;
    }
}
