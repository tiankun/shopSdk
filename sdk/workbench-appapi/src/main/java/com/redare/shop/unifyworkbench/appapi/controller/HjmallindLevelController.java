package com.redare.shop.unifyworkbench.appapi.controller;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.shop.unifyworkbench.sdk.HjmallindLevelSdk;
import com.redare.shop.unifyworkbench.sdk.HjmallindUserSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.HjmallindLevel;
import com.redare.shop.unifyworkbench.sdk.pojo.HjmallindUser;
import com.redare.shop.unifyworkbench.sdk.pojo.form.HjmallindLevelForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.HjmallindUserForm;
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
@RequestMapping("/level")
public class HjmallindLevelController extends BaseApiController{
    @Autowired
    HjmallindLevelSdk hjmallindLevelSdk;

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public CommonResult<List<HjmallindLevel>> findCardList(
            @RequestBody HjmallindLevelForm.Search form,
            HttpServletRequest request
    ) {
        return hjmallindLevelSdk.findHjmallindLevelList(form);
    }
}
