package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.sql.Sql;
import com.redare.devframework.sql.db.base.SpringJdbcHelper;
import com.redare.shop.unifyworkbench.sdk.pojo.ActivityStatistic;
import com.redare.shop.unifyworkbench.sdk.pojo.form.StatisticForm;
import com.redare.shop.unifyworkbench.service.dao.AreaDao;
import com.redare.shop.unifyworkbench.service.dao.StatisticDao;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticService {
    @Autowired
    StatisticDao statisticDao;
    @Autowired
    SpringJdbcHelper jdbcHelper;
    @Autowired
    AreaDao areaDao;


    public ActivityStatistic findStatisticsByTrainType(StatisticForm statisticForm){
        Sql sql=Sql.select()
                .field(" numberWeiQuan")
                .field("numberJob")
                .field("numberFimary")
                .field("numberFaZhan")
                .field("numberQuanyi")
                .field("ifnull(ROUND((numberWeiQuan / totalCount) * 100,2),0)",  "percentageWeiquan")
                .field("ifnull(ROUND((numberJob / totalCount) * 100,2),0)","percentageJob")
                .field("ifnull(ROUND((numberFimary / totalCount) * 100,2),0)","percentageFimary")
                .field("ifnull(ROUND((numberFaZhan / totalCount) * 100,2),0) ","percentageFaZhan")
                .field("ifnull(ROUND((numberQuanyi / totalCount) * 100,2),0) ","percentageQuanyi")
                .from(Sql.select()
                        .field("ifnull(sum(case when trainType='权益类' then 1 else 0 end),0) ","numberQuanyi")
                                .field("ifnull(sum(case when trainType='维权类' then 1 else 0 end),0) ","numberWeiQuan")
                                .field("ifnull(sum(case when trainType='家庭类' then 1 else 0 end),0) ","numberFimary")
                                .field("ifnull(sum(case when trainType='就业类' then 1 else 0 end),0) ","numberJob")
                                .field("ifnull(sum(case when trainType='发展类' then 1 else 0 end),0) ","numberFaZhan")
                        .field("ifnull(count(*),0)","totalCount")
                        .from(Sql.select()
                        .field("activityId")
                        .field("trainType")
                        .from("t_activity_sign","a")
                                .join("t_activity","b")
                                .on(" a.activityId","b.id")
                                .where()
                                        .andRlikeIf(StringUtils.isNotBlank(statisticForm.getAreaCode()), "b.areaCode", statisticForm.getAreaCode() == null ? "" : statisticForm.getAreaCode().replaceAll("(0)+$", ""))
                       ,"x" )

                ,"t");

        return jdbcHelper.queryForBean(sql.getSql().toString(),ActivityStatistic.class, sql.getParams().toArray());

    }

    public  ActivityStatistic statisticCountArea(){
        return statisticDao.statisticCountArea();
    }

    /**
     * @description 统计区域下的活动次数
     * @author zlx
     * @date 2020/11/14 15:34
     * @param areaCode
     * @return java.lang.Integer
     */
    public ActivityStatistic findActivityCount(String areaCode){
        return statisticDao.findActivityCount(areaCode);
    }

    /**
     * @description 查询该区域下的人员数
     * @author zlx
     * @date 2020/11/14 15:43
     * @param areaCode
     * @return java.lang.Integer
     */
    public ActivityStatistic findActivityPersonCount(String areaCode){
        return statisticDao.findActivityPersonCount(areaCode);
    }

    /**
     * 执委统计
     * @return
     */
    public  ActivityStatistic executiveMemberCount(String areaCode){
        return  statisticDao.executiveMemberCount(areaCode);
    }

    /**
     * 数字阵地统计
     * @return
     */
    public  ActivityStatistic szzdNumberStatistic(String areaCode){
        return  statisticDao.szzdNumberStatistic(areaCode);

    }

    /**
     * 素材分类占比
     * @return
     */
   /* public  List<ActivityStatistic> materailCountStatistic(){
        return statisticDao.materailCountStatistic();
    }*/

    /**
     * 素材分类占比
     * @return
     */
    public  List<ActivityStatistic> materailCountStatistic(StatisticForm statisticForm){

     /* StringBuilder sql=new StringBuilder();
        sql.append("select materailNumber,markName,ROUND((materailNumber / totalCount) * 100,2) as percentageMaterail from ");
        sql.append(" (select count(*) as materailNumber,markId,markName from t_school_material  where areaCode in('"+list1.toString()+"')  GROUP  by markId,markName) a ");
        sql.append(" cross join ( select count(*) as totalCount from t_school_material where areaCode in('"+list1.toString()+"')) b");*/
       Sql sql=Sql.select()
                .field("materailNumber")
                .field("markName")
                .field("ROUND((materailNumber / totalCount) * 100,2)","percentageMaterail")
                 .from(Sql.select()
                         .field(" count(*)","materailNumber")
                         .field("markId")
                         .field("markName")
                         .from("t_school_material","a")
                         .where()
                                 .andRlikeIf(StringUtils.isNotBlank(statisticForm.getAreaCode()), "areaCode", statisticForm.getAreaCode() == null ? "" : statisticForm.getAreaCode().replaceAll("(0)+$", ""))
                                 .groupBy("markId","markName")
                         ,"a")
                         .join(Sql.select().field("count(*)","totalCount")
                                 .from("t_school_material")
                                 .where()
                                         .andRlikeIf(StringUtils.isNotBlank(statisticForm.getAreaCode()), "areaCode", statisticForm.getAreaCode() == null ? "" : statisticForm.getAreaCode().replaceAll("(0)+$", ""))
                                 ,"b");
        return jdbcHelper.queryForListBean(sql.getSql().toString(),ActivityStatistic.class,sql.getParams().toArray());

    }

    /**
     * 活动分类占比
     * @return
     */
    public  List<ActivityStatistic> activityByTypeCountStatistic(StatisticForm statisticForm){

        Sql sql=Sql.select()
                .field("activityCountByType")
                .field("trainType")
                .field("ROUND((activityCountByType / totalCount) * 100,2)","percentageActivity")
                .from(Sql.select()
                                .field(" count(*)","activityCountByType")
                                .field("trainType")
                                .from("t_activity","a")
                                .where()
                                .andRlikeIf(StringUtils.isNotBlank(statisticForm.getAreaCode()), "areaCode", statisticForm.getAreaCode() == null ? "" : statisticForm.getAreaCode().replaceAll("(0)+$", ""))
                                .groupBy("trainType")
                        ,"a")
                .join(Sql.select().field("count(*)","totalCount")
                        .from("t_activity")
                        .where()
                                .andRlikeIf(StringUtils.isNotBlank(statisticForm.getAreaCode()), "areaCode", statisticForm.getAreaCode() == null ? "" : statisticForm.getAreaCode().replaceAll("(0)+$", ""))
                        ,"b");

        return jdbcHelper.queryForListBean(sql.getSql().toString(),ActivityStatistic.class,sql.getParams().toArray());
    }

    public  List<ActivityStatistic> findTotalStatisticCountByZs(){
        return statisticDao.findTotalStatisticCountByZs();
    }

    public static void main(String[] args) {
        System.out.println( "5300000000".replaceAll("(0)+$", ""));
        System.out.println( "53000002000".replaceAll("(0)+$", ""));
        System.out.println( "5300000002".replaceAll("(0)+$", ""));
    }

    }
