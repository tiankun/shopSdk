package com.redare.shop.unifyworkbench.service.dao;

import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.OrganizeHonor;
import com.redare.shop.unifyworkbench.sdk.pojo.form.OrganizeHonorForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/10/19 15:28
 * @version:
 */
@Repository
public class OrganizeHonorDao {

    @Autowired
    SpringJdbcHelper springJdbcHelper;

    public Page<OrganizeHonor> findOrganizeHonorPage(OrganizeHonorForm.Search form,int curPage,int pageSize,boolean calCount,boolean allList){
        Sql sql = Sql.select()
                .from("t_organize_honor")
                .where()
                .andBlikeJoinByOrIfNotBlank(form.getKey(),"orgName","honorName")
                .andEqIfNotBlank("orgId",form.getOrgId())
                .andEqIfNotNull("del",form.getDel())
                .orderBy().desc("id");
        return springJdbcHelper.queryForPageBean(sql.getSql().toString(),OrganizeHonor.class,sql.getParams().toArray(),curPage,pageSize,calCount,allList);
    }

    public OrganizeHonor findOrganizeHonor(OrganizeHonorForm.Get form){
        Sql sql = Sql.select()
                .from("t_organize_honor")
                .where()
                .andEq("id",form.getId());
        return springJdbcHelper.queryForBean(sql.getSql().toString(),OrganizeHonor.class,sql.getParams().toArray());
    }

    public Long addOrganizeHonor(OrganizeHonorForm.Add form){
        Sql sql = Sql.insert("t_organize_honor")
                .field("orgId",form.getOrgId())
                .field("orgName",form.getOrgName())
                .field("honorName",form.getHonorName())
                .field("userId",form.getUserId())
                .field("userName",form.getUserName())
                .field("del",form.getDel())
                .field("honorTime",form.getHonorTime())
                .field("createTime",form.getCreateTime())
                .field("updateTime",form.getUpdateTime());
        return springJdbcHelper.insertReturnFieldNumber(sql.getSql().toString(),sql.getParams().toArray()).longValue();
    }

    public int editOrganizeHonor(OrganizeHonorForm.Edit form){
        Sql sql = Sql.update("t_organize_honor")
                .setIfNotBlank("orgId",form.getOrgId())
                .setIfNotBlank("orgName",form.getOrgName())
                .setIfNotBlank("honorName",form.getHonorName())
                .setIfNotNull("userId",form.getUserId())
                .setIfNotBlank("userName",form.getUserName())
                .setIfNotNull("del",form.getDel())
                .setIfNotNull("honorTime",form.getHonorTime())
                .set("updateTime",new Date())
                .where()
                .andEq("id",form.getId());
        return springJdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    public int delOrganizeHonor(OrganizeHonorForm.Del form){
        Sql sql = Sql.delete("t_organize_honor")
                .where()
                .andEq("id", form.getId());
        return springJdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    public int[] batchAddOrganizeHonor(OrganizeHonorForm.BatchAdd form){
        Sql sql = Sql.insert("t_organize_honor")
                .field("orgId")
                .field("orgName")
                .field("honorName")
                .field("userId")
                .field("userName")
                .field("del")
                .field("honorTime")
                .field("createTime")
                .field("updateTime");
        List<Object[]> params = new ArrayList<>();
        for (OrganizeHonorForm.Add add : form.getList()){
            params.add(
                    new Object[]{
                            form.getOrgId(),
                            form.getOrgName(),
                            add.getHonorName(),
                            add.getUserId(),
                            add.getUserName(),
                            0,
                            add.getHonorTime(),
                            add.getCreateTime(),
                            new Date()
                    }
            );
        }
        return springJdbcHelper.batchUpdate(sql.toString(), params);
    }

    public int delByOrgId(OrganizeHonorForm.DelByOrgId form){
        Sql sql = Sql.delete("t_organize_honor")
                .where()
                .andEq("orgId",form.getOrgId());
        return springJdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    public int batchDel(List<String> orgIdList){
        Sql sql = Sql.update("t_organize_honor")
                .set("del",1)
                .where()
                .andIn("orgId",orgIdList);
        return springJdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }
}
