package com.redare.shop.unifyworkbench.service.dao;

import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.Message;
import com.redare.shop.unifyworkbench.sdk.pojo.MessageShow;
import com.redare.shop.unifyworkbench.sdk.pojo.form.MessageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MessageDao {
    @Autowired
    SpringJdbcHelper jdbcHelper;

    /**
     * 分页查询消息
     * @param form
     * @param curPage
     * @param pageSize
     * @param calCount
     * @param allList
     * @return
     */
    public Page<MessageShow> findMessagePage(MessageForm.Search form,int curPage, int pageSize, boolean calCount, boolean allList){
        Sql sql = Sql.select()
                .field("t1.msgId")
                .field("t1.sysCode")
                .field("t3.`name`","sysName")
                .field("t1.typeName")
                .field("t1.title")
                .field("t1.createTime")
                .field("t1.createDepartmentName")
                .field("t1.createUserName")
                .field("t1.url")
                .field("t1.mobileUrl")
                .from("tb_message","t1")
                .join("tb_message_receiveuser","t2").on("t1.msgId","t2.msgId")
                .join("t_application","t3").on("t1.sysCode","t3.accessCode")
                .where()
                .andEqIfNotNull("t2.ztktUserId",form.getZtktUserId())
                .andBlikeJoinByOrIfNotBlank(form.getKey(),"t1.title","t1.des","t1.createDepartmentName","t1.createUserName","t3.name")
                .orderBy().desc("t1.createTime");
        return jdbcHelper.queryForPageBean(sql.getSql().toString(),MessageShow.class,sql.getParams().toArray(),curPage,pageSize,calCount,allList);
    }

    /**
     * 获取消息信息
     * @param form
     * @return
     */
    public Message getMessage(MessageForm.Get form){
        Sql sql = Sql.select()
                .from("tb_message")
                .where()
                .andEqIfNotNull("id",form.getId())
                .andEqIfNotBlank("msgId",form.getMsgId())
                .andEqIfNotBlank("sysCode",form.getSysCode());
        return jdbcHelper.queryForBean(sql.getSql().toString(),Message.class,sql.getParams().toArray());
    }

    /**
     * 添加消息
     * @param form
     * @return
     */
    public long addMessage(MessageForm.Add form){
        Sql sql = Sql.insert("tb_message")
                .field("msgId",form.getMsgId())
                .field("sysCode",form.getSysCode())
                .field("typeName",form.getTypeName())
                .field("title",form.getTitle())
                .field("des",form.getDes())
                .field("createTime",form.getCreateTime())
                .field("createDepartmentId",form.getCreateDepartmentId())
                .field("createDepartmentName",form.getCreateDepartmentName())
                .field("createUserId",form.getCreateUserId())
                .field("createUserAccount",form.getCreateUserAccount())
                .field("createUserName",form.getCreateUserName())
                .field("ztktUserId",form.getZtktUserId())
                .field("url",form.getUrl())
                .field("mobileUrl",form.getMobileUrl());
        return jdbcHelper.insertReturnFieldNumber(sql).intValue();
    }

    /**
     * 修改消息
     * @param form
     * @return
     */
    public int editMessage(MessageForm.Edit form){
        Sql sql = Sql.update("tb_message")
                .setIfNotNull("msgId",form.getMsgId())
                .setIfNotNull("sysCode",form.getSysCode())
                .setIfNotNull("typeName",form.getTypeName())
                .setIfNotNull("title",form.getTitle())
                .setIfNotNull("des",form.getDes())
                .setIfNotNull("createTime",form.getCreateTime())
                .setIfNotNull("createDepartmentId",form.getCreateDepartmentId())
                .setIfNotNull("createDepartmentName",form.getCreateDepartmentName())
                .setIfNotNull("createUserId",form.getCreateUserId())
                .setIfNotNull("createUserAccount",form.getCreateUserAccount())
                .setIfNotNull("createUserName",form.getCreateUserName())
                .setIfNotNull("ztktUserId",form.getZtktUserId())
                .setIfNotNull("url",form.getUrl())
                .setIfNotNull("mobileUrl",form.getMobileUrl());
        return jdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    /**
     * 删除消息
     * @param form
     * @return
     */
    public int delMessage(MessageForm.Del form){
        Sql sql = Sql.delete("tb_message")
                .where()
                .andEq("id",form.getId());
        return jdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }
}
