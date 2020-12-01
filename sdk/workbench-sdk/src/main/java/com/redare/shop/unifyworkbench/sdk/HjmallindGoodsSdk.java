package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.HjmallindGoods;
import com.redare.shop.unifyworkbench.sdk.pojo.form.HjmallindGoodsForm;

import java.util.List;

/**
 * 商品 sdk
 *
 * @author tiankun
 * @date 2020-12-01 16:20:57
 */
public interface HjmallindGoodsSdk {

    /**
     * 新增商品
     */
    CommonResult<Boolean> addHjmallindGoods(HjmallindGoodsForm.Add form);

    /**
     * 编辑商品
     */
    CommonResult<Boolean> editHjmallindGoods(HjmallindGoodsForm.Edit form);

    /**
     * 删除商品
     */
    CommonResult<Boolean> deleteHjmallindGoods(HjmallindGoodsForm.Del form);

    /**
     * 查询商品
     */
    CommonResult<List<HjmallindGoods>> findHjmallindGoodsList(HjmallindGoodsForm.Search form);

    /**
     * 分页查询商品
     */
    CommonResult<List<HjmallindGoods>> findHjmallindGoodsList(HjmallindGoodsForm.Search form, int curPage, int pageSize);

    /**
     * 分页查询商品
     */
    CommonResult<Page<HjmallindGoods>> findHjmallindGoodsPage(HjmallindGoodsForm.Search form, int curPage, int pageSize);

    /**
     * 获取商品
     */
    CommonResult<HjmallindGoods> getHjmallindGoods(HjmallindGoodsForm.Get form);


}

