package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.shop.unifyworkbench.sdk.MessageReceiveuserSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.MessageReceiveuser;
import com.redare.shop.unifyworkbench.sdk.pojo.form.MessageReceiveuserForm;
import com.redare.shop.unifyworkbench.service.service.MessageReceiveuserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageReceiveuserSdkImpl implements MessageReceiveuserSdk {
    @Autowired
    MessageReceiveuserService messageReceiveuserService;
    @Override
    public CommonResult<MessageReceiveuser> getMessageReceiveuser(MessageReceiveuserForm.Get form) {
        return CommonResult.returnDataWrapper(messageReceiveuserService.getMessageReceiveuser(form));
    }

    @Override
    public CommonResult<Boolean> addReceiveUser(MessageReceiveuserForm.Add form) {
        Boolean result = false;
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        result = messageReceiveuserService.addMessageReceiveuser(form);
        return CommonResult.returnBoolWrapper(result,"添加消息接收人失败");
    }

    @Override
    public CommonResult<Boolean> updateReceiveUser(MessageReceiveuserForm.Edit form) {
        Boolean result = false;
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        result = messageReceiveuserService.editMessageReceiveuser(form);
        return CommonResult.returnBoolWrapper(result,"更新消息接收人失败");
    }

    @Override
    public CommonResult<Boolean> addOrUpdateReceiveUser(MessageReceiveuserForm.Add form) {
        Boolean result = false;
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        MessageReceiveuser messageReceiveuser = messageReceiveuserService.getMessageReceiveuser(new MessageReceiveuserForm.Get().setMsgId(form.getMsgId()).setUserId(form.getUserId()));
        if(messageReceiveuser!=null){
            MessageReceiveuserForm.Edit editForm = new MessageReceiveuserForm.Edit();
            BeanUtils.copyProperties(form,editForm);
            editForm.setId(messageReceiveuser.getId());
            result = messageReceiveuserService.editMessageReceiveuser(editForm);
        }else{
            result = messageReceiveuserService.addMessageReceiveuser(form);
        }
        return CommonResult.returnBoolWrapper(result,"操作失败");
    }

    @Override
    public CommonResult<Boolean> delMessageReceiveuser(MessageReceiveuserForm.Del form) {
        return CommonResult.returnBoolWrapper(messageReceiveuserService.delMessageReceiveuser(form),"删除失败");
    }
}
