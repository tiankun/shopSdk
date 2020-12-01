package com.redare.shop.unifyworkbench.service.dao;


import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.sql.Criteria;
import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.MySqlJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.Activity;
import com.redare.shop.unifyworkbench.sdk.pojo.ActivityHeatmap;
import com.redare.shop.unifyworkbench.sdk.pojo.User;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ActivityForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserOrgForm;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 活动管理(Activity)表数据库访问层
 *
 * @author dengchj
 * @since 2020-10-19 18:03:44
 */
@Repository
public class ActivityDao {
    private static final String TABLE = "t_activity";
    @Autowired
    MySqlJdbcHelper jdbcHelper;

    public Integer insertActivity(ActivityForm.Add form) {
        Sql sql = Sql.insert(TABLE)
                .field("title", form.getTitle())
                .field("place", form.getPlace())
                .field("beginDate", form.getBeginDate())
                .field("endDate", form.getEndDate())
                .field("activityType", form.getActivityType())
                .field("trainType", form.getTrainType())
                .field("orgId", form.getOrgId())
                .field("orgName", form.getOrgName())
                .field("departId", form.getDepartId())
                .field("departName", form.getDepartName())
                .field("areaCode", form.getAreaCode())
                .field("areaName", form.getAreaName())
                .field("joinCount", form.getJoinCount())
                .field("leaderId", form.getLeaderId())
                .field("leaderName", form.getLeaderName())
                .field("telphone", form.getTelphone())
                .field("createUserId", form.getCreateUserId())
                .field("createUserName", form.getCreateUserName())
                .field("createTime", new Date())
                .field("updateTime", new Date())
                .field("status",0)
                .field("description", form.getDescription())
                .field("picture", form.getPicture());
        return jdbcHelper.insertReturnFieldNumber(sql).intValue();
    }

    public Page<Activity> queryForPageActivity(ActivityForm.Search form, int curPage, int pageSize, boolean calCount, boolean allList) {
        Sql sql = Sql.select()
                .field("id")
                .field("title")
                .field("place")
                .field("beginDate")
                .field("endDate")
               // .field("DATE_FORMAT(beginDate,'%Y-%m-%d')","beginDate")
                //.field("DATE_FORMAT(endDate,'%Y-%m-%d')","endDate")
                .field("activityType")
                .field("trainType")
                .field("orgId")
                .field("orgName")
                .field("departId")
                .field("top")
                .field("departName")
                .field("areaCode")
                .field("areaName")
                .field("joinCount")
                .field("leaderId")
                .field("leaderName")
                .field("telphone")
                .field("createUserId")
                .field("createUserName")
                .field("createTime")
                .field("updateTime")
                .field("status")
                .field("sort")
                .field("description")
                .field("picture")
                .field("case when now()<beginDate then '0' when now() between beginDate and endDate then '1' else '2' end" , "zt" )
                //.field("zt")
                .from(TABLE)
                .where()
                .andJoinByOrIf(form.getZt() != null, () -> Arrays.asList(
                        Criteria.ifTimeStatus(form.getZt(), "beginDate", "endDate")))
                //.andEqIfNotNull("zt",form.getZt())
                .andBlikeJoinByOrIfNotBlank(form.getKey(), "title","orgName")
                .andEqIfNotBlank("DATE_FORMAT(beginDate,'%Y-%m-%d')",form.getBeginDate())
                .andEqIfNotNull("orgId",form.getOrgId())
                .andEqIfNotNull("top",form.getTop())
                .andEqIfNotNull("status",form.getStatus())
                .andEqIfNotNull("userId",form.getUserId())
                .andEqIfNotNull("activityType",form.getActivityType())
                .andEqIfNotNull("trainType",form.getTrainType())
                .orderBy()

                       .desc("top","updateTime");
        return jdbcHelper.queryForPageBean(sql.getSql().toString(), Activity.class, sql.getParams().toArray(), curPage, pageSize, calCount, allList);
    }

