package com.redare.shop.unifyworkbench.service.service;

import com.redare.shop.unifyworkbench.sdk.pojo.MessageReceiveuser;
import com.redare.shop.unifyworkbench.service.dao.MessageReceiveuserDao;
import com.redare.shop.unifyworkbench.sdk.pojo.form.MessageReceiveuserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageReceiveuserService {
    @Autowired
    MessageReceiveuserDao messageReceiveuserDao;

    public MessageReceiveuser getMessageReceiveuser(MessageReceiveuserForm.Get form){
        return messageReceiveuserDao.getMessageReceiveuser(form);
    }

    public Boolean addMessageReceiveuser(MessageReceiveuserForm.Add form){
        return messageReceiveuserDao.addMessageReceiveuser(form)>0;
    }

    public Boolean editMessageReceiveuser(MessageReceiveuserForm.Edit form){
        return messageReceiveuserDao.editMessageReceiveuser(form)>0;
    }

    public Boolean delMessageReceiveuser(MessageReceiveuserForm.Del form){
        return messageReceiveuserDao.delMessageReceiveuser(form)>0;
    }
}