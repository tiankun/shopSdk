package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.shop.unifyworkbench.sdk.pojo.ActivityStatistic;
import com.redare.shop.unifyworkbench.sdk.pojo.form.StatisticForm;

import java.util.List;
import java.util.Map;

public interface StatisticSdk {
    /**
     * 根据培训类型统计活动签到人次数、占比
     * @return
     */
    CommonResult<ActivityStatistic> ActivityStaticsByTrainType(StatisticForm statisticForm);

    /**
     * 地区指数：州市妇联、区县妇联、乡镇妇联、村社区妇联、活动数量、活动人次
     * @return
     */
    CommonResult<ActivityStatistic> statisticCountArea();

    /**
     * 州市：活动统计、参与人数、组织数
     * @return
     */
    CommonResult<Map<String,Object>> findStatisticCount(String areaCode);

    /**
     * 执委统计
     * @return
     */
    CommonResult<Map<String,Object>> executiveMemberCount(String areaCode);

    /**
     * 数字阵地统计
     * @return
     */
    CommonResult<Map<String,Object>> szzdNumberStatistic(String areaCode);

    CommonResult<List<ActivityStatistic>> materailCountStatistic(StatisticForm statisticForm);
    CommonResult<List<ActivityStatistic>> activityByTypeCountStatistic(StatisticForm statisticForm);
    CommonResult<List<ActivityStatistic>> findTotalStatisticCountByZs();
}
