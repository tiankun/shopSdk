package com.redare.shop.unifyworkbench.service.dao;


import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.MySqlJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.ActivitySign;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ActivitySignForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * (ActivitySign)表数据库访问层
 *
 * @author dengchj
 * @since 2020-10-20 17:34:45
 */
@Repository
public class ActivitySignDao {
    private static final String TABLE = "t_activity_sign";
    @Autowired
    MySqlJdbcHelper jdbcHelper;

    public long insertActivitySign(ActivitySignForm.Add form) {
        Sql sql = Sql.insert(TABLE)
                .field("userId", form.getUserId())
                .field("userName", form.getUserName())
                .field("depId", form.getDepId())
                .field("depName", form.getDepName())
                .field("orgId", form.getOrgId())
                .field("orgName", form.getOrgName())
                .field("areaCode", form.getAreaCode())
                .field("areaName", form.getAreaName())
                .field("sex", form.getSex())
                .field("postion",form.getPostion())
                .field("telphone", form.getTelphone())
                .field("postDate", form.getPostDate())
                .field("signTime", new Date())
                .field("birthDate", form.getBirthDate())
                .field("educationLevel", form.getEducationLevel())
                .field("status", form.getStatus())
                .field("activityId",form.getActivityId())
                .field("type", form.getType());
        return jdbcHelper.insertReturnFieldNumber(sql).longValue();
    }

    public Page<ActivitySign> queryForPageActivitySign(ActivitySignForm.Search form, int curPage, int pageSize, boolean calCount, boolean allList) {
        Sql sql = Sql.select()
                .field("id")
                .field("activityId")
                .field("userId")
                .field("userName")
                .field("depId")
                .field("depName")
                .field("orgId")
                .field("orgName")
                .field("areaCode")
                .field("areaName")
                .field("sex")
                .field("postion")
                .field("telphone")
                .field("postDate")
                .field("signTime")
                .field("birthDate")
                .field("educationLevel")
                .field("status")
                .field("type")
                .from(TABLE)
                .where()
                .andEqIfNotNull("activityId",form.getActivityId())
                .andEqIfNotNull("type",form.getType())
                .orderBy().desc("id");
        return jdbcHelper.queryForPageBean(sql.getSql().toString(), ActivitySign.class, sql.getParams().toArray(), curPage, pageSize, calCount, allList);
    }

    public List<ActivitySign> queryForListActivitySign(ActivitySignForm.Search form) {
        Sql sql = Sql.select()
               .fields("a.*")
                .field("b.title","activityTitle")
                .from("t_activity_sign","a")
                .leftJoin("t_activity","b")
                .on("a.activityId","b.id")
                .where()
                .andEqIfNotNull("a.type",form.getType())
                .andEqIfNotNull("a.id", form.getId())
                .andEqIfNotNull("a.userId",form.getUserId())
                .andEqIfNotNull("a.orgId",form.getOrgId())
                .andEqIfNotNull("a.activityId", form.getActivityId())
                .orderBy().desc("a.id");
        return jdbcHelper.queryForListBean(sql.getSql().toString(), ActivitySign.class, sql.getParams().toArray());
    }

    public int updateActivitySign(ActivitySign form) {
        Sql sql = Sql.update(TABLE)
                .setIfNotNull("userId", form.getUserId())
                .setIfNotBlank("userName", form.getUserName())
                .setIfNotNull("depId", form.getDepId())
                .setIfNotBlank("depName", form.getDepName())
                .setIfNotNull("orgId", form.getOrgId())
                .setIfNotBlank("orgName", form.getOrgName())
                .setIfNotBlank("areaCode", form.getAreaCode())
                .setIfNotBlank("areaName", form.getAreaName())
                .setIfNotBlank("sex", form.getSex())
                .setIfNotNull("postion",form.getPostion())
                .setIfNotBlank("telphone", form.getTelphone())
                .setIfNotNull("postDate", form.getPostDate())
                .setIfNotNull("signTime", form.getSignTime())
                .setIfNotNull("birthDate", form.getBirthDate())
                .setIfNotBlank("educationLevel", form.getEducationLevel())
                .setIfNotBlank("status", form.getStatus())
                .setIfNotNull("activityId",form.getActivityId())
                .setIfNotNull("type", form.getType())
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.update(sql);
    }

