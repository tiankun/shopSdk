package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.UserMessageToApp;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserMessageToAppForm;

import java.util.List;

/**
 * @description:UserMessageToAppSdk
 * @author: zlx
 * @date: Created in 2020/6/16 16:31
 * @version: 1.1
 */
public interface UserMessageToAppSdk {

    /**
     * @description 添加数据至消息推送至APP
     * @author zlx
     * @date 2020/6/16 16:32
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    CommonResult<Boolean> addUserMessageToApp(UserMessageToAppForm.Add form);

    /**
     * @description 分页查询列表
     * @author zlx
     * @date 2020/6/17 14:25
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.UserMessageToApp>>
     */
    CommonResult<Page<UserMessageToApp>> findUserMessageToAppPage(UserMessageToAppForm.Search form, int curPage, int pageSize);

    /**
     * @description 分页查询列表数据
     * @author zlx
     * @date 2020/6/17 14:26
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserMessageToApp>>
     */
    CommonResult<List<UserMessageToApp>> findUserMessageToAppList(UserMessageToAppForm.Search form ,int curPage,int pageSize);

    /**
     * @description 查询所有数据
     * @author zlx
     * @date 2020/6/17 14:27
     * @param from
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserMessageToApp>>
     */
    CommonResult<List<UserMessageToApp>> findUserMessageToAppList(UserMessageToAppForm.Search from);

    /**
     * @description 删除数据
     * @author zlx
     * @date 2020/6/17 14:35
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    CommonResult<Boolean> deleteUserMessageToApp(UserMessageToAppForm.Del form);


    /**
     * @description: 添加推送报表
     * @author: zhangsq
     * @date: Created in 2020-08-07 11:45
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    CommonResult<Boolean> addUserMessageSendReport(UserMessageToAppForm.Add form);

    /**
     * @description 推送报表分页查询列表
     * @author zlx
     * @date 2020/6/17 14:25
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.UserMessageToApp>>
     */
    CommonResult<Page<UserMessageToApp>> findUserMessageSendReportPage(UserMessageToAppForm.Search form,int curPage,int pageSize);

    /**
     * @description: 删除推送报表
     * @author: zhangsq
     * @date: Created in 2020-08-07 11:40
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    CommonResult<Boolean> delUserMessageSendReport(UserMessageToAppForm.Del form);
}
