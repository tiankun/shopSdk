package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.shop.unifyworkbench.sdk.ActivitySdk;
import com.redare.shop.unifyworkbench.sdk.pojo.*;
import com.redare.shop.unifyworkbench.sdk.pojo.form.*;
import com.redare.shop.unifyworkbench.service.service.ActivityAttachmentService;
import com.redare.shop.unifyworkbench.service.service.ActivityService;
import com.redare.shop.unifyworkbench.service.service.ActivitySignService;
import com.redare.shop.unifyworkbench.service.util.DateUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 活动管理(Activity)SdkImpl
 *
 * @author dengchj
 * @since 2020-10-19 18:03:45
 */
@Service
public class ActivitySdkImpl implements ActivitySdk {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActivitySdkImpl.class);
    @Autowired
    ActivityService activityService;
    @Autowired
    ActivityAttachmentService activityAttachementService;
    @Autowired
    ActivitySignService activitySignService;

    @Override
    public CommonResult<Integer> insertActivity(ActivityForm.Add form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        Integer activityId = activityService.insertActivity(form);
        return CommonResult.returnDataWrapper(activityId);
    }

    @Override
    public CommonResult<Boolean> updateActivity(ActivityForm.Edit form) {
        if (form.getId() == null) {
            return CommonResult.returnFailsWrapper("主键不能为空");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = activityService.updateActivity(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }

    @Override
    public CommonResult<Boolean> deleteActivity(CommonForm.Del form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = activityService.deleteActivity(form);
        activityAttachementService.batchDelAttachmentByActivityId(new ActivityAttachmentForm.GetByActivityId().setActivityId(form.getId()));
        activitySignService.deleteActivitySignByActivityId(new ActivitySignForm.DelByActivityId().setActivityId(form.getId()));
        return CommonResult.returnSuccessWrapper(row > 0);
    }


    @Override
    public CommonResult<Boolean> updateActivityStatus(ActivityForm.changeStatus form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = activityService.updateActivityStatus(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }

    @Override
    public CommonResult<Page<Activity>> queryForPageActivity(ActivityForm.Search form, int curPage, int pageSize) {
        Page<Activity> data = activityService.queryForPageActivity(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(data);
    }

    @Override
    public CommonResult<List<Activity>> queryForListActivity(ActivityForm.Search form,int curPage, int pageSize) {

        List<Activity> data = activityService.queryForListActivity(form,curPage,pageSize);
        return CommonResult.returnSuccessWrapper(data);
    }

    @Override
    public CommonResult<Activity> queryActivity(ActivityForm.Search form) {
      Activity activity=activityService.queryForActivity(form);
        if (activity == null) {
            return CommonResult.returnFailsWrapper("请传入活动Id");
        }
        ActivityAttachmentForm.GetByActivityId getByActivityId = new ActivityAttachmentForm.GetByActivityId();
        getByActivityId.setActivityId(form.getId());
        List<ActivityAttachment> list = activityAttachementService.findActivityAttachmentListByActivityId(getByActivityId.setFileType("文档"));
        List<ActivityAttachment> imagelist = activityAttachementService.findActivityAttachmentListByActivityId(getByActivityId.setFileType("图片"));
        List<ActivityAttachment> videolist = activityAttachementService.findActivityAttachmentListByActivityId(getByActivityId.setFileType("视频"));
        activity.setAttachmentList(list);
        activity.setImageList(imagelist);
        activity.setVideoList(videolist);
        return CommonResult.returnDataWrapper(activity);
    }

    @Override
    public CommonResult<Boolean> batchDelActivity(CommonForm.BatchDel form) {
        if (form == null) {
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        if (form.getIds() == null || form.getIds().size() <= 0) {
            return CommonResult.returnFailsWrapper("请传入主键id");
        }
        Boolean bool = activityService.batchDelActivity(form);
        activityAttachementService.batchDelAttachmentByActivityIds(new ActivityAttachmentForm.GetByActivityId().setActivityIds(form.getIds()));

        activitySignService.batchDeleteActivitySignByActivityId(new ActivitySignForm.BatchDelByActivityId().setActivityIds(form.getIds()));


        return CommonResult.returnBoolWrapper(bool, "批量删除失败");
    }

    @Override
    public CommonResult<List<Activity>> activityCountByZt(ActivityForm.Search form) {
        return CommonResult.returnSuccessWrapper(activityService.activityCountByZt(form));
    }

    @Override
    public CommonResult<List<User>> findUserListByOrgId(UserOrgForm.Get form) {
        return CommonResult.returnSuccessWrapper(activityService.findUserListByOrgId(form));
    }
    @Override
    public CommonResult<List<ActivityHeatmap>> groupActivityDayCount(ActivityForm.HeatmapSearch search){
        if(StringUtils.isBlank(search.getYearMonth())){
            return CommonResult.returnFailsWrapper("请传入月份，例：2020-10");
        }
        if(search.getYearMonth().length()!=7){
            return CommonResult.returnFailsWrapper("年月日期格式不正确，例：2020-10");
        }
        if(!search.getYearMonth().contains("-")){
            return CommonResult.returnFailsWrapper("年月日期格式不正确，例：2020-10");
        }
        List<ActivityHeatmap> returnList=new ArrayList<>();
        List<ActivityHeatmap> list = activityService.groupActivityDayCount(search);
        //获取当前月的天数
        List<String> monthDaysList = DateUtils.getMonthDaysList(search.getYearMonth());
        Iterator<String> iterator=monthDaysList.iterator();
        while (iterator.hasNext()){
            String day=iterator.next();
            ActivityHeatmap heatmap=new ActivityHeatmap().setCount(0).setDay(day);
            if(list!=null&&list.size()>0){
                for(ActivityHeatmap item:list){
                    if(item.getDay().equals(day)){
                        heatmap.setCount(item.getCount());
                    }
                }
            }
            returnList.add(heatmap);
        }
        return CommonResult.returnSuccessWrapper(returnList);
    }

    @Override
    public CommonResult<Map<String, Object>> findActivityStatics(ActivityForm.Search form) {
        return CommonResult.returnSuccessWrapper(activityService.findActivityStatics(form));
    }

    @Override
    public CommonResult<Boolean> updateTopStatus(ActivityForm.Top form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = activityService.updateTopStatus(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }

    @Override
    public CommonResult<Boolean> updateSort(ActivityForm.Sort form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = activityService.updateSort(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }
}