    public List<Activity> queryForListActivity(ActivityForm.Search form,int curPage, int pageSize) {
        Sql sql = Sql.select()
                .field("a.id","id")
                .field("title")
                .field("place")
                .field("beginDate")
                .field("endDate")
                .field("activityType")
                .field("trainType")
                .field("orgId")
                .field("orgName")
                .field("departId")
                .field("departName")
                .field("areaCode")
                .field("areaName")
                .field("joinCount")
                .field("leaderId")
                .field("leaderName")
                .field("telphone")
                .field("createUserId")
                .field("createUserName")
                .field("createTime")
                .field("updateTime")
                .field("status")
                .field("top")
                .field("sort")
                .field("picture")
                .field("description")
                .field("b.url","signUrl")
                .field("case when now()<beginDate then '0' when now() between beginDate and endDate then '1' else '2' end" , "zt" )

                //.field("zt")
                .from(TABLE,"a")
                .join("t_activity_config","b")
                .where()
                .andJoinByOrIf(form.getZt() != null, () -> Arrays.asList(
                        Criteria.ifTimeStatus(form.getZt(), "a.beginDate", "a.endDate")))
                .andEqIfNotNull("a.id", form.getId())
                //.andEqIfNotNull("DATE_FORMAT(a.beginDate,'%Y-%m-%d')",form.getBeginDate())
                .andEqIfNotNull("a.top",form.getTop())
                .andEq("a.status",1)
                .andEqIfNotNull("a.orgId",form.getOrgId())
                .andEqIfNotNull("a.userId",form.getUserId())
                .andEqIfNotNull("a.areaName",form.getAreaName())
                .andEqIfNotNull("a.areaCode",form.getAreaCode())
                .andEqIfNotNull("a.activityType",form.getActivityType())
                .andEqIfNotNull("a.trainType",form.getTrainType())
                .andBlikeJoinByOrIfNotBlank(form.getKey(), "a.title","a.orgName")
                .andBetweenOptionIf(form.getBeginDate()!=null && form.getEndDate()!=null, "beginDate",form.getBeginDate()+" 00:00:00", form.getEndDate()+" 23:59:59")
                .andGtEqIf(form.getBeginDate()!=null &&form.getEndDate()==null, "beginDate",form.getBeginDate()+" 00:00:00")
                .andLtEqIf(form.getEndDate()!=null && form.getBeginDate()==null, "beginDate", form.getEndDate()+" 23:59:59")
                .orderBy()
                .desc("a.top","a.updateTime");

        return jdbcHelper.queryForListBean(sql.getSql().toString(), Activity.class, sql.getParams().toArray(),curPage,pageSize);
    }


    public Activity getActivityInfo(ActivityForm.Search form) {
        Sql sql = Sql.select()
                .field("a.id","id")
                .field("title")
                .field("place")
                .field("beginDate")
                .field("endDate")
                .field("activityType")
                .field("trainType")
                .field("orgId")
                .field("orgName")
                .field("departId")
                .field("departName")
                .field("areaCode")
                .field("areaName")
                .field("joinCount")
                .field("leaderId")
                .field("leaderName")
                .field("telphone")
                .field("createUserId")
                .field("createUserName")
                .field("createTime")
                .field("updateTime")
                .field("status")
                .field("top")
                .field("sort")
                .field("description")
                .field("picture")
                .field("b.url","signUrl")
                .field("case when now()<beginDate then '未开始' when now() between beginDate and endDate then '进行中' else '已结束' end" , "zt" )
                //.field("zt")
                .from(TABLE,"a")
                .join("t_activity_config","b")
                .where()
                .andEqIfNotNull("a.id", form.getId())
                .orderBy().desc("a.id");
        return jdbcHelper.queryForBean(sql.getSql().toString(), Activity.class, sql.getParams().toArray());
    }