    public int deleteActivitySign(CommonForm.Del form) {
        Sql sql = Sql.delete(TABLE)
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.update(sql);
    }

    public int batchDelActivitySign(CommonForm.BatchDel form) {
        Sql sql = Sql.delete(TABLE)
                .where()
                .andIn("id", form.getIds());
        return jdbcHelper.update(sql);
    }

    public List<ActivitySign> signCount(ActivitySignForm.Get form){
        String sql=" select count(*) as  manCount ,'全部' as type from t_activity_sign where activityId="+form.getActivityId()+"  union all select count(*) as  manCount ,'内部' as type from t_activity_sign where type=0 and activityId="+form.getActivityId()+"  union all select count(*) as  manCount ,'群众' as type from t_activity_sign where type=1 and activityId="+form.getActivityId()+"  union all select count(*) as  manCount ,'巾帼志愿者' as type from t_activity_sign where type=2 and activityId="+form.getActivityId()+" ";
        return jdbcHelper.queryForListBean(sql, ActivitySign.class);

    }


    /**
     * 批量添加签到记录

     */
    public int[] batchAddSignInfo(ActivitySignForm.BatchAdd form) {
        Sql sql = Sql.insert("t_activity_sign")
                .field("activityId")
                .field("userId")
                .field("userName")
                .field("sex")
                .field("telphone")
                .field("signTime")
                .field("birthDate")
                .field("educationLevel")
                .field("type");

        List<Object[]> params = new ArrayList<>();
        for (ActivitySignForm.Add item : form.getAddList()) {
            params.add(
                    new Object[]{
                            item.getActivityId(),
                            item.getUserId(),
                            item.getUserName(),
                            item.getSex(),
                            item.getTelphone(),
                            item.getSignTime(),
                            item.getBirthDate(),
                            item.getEducationLevel(),
                            item.getType()

                    }
            );
        }
        return jdbcHelper.batchUpdate(sql.toString(), params);
    }

    public boolean existSign(ActivitySignForm.Search form){
        Sql countSql = Sql.select().field("count(*)").from("t_activity_sign").where().andEq("userName",form.getUserName() ).andEq("birthDate",form.getBirthDate()).andEq("activityId",form.getActivityId()).andEq("type",form.getType());
        return  jdbcHelper.queryForNumber(countSql).intValue()>0;

    }

    /**
     * 内部签到是否存在
     * @param form
     * @return
     */
    public boolean existNeiBuSign(ActivitySignForm.Search form){
        Sql countSql = Sql.select().field("count(*)").from("t_activity_sign").where().andEq("userId",form.getUserId()).andEq("activityId",form.getActivityId()).andEq("orgId",form.getOrgId()).andEq("type","0");
        return  jdbcHelper.queryForNumber(countSql).intValue()>0;

    }
    /**
     * 根据活动id删除签到信息
     */
    public int deleteActivitySignByActivityId(ActivitySignForm.DelByActivityId form) {
        Sql sql = Sql.delete(TABLE)
                .where()
                .andEq("activityId", form.getActivityId());
        return jdbcHelper.update(sql);
    }

    /**
     * 根据活动id批量删除签到信息
     */
    public int batchDeleteActivitySignByActivityId(ActivitySignForm.BatchDelByActivityId form) {
        Sql sql = Sql.delete(TABLE)
                .where()
                .andIn("activityId", form.getActivityIds());
        return jdbcHelper.update(sql);
    }
    /**
     * 根据activityId和type删除签到信息
     */

    public int deleteSignByActivityIdAndType(ActivitySignForm.DelByActivityIdAndType form) {
        Sql sql = Sql.delete(TABLE)
                .where()
                .andEqIfNotNull("activityId", form.getActivityId())
                .andEqIfNotNull("type",form.getType());
        return jdbcHelper.update(sql);
    }
}