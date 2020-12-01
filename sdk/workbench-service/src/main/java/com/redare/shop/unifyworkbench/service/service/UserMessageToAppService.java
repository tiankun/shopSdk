package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.webplatform.sdk.core.pojo.Account;
import com.redare.shop.unifyworkbench.sdk.pojo.UserMessageToApp;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserMessageToAppForm;
import com.redare.shop.unifyworkbench.service.dao.UserMessageToAppDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:UserMessageToAppService
 * @author: zlx
 * @date: Created in 2020/6/16 16:41
 * @version: 1.1
 */
@Service
public class UserMessageToAppService {

    @Autowired
    UserMessageToAppDao userMessageToAppDao;

    /**
     * @description 添加数据
     * @author zlx
     * @date 2020/6/16 16:43
     * @param form
     * @return java.lang.Boolean
     */
    public Boolean AddUserMessageToApp(UserMessageToAppForm.Add form){
        return userMessageToAppDao.addUserMessageToApp(form)>0;
    }

    /**
     * @description 根据角色集合查询有改角色的用户Id
     * @author zlx
     * @date 2020/6/16 17:45
     * @return java.util.List<java.lang.String>
     */
    public List<Account> findUserIdByRoleId(){
        return userMessageToAppDao.findUserIdByRoleId();
    }

    /**
     * @description 分页查询列表
     * @author zlx
     * @date 2020/6/17 15:12
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.UserMessageToApp>
     */
    public Page<UserMessageToApp> findUserMessageToAppPage(UserMessageToAppForm.Search form, int curPage, int pageSize){
        Page<UserMessageToApp> page = userMessageToAppDao.findUserMessageToAppPage(form,curPage,pageSize,true,false);
        return page;
    }

    /**
     * @description 分页查询列表数据
     * @author zlx
     * @date 2020/6/17 15:14
     * @param form
     * @param curPage
     * @param pageSize
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserMessageToApp>
     */
    public List<UserMessageToApp> findUserMessageToAppList(UserMessageToAppForm.Search form,int curPage,int pageSize){
        List<UserMessageToApp> list = userMessageToAppDao.findUserMessageToAppPage(form,curPage,pageSize,false,false).getResult();
        return list;
    }

    /**
     * @description 查询所有数据
     * @author zlx
     * @date 2020/6/17 15:15
     * @param form
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserMessageToApp>
     */
    public List<UserMessageToApp> findUserMessageToAppList(UserMessageToAppForm.Search form){
        List<UserMessageToApp> list = userMessageToAppDao.findUserMessageToAppPage(form,0,0,false,true).getResult();
        return list;
    }

    /**
     * @description 删除数据
     * @author zlx
     * @date 2020/6/17 15:17
     * @param form
     * @return java.lang.Boolean
     */
    public Boolean delUserMessageToApp(UserMessageToAppForm.Del form){
        return userMessageToAppDao.delUserMessageToApp(form)>0;
    }

    /**
     * @description: 添加推送报表
     * @author: zhangsq
     * @date: Created in 2020-08-07 11:48
     * @param form
     * @return: java.lang.Boolean
     * @exception:
     */
    public Boolean addUserMessageSendReport(UserMessageToAppForm.Add form){
        return userMessageToAppDao.addUserMessageSendReport(form)>0;
    }

    /**
     * @description: 推送报表分页查询列表
     * @author: zhangsq
     * @date: Created in 2020-08-07 11:38
     * @param form
     * @param curPage
     * @param pageSize
     * @return: com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.UserMessageToApp>
     * @exception:
     */
    public Page<UserMessageToApp> findUserMessageSendReportPage(UserMessageToAppForm.Search form,int curPage,int pageSize){
        Page<UserMessageToApp> page = userMessageToAppDao.findUserMessageSendReportPage(form,curPage,pageSize,true,false);
        return page;
    }

    /**
     * @description: 删除推送报表
     * @author: zhangsq
     * @date: Created in 2020-08-07 11:41
     * @param form
     * @return: java.lang.Boolean
     * @exception:
     */
    public Boolean delUserMessageSendReport(UserMessageToAppForm.Del form){
        return userMessageToAppDao.delUserMessageSendReport(form)>0;
    }
}
