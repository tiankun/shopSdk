package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.SchoolMaterialAttachment;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.SchoolMaterialAttachmentForm;

import java.util.List;

/**
 * 素材附件管理(SchoolMaterialAttachment)SDK
 *
 * @author dengchj
 * @since 2020-10-13 14:24:04
 */
public interface SchoolMaterialAttachmentSdk {

    CommonResult<Boolean> insertSchoolMaterialAttachment(SchoolMaterialAttachment form);

    CommonResult<Boolean> updateSchoolMaterialAttachment(SchoolMaterialAttachment form);

    CommonResult<Boolean> deleteSchoolMaterialAttachment(CommonForm.Del form);

    CommonResult<Boolean> updateSchoolMaterialAttachmentStatus(SchoolMaterialAttachmentForm.Edit form);

    CommonResult<Page<SchoolMaterialAttachment>> queryForPageSchoolMaterialAttachment(SchoolMaterialAttachmentForm.Search form, int curPage, int pageSize);

    CommonResult<List<SchoolMaterialAttachment>> queryForListSchoolMaterialAttachment(SchoolMaterialAttachmentForm.Search form);

    CommonResult<SchoolMaterialAttachment> querySchoolMaterialAttachment(SchoolMaterialAttachmentForm.Search form);

    CommonResult<Boolean> batchDelSchoolMaterialAttachment(CommonForm.BatchDel form);

    /**
     * 根据材料Id批量删除
     * @param form
     * @return
     */
    CommonResult<Boolean> batchDelAttachmentByMaterialId(SchoolMaterialAttachmentForm.BatchDel form);

    /**
     * 根据材料Id查询附件
     * @param form
     * @return
     */
    CommonResult<List<SchoolMaterialAttachment>> findMaterialAttachmentListByMaterialId(SchoolMaterialAttachmentForm.GetByMaterialId form);
    CommonResult<Boolean> batchAddAttachment(SchoolMaterialAttachmentForm.BatchAdd form);



}