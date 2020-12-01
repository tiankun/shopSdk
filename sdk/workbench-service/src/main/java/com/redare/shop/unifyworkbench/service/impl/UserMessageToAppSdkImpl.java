package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.apppush.sdk.AppPushSdk;
import com.redare.devframework.apppush.sdk.pojo.arg.PushArg;
import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.devframework.webplatform.sdk.core.pojo.Account;
import com.redare.shop.unifyworkbench.sdk.UserMessageToAppSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.User;
import com.redare.shop.unifyworkbench.sdk.pojo.UserMessageToApp;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserMessageForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserMessageToAppForm;
import com.redare.shop.unifyworkbench.service.service.UserMessageService;
import com.redare.shop.unifyworkbench.service.service.UserMessageToAppService;
import com.redare.shop.unifyworkbench.service.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:UserMessageToAppSdkImpl
 * @author: zlx
 * @date: Created in 2020/6/16 16:43
 * @version: 1.1
 */
@Service
@PropertySource("classpath:config.properties")
public class UserMessageToAppSdkImpl implements UserMessageToAppSdk {

    @Autowired
    UserMessageToAppService userMessageToAppService;

    @Autowired
    UserMessageService userMessageService;

    @Autowired
    AppPushSdk appPushSdk;

    @Autowired
    UserService userService;



    @Value("${report.h5app.server.url}")
    private String reportH5appServerUrl;

