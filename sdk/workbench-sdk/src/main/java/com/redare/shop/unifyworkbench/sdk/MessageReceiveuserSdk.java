package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.shop.unifyworkbench.sdk.pojo.MessageReceiveuser;
import com.redare.shop.unifyworkbench.sdk.pojo.form.MessageReceiveuserForm;

public interface MessageReceiveuserSdk {
    /**
     * 获取消息接收人信息
     * @param form
     * @return
     */
    CommonResult<MessageReceiveuser> getMessageReceiveuser(MessageReceiveuserForm.Get form);

    /**
     * 添加接收人消息
     * @param form
     * @return
     */
    CommonResult<Boolean> addReceiveUser(MessageReceiveuserForm.Add form);

    /**
     * 更新接收人消息
     * @param form
     * @return
     */
    CommonResult<Boolean> updateReceiveUser(MessageReceiveuserForm.Edit form);
    /**
     * 添加或修改待阅消息接收人
     * @param form
     * @return
     */
    CommonResult<Boolean> addOrUpdateReceiveUser(MessageReceiveuserForm.Add form);

    /**
     * 删除消息接收人信息
     * @param form
     * @return
     */
    CommonResult<Boolean> delMessageReceiveuser(MessageReceiveuserForm.Del form);
}
