package com.redare.shop.unifyworkbench.service.dao;

import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.LoginLog;
import com.redare.shop.unifyworkbench.sdk.pojo.form.LoginLogForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/7/29 10:24
 * @version: 1.1
 */
@Repository
public class LoginLogDao {

    @Autowired
    SpringJdbcHelper springJdbcHelper;

    /**
     * @description 分页查询
     * @author zlx
     * @date 2020/7/29 10:31
     * @param form
     * @param curPage
     * @param pageSize
     * @param calCount
     * @param allList
     * @return com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.LoginLog>
     */
    public Page<LoginLog> findLoginLogPage(LoginLogForm.Search form,int curPage,int pageSize,boolean calCount,boolean allList){
        Sql sql = Sql.select()
                .from("t_login_log")
                .where()
                .andBlikeJoinByOrIfNotBlank(form.getKey(),"classify","operator","content")
                .andBetweenOptionIf(form.getStartTime() != null&&form.getEndTime() != null,"createTime",form.getStartTime(),form.getEndTime())
                .orderBy().asc("id");
        return springJdbcHelper.queryForPageBean(sql.getSql().toString(),LoginLog.class,sql.getParams().toArray(),curPage,pageSize,calCount,allList);
    }

    /**
     * @description 添加日志数据
     * @author zlx
     * @date 2020/7/29 10:35
     * @param form
     * @return java.lang.Long
     */
    public Long addLoginLog(LoginLogForm.Add form){
        Sql sql = Sql.insert("t_login_log")
                .field("classify",form.getClassify())
                .field("operator",form.getOperator())
                .field("content",form.getContent())
                .field("createTime",form.getCreateTime())
                .field("source",form.getSource());
        return springJdbcHelper.insertReturnFieldNumber(sql).longValue();
    }
}
