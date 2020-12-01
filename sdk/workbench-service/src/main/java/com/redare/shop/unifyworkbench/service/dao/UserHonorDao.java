package com.redare.shop.unifyworkbench.service.dao;

import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.UserHonor;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserHonorForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : zhangsq
 * @version :
 * @description：人员荣誉信息数据层
 * @date ：Created in 2020-10-20 15:13
 */
@Repository
public class UserHonorDao {

    @Autowired
    SpringJdbcHelper jdbcHelper;

    /**
     * @description: 分页查询列表数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 16:54
     * @param form
     * @param curPage
     * @param pageSize
     * @param calCount
     * @param allList
     * @return: com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.UserHonor>
     * @exception:
     */
    public Page<UserHonor> findUserHonorPage(UserHonorForm.Search form, int curPage, int pageSize,boolean calCount,boolean allList){
        Sql sql = Sql.select()
                .from("t_user_honor")
                .where()
                .andBlikeJoinByOrIfNotBlank(form.getKey(),"honorName")
                .andEqIfNotNull("userId",form.getUserId())
                .andEqIfNotNull("del",0)
                .orderBy().desc("id");
        return jdbcHelper.queryForPageBean(sql.getSql().toString(), UserHonor.class,sql.getParams().toArray(),curPage,pageSize,calCount,allList);
    }

    /**
     * @description: 根据荣誉id查询数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 17:10
     * @param form
     * @return: com.redare.shop.unifyworkbench.sdk.pojo.UserHonor
     * @exception:
     */
    public UserHonor findUserHonor(UserHonorForm.Get form){
        Sql sql = Sql.select()
                .from("t_user_honor")
                .where()
                .andEq("id",form.getId());
        return jdbcHelper.queryForBean(sql.getSql().toString(),UserHonor.class,sql.getParams().toArray());
    }

    /**
     * @description: 添加数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 17:16
     * @param form
     * @return: java.lang.Long
     * @exception:
     */
    public Long addUserHonor(UserHonorForm.Add form){
        Sql sql = Sql.insert("t_user_honor")
                .field("userId",form.getUserId())
                .field("honorName",form.getHonorName())
                .field("honorTypeId",form.getHonorTypeId())
                .field("honorTypeName",form.getHonorTypeName())
                .field("honorTime",form.getHonorTime())
                .field("operator",form.getOperator())
                .field("del",0)
                .field("createTime",form.getCreateTime())
                .field("updateTime",form.getUpdateTime());
        return jdbcHelper.insertReturnFieldNumber(sql.getSql().toString(),sql.getParams().toArray()).longValue();
    }

    /**
     * @description: 批量添加
     * @author: zhangsq
     * @date: Created in 2020-10-21 11:32
     * @param form
     * @return: int[]
     * @exception:
     */
    public int[] batchAddUserHonor(UserHonorForm.BatchAdd form){
        Sql sql = Sql.insert("t_user_honor")
                .field("userId")
                .field("honorName")
                .field("honorTypeId")
                .field("honorTypeName")
                .field("honorTime")
                .field("operator")
                .field("del")
                .field("createTime")
                .field("updateTime");
        List<Object[]> params = new ArrayList<>();
        for (UserHonorForm.Add add : form.getList()){
            params.add(
                    new Object[]{
                            form.getUserId(),
                            add.getHonorName(),
                            add.getHonorTypeId(),
                            add.getHonorTypeName(),
                            add.getHonorTime(),
                            add.getOperator(),
                           0,
                            new Date(),
                            new Date()
                    }
            );
        }
        return jdbcHelper.batchUpdate(sql.toString(), params);
    }

    /**
     * @description: 编辑数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 17:23
     * @param form
     * @return: int
     * @exception:
     */
    public int editUserHonor(UserHonorForm.Edit form){
        Sql sql = Sql.update("t_user_honor")
                .setIfNotNull("userId",form.getUserId())
                .setIfNotBlank("honorName",form.getHonorName())
                .setIfNotNull("honorTypeId",form.getHonorTypeId())
                .setIfNotBlank("honorTypeName",form.getHonorTypeName())
                .setIfNotNull("honorTime",form.getHonorTime())
                .setIfNotBlank("operator",form.getOperator())
                .set("updateTime",new Date())
                .where()
                .andEq("id",form.getId());
        return jdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    /**
     * @description: 删除数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 17:30
     * @param form
     * @return: int
     * @exception:
     */
    public int delUserHonor(UserHonorForm.Del form){
        Sql sql = Sql.update("t_user_honor")
                .set("del",1)
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    public int delByUserHonor(UserHonorForm.Del form){
        Sql sql = Sql.update("t_user_honor")
                .set("del",1)
                .where()
                .andEq("userId", form.getUserId());
        return jdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    /**
     * @description: 批量删除数据
     * @author: zhangsq
     * @date: Created in 2020-10-21 11:07
     * @param form
     * @return: int
     * @exception:
     */
    public int batchDelUserHonor(UserHonorForm.BatchDel form){
        Sql sql = Sql.update("t_user_honor")
                .set("del",1)
                .where()
                .andIn("id",form.getUserIdList());
        return jdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    public int batchDelUserListHonor(List<Long> userIdList){
        Sql sql = Sql.update("t_user_honor")
                .set("del",1)
                .where()
                .andIn("userId",userIdList);
        return jdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

}
