package com.redare.shop.unifyworkbench.service.dao;

import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.UserOrg;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserOrgForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author : zhangsq
 * @version :
 * @description：人员组织机构数据层
 * @date ：Created in 2020-10-20 15:12
 */
@Repository
public class UserOrgDao {

    @Autowired
    SpringJdbcHelper jdbcHelper;

    /**
     * @description: 分页查询列表数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 17:02
     * @param form
     * @param curPage
     * @param pageSize
     * @param calCount
     * @param allList
     * @return: com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.UserOrg>
     * @exception:
     */
    public Page<UserOrg> findUserOrgPage(UserOrgForm.Search form, int curPage, int pageSize, boolean calCount, boolean allList){
        Sql sql = Sql.select()
                .from("t_user_org")
                .where()
                .andBlikeJoinByOrIfNotBlank(form.getKey(),"orgName")
                .andEqIfNotNull("userId",form.getUserId())
                .andEqIfNotNull("del",0)
                .andInIfNotEmpty("orgId",form.getOrgIdList())
                .orderBy().desc("id");
        return jdbcHelper.queryForPageBean(sql.getSql().toString(),UserOrg.class,sql.getParams().toArray(),curPage,pageSize,calCount,allList);
    }

    /**
     * @description: 根据主键id查询数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 17:00
     * @param form
     * @return: com.redare.shop.unifyworkbench.sdk.pojo.UserOrg
     * @exception:
     */
    public UserOrg findUserOrg(UserOrgForm.Get form){
        Sql sql = Sql.select()
                .from("t_user_org")
                .where()
                .andEqIfNotNull("del",0)
                .andEq("id",form.getId());
        return jdbcHelper.queryForBean(sql.getSql().toString(), UserOrg.class,sql.getParams().toArray());
    }

