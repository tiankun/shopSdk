package com.redare.shop.unifyworkbench.service.dao;

import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.UserMessage;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserMessageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * UserMessageDao
 *
 * @Author zlx
 * @Date 2020/5/13 15:51
 */
@Repository
public class UserMessageDao {

    private static final StringBuilder FIELD_MSGNAME = new StringBuilder();

    static {
        FIELD_MSGNAME.append("(case when t.msgType='sys' then '系统消息' ")
                .append("when t.msgType='notice' then '通知公告' ")
                .append("when t.msgType='report' then '报表消息' ")
                .append("when t.msgType='news' then '新闻公告' when t.msgType='gtasks' then '待办任务' else '' end) as msgName");
    }

    @Autowired
    SpringJdbcHelper springJdbcHelper;

    /**
     * 分页查询UserMessage列表
     * @author zlx
     * @date 2020/5/13 16:19
     * @param form
     * @param curPage
     * @param pageSize
     * @param calCount
     * @param allList
     * @return com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.UserMessage>
     */
    public Page<UserMessage> findUserMessagePage(UserMessageForm.Search form, int curPage, int pageSize, boolean calCount, boolean allList){
        Sql sql = Sql.select()
                .field("t.id")
                .field("t.msgType")
                .field("t.title")
                .field("t.content")
                .field("t.url")
                .field("t.userId")
                .field("t.readed")
                .field("t.readTime")
                .field("t.createTime")
                .field("t.updateTime")
                .field("t.msgId")
                .field("t.bizId")
                .field("t.bizTable")
                .field("t.appUrl")
                .field("IFNULL(DATE_FORMAT(t.readTime,'%Y-%m-%d %H:%i'),null)","readTimeStr")
                .field("IFNULL(DATE_FORMAT(t.createTime,'%Y-%m-%d %H:%i'),null)","createTimeStr")
                .field(FIELD_MSGNAME.toString())
                .field("b.name","userName")
                .from("t_user_message","t")
                .leftJoin("base_user","b")
                .on("t.userId","b.userId")
                .where()
                .andBlikeJoinByOrIfNotBlank(form.getKey(),"t.content")
                .andEqIfNotBlank("t.msgType",form.getMsgType())
                .andLikeIfNotBlank("t.title",form.getTitle())
                .andLikeIfNotBlank("t.content",form.getContent())
                .andEqIfNotNull("t.userId",form.getUserId())
                .andEqIfNotNull("t.readed",form.getReaded())
                .orderBy().asc("t.readed").desc("t.createTime");
        return springJdbcHelper.queryForPageBean(sql.getSql().toString(),UserMessage.class,sql.getParams().toArray(),curPage,pageSize,calCount,allList);
    }

    /**
     * 新增UserMessage数据
     * @author zlx
     * @date 2020/5/13 17:39
     * @param form
     * @return int
     */
    public int addUserMessage(UserMessageForm.Add form){
        Sql sql = Sql.insert("t_user_message")
                .field("msgType",form.getMsgType())
                .field("title",form.getTitle())
                .field("content",form.getContent())
                .field("url",form.getUrl())
                .field("userId",form.getUserId())
                .field("readed",0)
                .field("msgId",form.getMsgId())
                .field("readTime",form.getReadTime())
                .field("bizId",form.getBizId())
                .field("bizTable",form.getBizTable())
                .field("appUrl",form.getAppUrl())
                .field("createTime",new Date())
                .field("updateTime",new Date());
        return springJdbcHelper.insertReturnFieldNumber(sql).intValue();
    }

    /**
     * 根据id查询数据
     * @author zlx
     * @date 2020/5/13 18:26
     * @param form
     * @return com.redare.shop.unifyworkbench.sdk.pojo.UserMessage
     */
    public UserMessage getUserMessage(UserMessageForm.Get form){
        Sql sql = Sql.select()
                .field("m.id,m.msgType,m.title,m.url,m.userId,m.readed,m.readTime,m.createTime")
                .field("m.updateTime,m.msgId,m.bizId,m.appUrl,m.bizTable")
                .field("c.content")
                .from("t_user_message","m")
                .join("t_content_manage","c")
                .on("m.bizId","c.id")
                .where()
                .andEq("m.id",form.getId());
        return springJdbcHelper.queryForBean(sql,UserMessage.class);
    }

