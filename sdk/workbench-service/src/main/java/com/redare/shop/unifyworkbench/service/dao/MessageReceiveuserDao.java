package com.redare.shop.unifyworkbench.service.dao;

import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.MessageReceiveuser;
import com.redare.shop.unifyworkbench.sdk.pojo.form.MessageReceiveuserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MessageReceiveuserDao {
    @Autowired
    SpringJdbcHelper jdbcHelper;

    /**
     * 获取消息接收人信息
     * @param form
     * @return
     */
    public MessageReceiveuser getMessageReceiveuser(MessageReceiveuserForm.Get form){
        Sql sql = Sql.select()
                .from("tb_message_receiveuser")
                .where()
                .andEqIfNotNull("id",form.getId())
                .andEqIfNotBlank("msgId",form.getMsgId())
                .andEqIfNotBlank("userId",form.getUserId());
        return jdbcHelper.queryForBean(sql.getSql().toString(),MessageReceiveuser.class,sql.getParams().toArray());
    }

    /**
     * 添加消息接收人信息
     * @param form
     * @return
     */
    public long addMessageReceiveuser(MessageReceiveuserForm.Add form){
        Sql sql = Sql.insert("tb_message_receiveuser")
                .field("msgId",form.getMsgId())
                .field("userId",form.getUserId())
                .field("account",form.getAccount())
                .field("name",form.getName())
                .field("ztktUserId",form.getZtktUserId())
                .field("departmentId",form.getDepartmentId())
                .field("departmentName",form.getDepartmentName())
                .field("readed",form.getReaded())
                .field("readTime",form.getReadTime());
        return jdbcHelper.insertReturnFieldNumber(sql).intValue();
    }

    /**
     * 修改消息接收人
     * @param form
     * @return
     */
    public int editMessageReceiveuser(MessageReceiveuserForm.Edit form){
        Sql sql = Sql.update("tb_message_receiveuser")
                .setIfNotNull("msgId",form.getMsgId())
                .setIfNotNull("userId",form.getUserId())
                .setIfNotNull("account",form.getAccount())
                .setIfNotNull("name",form.getName())
                .setIfNotNull("ztktUserId",form.getZtktUserId())
                .setIfNotNull("departmentId",form.getDepartmentId())
                .setIfNotNull("departmentName",form.getDepartmentName())
                .setIfNotNull("readed",form.getReaded())
                .setIfNotNull("readTime",form.getReadTime());
        return jdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    /**
     * 删除消息接收人
     * @param form
     * @return
     */
    public int delMessageReceiveuser(MessageReceiveuserForm.Del form){
        Sql sql = Sql.delete("tb_message_receiveuser")
                .where()
                .andEq("id",form.getId());
        return jdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }
}
