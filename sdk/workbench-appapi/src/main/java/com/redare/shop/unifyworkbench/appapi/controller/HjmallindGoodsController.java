package com.redare.shop.unifyworkbench.appapi.controller;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.shop.unifyworkbench.sdk.HjmallindGoodsSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.HjmallindGoods;
import com.redare.shop.unifyworkbench.sdk.pojo.form.HjmallindGoodsForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by tiankun on 2020-12-01
 * 会员
 */
@Controller
@RequestMapping("/goods")
public class HjmallindGoodsController extends BaseApiController{
    @Autowired
    HjmallindGoodsSdk hjmallindGoodsSdk;

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public CommonResult<List<HjmallindGoods>> findCardList(
            @RequestBody HjmallindGoodsForm.Search form,
            HttpServletRequest request
    ) {
        return hjmallindGoodsSdk.findHjmallindGoodsList(form);
    }
}
