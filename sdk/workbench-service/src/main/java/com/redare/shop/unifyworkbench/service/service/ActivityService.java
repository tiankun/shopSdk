package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.Activity;
import com.redare.shop.unifyworkbench.sdk.pojo.ActivityHeatmap;
import com.redare.shop.unifyworkbench.sdk.pojo.User;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ActivityForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserOrgForm;
import com.redare.shop.unifyworkbench.service.dao.ActivityDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 活动管理(Activity)表服务接口
 *
 * @author dengchj
 * @since 2020-10-19 18:03:45
 */
@Service
public class ActivityService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityService.class);
    @Autowired
    ActivityDao activityDao;

    public Integer insertActivity(ActivityForm.Add form) {
        return activityDao.insertActivity(form);
    }

    public int updateActivity(ActivityForm.Edit form) {
        return activityDao.updateActivity(form);
    }

    public Page<Activity> queryForPageActivity(ActivityForm.Search form, int curPage, int pageSize) {
        return activityDao.queryForPageActivity(form, curPage, pageSize, true, false);
    }

    public List<Activity> queryForListActivity(ActivityForm.Search form,int curPage, int pageSize) {
        return activityDao.queryForListActivity(form,curPage,pageSize);
    }


    public Activity queryForActivity(ActivityForm.Search form) {
     return  activityDao.getActivityInfo(form);
    }

    public int deleteActivity(CommonForm.Del form) {
        return activityDao.deleteActivity(form);
    }

    public Boolean batchDelActivity(CommonForm.BatchDel form) {
        return activityDao.batchDelActivity(form) > 0;
    }

    public int updateActivityStatus(ActivityForm.changeStatus form) {
        return activityDao.updateActivityStatus(form);
    }

    public List<Activity> activityCountByZt(ActivityForm.Search form){
        return  activityDao.activityCountByZt(form);
    }

    public List<User> findUserListByOrgId(UserOrgForm.Get form){
        return  activityDao.findUserListByOrgId(form);
    }

    public List<ActivityHeatmap> groupActivityDayCount(ActivityForm.HeatmapSearch search) {
        return  activityDao.groupActivityDayCount(search);
    }

    /**
     * 根据组织id统计活动次数、活动参与人数
     * @param form
     * @return
     */
    public Map<String, Object> findActivityStatics(ActivityForm.Search form){
        Map<String,Object> data = new HashMap<>();

        final Activity activityStatics = activityDao.findActivityStatics(form);
        //活动数量
        Map<String,Object> activityCount =  new HashMap<>();
        activityCount.put("amount",activityStatics.getActivityCount());
        activityCount.put("isUp",false);
        data.put("activityCount",activityCount);

        //活动人次
        Map<String,Object> joinCount =  new HashMap<>();
        joinCount.put("amount",activityStatics.getJoinCount());
        joinCount.put("isUp",true);
        data.put("joinCount",joinCount);

        return data;
    }

    public int updateTopStatus(ActivityForm.Top form) {
        return  activityDao.updateTopStatus(form);
    }

    public int updateSort(ActivityForm.Sort form) {
        return activityDao.updateSort(form);
    }
}
