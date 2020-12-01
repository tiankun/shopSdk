package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.SchoolComment;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.SchoolCommentForm;

import java.util.List;

/**
 * 评论表(SchoolComment)SDK
 *
 * @author dengchj
 * @since 2020-10-13 14:21:05
 */
public interface SchoolCommentSdk {

    CommonResult<Boolean> insertSchoolComment(SchoolComment form);

    CommonResult<Boolean> updateSchoolComment(SchoolComment form);

    CommonResult<Boolean> deleteSchoolComment(CommonForm.Del form);

    CommonResult<Boolean> updateSchoolCommentStatus(SchoolCommentForm.Edit form);

    CommonResult<Page<SchoolComment>> queryForPageSchoolComment(SchoolCommentForm.Search form, int curPage, int pageSize);

    CommonResult<List<SchoolComment>> queryForListSchoolComment(SchoolCommentForm.Search form);

    CommonResult<SchoolComment> querySchoolComment(SchoolCommentForm.Search form);

    CommonResult<Boolean> batchDelSchoolComment(CommonForm.BatchDel form);

}