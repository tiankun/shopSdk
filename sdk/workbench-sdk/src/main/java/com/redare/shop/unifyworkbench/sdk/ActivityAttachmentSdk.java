package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.ActivityAttachment;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ActivityAttachmentForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;

import java.util.List;

/**
 * 学堂管理-素材附件管理(ActivityAttachment)SDK
 *
 * @author dengchj
 * @since 2020-10-19 18:03:17
 */
public interface ActivityAttachmentSdk {

    CommonResult<Boolean> insertActivityAttachment(ActivityAttachment form);

    CommonResult<Boolean> updateActivityAttachment(ActivityAttachment form);

    CommonResult<Boolean> deleteActivityAttachment(ActivityAttachmentForm.Del form);

    CommonResult<Boolean> updateActivityAttachmentStatus(ActivityAttachmentForm.Edit form);

    CommonResult<Page<ActivityAttachment>> queryForPageActivityAttachment(ActivityAttachmentForm.Search form, int curPage, int pageSize);

    CommonResult<List<ActivityAttachment>> queryForListActivityAttachment(ActivityAttachmentForm.Search form);

    CommonResult<ActivityAttachment> queryActivityAttachment(ActivityAttachmentForm.Search form);

    CommonResult<Boolean> batchDelActivityAttachment(CommonForm.BatchDel form);

    /**
     * 根据活动id删除附件信息
     * @param form
     * @return
     */
    CommonResult<Boolean> batchDelAttachmentByActivityId(ActivityAttachmentForm.GetByActivityId form);

    /**
     * 根据活动id查询所有附件信息
     * @param form
     * @return
     */
    CommonResult<List<ActivityAttachment>> findActivityAttachmentListByActivityId(ActivityAttachmentForm.GetByActivityId form);

    /**
     * 批量添加附件
     * @param form
     * @return
     */
    CommonResult<Boolean> batchAddAttachment(ActivityAttachmentForm.BatchAdd form);


}