    /**
     * @description 添加数据
     * @author zlx
     * @date 2020/6/16 16:47
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    @Override
    @Transactional
    public CommonResult<Boolean> addUserMessageToApp(UserMessageToAppForm.Add form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        if (form.getMsgScopeList()!= null && form.getMsgScopeList().size() == 2){
            //同时推送到消息和app提醒
            List<Long> userIdList = getAllUserIdList();
            List<UserMessageForm.Add> addList = getUserMessageFormAdd(form,userIdList);
            userMessageService.batchAddUserMessage(addList);
            form.setRoleIds(StringUtils.join(form.getRoleIdList(),","));
            form.setMsgScope(StringUtils.join(form.getMsgScopeList(),","));
            userMessageToAppService.AddUserMessageToApp(form);
            PushArg pushArg = getPushArg(form,userIdList);
            appPushSdk.pushNotice(pushArg);
        }else if (form.getMsgScopeList()!= null && form.getMsgScopeList().size() == 1 && "1".equals(form.getMsgScopeList().get(0))){
            //推送到消息
            List<Long> userIdList = getAllUserIdList();
            List<UserMessageForm.Add> addList = getUserMessageFormAdd(form,userIdList);
            userMessageService.batchAddUserMessage(addList);
            form.setRoleIds(StringUtils.join(form.getRoleIdList(),","));
            form.setMsgScope(StringUtils.join(form.getMsgScopeList(),","));
            userMessageToAppService.AddUserMessageToApp(form);
        }else if (form.getMsgScopeList()!= null && form.getMsgScopeList().size() == 1 && "2".equals(form.getMsgScopeList().get(0))){
            //推送到app提醒
            form.setRoleIds(StringUtils.join(form.getRoleIdList(),","));
            form.setMsgScope(StringUtils.join(form.getMsgScopeList(),","));
            userMessageToAppService.AddUserMessageToApp(form);
            List<Long> userIdList = getAllUserIdList();
            PushArg pushArg = getPushArg(form,userIdList);
            appPushSdk.pushNotice(pushArg);
        }
        return CommonResult.returnBoolWrapper(true,"新增数据失败");
    }

    private PushArg getPushArg(UserMessageToAppForm.Add form,List<Long> userIdList){
        PushArg pushArg = new PushArg();
        pushArg.setTitle(form.getTitle());
        pushArg.setBody(form.getContent());
        PushArg.Target target = new PushArg.Target();
        target.setTarget("ACCOUNT");
        target.setDeviceType("ALL");
        target.setTargetValuesAnd(false);
        List<String> result = new ArrayList<>();
        for (Long userid :userIdList){
            result.add("online_"+userid);
        }
        target.setTargetValues(result);
        pushArg.setTarget(target);
        Map<String,Object> map = new HashMap<>();
        map.put("type",form.getMsgType());
        if ("sys".equals(form.getMsgType())){
            map.put("typeName","系统消息");
        }else if ("notice".equals(form.getMsgType())){
            map.put("typeName","通知公告");
        }else if ("report".equals(form.getMsgType())){
            map.put("typeName","报表消息");
        }else {
            map.put("typeName","新闻公告");
        }
        pushArg.setExtParams(map);
        pushArg.setSysCode("shop");
        pushArg.setSync(true);
        PushArg.Android android=new PushArg.Android()
                .setOpenType("APPLICATION")
                .setOpenValue(null)
                .setNotificationChannel("1")
                .setPopupActivity("com.redare.devframework.rn.aliyun.apppush.activity.PushPopupActivity")
                .setMessageToPopupActivity(false)
                .setPopupTitle(null)
                .setPopupBody(null)
                .setExtParams(null);
        pushArg.setAndroid(android);
        PushArg.Ios ios=new PushArg.Ios()
                .setBadge(null)
                .setProduct(false)
                .setSilentNotification(false)
                .setMusic(null)
                .setSubtitle(null)
                .setNotificationCategory(null)
                .setMutableContent(false)
                .setExtParams(null)
                .setMessageToNotice(false)
                .setMessageToNoticeBody(null);
        pushArg.setIos(ios);
        return pushArg;
    }

    private List<Long> getAllUserIdList (){
        //查询所有用户
        List<Long> users = new ArrayList<>();
        List<User> list = userService.findUserAll(new UserForm.Search());
        if (list != null && list.size() >0){
            for (User user : list){
                users.add(user.getUserId());
            }
        }
        return users;
    }

    private List<Long> getUserIdList (UserMessageToAppForm.Add form){
        List<Long> users = new ArrayList<>();
        if (form.getRoleIdList() != null && form.getRoleIdList().size() >0){
            List<Account> list = userMessageToAppService.findUserIdByRoleId();
            if (list != null && list.size() >0){
                for (Account account : list){
                    if (account.getRoleIds() != null && !"".equals(account.getRoleIds())){
                        List<String> roles = Arrays.stream(account.getRoleIds().split(","))
                                .collect(Collectors.toList());
                        roles.retainAll(form.getRoleIdList());
                        if (roles.size()>0){
                            users.add(account.getId());
                        }
                    }
                }
            }
        }
        return users;
    }

    private List<UserMessageForm.Add> getUserMessageFormAdd(UserMessageToAppForm.Add form,List<Long> list){
        List<UserMessageForm.Add> userAddList = new ArrayList<>();
        for (Long userId : list){
            UserMessageForm.Add add = new UserMessageForm.Add();
            add.setMsgType(form.getMsgType());
            add.setTitle(form.getTitle());
            add.setContent(form.getContent());
            add.setUrl(form.getUrl());
            add.setUserId(userId);
            add.setReaded(0);
            add.setCreateTime(new Date());
            add.setUpdateTime(new Date());
            userAddList.add(add);
        }
        return userAddList;
    }

    /**
     * @description 分页查询列表
     * @author zlx
     * @date 2020/6/17 15:18
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.UserMessageToApp>>
     */
    @Override
    public CommonResult<Page<UserMessageToApp>> findUserMessageToAppPage(UserMessageToAppForm.Search form, int curPage, int pageSize) {
        Page<UserMessageToApp> page = userMessageToAppService.findUserMessageToAppPage(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(page);
    }

    /**
     * @description 分页查询列表数据
     * @author zlx
     * @date 2020/6/17 15:19
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserMessageToApp>>
     */
    @Override
    public CommonResult<List<UserMessageToApp>> findUserMessageToAppList(UserMessageToAppForm.Search form, int curPage, int pageSize) {
        List<UserMessageToApp> list = userMessageToAppService.findUserMessageToAppList(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(list);
    }

    /**
     * @description 查询所有数据
     * @author zlx
     * @date 2020/6/17 15:20
     * @param from
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserMessageToApp>>
     */
    @Override
    public CommonResult<List<UserMessageToApp>> findUserMessageToAppList(UserMessageToAppForm.Search from) {
        List<UserMessageToApp> list = userMessageToAppService.findUserMessageToAppList(from);
        return CommonResult.returnSuccessWrapper(list);
    }

    /**
     * @description 删除数据
     * @author zlx
     * @date 2020/6/17 15:21
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    @Override
    public CommonResult<Boolean> deleteUserMessageToApp(UserMessageToAppForm.Del form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        Boolean bool = userMessageToAppService.delUserMessageToApp(form);
        return CommonResult.returnBoolWrapper(bool,"删除失败");
    }





    /**
     * @description: 添加推送报表
     * @author: zhangsq
     * @date: Created in 2020-08-07 11:46
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    @Override
    public CommonResult<Boolean> addUserMessageSendReport(UserMessageToAppForm.Add form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }

        List<String> list = new ArrayList<>();
        for (String str : form.getBudgetReport()) {
            list.add(str.concat(form.getJd()));
        }

        for (String str : form.getManageReport()) {
            list.add(str.concat(form.getEndDate()));
        }
        form.setMsgType("report");
        form.setSendReport(StringUtils.join(list,'，'));

        form.setUrl(reportH5appServerUrl.concat("?endDate=").concat(form.getEndDate()).concat("&jd=").concat(form.getJd()));
        if (form.getMsgScopeList()!= null && form.getMsgScopeList().size() == 2){
            if (form.getMsgReceiveType() != null && form.getMsgReceiveType() == 1){
                List<Long> userIdList = getUserIdList(form);
                List<UserMessageForm.Add> addList = getUserMessageFormAdd(form,userIdList);
//                for (UserMessageForm.Add add : addList){
//                    userMessageService.addUserMessage(add);
//                }
                userMessageService.batchAddUserMessage(addList);
                form.setRoleIds(StringUtils.join(form.getRoleIdList(),","));
                form.setMsgScope(StringUtils.join(form.getMsgScopeList(),","));
                userMessageToAppService.addUserMessageSendReport(form);
                PushArg pushArg = getPushArg(form,userIdList);
                appPushSdk.pushNotice(pushArg);
            }else if (form.getMsgReceiveType() != null && form.getMsgReceiveType() == 2){
                List<Long> ids = form.getUserIdList().stream().map(Long::parseLong).collect(Collectors.toList());
                List<UserMessageForm.Add> addList = getUserMessageFormAdd(form,ids);
//                for (UserMessageForm.Add add : addList){
//                    userMessageService.addUserMessage(add);
//                }
                userMessageService.batchAddUserMessage(addList);
                form.setUserIds(StringUtils.join(form.getUserIdList(),","));
                form.setMsgScope(StringUtils.join(form.getMsgScopeList(),","));
                userMessageToAppService.addUserMessageSendReport(form);
                PushArg pushArg = getPushArg(form,ids);
                appPushSdk.pushNotice(pushArg);
            }
        }else if (form.getMsgScopeList()!= null && form.getMsgScopeList().size() == 1 && "1".equals(form.getMsgScopeList().get(0))){
            if (form.getMsgReceiveType() != null && form.getMsgReceiveType() == 1){
                List<Long> userIdList = getUserIdList(form);
                List<UserMessageForm.Add> addList = getUserMessageFormAdd(form,userIdList);
//                for (UserMessageForm.Add add : addList){
//                    userMessageService.addUserMessage(add);
//                }
                userMessageService.batchAddUserMessage(addList);
                form.setRoleIds(StringUtils.join(form.getRoleIdList(),","));
                form.setMsgScope(StringUtils.join(form.getMsgScopeList(),","));
                userMessageToAppService.addUserMessageSendReport(form);
            }else if (form.getMsgReceiveType() != null && form.getMsgReceiveType() == 2){
                List<Long> ids = form.getUserIdList().stream().map(Long::parseLong).collect(Collectors.toList());
                List<UserMessageForm.Add> addList = getUserMessageFormAdd(form,ids);
//                for (UserMessageForm.Add add : addList){
//                    userMessageService.addUserMessage(add);
//                }
                userMessageService.batchAddUserMessage(addList);
                form.setUserIds(StringUtils.join(form.getUserIdList(),","));
                form.setMsgScope(StringUtils.join(form.getMsgScopeList(),","));
                userMessageToAppService.addUserMessageSendReport(form);
            }
        }else if (form.getMsgScopeList()!= null && form.getMsgScopeList().size() == 1 && "2".equals(form.getMsgScopeList().get(0))){
            if (form.getMsgReceiveType() != null && form.getMsgReceiveType() == 1){
                form.setRoleIds(StringUtils.join(form.getRoleIdList(),","));
                form.setMsgScope(StringUtils.join(form.getMsgScopeList(),","));
                userMessageToAppService.addUserMessageSendReport(form);
                List<Long> userIdList = getUserIdList(form);
                PushArg pushArg = getPushArg(form,userIdList);
                appPushSdk.pushNotice(pushArg);
            }else if (form.getMsgReceiveType() != null && form.getMsgReceiveType() == 2){
                form.setUserIds(StringUtils.join(form.getUserIdList(),","));
                form.setMsgScope(StringUtils.join(form.getMsgScopeList(),","));
                userMessageToAppService.addUserMessageSendReport(form);
                List<Long> ids = form.getUserIdList().stream().map(Long::parseLong).collect(Collectors.toList());
                PushArg pushArg = getPushArg(form,ids);
                appPushSdk.pushNotice(pushArg);
            }
        }
        return CommonResult.returnBoolWrapper(true,"新增数据失败");
    }

    /**
     * @description: 推送报表分页查询列表
     * @author: zhangsq
     * @date: Created in 2020-08-07 11:38
     * @param form
     * @param curPage
     * @param pageSize
     * @return: com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.UserMessageToApp>>
     * @exception:
     */
    @Override
    public CommonResult<Page<UserMessageToApp>> findUserMessageSendReportPage(UserMessageToAppForm.Search form, int curPage, int pageSize) {
        Page<UserMessageToApp> page = userMessageToAppService.findUserMessageSendReportPage(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(page);
    }

    /**
     * @description: 删除推送报表
     * @author: zhangsq
     * @date: Created in 2020-08-07 11:40
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    @Override
    public CommonResult<Boolean> delUserMessageSendReport(UserMessageToAppForm.Del form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        Boolean bool = userMessageToAppService.delUserMessageSendReport(form);
        return CommonResult.returnBoolWrapper(bool,"删除失败");
    }
}