    public int updateActivity(ActivityForm.Edit form) {
        Sql sql = Sql.update(TABLE)
                .setIfNotBlank("title", form.getTitle())
                .setIfNotBlank("place", form.getPlace())
                .setIfNotNull("beginDate", form.getBeginDate())
                .setIfNotNull("endDate", form.getEndDate())
                .setIfNotBlank("activityType", form.getActivityType())
                .setIfNotBlank("trainType", form.getTrainType())
                .setIfNotNull("orgId", form.getOrgId())
                .setIfNotBlank("orgName", form.getOrgName())
                .setIfNotNull("departId", form.getDepartId())
                .setIfNotBlank("departName", form.getDepartName())
                .setIfNotBlank("areaCode", form.getAreaCode())
                .setIfNotBlank("areaName", form.getAreaName())
                .setIfNotNull("joinCount", form.getJoinCount())
                .setIfNotNull("leaderId", form.getLeaderId())
                .setIfNotBlank("leaderName", form.getLeaderName())
                .setIfNotBlank("telphone", form.getTelphone())
                .setIfNotNull("createUserId", form.getCreateUserId())
                .setIfNotBlank("createUserName", form.getCreateUserName())
                .set("updateTime", new Date())
                .setIfNotNull("status", form.getStatus())
                .setIfNotBlank("description", form.getDescription())
                .setIfNotNull("picture",form.getPicture())
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    public int deleteActivity(CommonForm.Del form) {
        Sql sql = Sql.delete(TABLE)
                .where()
                .andEq("id", form.getId());
        return jdbcHelper.update(sql);
    }

    public int batchDelActivity(CommonForm.BatchDel form) {
        Sql sql = Sql.delete(TABLE)
                .where()
                .andIn("id", form.getIds());
        return jdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());
    }

    public int updateActivityStatus(ActivityForm.changeStatus form) {
        Sql sql = Sql.update("t_activity")
                .set("status", form.getStatus())
                .where().andEq("id", form.getId());
        return jdbcHelper.update(sql.getSql().toString(),sql.getParams().toArray());

    }

    public List<Activity> activityCountByZt(ActivityForm.Search form){
        /*String sql1="select count(*) as activityCount,'全部' as zt from t_activity  where orgId='"+form.getOrgId()+"'" +
                "union all " +
                " select count(*) as activityCount,'进行中' as zt from t_activity where  orgId='"+form.getOrgId()+"' and now() between beginDate and endDate " +
                "union all " +
                " select count(*) as activityCount ,'未开始' as zt from t_activity where orgId='"+form.getOrgId()+"' and  now()<beginDate " +
                "union all " +
                " select count(*) as activityCount ,'已结束' as zt from t_activity where orgId='"+form.getOrgId()+"' and  now()>endDate";
*/
       StringBuilder sql=new StringBuilder();
        List<Object> params=new ArrayList<>();
       sql.append("select count(*) as activityCount,'全部' as zt from t_activity  where 1=1 ");
       if(form.getOrgId()!=null){
           sql.append(" and orgId='"+form.getOrgId()+"'");
       }
       if(form.getStatus()!=null){
           sql.append(" and status="+form.getStatus()+"");
       }
       if(form.getTop()!=null){
           sql.append(" and top="+form.getTop()+"");
       }
       if(StringUtils.isNotBlank(form.getActivityType())){
           sql.append(" and activityType='"+form.getActivityType()+"'");
       }
        if(StringUtils.isNotBlank(form.getTrainType())){
            sql.append(" and trainType='"+form.getTrainType()+"'");
        }
       if(StringUtils.isNotBlank(form.getKey())){

           sql.append(" and (title like '%"+form.getKey()+"%' or orgName like '%"+form.getKey()+"%' )");
       }
       sql.append(" union all  ");

        sql.append("select count(*) as activityCount,'进行中' as zt from t_activity  where  now() between beginDate and endDate ");
        if(form.getOrgId()!=null){
            sql.append(" and orgId='"+form.getOrgId()+"'");
        }
        if(form.getStatus()!=null){
            sql.append(" and status="+form.getStatus()+"");
        }
        if(form.getTop()!=null){
            sql.append(" and top="+form.getTop()+"");
        }
        if(StringUtils.isNotBlank(form.getActivityType())){
            sql.append(" and activityType='"+form.getActivityType()+"'");
        }
        if(StringUtils.isNotBlank(form.getTrainType())){
            sql.append(" and trainType='"+form.getTrainType()+"'");
        }
        if(StringUtils.isNotBlank(form.getKey())){

            sql.append(" and (title like '%"+form.getKey()+"%' or orgName like '%"+form.getKey()+"%' )");


        }

        sql.append(" union all  ");

        sql.append("select count(*) as activityCount,'未开始' as zt from t_activity  where  now()<beginDate ");
        if(form.getOrgId()!=null){
            sql.append(" and orgId='"+form.getOrgId()+"'");
        }
        if(form.getStatus()!=null){
            sql.append(" and status="+form.getStatus()+"");
        }
        if(form.getTop()!=null){
            sql.append(" and top="+form.getTop()+"");
        }
        if(StringUtils.isNotBlank(form.getActivityType())){
            sql.append(" and activityType='"+form.getActivityType()+"'");
        }
        if(StringUtils.isNotBlank(form.getTrainType())){
            sql.append(" and trainType='"+form.getTrainType()+"'");
        }
        if(StringUtils.isNotBlank(form.getKey())){

            sql.append(" and (title like '%"+form.getKey()+"%' or orgName like '%"+form.getKey()+"%' )");

        }

        sql.append(" union all  ");

        sql.append("select count(*) as activityCount,'已结束' as zt from t_activity  where  now()>endDate ");
        if(form.getOrgId()!=null){
            sql.append(" and orgId='"+form.getOrgId()+"'");
        }
        if(form.getStatus()!=null){
            sql.append(" and status="+form.getStatus()+"");
        }
        if(form.getTop()!=null){
            sql.append(" and top="+form.getTop()+"");
        }
        if(StringUtils.isNotBlank(form.getActivityType())){
            sql.append(" and activityType='"+form.getActivityType()+"'");
        }
        if(StringUtils.isNotBlank(form.getTrainType())){
            sql.append(" and trainType='"+form.getTrainType()+"'");
        }
        if(StringUtils.isNotBlank(form.getKey())){

            sql.append(" and (title like '%"+form.getKey()+"%' or orgName like '%"+form.getKey()+"%' )");


        }
        return jdbcHelper.queryForListBean(sql.toString(),Activity.class,params.toArray());

    }

