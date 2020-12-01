package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.Message;
import com.redare.shop.unifyworkbench.sdk.pojo.MessageShow;
import com.redare.shop.unifyworkbench.service.dao.MessageDao;
import com.redare.shop.unifyworkbench.sdk.pojo.form.MessageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageDao messageDao;

    /**
     * 分页查询消息信息
     * @param form
     * @param curPage
     * @param pageSize
     * @return
     */
    public Page<MessageShow> findMessagePage(MessageForm.Search form, int curPage, int pageSize){
        return messageDao.findMessagePage(form,curPage,pageSize,true,false);
    }

    public List<MessageShow> findMessageList(MessageForm.Search form,int curPage,int pageSize){
        return messageDao.findMessagePage(form,curPage,pageSize,false,false).getResult();
    }

    public List<MessageShow> findMessageList(MessageForm.Search form){
        return messageDao.findMessagePage(form,0,0,false,true).getResult();
    }

    /**
     * 获取消息信息
     * @param form
     * @return
     */
    public Message getMessage(MessageForm.Get form){
        return messageDao.getMessage(form);
    }

    /**
     * 添加消息
     * @param form
     * @return
     */
    public Boolean addMessage(MessageForm.Add form){
        return messageDao.addMessage(form)>0;
    }

    /**
     * 修改消息
     * @param form
     * @return
     */
    public Boolean editMessage(MessageForm.Edit form){
        return messageDao.editMessage(form)>0;
    }

    /**
     * 删除消息
     * @param form
     * @return
     */
    public Boolean delMessage(MessageForm.Del form){
        return messageDao.delMessage(form)>0;
    }
}