    /**
     * @description: 添加数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 17:01
     * @param form
     * @return: java.lang.Long
     * @exception:
     */
    public Long addUserOrg(UserOrgForm.Add form){
        Sql sql = Sql.insert("t_user_org")
                .field("userId",form.getUserId())
                .field("orgId",form.getOrgId())
                .field("orgName",form.getOrgName())
                .field("deptId",form.getDeptId())
                .field("deptName",form.getDeptName())
                .field("womenPositionId",form.getWomenPositionId())
                .field("womenPosition",form.getWomenPosition())
                .field("positionTypeCode",form.getPositionTypeCode())
                .field("positionTypeName",form.getPositionTypeName())
                .field("servedTime",form.getServedTime())
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
    public int[] batchAddUserOrg(UserOrgForm.BatchAdd form){
        Sql sql = Sql.insert("t_user_org")
                .field("userId")
                .field("orgId")
                .field("orgName")
                .field("deptId")
                .field("deptName")
                .field("womenPositionId")
                .field("womenPosition")
                .field("positionTypeCode")
                .field("positionTypeName")
                .field("servedTime")
                .field("operator")
                .field("del")
                .field("createTime")
                .field("updateTime");
        List<Object[]> params = new ArrayList<>();
        for (UserOrgForm.Add add : form.getList()){
            params.add(
                    new Object[]{
                            form.getUserId(),
                            add.getOrgId(),
                            add.getOrgName(),
                            add.getDeptId(),
                            add.getDeptName(),
                            add.getWomenPositionId(),
                            add.getWomenPosition(),
                            add.getPositionTypeCode(),
                            add.getPositionTypeName(),
                            add.getServedTime(),
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
     * @date: Created in 2020-10-20 17:01
     * @param form
     * @return: int
     * @exception:
     */
    public int editUserOrg(UserOrgForm.Edit form){
        Sql sql = Sql.update("t_user_org")
                .setIfNotNull("orgId",form.getOrgId())
                .setIfNotBlank("orgName",form.getOrgName())
                .setIfNotBlank("deptId",form.getDeptId())
                .setIfNotBlank("deptName",form.getDeptName())
                .setIfNotNull("womenPositionId",form.getWomenPositionId())
                .setIfNotBlank("womenPosition",form.getWomenPosition())
                .setIfNotBlank("positionTypeCode",form.getPositionTypeCode())
                .setIfNotBlank("positionTypeName",form.getPositionTypeName())
                .setIfNotNull("servedTime",form.getServedTime())
                .setIfNotBlank("operator",form.getOperator())
                .set("updateTime",new Date())
                .where()
                .andEq("id",form.getId());
        return jdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    /**
     * @description: 删除数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 17:01
     * @param form
     * @return: int
     * @exception:
     */
    public int delUserOrg(UserOrgForm.Del form){
        Sql sql = Sql.delete("t_user_org")
                .where()
                .andEq("userId", form.getUserId());
        return jdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    public int delById(UserOrgForm.Del form){
        Sql sql = Sql.update("t_user_org")
                .set("del",1)
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    /**
     * @description: 批量删除数据
     * @author: zhangsq
     * @date: Created in 2020-10-21 11:08
     * @param userIdList
     * @return: int
     * @exception:
     */
    public int batchDelUserOrg(List<Long> userIdList){
        Sql sql = Sql.update("t_user_org")
                .set("del",1)
                .where()
                .andIn("userId",userIdList);
        return jdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    /**
     * @description 根据用户id查询用户所在的机构
     * @author zlx
     * @date 2020/10/24 14:05
     * @param form
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserOrg>
     */
    public List<UserOrg> findUserOrgByUserId(UserOrgForm.Search form){
        Sql sql = Sql.select()
                .field("t.*")
                .field("IF(b.userPlatform=t.orgId,1,0)","major")
                .from("t_user_org","t")
                .leftJoin("base_account","b")
                .on("t.userId","b.id")
                .where()
                .andEq("t.del",0)
                .andEq("t.userId",form.getUserId())
                .orderBy().desc("major");
        return jdbcHelper.queryForListBean(sql.getSql().toString(),UserOrg.class,sql.getParams().toArray());
    }

    /**
     * @description 根据组织机构id进行统计
     * @author zlx
     * @date 2020/10/28 15:21
     * @param form
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public Map<String,Object> findStatistics(UserOrgForm.Get form){
        Sql sql = Sql.select()
                .field("SUM(IF(c.sex ='男',1,0)) as man")
                .field("SUM(IF(c.sex ='女',1,0)) AS woman")
                .field("SUM(CASE WHEN c.age BETWEEN 20 AND 24 THEN 1 ELSE 0 END) age1")
                .field("SUM(CASE WHEN c.age BETWEEN 25 AND 29 THEN 1 ELSE 0 END) age2")
                .field("SUM(CASE WHEN c.age BETWEEN 30 AND 34 THEN 1 ELSE 0 END) age3")
                .field("SUM(CASE WHEN c.age BETWEEN 35 AND 39 THEN 1 ELSE 0 END) age4")
                .field("SUM(CASE WHEN c.age BETWEEN 40 AND 44 THEN 1 ELSE 0 END) age5")
                .field("SUM(CASE WHEN c.age BETWEEN 45 AND 49 THEN 1 ELSE 0 END) age6")
                .field("SUM(CASE WHEN c.age BETWEEN 50 AND 54 THEN 1 ELSE 0 END) age7")
                .field("SUM(CASE WHEN c.age BETWEEN 55 AND 59 THEN 1 ELSE 0 END) age8")
                .field("SUM(CASE WHEN c.age BETWEEN 60 AND 64 THEN 1 ELSE 0 END) age9")
                .field("SUM(CASE WHEN c.age >65 THEN 1 ELSE 0 END) age10")
                .from(Sql.select()
                        .field("b.userId,b.`name`,b.sex")
                        .field("TIMESTAMPDIFF(YEAR, b.birthday, CURDATE()) as age")
                        .from("t_user_org","t")
                        .join("base_user","b")
                        .on("t.userId","b.userId")
                        .where()
                        .andEq("t.orgId",form.getOrgId())
                        .andEq("t.del",0),"c");
        return jdbcHelper.queryForMap(sql.getSql().toString(),sql.getParams().toArray());
    }

    /**
     * @description 根据机构id分页查询人员数据
     * @author zlx
     * @date 2020/10/28 17:53
     * @param form
     * @param curPage
     * @param pageSize
     * @param calCount
     * @param allList
     * @return com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.UserOrg>
     */
    public Page<UserOrg> findUserOrgPageByOrgId(UserOrgForm.Get form,int curPage,int pageSize,boolean calCount,boolean allList){
        Sql sql = Sql.select()
                .field("b.`name`,b.cardNo,b.birthday,b.mobile,b.sex")
                .field("t.*")
                .from("t_user_org","t")
                .join("base_user","b")
                .on("t.userId","b.userId")
                .where()
                .andEq("t.orgId",form.getOrgId())
                .andEq("t.del",0);
        return jdbcHelper.queryForPageBean(sql.getSql().toString(),UserOrg.class,sql.getParams().toArray(),curPage,pageSize,calCount,allList);
    }

    /**
     * @description 根据机构id和部门id查询信息
     * @author zlx
     * @date 2020/11/23 16:13
     * @param form
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserOrg>
     */
    public List<UserOrg> checkUserOrgByOrgIdAndDeptId(UserOrgForm.Get form){
        Sql sql = Sql.select()
                .from("t_user_org")
                .where()
                .andEq("orgId",form.getOrgId())
                .andEq("deptId",form.getDeptId())
                .andEq("del",0);
        return jdbcHelper.queryForListBean(sql.getSql().toString(),UserOrg.class,sql.getParams().toArray());
    }

}
