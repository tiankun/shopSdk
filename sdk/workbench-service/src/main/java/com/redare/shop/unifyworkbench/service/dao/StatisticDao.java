package com.redare.shop.unifyworkbench.service.dao;

import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.ActivityStatistic;
import com.redare.shop.unifyworkbench.sdk.pojo.Area;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StatisticDao {
    @Autowired
    SpringJdbcHelper jdbcHelper;

    /**
     *  根据培训类型统计活动次数、活动占比
     * @return
     */
    public ActivityStatistic findStatisticsByTrainType(){
        StringBuilder sql=new StringBuilder();
        sql.append(" select numberWeiQuan,numberJob,numberFimary,numberFaZhan,ROUND((numberWeiQuan / totalCount) * 100,2) as percentageWeiquan,");
        sql.append("ROUND((numberJob / totalCount) * 100,2) as percentageJob,");
        sql.append("ROUND((numberFimary / totalCount) * 100,2) as percentageFimary,");
        sql.append("ROUND((numberFaZhan / totalCount) * 100,2) as percentageFaZhan from (");
        sql.append(" select sum(case when trainType='权益类' then 1 else 0 end) as numberWeiQuan,sum(case when trainType='就业类' then 1 else 0 end ) as numberJob, ");
        sql.append(" sum(case when trainType='家庭类' then 1 else 0 end) as numberFimary,sum(case when trainType='发展类' then 1 else 0 end) as numberFaZhan ,");
        sql.append("count(*) as totalCount from t_activity ) a");
        return jdbcHelper.queryForBean(sql.toString(),ActivityStatistic.class);

    }

    /**
     * 地区指数
     * @return
     */
    public  ActivityStatistic statisticCountArea(){
        StringBuilder sql=new StringBuilder();
        sql.append(" select * from (select sum(case when areaLevel=1 then 1 else 0 end ) as sjNumber, sum(case when areaLevel=2 then 1 else 0 end ) as zsNumber,sum(case when areaLevel=3 then 1 else 0 end ) as qxNumber,sum(case when areaLevel=4 then 1 else 0 end ) as xzNumber,sum(case when areaLevel=5 then 1 else 0 end ) as csNumber from t_organization where status=1) a ");
        sql.append(" cross join");
        sql.append(" (select count(*) as totalActivity from t_activity) b");
        sql.append(" cross join");
        sql.append(" (select count(*) as joinCount from t_activity_sign) c");

        return jdbcHelper.queryForBean(sql.toString(),ActivityStatistic.class);
    }

    public List<Area> fingAreaList(){
        String sql=" select areaCode from t_area where level=2";
        return jdbcHelper.queryForListBean(sql.toString(),Area.class);

    }

    /**
     * @description 统计区域下的活动次数
     * @author zlx
     * @date 2020/11/14 15:34
     * @param areaCode
     * @return java.lang.Integer
     */
    public ActivityStatistic findActivityCount(String areaCode){
        Sql sql = Sql.select()
                .field("count(1)","activityCount")
                .from("t_activity")
                .where()
                .andRlikeIf(StringUtils.isNotBlank(areaCode),"areaCode",
                        StringUtils.isBlank(areaCode) ? "" : areaCode.replaceAll("(0)+$", ""))
                ;
        return jdbcHelper.queryForBean(sql.getSql().toString(),ActivityStatistic.class,sql.getParams().toArray());
    }

    /**
     * @description 查询该区域下的人员数
     * @author zlx
     * @date 2020/11/14 15:43
     * @param areaCode
     * @return java.lang.Integer
     */
    public ActivityStatistic findActivityPersonCount(String areaCode){
        Sql sql = Sql.select()
                .field("count(1)","joinCount")
                .from(Sql.select()
                        .field("s.*")
                        .from("t_activity_sign","s")
                        .join("t_activity","a")
                        .on("s.activityId","a.id")
                        .where()
                        .andRlikeIf(StringUtils.isNotBlank(areaCode),"a.areaCode",
                                StringUtils.isBlank(areaCode) ? "" : areaCode.replaceAll("(0)+$", "")),"b");
        return jdbcHelper.queryForBean(sql.getSql().toString(),ActivityStatistic.class,sql.getParams().toArray());
    }

    /**
     * 执委统计
     * @return
     */
    public  ActivityStatistic executiveMemberCount(String areaCode){
        Sql sql = Sql.select()
                .field("count(1)","executiveMemberCount")
                .from(Sql.select()
                        .field("u.*")
                        .field("o.areaCode,o.areaName")
                        .from("t_user_org","u")
                        .join("t_organization","o")
                        .on("u.orgId","o.orgId")
                        .where()
                        .andEq("u.del",0)
                        .andRlikeIf(StringUtils.isNotBlank(areaCode),"o.areaCode",
                                StringUtils.isBlank(areaCode) ? "" : areaCode.replaceAll("(0)+$", "")),"b")
                        .where()
                        .andEq("b.womenPositionId",300);
        return jdbcHelper.queryForBean(sql.toString(),ActivityStatistic.class,sql.getParams().toArray());

    }

    /**
     * 数字阵地统计
     * @return
     */
    public  ActivityStatistic szzdNumberStatistic(String areaCode){
        Sql sql = Sql.select()
                .field("count(1)","szzdNumber")
                .from(Sql.select()
                        .field("t.*")
                        .from("t_school_numberposition","t")
                        .join("t_organization","o")
                        .on("t.orgId","o.orgId")
                        .where()
                        .andRlikeIf(StringUtils.isNotBlank(areaCode),"o.areaCode",
                                StringUtils.isBlank(areaCode) ? "" : areaCode.replaceAll("(0)+$", "")),"b");
        return jdbcHelper.queryForBean(sql.toString(),ActivityStatistic.class,sql.getParams().toArray());

    }

    /**
     * 素材分类占比
     * @return
     */
    public  List<ActivityStatistic> materailCountStatistic(){
        StringBuilder sql=new StringBuilder();
        sql.append("select materailNumber,markName,ROUND((materailNumber / totalCount) * 100,2) as percentageMaterail from ");
        sql.append(" (select count(*) as materailNumber,markId,markName from t_school_material GROUP  by markId,markName) a ");
        sql.append(" cross join ( select count(*) as totalCount from t_school_material) b");
        return jdbcHelper.queryForListBean(sql.toString(),ActivityStatistic.class);

    }

    /**
     * 活动分类占比
     * @return
     */

    public  List<ActivityStatistic> activityByTypeCountStatistic(){
        StringBuilder sql=new StringBuilder();
        sql.append("select activityCountByType,trainType,ROUND((activityCountByType / totalCount) * 100,2) as percentageActivity from ");
        sql.append(" (select count(*) as activityCountByType,trainType from t_activity GROUP by trainType) a ");
        sql.append(" cross join ( select count(*) as totalCount from t_activity) b");
        return jdbcHelper.queryForListBean(sql.toString(),ActivityStatistic.class);


    }


    /**
     * 根据州市统计妇联数量、活动数量、活动人次(地区指数)
     * @return
     */
    public  List<ActivityStatistic> findTotalStatisticCountByZs(){
        StringBuilder sql=new StringBuilder();
        sql.append("select a.areaCode as areaCode,a.areaName as areaName,IFNULL(activityCount,0) as activityCount,IFNULL(joinCount,0) as joinCount,IFNULL(orgNum,0) as orgNum from (select areaCode,areaName from t_area where `level`=2) a ");
        sql.append(" left join ");
        sql.append(" (select count(*) as activityCount,'530100' as areaCode   from t_activity where areaCode like '5301%'" );
        sql.append(" union all select count(*) as activityCount,'530300' as areaCode   from t_activity where areaCode like '5303%' ");
        sql.append(" union all select count(*) as activityCount,'530400' as areaCode   from t_activity where areaCode like '5304%' ");
        sql.append(" union all select count(*) as activityCount,'530500' as areaCode   from t_activity where areaCode like '5305%' ");
        sql.append(" union all select count(*) as activityCount,'530600' as areaCode   from t_activity where areaCode like '5306%' ");
        sql.append(" union all select count(*) as activityCount,'530700' as areaCode   from t_activity where areaCode like '5307%' ");
        sql.append(" union all select count(*) as activityCount,'530800' as areaCode   from t_activity where areaCode like '5308%' ");
        sql.append(" union all select count(*) as activityCount,'530900' as areaCode   from t_activity where areaCode like '5309%' ");
        sql.append(" union all select count(*) as activityCount,'532300' as areaCode   from t_activity where areaCode like '5323%' ");
        sql.append(" union all select count(*) as activityCount,'532500' as areaCode   from t_activity where areaCode like '5325%' ");
        sql.append(" union all select count(*) as activityCount,'532600' as areaCode   from t_activity where areaCode like '5326%' ");
        sql.append(" union all select count(*) as activityCount,'532800' as areaCode   from t_activity where areaCode like '5328%' ");
        sql.append(" union all select count(*) as activityCount,'532900' as areaCode   from t_activity where areaCode like '5329%' ");
        sql.append(" union all select count(*) as activityCount,'533100' as areaCode   from t_activity where areaCode like '5331%' ");
        sql.append(" union all select count(*) as activityCount,'533300' as areaCode   from t_activity where areaCode like '5333%' ");
        sql.append(" union all select count(*) as activityCount,'533400' as areaCode   from t_activity where areaCode like '5334%' ");
        sql.append(      ")t1 on a.areaCode=t1.areaCode ");
        sql.append(" left join ");

        sql.append(" (select count(*) as orgNum,'530100' as areaCode   from t_organization where status=1 and  areaCode like '5301%'" );
        sql.append(" union all select count(*) as orgNum,'530300' as areaCode   from t_organization where status=1 and areaCode like '5303%' ");
        sql.append(" union all select count(*) as orgNum,'530400' as areaCode   from t_organization where status=1 and areaCode like '5304%' ");
        sql.append(" union all select count(*) as orgNum,'530500' as areaCode   from t_organization where status=1 and areaCode like '5305%' ");
        sql.append(" union all select count(*) as orgNum,'530600' as areaCode   from t_organization where status=1 and areaCode like '5306%' ");
        sql.append(" union all select count(*) as orgNum,'530700' as areaCode   from t_organization where status=1 and areaCode like '5307%' ");
        sql.append(" union all select count(*) as orgNum,'530800' as areaCode   from t_organization where status=1 and areaCode like '5308%' ");
        sql.append(" union all select count(*) as orgNum,'530900' as areaCode   from t_organization where status=1 and areaCode like '5309%' ");
        sql.append(" union all select count(*) as orgNum,'532300' as areaCode   from t_organization where status=1 and areaCode like '5323%' ");
        sql.append(" union all select count(*) as orgNum,'532500' as areaCode   from t_organization where status=1 and areaCode like '5325%' ");
        sql.append(" union all select count(*) as orgNum,'532600' as areaCode   from t_organization where status=1 and areaCode like '5326%' ");
        sql.append(" union all select count(*) as orgNum,'532800' as areaCode   from t_organization where status=1 and  areaCode like '5328%' ");
        sql.append(" union all select count(*) as orgNum,'532900' as areaCode   from t_organization where status=1 and  areaCode like '5329%' ");
        sql.append(" union all select count(*) as orgNum,'533100' as areaCode   from t_organization where status=1 and  areaCode like '5331%' ");
        sql.append(" union all select count(*) as orgNum,'533300' as areaCode   from t_organization where status=1 and areaCode like '5333%' ");
        sql.append(" union all select count(*) as orgNum,'533400' as areaCode   from t_organization where status=1 and areaCode like '5334%' ");
        sql.append(      ")t2 on a.areaCode=t2.areaCode ");

        sql.append(" left join ");

        sql.append(" (select count(*) as joinCount,'530100' as areaCode   from  (select * from t_activity_sign) a left join (select * from t_activity) b on a.activityId=b.id where  b.areaCode like '5301%'" );
        sql.append(" union all select count(*) as joinCount,'530300' as areaCode  from (select * from t_activity_sign) a left join (select * from t_activity) b on a.activityId=b.id where  b.areaCode like '5303%' ");
        sql.append(" union all select count(*) as joinCount,'530400' as areaCode   from (select * from t_activity_sign) a left join (select * from t_activity) b on a.activityId=b.id where  b.areaCode like '5304%' ");
        sql.append(" union all select count(*) as joinCount,'530500' as areaCode   from (select * from t_activity_sign) a left join (select * from t_activity) b on a.activityId=b.id where  b.areaCode like '5305%' ");
        sql.append(" union all select count(*) as joinCount,'530600' as areaCode   from (select * from t_activity_sign) a left join (select * from t_activity) b on a.activityId=b.id where  b.areaCode like '5306%' ");
        sql.append(" union all select count(*) as joinCount,'530700' as areaCode   from (select * from t_activity_sign) a left join (select * from t_activity) b on a.activityId=b.id where  b.areaCode like '5307%' ");
        sql.append(" union all select count(*) as joinCount,'530800' as areaCode   from (select * from t_activity_sign) a left join (select * from t_activity) b on a.activityId=b.id where  b.areaCode like '5308%' ");
        sql.append(" union all select count(*) as joinCount,'530900' as areaCode   from (select * from t_activity_sign) a left join (select * from t_activity) b on a.activityId=b.id where  b.areaCode like '5309%' ");
        sql.append(" union all select count(*) as joinCount,'532300' as areaCode   from (select * from t_activity_sign) a left join (select * from t_activity) b on a.activityId=b.id where  b.areaCode like '5323%' ");
        sql.append(" union all select count(*) as joinCount,'532500' as areaCode   from (select * from t_activity_sign) a left join (select * from t_activity) b on a.activityId=b.id where  b.areaCode like '5325%' ");
        sql.append(" union all select count(*) as joinCount,'532600' as areaCode   from (select * from t_activity_sign) a left join (select * from t_activity) b on a.activityId=b.id where  b.areaCode like '5326%' ");
        sql.append(" union all select count(*) as joinCount,'532800' as areaCode   from (select * from t_activity_sign) a left join (select * from t_activity) b on a.activityId=b.id where  b.areaCode like '5328%' ");
        sql.append(" union all select count(*) as joinCount,'532900' as areaCode   from (select * from t_activity_sign) a left join (select * from t_activity) b on a.activityId=b.id where  b.areaCode like '5329%' ");
        sql.append(" union all select count(*) as joinCount,'533100' as areaCode   from (select * from t_activity_sign) a left join (select * from t_activity) b on a.activityId=b.id where  b.areaCode like '5331%' ");
        sql.append(" union all select count(*) as joinCount,'533300' as areaCode   from (select * from t_activity_sign) a left join (select * from t_activity) b on a.activityId=b.id where  b.areaCode like '5333%' ");
        sql.append(" union all select count(*) as joinCount,'533400' as areaCode   from (select * from t_activity_sign) a left join (select * from t_activity) b on a.activityId=b.id where  b.areaCode like '5334%' ");
        sql.append(      ")t3 on a.areaCode=t3.areaCode ");
        return jdbcHelper.queryForListBean(sql.toString(),ActivityStatistic.class);

    }






}