    public List<User> findUserListByOrgId(UserOrgForm.Get form){

        StringBuilder sql=new StringBuilder();
        List<Object> params=new ArrayList<>();
      sql.append(" select a.userId as userId,b.name as name,b.mobile as mobile from t_user_org a left join base_user b on a.userId = b.userId where a.orgId='"+form.getOrgId()+"'");
        if(StringUtils.isNotBlank(form.getKey())){
            sql.append(" and b.name like '%"+form.getKey()+"%'");
        }
        return  jdbcHelper.queryForListBean(sql.toString(),User.class);



    }

    public List<ActivityHeatmap> groupActivityDayCount(ActivityForm.HeatmapSearch search) {
        Sql sql=Sql.select()
                .field("DATE_FORMAT(beginDate,'%Y-%m-%d')","day")
                .fieldIf(StringUtils.isNotBlank(search.getOrgId()),"orgId")
                .field("count(1)","count")
                .from(TABLE)
                .where()
                .andEqIfNotNull("orgId",search.getOrgId())
                .andEq("DATE_FORMAT(beginDate,'%Y-%m')",search.getYearMonth())
                .groupBy("day");
        return  jdbcHelper.queryForListBean(sql,ActivityHeatmap.class);
    }

    /**
     * 根据组织id统计活动次数、活动参与人数
     * @param form
     * @return
     */
    public Activity findActivityStatics(ActivityForm.Search form){
        StringBuilder sql=new StringBuilder();
        List<Object> params=new ArrayList<>();
        sql.append(" select sum(activityCount) as activityCount,sum(joinCount) as joinCount from (select count(*) as activityCount,id from t_activity " );
        if(form.getOrgId()!=null){
            sql.append(" where orgId=?");
            params.add(form.getOrgId());
        }
          sql.append("group by id) a");
        sql.append("  left join");
        sql.append(" (select count(*) as joinCount,activityId from t_activity_sign group by activityId) b" );
        sql.append(" on a.id=b.activityId");


        /*Sql sql=Sql.select()
                .field(" count(*)","activityCount")
                .from("t_activity")
                .leftJoin()
                .where()
                .andEqIfNotNull("orgId",form.getOrgId());*/
        return  jdbcHelper.queryForBean(sql.toString(),Activity.class,params.toArray());
    }

    /**
     * 置顶
     * @param form
     * @return
     */
    public int updateTopStatus(ActivityForm.Top form) {
        Sql sql = Sql.update("t_activity")
                .set("top", form.getTop())
                .where().andEq("id", form.getId());
        return jdbcHelper.update(sql);
    }


    //设置排序
    public int updateSort(ActivityForm.Sort form) {
        Sql sql = Sql.update("t_activity")
                .set("sort", form.getSort())
                .where().andEq("id", form.getId());
        return jdbcHelper.update(sql);
    }
}
