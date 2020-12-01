package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.shop.unifyworkbench.sdk.MessageSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.Message;
import com.redare.shop.unifyworkbench.sdk.pojo.MessageShow;
import com.redare.shop.unifyworkbench.sdk.pojo.form.MessageForm;
import com.redare.shop.unifyworkbench.service.service.MessageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageSdkImpl implements MessageSdk {
    @Autowired
    MessageService messageService;
    @Override
    public CommonResult<Page<MessageShow>> findMessagePage(MessageForm.Search form, int curPage, int pageSize) {
        return CommonResult.returnSuccessWrapper(messageService.findMessagePage(form,curPage,pageSize));
    }

    @Override
    public CommonResult<List<MessageShow>> findMessageList(MessageForm.Search form, int curPage, int pageSize) {
        return CommonResult.returnSuccessWrapper(messageService.findMessageList(form,curPage,pageSize));
    }

    @Override
    public CommonResult<List<MessageShow>> findMessageList(MessageForm.Search form) {
        return CommonResult.returnSuccessWrapper(messageService.findMessageList(form));
    }

    @Override
    public CommonResult<Boolean> addMessage(MessageForm.Add form) {
        Boolean result = false;
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        result = messageService.addMessage(form);
        return CommonResult.returnBoolWrapper(result,"添加消息失败");
    }

    @Override
    public CommonResult<Boolean> updateMessage(MessageForm.Edit form) {
        Boolean result = false;
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        result = messageService.editMessage(form);
        return CommonResult.returnBoolWrapper(result,"更新消息失败");
    }


    @Override
    public CommonResult<Boolean> addOrUpdateMessage(MessageForm.Add form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        Message message = messageService.getMessage(new MessageForm.Get().setMsgId(form.getMsgId()).setSysCode(form.getSysCode()));
        if(message!=null){
            MessageForm.Edit editForm = new MessageForm.Edit();
            BeanUtils.copyProperties(form,editForm);
            editForm.setId(message.getId());
            messageService.editMessage(editForm);
        }else{
            messageService.addMessage(form);
        }
        return CommonResult.returnSuccessWrapper();
    }

    @Override
    public CommonResult<Boolean> delMessage(MessageForm.Del form) {
        return CommonResult.returnBoolWrapper(messageService.delMessage(form),"删除消息失败");
    }
}
