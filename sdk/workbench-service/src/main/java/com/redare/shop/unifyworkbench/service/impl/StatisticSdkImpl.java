package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.shop.unifyworkbench.sdk.StatisticSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.ActivityStatistic;
import com.redare.shop.unifyworkbench.sdk.pojo.Area;
import com.redare.shop.unifyworkbench.service.service.AreaService;
import com.redare.shop.unifyworkbench.sdk.pojo.form.StatisticForm;
import com.redare.shop.unifyworkbench.service.service.StatisticService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatisticSdkImpl  implements StatisticSdk {
    @Autowired
    StatisticService statisticService;

    @Autowired
    AreaService areaService;

    @Override
    public CommonResult<ActivityStatistic> ActivityStaticsByTrainType(StatisticForm statisticForm) {
        return CommonResult.returnSuccessWrapper(statisticService.findStatisticsByTrainType(statisticForm));
    }

    @Override
    public CommonResult<ActivityStatistic> statisticCountArea() {
        return CommonResult.returnSuccessWrapper(statisticService.statisticCountArea());
    }

    @Override
    public CommonResult<Map<String,Object>> findStatisticCount(String areaCode) {
        if (StringUtils.isBlank(areaCode)){
            return CommonResult.returnFailsWrapper("请传入区域code");
        }
        Map<String,Object> map = new HashMap<>();
        List<String> areaNameList = new ArrayList<>();
        List<Integer> activityList = new ArrayList<>();
        List<Integer> personList = new ArrayList<>();
        List<Area> areaList = areaService.findNextAreaByParentCode(areaCode);
        if (areaList != null && areaList.size()>0){
            for (Area area : areaList){
                areaNameList.add(area.getAreaName());
                activityList.add(statisticService.findActivityCount(area.getAreaCode()).getActivityCount());
                personList.add(statisticService.findActivityPersonCount(area.getAreaCode()).getJoinCount());
            }
        }
        map.put("areaName",areaNameList);
        map.put("activity",activityList);
        map.put("person",personList);
        return CommonResult.returnSuccessWrapper(map);
    }

    @Override
    public CommonResult<Map<String,Object>> executiveMemberCount(String areCode) {
        if (StringUtils.isBlank(areCode)){
            return CommonResult.returnFailsWrapper("请传入区域code");
        }
        Map<String,Object> map = new HashMap<>();
        List<String> areaNameList = new ArrayList<>();
        List<Integer> countList = new ArrayList<>();
        List<Area> areaList = areaService.findNextAreaByParentCode(areCode);
        if (areaList != null && areaList.size() >0){
            for (Area area : areaList){
                areaNameList.add(area.getAreaName());
                countList.add(statisticService.executiveMemberCount(area.getAreaCode()).getExecutiveMemberCount());
            }
        }
        map.put("areaName",areaNameList);
        map.put("count",countList);
        return CommonResult.returnSuccessWrapper(map);
    }

    @Override
    public CommonResult<Map<String,Object>> szzdNumberStatistic(String areaCode) {
        if (StringUtils.isBlank(areaCode)){
            return CommonResult.returnFailsWrapper("请传入区域code");
        }
        Map<String,Object> map = new HashMap<>();
        List<String> areaNameList = new ArrayList<>();
        List<Integer> countList = new ArrayList<>();
        List<Area> areaList = areaService.findNextAreaByParentCode(areaCode);
        if (areaList != null && areaList.size() >0){
            for (Area area : areaList){
                areaNameList.add(area.getAreaName());
                countList.add(statisticService.szzdNumberStatistic(area.getAreaCode()).getSzzdNumber());
            }
        }
        map.put("areaName",areaNameList);
        map.put("count",countList);
        return CommonResult.returnSuccessWrapper(map);
    }

    @Override
    public CommonResult<List<ActivityStatistic>> materailCountStatistic(StatisticForm statisticForm) {
        return CommonResult.returnSuccessWrapper(statisticService.materailCountStatistic(statisticForm));
    }

    @Override
    public CommonResult<List<ActivityStatistic>> activityByTypeCountStatistic(StatisticForm statisticForm) {
        return CommonResult.returnSuccessWrapper(statisticService.activityByTypeCountStatistic(statisticForm));
    }

    @Override
    public CommonResult<List<ActivityStatistic>> findTotalStatisticCountByZs() {
        return CommonResult.returnSuccessWrapper(statisticService.findTotalStatisticCountByZs());
    }
}
