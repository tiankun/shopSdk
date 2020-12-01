package com.redare.shop.unifyworkbench.appapi.controller;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.webplatform.sdk.core.UserSdk;
import com.redare.devframework.webplatform.sdk.core.arg.UserArg;
import com.redare.devframework.webplatform.sdk.core.pojo.User;
import com.redare.shop.unifyworkbench.sdk.HjmallindCardSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.HjmallindCard;
import com.redare.shop.unifyworkbench.sdk.pojo.form.HjmallindCardForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * 商品分类
 */

@Controller
@RequestMapping("/card")
public class HjmallindCardController extends BaseApiController{
    private static Logger logger = LoggerFactory.getLogger(HjmallindCardController.class);
    @Autowired
    HjmallindCardSdk hjmallindCardSdk;

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public CommonResult<List<HjmallindCard>> findCardList(
            @RequestBody HjmallindCardForm.Search form,
            HttpServletRequest request
    ) {
        return hjmallindCardSdk.findHjmallindCardList(form);
    }
}
