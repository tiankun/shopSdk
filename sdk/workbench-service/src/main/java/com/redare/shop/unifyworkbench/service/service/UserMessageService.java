package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.UserMessage;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserMessageForm;
import com.redare.shop.unifyworkbench.service.dao.UserMessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserMessageService
 *
 * @Author zlx
 * @Date 2020/5/13 16:21
 */
@Service
@EnableAsync
public class UserMessageService {

    @Autowired
    UserMessageDao userMessageDao;

    /**
     * 分页查询UserMessage列表
     * @author zlx
     * @date 2020/5/13 16:24
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.UserMessage>
     */
    public Page<UserMessage> findUserMessagePage(UserMessageForm.Search form, int curPage, int pageSize){
        Page<UserMessage> page = userMessageDao.findUserMessagePage(form,curPage,pageSize,true,false);
        return page;
    }

    /**
     * 分页查询UserMessage列表数据
     * @author zlx
     * @date 2020/5/13 16:26
     * @param form
     * @param curPage
     * @param pageSize
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserMessage>
     */
    public List<UserMessage> findUserMessageList(UserMessageForm.Search form,int curPage,int pageSize){
        List<UserMessage> list = userMessageDao.findUserMessagePage(form,curPage,pageSize,false,false).getResult();
        return list;
    }

    /**
     * 查询UserMessage的所有数据，不分页
     * @author zlx
     * @date 2020/5/13 16:28
     * @param form
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserMessage>
     */
    public List<UserMessage> findUserMessageList(UserMessageForm.Search form){
        List<UserMessage> list = userMessageDao.findUserMessagePage(form,0,0,false,true).getResult();
        return list;
    }

    /**
     * 新增UserMessage数据
     * @author zlx
     * @date 2020/5/13 17:40
     * @param form
     * @return java.lang.Boolean
     */
    public Boolean addUserMessage(UserMessageForm.Add form){
        return userMessageDao.addUserMessage(form)>0;
    }

    /**
     * 根据id查询数据
     * @author zlx
     * @date 2020/5/13 18:27
     * @param form
     * @return com.redare.shop.unifyworkbench.sdk.pojo.UserMessage
     */
    public UserMessage getUserMessage(UserMessageForm.Get form){
        return userMessageDao.getUserMessage(form);
    }

    /**
     * 修改数据
     * @author zlx
     * @date 2020/5/13 18:44
     * @param form
     * @return java.lang.Boolean
     */
    public Boolean editUserMessage(UserMessageForm.Edit form){
        return userMessageDao.editUserMessage(form)>0;
    }

    /**
     * 删除消息数据
     * @author zlx
     * @date 2020/5/14 10:05
     * @param form
     * @return java.lang.Boolean
     */
    public Boolean deleteUserMessage(UserMessageForm.Delete form){
        return userMessageDao.deleteUserMessage(form)>0;
    }

    /**
     * 批量更新已读未读
     * @author zlx
     * @date 2020/5/15 15:00
     * @param form
     * @return java.lang.Boolean
     */
    public Boolean batchUpdateMessageStatus(UserMessageForm.batchUpdateMessageStatus form){
        return userMessageDao.batchUpdateMessageStatus(form)>0;
    }

    /**
     * 根据用户id和消息分类统计未读条数
     * @author zlx
     * @date 2020/5/15 15:37
     * @param form
     * @return java.lang.Long
     */
    public Long countItem(UserMessageForm.CountItem form){
        return userMessageDao.CountItem(form);
    }

    /**
     * 根据消息id删除数据
     * @author zlx
     * @date 2020/5/15 16:28
     * @param form
     * @return java.lang.Boolean
     */
    public Boolean deleteByMsgId(UserMessageForm.DeleteByMsgId form){
        return userMessageDao.deleteByMsgId(form)>0;
    }

    /**
     * 根据消息id更新消息内容
     * @author zlx
     * @date 2020/5/15 17:01
     * @param form
     * @return java.lang.Boolean
     */
    public Boolean editContentByMsgId(UserMessageForm.EditContentByMsgId form){
        return userMessageDao.editContentByMsgId(form)>0;
    }

    /**
     * 根据用户id查询数据
     * @author zlx
     * @date 2020/6/3 17:02
     * @param form
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserMessage>
     */
    public List<UserMessage> getUserMessageByUserId(UserMessageForm.GetByUserId form){
        return userMessageDao.getUserMessageByUserId(form);
    }

    /**
     * @description: 根据用户id和消息类型查询未读的消息
     * @author: zhangsq
     * @date: Created in 2020-07-14 15:21
     * @param form
     * @return: java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserMessage>
     * @exception:
     */
    public List<UserMessage> getMessageNoticeByUserId(UserMessageForm.GetByUserId form){
        return userMessageDao.getMessageNoticeByUserId(form);
    }

    /**
     * 根据主键id更新阅读状态和阅读时间
     * @author zlx
     * @date 2020/6/4 15:09
     * @param form
     * @return java.lang.Boolean
     */
    public Boolean updateReadedAndReadTime(UserMessageForm.Get form){
        return userMessageDao.updateReaded(form)>0;
    }

    /**
     * 根据用户id统计所有消息条数
     * @author zlx
     * @date 2020/6/4 17:37
     * @param form
     * @return java.lang.Long
     */
    public Long findAllCountByUserId(UserMessageForm.GetByUserId form){
        return userMessageDao.findAllCountByUserId(form);
    }

    /**
     * @description 批量添加
     * @author zlx
     * @date 2020/7/29 18:36
     * @param list
     * @return int[]
     */
    @Async
    public int[] batchAddUserMessage(List<UserMessageForm.Add> list){
        return userMessageDao.batchAddUserMessage(list);
    }
}
