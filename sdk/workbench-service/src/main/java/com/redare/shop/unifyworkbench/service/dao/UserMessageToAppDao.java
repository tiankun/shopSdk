package com.redare.shop.unifyworkbench.service.dao;

import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.devframework.webplatform.sdk.core.pojo.Account;
import com.redare.shop.unifyworkbench.sdk.pojo.UserMessageToApp;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserMessageToAppForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @description: UserMessageToAppDao
 * @author: zlx
 * @date: Created in 2020/6/16 16:33
 * @version: 1.1
 */
@Repository
public class UserMessageToAppDao {

    @Autowired
    SpringJdbcHelper springJdbcHelper;


    private static final StringBuilder APP_ROLE_NAME = new StringBuilder();
    private static final StringBuilder APP_USER_NAME = new StringBuilder();
    private static final StringBuilder FIELD_MSGNAME = new StringBuilder();
    static {
        APP_ROLE_NAME.append("(SELECT t.id AS appId,GROUP_CONCAT(r.`name`) AS roleNames ")
                .append("FROM t_user_message_toApp t ")
                .append("LEFT JOIN base_platform_role r ")
                .append("ON FIND_IN_SET(r.id, t.roleIds) GROUP BY t.id )");

        APP_USER_NAME.append("(SELECT t.id AS appId,GROUP_CONCAT(r.`name`) AS userNames ")
                .append("FROM t_user_message_toApp t ")
                .append("LEFT JOIN base_user r ")
                .append("ON FIND_IN_SET(r.userId, t.userIds) GROUP BY t.id )");

        FIELD_MSGNAME.append("(case when a.msgType='sys' then '系统消息' ")
                .append("when a.msgType='notice' then '通知公告' ")
                .append("when a.msgType='report' then '报表消息' ")
                .append("when a.msgType='news' then '新闻公告' else '' end) as msgName");

    }

    /**
     * @description 添加数据
     * @author zlx
     * @date 2020/6/16 16:41
     * @param form
     * @return int
     */
    public int addUserMessageToApp(UserMessageToAppForm.Add form){
        Sql sql = Sql.insert("t_user_message_toApp")
                .field("title",form.getTitle())
                .field("msgType",form.getMsgType())
                .field("content",form.getContent())
                .field("url",form.getUrl())
                .field("userIds",form.getUserIds())
                .field("readed",0)
                .field("readTime",form.getReadTime())
                .field("createTime",new Date())
                .field("updateTime",new Date())
                .field("msgId",form.getMsgId())
                .field("roleIds",form.getRoleIds())
                .field("msgReceiveType",form.getMsgReceiveType())
                .field("msgScope",form.getMsgScope());
        return springJdbcHelper.insertReturnFieldNumber(sql).intValue();
    }

    /**
     * @description 查询用户id集合
     * @author zlx
     * @date 2020/6/17 14:36
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    public List<Account> findUserIdByRoleId(){
        StringBuilder sql = new StringBuilder("select ")
                .append("t.* from base_account t ");
        return springJdbcHelper.queryForListBean(sql.toString(),Account.class);
    }

    /**
     * @description 分页查询
     * @author zlx
     * @date 2020/6/17 15:08
     * @param form
     * @param curPage
     * @param pageSize
     * @param calCount
     * @param allList
     * @return com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.UserMessageToApp>
     */
    public Page<UserMessageToApp> findUserMessageToAppPage(UserMessageToAppForm.Search form, int curPage, int pageSize, boolean calCount, boolean allList){
        Sql sql = Sql.select()
                .fields("a.*")
                .field("b.roleNames")
                .field("c.userNames")
                .field(FIELD_MSGNAME.toString())
                .from("t_user_message_toApp","a")
                .join(APP_ROLE_NAME.toString(),"b")
                .on("a.id","b.appId")
                .join(APP_USER_NAME.toString(),"c")
                .on("a.id","c.appId")
                .where()
                .andBlikeJoinByOrIfNotBlank(form.getKey(),"a.title","a.content")
                .andEqIfNotBlank("a.msgType",form.getMsgType())
                .orderBy().desc("a.createTime");
        return springJdbcHelper.queryForPageBean(sql.getSql().toString(),UserMessageToApp.class,sql.getParams().toArray(),curPage,pageSize,calCount,allList);
    }

    /**
     * @description 删除数据
     * @author zlx
     * @date 2020/6/17 15:10
     * @param form
     * @return int
     */
    public int delUserMessageToApp(UserMessageToAppForm.Del form){
        Sql sql = Sql.delete("t_user_message_toApp")
                .where()
                .andEq("id",form.getId());
        return springJdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    /**
     * @description: 添加推送报表
     * @author: zhangsq
     * @date: Created in 2020-08-07 11:49
     * @param form
     * @return: int
     * @exception:
     */
    public int addUserMessageSendReport(UserMessageToAppForm.Add form){
        Sql sql = Sql.insert("t_user_message_toApp")
                .field("title",form.getTitle())
                .field("msgType",form.getMsgType())
                .field("content",form.getContent())
                .field("url",form.getUrl())
                .field("userIds",form.getUserIds())
                .field("readed",0)
                .field("readTime",form.getReadTime())
                .field("createTime",new Date())
                .field("updateTime",new Date())
                .field("msgId",form.getMsgId())
                .field("roleIds",form.getRoleIds())
                .field("msgReceiveType",form.getMsgReceiveType())
                .field("sendReport",form.getSendReport())
                .field("msgScope",form.getMsgScope());
        return springJdbcHelper.insertReturnFieldNumber(sql).intValue();
    }

    /**
     * @description: 推送报表分页查询列表
     * @author: zhangsq
     * @date: Created in 2020-08-07 11:39
     * @param form
     * @param curPage
     * @param pageSize
     * @param calCount
     * @param allList
     * @return: com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.UserMessageToApp>
     * @exception:
     */
    public Page<UserMessageToApp> findUserMessageSendReportPage(UserMessageToAppForm.Search form,int curPage,int pageSize,boolean calCount,boolean allList){
        Sql sql = Sql.select()
                .fields("a.*")
                .field("b.roleNames")
                .field("c.userNames")
                .field(FIELD_MSGNAME.toString())
                .from("t_user_message_toApp","a")
                .join(APP_ROLE_NAME.toString(),"b")
                .on("a.id","b.appId")
                .join(APP_USER_NAME.toString(),"c")
                .on("a.id","c.appId")
                .where()
                .andBlikeJoinByOrIfNotBlank(form.getKey(),"a.title","a.content")
                .andEqIfNotBlank("a.msgScope",form.getMsgScope())
                .orderBy().desc("a.createTime");
        return springJdbcHelper.queryForPageBean(sql.getSql().toString(),UserMessageToApp.class,sql.getParams().toArray(),curPage,pageSize,calCount,allList);
    }

    /**
     * @description: 删除推送报表
     * @author: zhangsq
     * @date: Created in 2020-08-07 11:42
     * @param form
     * @return: int
     * @exception:
     */
    public int delUserMessageSendReport(UserMessageToAppForm.Del form){
        Sql sql = Sql.delete("t_user_message_toApp")
                .where()
                .andEq("id",form.getId());
        return springJdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }
}