    /**
     * 修改数据
     * @author zlx
     * @date 2020/5/13 18:43
     * @param form
     * @return int
     */
    public int editUserMessage(UserMessageForm.Edit form){
        Sql sql = Sql.update("t_user_message")
                .setIfNotBlank("msgType",form.getMsgType())
                .setIfNotBlank("title",form.getTitle())
                .setIfNotBlank("content",form.getContent())
                .setIfNotBlank("url",form.getUrl())
                .setIfNotNull("userId",form.getUserId())
                .setIfNotNull("readed",form.getReaded())
                .setIfNotNull("readTime",form.getReadTime())
                .set("updateTime",new Date())
                .where()
                .andEqIfNotNull("id",form.getId())
                .andEqIfNotNull("userId",form.getUserId())
                .andEqIfNotNull("bizTable",form.getBizTable())
                .andEqIfNotNull("megType",form.getMsgType())
                .andEqIfNotNull("bizId",form.getBizId());
        return springJdbcHelper.update(sql.getSql().append(" limit 1").toString(),sql.getParams().toArray());
    }

    /**
     * 删除消息数据
     * @author zlx
     * @date 2020/5/14 10:04
     * @param form
     * @return int
     */
    public int deleteUserMessage(UserMessageForm.Delete form){
        Sql sql = Sql.delete("t_user_message")
                .where()
                .andEq("id",form.getId());
        return springJdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    /**
     * 批量更新已读未读
     * @author zlx
     * @date 2020/5/15 14:58
     * @param form
     * @return int[]
     */
    public int batchUpdateMessageStatus(UserMessageForm.batchUpdateMessageStatus form){
        Sql sql = Sql.update("t_user_message")
                .set("readed",1)
                .set("readTime",new Date())
                .where()
                .andEq("userId",form.getUserId())
                .andEqIfNotBlank("msgType",form.getMsgType())
                .andEq("readed",0);
        return springJdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    /**
     * 根据主键id更新阅读状态和阅读时间
     * @author zlx
     * @date 2020/6/4 15:05
     * @param form
     * @return int
     */
    public int updateReaded(UserMessageForm.Get form){
        Sql sql = Sql.update("t_user_message")
                .set("readed",1)
                .set("readTime",new Date())
                .where()
                .andEq("id",form.getId());
        return springJdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    /**
     * 根据用户id和消息类型统计未读条数
     * @author zlx
     * @date 2020/5/15 15:35
     * @param form
     * @return java.lang.Long
     */
    public Long CountItem(UserMessageForm.CountItem form){
        Sql sql = Sql.selectCount()
                .from("t_user_message")
                .where()
                .andEqIfNotBlank("msgType",form.getMsgType())
                .andEq("userId",form.getUserId())
                .andEq("readed",0);
        return springJdbcHelper.queryForNumber(sql.getSql().toString(),sql.getParams().toArray());
    }

    /**
     * 根据消息id删除数据
     * @author zlx
     * @date 2020/5/15 16:26
     * @param form
     * @return int
     */
    public int deleteByMsgId(UserMessageForm.DeleteByMsgId form){
        Sql sql = Sql.delete("t_user_message")
                .where()
                .andIn("msgId",form.getMsgId());
        return springJdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    /**
     * 根据消息id更新消息内容
     * @author zlx
     * @date 2020/5/15 17:00
     * @param form
     * @return int
     */
    public int editContentByMsgId(UserMessageForm.EditContentByMsgId form){
        Sql sql = Sql.update("t_user_message")
                .setIfNotBlank("title",form.getTitle())
                .setIfNotBlank("content",form.getContent())
                .where()
                .andEq("msgId",form.getMsgId());
        return springJdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    /**
     * 根据用户id和消息类型查询数据
     * @author zlx
     * @date 2020/6/3 17:01
     * @param form
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserMessage>
     */
    public List<UserMessage> getUserMessageByUserId(UserMessageForm.GetByUserId form){
        Sql sql = Sql.select()
                .fields("t.*")
                .field("date_format(t.createTime,'%Y-%m-%d %H:%i')","createTimeStr")
                .from("t_user_message","t")
                .where()
                .andEqIfNotNull("t.userId",form.getUserId())
                .andEqIfNotBlank("t.bizId",form.getBizId())
                .andEqIfNotBlank("t.bizTable",form.getBizTable())
                .andEqIfNotBlank("t.msgType",form.getMsgType())
                .orderBy().asc("t.readed").desc("t.createTime");
        return springJdbcHelper.queryForListBean(sql.getSql().toString(),UserMessage.class,sql.getParams().toArray());
    }

    /**
     * 根据用户id统计所有消息条数
     * @author zlx
     * @date 2020/6/4 17:36
     * @param form
     * @return java.lang.Long
     */
    public Long findAllCountByUserId(UserMessageForm.GetByUserId form){
        Sql sql = Sql.selectCount()
                .from("t_user_message")
                .where()
                .andEq("userId",form.getUserId());
        return springJdbcHelper.queryForNumber(sql.getSql().toString(),sql.getParams().toArray());
    }

    /**
     * @description: 根据用户id和消息类型查询未读的消息
     * @author: zhangsq
     * @date: Created in 2020-07-14 15:13
     * @param form
     * @return: java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserMessage>
     * @exception:
     */
    public List<UserMessage> getMessageNoticeByUserId(UserMessageForm.GetByUserId form){
        Sql sql = Sql.select()
                .fields("t.*")
                .field("date_format(t.createTime,'%Y-%m-%d %H:%i:%s')","createTimeStr")
                .from("t_user_message","t")
                .where()
                .andEq("t.userId",form.getUserId())
                .andEqIfNotBlank("t.msgType",form.getMsgType())
                .andEqIfNotBlank("t.readed","0")
                .orderBy().asc("t.readed").desc("t.createTime");
        return springJdbcHelper.queryForListBean(sql.getSql().toString(),UserMessage.class,sql.getParams().toArray());
    }

    /**
     *
     * @param form
     * @param curPage
     * @param pageSize
     * @param calCount
     * @param allList
     * @return
     */
    public Page<UserMessage> queryForPageMessageByBizId(UserMessageForm.Search form,int curPage, int pageSize, boolean calCount, boolean allList){
        Sql sql = Sql.select()
                .from("t_user_message")
                .where()
                .andEqIfNotBlank("msgType",form.getMsgType())
                .andEqIfNotBlank("bizTable",form.getBizTable())
                .andEqIfNotNull("readed",form.getReaded())
                .orderBy().desc("readTime");
        return springJdbcHelper.queryForPageBean(sql.getSql().toString(),UserMessage.class,sql.getParams().toArray(),curPage,pageSize,calCount,allList);
    }

    /**
     * @description 批量添加
     * @author zlx
     * @date 2020/7/29 18:35
     * @param list
     * @return int[]
     */
    public int[] batchAddUserMessage(List<UserMessageForm.Add> list){
        Sql sql = Sql.insert("t_user_message")
                .field("msgType")
                .field("title")
                .field("content")
                .field("url")
                .field("userId")
                .field("readed")
                .field("msgId")
                .field("bizId")
                .field("appUrl")
                .field("bizTable")
                .field("readTime")
                .field("createTime")
                .field("updateTime");
        List<Object[]> params = new ArrayList<>();
        for (UserMessageForm.Add form:list){
            params.add(
                    new Object[]{
                            form.getMsgType(),
                            form.getTitle(),
                            form.getContent(),
                            form.getUrl(),
                            form.getUserId(),
                            form.getReaded(),
                            form.getMsgId(),
                            form.getBizId(),
                            form.getAppUrl(),
                            form.getBizTable(),
                            form.getReadTime(),
                            form.getCreateTime(),
                            form.getUpdateTime()
                    }
            );
        }
        return springJdbcHelper.batchUpdate(sql.toString(), params);
    }

}
