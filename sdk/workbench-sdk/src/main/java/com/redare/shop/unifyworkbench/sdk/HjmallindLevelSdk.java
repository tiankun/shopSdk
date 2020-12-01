package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.HjmallindLevel;
import com.redare.shop.unifyworkbench.sdk.pojo.form.HjmallindLevelForm;

import java.util.List;

/**
 * 会员等级 sdk
 *
 * @author tiankun
 * @date 2020-12-01 16:56:53
 */
public interface HjmallindLevelSdk {

    /**
     * 新增会员等级
     */
    CommonResult<Boolean> addHjmallindLevel(HjmallindLevelForm.Add form);

    /**
     * 编辑会员等级
     */
    CommonResult<Boolean> editHjmallindLevel(HjmallindLevelForm.Edit form);

    /**
     * 删除会员等级
     */
    CommonResult<Boolean> deleteHjmallindLevel(HjmallindLevelForm.Del form);

    /**
     * 查询会员等级
     */
    CommonResult<List<HjmallindLevel>> findHjmallindLevelList(HjmallindLevelForm.Search form);

    /**
     * 分页查询会员等级
     */
    CommonResult<List<HjmallindLevel>> findHjmallindLevelList(HjmallindLevelForm.Search form, int curPage, int pageSize);

    /**
     * 分页查询会员等级
     */
    CommonResult<Page<HjmallindLevel>> findHjmallindLevelPage(HjmallindLevelForm.Search form, int curPage, int pageSize);

    /**
     * 获取会员等级
     */
    CommonResult<HjmallindLevel> getHjmallindLevel(HjmallindLevelForm.Get form);


}

