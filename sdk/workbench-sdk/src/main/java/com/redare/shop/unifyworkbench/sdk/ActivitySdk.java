package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.Activity;
import com.redare.shop.unifyworkbench.sdk.pojo.ActivityHeatmap;
import com.redare.shop.unifyworkbench.sdk.pojo.User;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ActivityForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserOrgForm;

import java.util.List;
import java.util.Map;

/**
 * 活动管理(Activity)SDK
 *
 * @author dengchj
 * @since 2020-10-19 18:02:45
 */
public interface ActivitySdk {
    /**
     * 添加活动
     * @param form
     * @return
     */
    CommonResult<Integer> insertActivity(ActivityForm.Add form);

    /**
     * 修改活动
     * @param form
     * @return
     */

    CommonResult<Boolean> updateActivity(ActivityForm.Edit form);

    /**
     * 删除活动
     * @param form
     * @return
     */
    CommonResult<Boolean> deleteActivity(CommonForm.Del form);

    /**
     * 更改状态
     * @param form
     * @return
     */

    CommonResult<Boolean> updateActivityStatus(ActivityForm.changeStatus form);

    /**
     * 分页查询活动信息
     * @param form
     * @param curPage
     * @param pageSize
     * @return
     */

    CommonResult<Page<Activity>> queryForPageActivity(ActivityForm.Search form, int curPage, int pageSize);

    CommonResult<List<Activity>> queryForListActivity(ActivityForm.Search form,int curPage, int pageSize);

    /**
     * 根据id查询活动信息
     * @param form
     * @return
     */
    CommonResult<Activity> queryActivity(ActivityForm.Search form);

    /**
     * 批量删除
     * @param form
     * @return
     */

    CommonResult<Boolean> batchDelActivity(CommonForm.BatchDel form);

    /**
     * 统计活动
     * @return
     */
    CommonResult<List<Activity>> activityCountByZt(ActivityForm.Search form);

    /**
     * 选择负责人
     * @param form
     * @return
     */
    CommonResult<List<User>> findUserListByOrgId(UserOrgForm.Get form);

    /**
     * 查询当前月份每天的活动数
     * @param search
     * @return
     */
    CommonResult<List<ActivityHeatmap>> groupActivityDayCount(ActivityForm.HeatmapSearch search);

    /**
     * 根据组织id统计活动次数、活动参与人数
     * @param form
     * @return
     */
    CommonResult<Map<String, Object>> findActivityStatics(ActivityForm.Search form);

    /**
     * 置顶
     * @param form
     * @return
     */
    CommonResult<Boolean> updateTopStatus(ActivityForm.Top form);

    /**
     * 设置排序
     * @param form
     * @return
     */
    CommonResult<Boolean> updateSort(ActivityForm.Sort form);

}
