package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.shop.unifyworkbench.sdk.HjmallindGoodsSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.HjmallindGoods;
import com.redare.shop.unifyworkbench.sdk.pojo.form.HjmallindGoodsForm;
import com.redare.shop.unifyworkbench.service.service.HjmallindGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品 impl
 *
 * @author tiankun
 * @date 2020-12-01 16:20:57
 */
@Service
public class HjmallindGoodsSdkImpl implements HjmallindGoodsSdk {

    @Autowired
    HjmallindGoodsService hjmallindGoodsService;

    @Override
    public CommonResult<Boolean> addHjmallindGoods(HjmallindGoodsForm.Add form) {
        CommonResult result = ValidationUtils.simpleValidate(form);
        if (result.isNotSuccess()) {
            return result;
        }
        boolean bool = hjmallindGoodsService.addHjmallindGoods(form);
        return CommonResult.returnBoolWrapper(bool, "添加失败");
    }

    @Override
    public CommonResult<Boolean> editHjmallindGoods(HjmallindGoodsForm.Edit form) {
        CommonResult result = ValidationUtils.simpleValidate(form);
        if (result.isNotSuccess()) {
            return result;
        }
        boolean bool = hjmallindGoodsService.editHjmallindGoods(form);
        return CommonResult.returnBoolWrapper(bool, "编辑失败");
    }

    @Override
    public CommonResult<Boolean> deleteHjmallindGoods(HjmallindGoodsForm.Del form) {
        CommonResult result = ValidationUtils.simpleValidate(form);
        if (result.isNotSuccess()) {
            return result;
        }
        boolean bool = hjmallindGoodsService.deleteHjmallindGoods(form);
        return CommonResult.returnBoolWrapper(bool, "删除失败");
    }

    @Override
    public CommonResult<List<HjmallindGoods>> findHjmallindGoodsList(HjmallindGoodsForm.Search form) {
        List<HjmallindGoods> list = hjmallindGoodsService.findHjmallindGoodsList(form);
        return CommonResult.returnSuccessWrapper(list);
    }

    @Override
    public CommonResult<List<HjmallindGoods>> findHjmallindGoodsList(HjmallindGoodsForm.Search form, int curPage, int pageSize) {
        List<HjmallindGoods> list = hjmallindGoodsService.findHjmallindGoodsList(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(list);
    }

    @Override
    public CommonResult<Page<HjmallindGoods>> findHjmallindGoodsPage(HjmallindGoodsForm.Search form, int curPage, int pageSize) {
        Page<HjmallindGoods> page = hjmallindGoodsService.findHjmallindGoodsPage(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(page);
    }

    @Override
    public CommonResult<HjmallindGoods> getHjmallindGoods(HjmallindGoodsForm.Get form) {
        CommonResult result = ValidationUtils.simpleValidate(form);
        if (result.isNotSuccess()) {
            return result;
        }
        HjmallindGoods info = hjmallindGoodsService.getHjmallindGoods(form);
        if (info == null) {
            return CommonResult.returnFailsWrapper("数据不存在");
        }
        return CommonResult.returnSuccessWrapper(info);
    }


}

