package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.HjmallindCard;
import com.redare.shop.unifyworkbench.sdk.pojo.form.HjmallindCardForm;

import java.util.List;

/**
 * sdk
 *
 * @author tiankun
 * @date 2020-12-01 13:43:00
 */
public interface HjmallindCardSdk {

    /**
     * 新增
     */
    CommonResult<Boolean> addHjmallindCard(HjmallindCardForm.Add form);

    /**
     * 编辑
     */
    CommonResult<Boolean> editHjmallindCard(HjmallindCardForm.Edit form);

    /**
     * 删除
     */
    CommonResult<Boolean> deleteHjmallindCard(HjmallindCardForm.Del form);

    /**
     * 查询
     */
    CommonResult<List<HjmallindCard>> findHjmallindCardList(HjmallindCardForm.Search form);

    /**
     * 分页查询
     */
    CommonResult<List<HjmallindCard>> findHjmallindCardList(HjmallindCardForm.Search form, int curPage, int pageSize);

    /**
     * 分页查询
     */
    CommonResult<Page<HjmallindCard>> findHjmallindCardPage(HjmallindCardForm.Search form, int curPage, int pageSize);

    /**
     * 获取
     */
    CommonResult<HjmallindCard> getHjmallindCard(HjmallindCardForm.Get form);


}

