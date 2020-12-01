package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.UserMessage;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserMessageForm;

import java.util.List;
import java.util.Map;

/**
 * UserMessageSdk
 *
 * @Author zlx
 * @Date 2020/5/13 15:46
 */
public interface UserMessageSdk {
    /**
     * 分页查询UserMessage表
     * @author zlx
     * @date 2020/5/13 15:48
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.UserMessage>>
     */
    CommonResult<Page<UserMessage>> findUserMessagePage(UserMessageForm.Search form, int curPage, int pageSize);

    /**
     * 分页查询UserMessage表数据
     * @author zlx
     * @date 2020/5/13 15:49
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserMessage>>
     */
    CommonResult<List<UserMessage>> findUserMessageList(UserMessageForm.Search form,int curPage,int pageSize);

    /**
     * 查询列表数据，不分页
     * @author zlx
     * @date 2020/5/13 15:50
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserMessage>>
     */
    CommonResult<List<UserMessage>> findUserMessageList(UserMessageForm.Search form);

    /**
     * 根据id查询数据
     * @author zlx
     * @date 2020/5/13 18:21
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.UserMessage>
     */
    CommonResult<UserMessage> getUserMessage(UserMessageForm.Get form);

    /**
     * 编辑数据
     * @author zlx
     * @date 2020/5/13 18:38
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    CommonResult<Boolean> editUserMessage(UserMessageForm.Edit form);

    /**
     * 删除消息数据
     * @author zlx
     * @date 2020/5/14 9:59
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    CommonResult<Boolean> deleteUserMessage(UserMessageForm.Delete form);

    /**
     * 修改阅读状态和阅读时间
     * @author zlx
     * @date 2020/5/14 16:22
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    CommonResult<Boolean> editReadedAndreadTime(UserMessageForm.Edit form);

    /**
     * 批量标记消息状态
     * @param form
     * @return
     */
    CommonResult<Boolean> batchUpdateMessageStatus(UserMessageForm.batchUpdateMessageStatus form);

    /**
     * 根据用户id和消息类型统计未读条数
     * @author zlx
     * @date 2020/5/15 15:26
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Integer>
     */
    CommonResult<Long> countItem(UserMessageForm.CountItem form);

    /**
     * 根据消息id删除数据
     * @author zlx
     * @date 2020/5/15 16:22
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    CommonResult<Boolean> deleteByMsgId(UserMessageForm.DeleteByMsgId form);

    /**
     * 根据消息id更新消息内容
     * @author zlx
     * @date 2020/5/15 16:57
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    CommonResult<Boolean> editContentByMsgId(UserMessageForm.EditContentByMsgId form);

    /**
     * 根据用户id和消息类型查询数据
     * @author zlx
     * @date 2020/6/3 16:56
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserMessage>>
     */
    CommonResult<List<UserMessage>> getUserMessageByUserId(UserMessageForm.GetByUserId form);

    /**
     * @description: 根据用户id和消息类型查询未读的消息
     * @author: zhangsq
     * @date: Created in 2020-07-14 15:20
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserMessage>>
     * @exception:
     */
    CommonResult<List<UserMessage>> getMessageNoticeByUserId(UserMessageForm.GetByUserId form);

    /**
     * 根据主键id更新阅读状态和阅读时间
     * @author zlx
     * @date 2020/6/4 15:08
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    CommonResult<Boolean> updateReadedAndReadTime(UserMessageForm.Get form);

    /**
     * 根据用户id查询所有消息条数以及未读条数
     * @author zlx
     * @date 2020/6/4 17:31
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.Map<java.lang.String,java.lang.Object>>
     */
    CommonResult<Map<String,Object>> findCountByUserId(UserMessageForm.GetByUserId form);

    /**
     * 添加消息
     * @param form
     * @return
     */
    CommonResult<Boolean>addUserMessage(UserMessageForm.Add form);
}
