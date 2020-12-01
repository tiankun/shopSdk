package com.redare.shop.unifyworkbench.service.dao;

import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.UserInfo;
import com.redare.shop.unifyworkbench.sdk.pojo.UserInfoLinkman;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserInfoLinkmanForm;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * ：UserInfoLinkmanDao
 *
 * @author yj
 * @email yangj@redare.cn
 * @date 2020-08-25
 */
@Repository
public class UserInfoLinkmanDao {
    @Autowired
    SpringJdbcHelper jdbcHelper;

    /**
     * 查询(t_user_info_linkman：)列表
     * @param form
     * @param curPage
     * @param pageSize
     * @return
     */
    public Page<UserInfo> findUserInfoLinkmanPage(UserInfoLinkmanForm.Search form, int curPage, int pageSize, boolean calCount, boolean allList) {
        Sql sql = Sql.select()
                .field("a.*")
                .from("t_user_info","a")
                .join("t_user_info_linkman","b")
                .on("a.userId","b.userId")
                .where()
                .andEqIfNotNull("b.ztktUserId", form.getZtktUserId());
        return jdbcHelper.queryForPageBean(sql.getSql().toString(), UserInfo.class, sql.getParams().toArray(), curPage, pageSize, calCount, allList);
    }

    /**
    * 根据id查询(t_user_info_linkman：)详情
    * @param form
    */
    public UserInfoLinkman getUserInfoLinkman(UserInfoLinkmanForm.Get form){
        Sql sql = Sql.select()
                .from("t_user_info_linkman")
                .where()
                .andEqIfNotNull("ztktUserId",form.getZtktUserId())
                .andEqIfNotBlank("userId",form.getUserId())
                .andEqIf(StringUtils.isBlank(form.getUserId())&&form.getZtktUserId()==null,"id",form.getId());
        return jdbcHelper.queryForBean(sql,UserInfoLinkman.class);
    }

    /**
    * 新增(t_user_info_linkman：)信息
    * @param form
    * @return
    */
    public boolean addUserInfoLinkman(UserInfoLinkmanForm.Add form){
        Sql sql=Sql.insert("t_user_info_linkman")
                    .field("ztktUserId",form.getZtktUserId())
                    .field("userId",form.getUserId())
                    .field("linkCount",form.getLinkCount())
                    .field("createTime",form.getCreateTime());
        return jdbcHelper.insertReturnFieldNumber(sql).intValue() >0;
    }

    /**
    * 修改(t_user_info_linkman：)信息
    * @param form
    * @return
    */
    public boolean editUserInfoLinkman(UserInfoLinkmanForm.Edit form){
        Sql sql = Sql.update("t_user_info_linkman")
            .setIfNotNull("id",form.getId())
            .setIfNotNull("ztktUserId",form.getZtktUserId())
            .setIfNotNull("userId",form.getUserId())
            .setIfNotNull("linkCount",form.getLinkCount())
            .setIfNotNull("createTime",form.getCreateTime())
            .where()
            .andEq("id", form.getId());
        return jdbcHelper.update(sql.toString(), sql.getParams().toArray())>0;
    }

    /**
    * 根据id删除(t_user_info_linkman：)信息
    * @param form
    * @return
    */
    public boolean deleteUserInfoLinkman(UserInfoLinkmanForm.Del form){
        Sql sql = Sql.delete("t_user_info_linkman")
                .where().andEq("id", form.getId());
        return jdbcHelper.update(sql.toString(), sql.getParams().toArray())>0;
    }

}
