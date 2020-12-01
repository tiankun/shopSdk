package com.redare.shop.unifyworkbench.service.dao;

import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.OrganizeChangeTerm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.OrganizeChangeTermForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/10/19 11:24
 * @version:
 */
@Repository
public class OrganizeChangeTermDao {

    @Autowired
    SpringJdbcHelper springJdbcHelper;

    public Page<OrganizeChangeTerm> findOrganizeChangeTermPage(OrganizeChangeTermForm.Search form,int curPage,int pageSize,boolean calCount,boolean allList){
        Sql sql = Sql.select()
                .from("t_organize_change_term")
                .where()
                .andBlikeJoinByOrIfNotBlank(form.getKey(),"orgName","changeInfo","userName")
                .andEqIfNotBlank("orgId",form.getOrgId())
                .andEqIfNotNull("del",form.getDel())
                .orderBy().desc("id");
        return springJdbcHelper.queryForPageBean(sql.getSql().toString(),OrganizeChangeTerm.class,sql.getParams().toArray(),curPage,pageSize,calCount,allList);
    }

    public OrganizeChangeTerm findOrganizeChangeTerm(OrganizeChangeTermForm.Get form){
        Sql sql = Sql.select()
                .from("t_organize_change_term")
                .where()
                .andEq("id",form.getId());
        return springJdbcHelper.queryForBean(sql.getSql().toString(),OrganizeChangeTerm.class,sql.getParams().toArray());
    }

    public Long addOrganizeChangeTerm(OrganizeChangeTermForm.Add form){
        Sql sql = Sql.insert("t_organize_change_term")
                .field("orgId",form.getOrgId())
                .field("orgName",form.getOrgName())
                .field("changeInfo",form.getChangeInfo())
                .field("userId", form.getUserId())
                .field("userName",form.getUserName())
                .field("del",form.getDel())
                .field("changeTime",form.getChangeTime())
                .field("createTime",form.getCreateTime())
                .field("updateTime",form.getUpdateTime());
        return springJdbcHelper.insertReturnFieldNumber(sql).longValue();
    }

    public int editOrganizeChangeTerm(OrganizeChangeTermForm.Edit form){
        Sql sql = Sql.update("t_organize_change_term")
                .setIfNotBlank("orgId",form.getOrgId())
                .setIfNotBlank("orgName",form.getOrgName())
                .setIfNotBlank("changeInfo",form.getChangeInfo())
                .setIfNotNull("userId", form.getUserId())
                .setIfNotBlank("userName",form.getUserName())
                .setIfNotNull("del",form.getDel())
                .setIfNotNull("changeTime",form.getChangeTime())
                .set("updateTime",new Date())
                .where()
                .andEq("id",form.getId());
        return springJdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    public  int delOrganizeChangeTerm(OrganizeChangeTermForm.Del form){
        Sql sql = Sql.delete("t_organize_change_term")
                .where()
                .andEq("id",form.getId());
        return springJdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    public int[] batchAddOrganizeChangeTerm(OrganizeChangeTermForm.BatchAdd form){
        Sql sql = Sql.insert("t_organize_change_term")
                .field("orgId")
                .field("orgName")
                .field("changeInfo")
                .field("userId")
                .field("userName")
                .field("del")
                .field("changeTime")
                .field("createTime")
                .field("updateTime");
        List<Object[]> params = new ArrayList<>();
        for (OrganizeChangeTermForm.Add add : form.getList()){
            params.add(
                    new Object[]{
                            form.getOrgId(),
                            form.getOrgName(),
                            add.getChangeInfo(),
                            add.getUserId(),
                            add.getUserName(),
                            0,
                            add.getChangeTime(),
                            add.getCreateTime(),
                            new Date()
                    }
            );
        }
        return springJdbcHelper.batchUpdate(sql.toString(), params);
    }

    public int delByOrgId(OrganizeChangeTermForm.DelByOrgId form){
        Sql sql = Sql.delete("t_organize_change_term")
                .where()
                .andEq("orgId",form.getOrgId());
        return springJdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    public int batchDel(List<String> orgIdList){
        Sql sql = Sql.update("t_organize_change_term")
                .set("del",1)
                .where()
                .andIn("orgId",orgIdList);
        return springJdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }
}
