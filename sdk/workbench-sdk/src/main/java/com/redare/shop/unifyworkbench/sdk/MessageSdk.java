package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.MessageShow;
import com.redare.shop.unifyworkbench.sdk.pojo.form.MessageForm;

import java.util.List;

public interface MessageSdk {
    /**
     * 分页查询
     * @param form
     * @return
     */
    CommonResult<Page<MessageShow>> findMessagePage(MessageForm.Search form, int curPage, int pageSize);

    /**
     * 分页查询
     * @param form
     * @return
     */
    CommonResult<List<MessageShow>> findMessageList(MessageForm.Search form,int curPage,int pageSize);

    /**
     * 查询列表
     * @param form
     * @return
     */
    CommonResult<List<MessageShow>> findMessageList(MessageForm.Search form);

    /**
     * 添加消息
     * @param form
     * @return
     */
    CommonResult<Boolean> addMessage(MessageForm.Add form);

    /**
     * 更新消息
     * @param form
     * @return
     */
    CommonResult<Boolean> updateMessage(MessageForm.Edit form);

    /**
     * 添加或修改待阅消息
     * @param form
     * @return
     */
    CommonResult<Boolean> addOrUpdateMessage(MessageForm.Add form);

    /**
     * 删除消息
     * @param form
     * @return
     */
    CommonResult<Boolean> delMessage(MessageForm.Del form);
}
