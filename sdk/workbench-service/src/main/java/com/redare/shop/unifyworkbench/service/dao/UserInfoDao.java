package com.redare.shop.unifyworkbench.service.dao;

import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.UserInfo;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserInfoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserInfoDao {

    @Autowired
    SpringJdbcHelper jdbcHelper;

    /**
     * 查询用户列表
     * @param form
     * @param curPage
     * @param pageSize
     * @param calCount
     * @param allList
     * @return
     */
    public Page<UserInfo> findUserInfoPage(UserInfoForm.Search form,int curPage,int pageSize, boolean calCount, boolean allList){
        Sql sql = Sql.select()
                .from("t_user_info")
                .where()
                .andEqIfNotBlank("deptId",form.getDeptId())
                .andBlikeIfNotBlank("userName",form.getUserName())
                .andBlikeIfNotBlank("fullDeptName",form.getFullDeptName())
                .andEqIfNotBlank("sex",form.getSex())
                .andLikeIfNotBlank("jianpin",form.getJianpin())
                .orderBy().asc("jianpin");
        return jdbcHelper.queryForPageBean(sql.getSql().toString(),UserInfo.class,sql.getParams().toArray(),curPage,pageSize,calCount,allList);
    }

    /**
     * 添加用户
     * @param form
     * @return
     */
    public int addUserInfo(UserInfoForm.Add form){
        Sql sql = Sql.insert("t_user_info")
                .field("userId",form.getUserId())
                .field("fullDeptName",form.getFullDeptName())
                .field("userCode",form.getUserCode())
                .field("userName",form.getUserName())
                .field("deptId",form.getDeptId())
                .field("sex",form.getSex())
                .field("password",form.getPassword())
                .field("email",form.getEmail())
                .field("mobilePhone",form.getMobilePhone())
                .field("pinyin",form.getPinyin())
                .field("jianpin",form.getJianpin());
        return jdbcHelper.insert(sql.getSql().toString(),sql.getParams().toArray());
    }

    /**
     * 修改用户信息
     * @param form
     * @return
     */
    public int editUserInfo(UserInfoForm.Edit form){
        Sql sql = Sql.update("t_user_info")
                .setIfNotNull("userId",form.getUserId())
                .setIfNotNull("fullDeptName",form.getFullDeptName())
                .setIfNotNull("userCode",form.getUserCode())
                .setIfNotNull("userName",form.getUserName())
                .setIfNotNull("deptId",form.getDeptId())
                .setIfNotNull("sex",form.getSex())
                .setIfNotNull("password",form.getPassword())
                .setIfNotNull("email",form.getEmail())
                .setIfNotNull("mobilePhone",form.getMobilePhone())
                .setIfNotNull("pinyin",form.getPinyin())
                .setIfNotNull("jianpin",form.getJianpin())
                .where()
                .andEq("id",form.getId());
        return jdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    public UserInfo getUserInfoByUserId(UserInfoForm.Get form){
        Sql sql = Sql.select()
                .from("t_user_info")
                .where()
                .andEqIfNotBlank("id",form.getUserId());
        return jdbcHelper.queryForBean(sql.getSql().toString(),UserInfo.class,sql.getParams().toArray());
    }

    /**
     * 清空表
     * @return
     */
    public int truncateTable(){
        String sql = "truncate table t_user_info";
        return jdbcHelper.update(sql);
    }

    public UserInfo getUserInfoByLoginUserId(UserInfoForm.Get form){
        String sql="select * from t_user_info t where t.userId=(select b.accountId from t_application a join t_user_application b on a.id=b.applicationId and a.sysCode='ztkt_oa' and b.pcOrMobile=1 and b.userId=?)";
        List<Object> params=new ArrayList<>();
        params.add(form.getUserId());
        return jdbcHelper.queryForBean(sql,UserInfo.class,params.toArray());
    }

    /**
     * @description: 通讯录中根据组织机构id或ParentId查询机构下的用户信息
     * @author: zhangsq
     * @date: Created in 2020-08-24 11:11
     * @param form
     * @param curPage
     * @param pageSize
     * @param calCount
     * @param allList
     * @return: com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.UserInfo>
     * @exception:
     */
    public Page<UserInfo> findContactsBookUserListByOgrId(UserInfo form, int curPage, int pageSize, boolean calCount, boolean allList) {
        StringBuilder sql = new StringBuilder();
        sql.append("select u.id,u.userId,u.userCode,u.userName,u.deptId,u.sex,u.`password`,u.email,u.pinyin,u.mobilePhone,u.jianpin,u.fullDeptName ");
        sql.append("from t_user_info u ");
        sql.append("where 1=1 ");
        List<String> list = new ArrayList<>();
        if (form.getDeptId() != null && !"".equals(form.getDeptId())){
            // sql.append(" and u.deptId in('"+ StringUtils.join(form.getStrList().toArray(),"','")+"')");
            sql.append(" and u.deptId = '"+ form.getDeptId()+"'");
        }
        if (form.getFullDeptName() != null && !"".equals(form.getFullDeptName())){
            sql.append(" and u.fullDeptName like '"+form.getFullDeptName()+"%' ");
        }
        if (form.getKey() != null && !"".equals(form.getKey())){
            sql.append(" and concat(IFNULL(u.userName,''),IFNULL(u.email,''),IFNULL(u.mobilePhone,''),IFNULL(u.jianpin,''),IFNULL(u.fullDeptName,'')) like '%"+form.getKey()+"%'");
        }
        if (form.getJianpin() != null && !"".equals(form.getJianpin())){
            sql.append(" and u.jianpin like '"+form.getJianpin()+"%' ");
        }
        if (form.isEmailFlag() == true) {
            sql.append(" and u.email is not null and u.email != '' ");
        }
        if (form.isMobilePhoneFlag() == true) {
            sql.append(" and u.mobilePhone is not null and u.mobilePhone != ''");
        }
        sql.append("ORDER BY u.userId asc");

        return jdbcHelper.queryForPageBean(sql.toString(), UserInfo.class,list.toArray(), curPage, pageSize, calCount, allList);
    }

}
