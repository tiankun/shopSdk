package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.apppush.sdk.AppPushSdk;
import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.shop.unifyworkbench.sdk.UserMessageSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.UserMessage;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserMessageForm;
import com.redare.shop.unifyworkbench.service.service.UserMessageService;
import com.redare.shop.unifyworkbench.service.service.UserMessageToAppService;
import com.redare.shop.unifyworkbench.service.util.HtmlProcessUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * UserMessageSdkImpl
 *
 * @Author zlx
 * @Date 2020/5/13 16:29
 */
@Service
public class UserMessageSdkImpl implements UserMessageSdk {

    @Autowired
    UserMessageService userMessageService;

    @Autowired
    UserMessageToAppService userMessageToAppService;

    @Autowired
    AppPushSdk appPushSdk;

    /**
     * 分页查询UserMessage列表
     * @author zlx
     * @date 2020/5/13 16:31
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.UserMessage>>
     */
    @Override
    public CommonResult<Page<UserMessage>> findUserMessagePage(UserMessageForm.Search form, int curPage, int pageSize) {
        Page<UserMessage> page = userMessageService.findUserMessagePage(form, curPage, pageSize);
        List<UserMessage> list = page.getResult();
        for (UserMessage userMessage : list){
            if (StringUtils.isNotBlank(userMessage.getContent())){
                String content = StringEscapeUtils.unescapeHtml4(userMessage.getContent());
                userMessage.setContent(HtmlProcessUtil.getTextFromHtml(content));
            }
        }
        return CommonResult.returnSuccessWrapper(page);
    }

    /**
     * 分页查询UserMessage列表数据
     * @author zlx
     * @date 2020/5/13 16:33
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserMessage>>
     */
    @Override
    public CommonResult<List<UserMessage>> findUserMessageList(UserMessageForm.Search form, int curPage, int pageSize) {
        List<UserMessage> list = userMessageService.findUserMessageList(form, curPage, pageSize);
        for (UserMessage userMessage : list){
            if (StringUtils.isNotBlank(userMessage.getContent())){
                String content = StringEscapeUtils.unescapeHtml4(userMessage.getContent());
                userMessage.setContent(HtmlProcessUtil.getTextFromHtml(content));
            }
        }
        return CommonResult.returnDataWrapper(list);
    }

    /**
     * 查询UserMessage列表所有数据
     * @author zlx
     * @date 2020/5/13 16:33
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserMessage>>
     */
    @Override
    public CommonResult<List<UserMessage>> findUserMessageList(UserMessageForm.Search form) {
        List<UserMessage> list = userMessageService.findUserMessageList(form);
        for (UserMessage userMessage : list){
            if (StringUtils.isNotBlank(userMessage.getContent())){
                String content = StringEscapeUtils.unescapeHtml4(userMessage.getContent());
                userMessage.setContent(HtmlProcessUtil.getTextFromHtml(content));
            }
        }
        return CommonResult.returnDataWrapper(list);
    }


    /**
     * 根据id查询用户数据
     * @author zlx
     * @date 2020/5/13 18:30
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.UserMessage>
     */
    @Override
    public CommonResult<UserMessage> getUserMessage(UserMessageForm.Get form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        if (form.getType() == null || form.getType() != 1){
            userMessageService.updateReadedAndReadTime(form);
        }
        UserMessage userMessage = userMessageService.getUserMessage(form);
        if (userMessage != null){
            if (StringUtils.isNotBlank(userMessage.getContent())){
                String content = StringEscapeUtils.unescapeHtml4(userMessage.getContent());
                userMessage.setContent(content);
            }
        }
        return CommonResult.returnDataWrapper(userMessage);
    }

    /**
     * 编辑数据
     * @author zlx
     * @date 2020/5/13 18:46
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    @Override
    public CommonResult<Boolean> editUserMessage(UserMessageForm.Edit form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        if (form.getId() == null){
            return CommonResult.returnFailsWrapper("主键id不能为空");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        Boolean bool = userMessageService.editUserMessage(form);
        return CommonResult.returnBoolWrapper(bool,"编辑数据失败");
    }

    /**
     * 删除消息数据
     * @author zlx
     * @date 2020/5/14 10:08
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    @Override
    public CommonResult<Boolean> deleteUserMessage(UserMessageForm.Delete form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        Boolean bool = userMessageService.deleteUserMessage(form);
        return CommonResult.returnBoolWrapper(bool,"删除数据失败");
    }

    /**
     * 修改阅读状态和阅读时间
     * @author zlx
     * @date 2020/5/14 16:27
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    @Override
    public CommonResult<Boolean> editReadedAndreadTime(UserMessageForm.Edit form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        if (form.getId() == null){
            if (StringUtils.isBlank(form.getBizId()) || form.getUserId() == null || StringUtils.isBlank(form.getMsgType())){
                return CommonResult.returnFailsWrapper("业务ID和用户ID不能为空");
            }
            return CommonResult.returnFailsWrapper("主键id不能为空");
        }

        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        form.setReaded(1);
        form.setReadTime(new Date());
        Boolean bool = userMessageService.editUserMessage(form);
        return CommonResult.returnBoolWrapper(bool,"修改阅读状态和时间失败");
    }

    /**
     * 批量更新已读未读
     * @author zlx
     * @date 2020/5/15 15:11
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    @Override
    public CommonResult<Boolean> batchUpdateMessageStatus(UserMessageForm.batchUpdateMessageStatus form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        userMessageService.batchUpdateMessageStatus(form);
        return CommonResult.returnBoolWrapper(true,"批量更新失败");
    }

    /**
     * 根据用户id和消息分类统计未读条数
     * @author zlx
     * @date 2020/5/15 15:39
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Long>
     */
    @Override
    public CommonResult<Long> countItem(UserMessageForm.CountItem form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        Long count = userMessageService.countItem(form);
        return CommonResult.returnDataWrapper(count);
    }

    /**
     * 根据消息id删除数据
     * @author zlx
     * @date 2020/5/15 16:31
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    @Override
    public CommonResult<Boolean> deleteByMsgId(UserMessageForm.DeleteByMsgId form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        Boolean bool = userMessageService.deleteByMsgId(form);
        return CommonResult.returnBoolWrapper(bool,"删除数据失败");
    }

    /**
     * 根据消息id更新消息内容
     * @author zlx
     * @date 2020/5/15 17:03
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    @Override
    public CommonResult<Boolean> editContentByMsgId(UserMessageForm.EditContentByMsgId form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        Boolean bool = userMessageService.editContentByMsgId(form);
        return CommonResult.returnBoolWrapper(bool,"修改数据失败");
    }

    /**
     * 根据用户id查询数据
     * @author zlx
     * @date 2020/6/3 17:28
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserMessage>>
     */
    @Override
    public CommonResult<List<UserMessage>> getUserMessageByUserId(UserMessageForm.GetByUserId form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        List<UserMessage> list = userMessageService.getUserMessageByUserId(form);
        for(UserMessage userMessage : list){
            if (StringUtils.isNotBlank(userMessage.getContent())){
                String content = StringEscapeUtils.unescapeHtml4(userMessage.getContent());
                userMessage.setContent(HtmlProcessUtil.getTextFromHtml(content));
            }
            String[] strings = userMessage.getCreateTimeStr().split(" ");
            userMessage.setDateStr(strings[0]);
            userMessage.setTimeStr(strings[1]);
        }
        return CommonResult.returnSuccessWrapper(list);
    }

    /**
     * @description: 根据用户id和消息类型查询未读的消息
     * @author: zhangsq
     * @date: Created in 2020-07-14 15:21
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserMessage>>
     * @exception:
     */
    @Override
    public CommonResult<List<UserMessage>> getMessageNoticeByUserId(UserMessageForm.GetByUserId form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        List<UserMessage> list = userMessageService.getMessageNoticeByUserId(form);
        for(UserMessage userMessage : list){
            if (StringUtils.isNotBlank(userMessage.getContent())){
                String content = StringEscapeUtils.unescapeHtml4(userMessage.getContent());
                userMessage.setContent(HtmlProcessUtil.getTextFromHtml(content));
            }
            String[] strings = userMessage.getCreateTimeStr().split(" ");
            userMessage.setDateStr(strings[0]);
            userMessage.setTimeStr(strings[1]);
        }
        return CommonResult.returnSuccessWrapper(list);
    }

    /**
     * 根据主键id更新阅读时间和阅读状态
     * @author zlx
     * @date 2020/6/4 15:10
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    @Override
    public CommonResult<Boolean> updateReadedAndReadTime(UserMessageForm.Get form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        Boolean bool = userMessageService.updateReadedAndReadTime(form);
        return CommonResult.returnBoolWrapper(bool,"更新阅读状态失败！");
    }

    /**
     * 根据用户id统计所有消息数和未读条数
     * @author zlx
     * @date 2020/6/4 17:42
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.Map<java.lang.String,java.lang.Object>>
     */
    @Override
    public CommonResult<Map<String, Object>> findCountByUserId(UserMessageForm.GetByUserId form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        Map<String,Object> map = new HashMap<>();
        Long allCount = userMessageService.findAllCountByUserId(form);
        UserMessageForm.CountItem countItem = new UserMessageForm.CountItem();
        countItem.setUserId(form.getUserId());
        Long noRead = userMessageService.countItem(countItem);
        map.put("allCount",allCount);
        map.put("noRead",noRead);
        return CommonResult.returnSuccessWrapper(map);
    }

    @Override
    public CommonResult<Boolean> addUserMessage(UserMessageForm.Add form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        return CommonResult.returnSuccessWrapper(userMessageService.addUserMessage(form));
    }
}
