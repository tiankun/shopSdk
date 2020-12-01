package com.redare.shop.unifyworkbench.appapi.controller;

import com.redare.devframework.common.spring.mvc.BaseController;
import com.redare.shop.unifyworkbench.appapi.pojo.GlobalArg;
import com.redare.shop.unifyworkbench.appapi.utils.Fields;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yangqy on 2019-10-30.
 */
public abstract class BaseApiController extends BaseController {


    protected final long getUserId(HttpServletRequest request) {
        GlobalArg arg = this.getGlobalArg(request);
        return arg.getUserId();
    }

    protected final String getUserName(HttpServletRequest request) {
        GlobalArg arg = this.getGlobalArg(request);
        return arg.getName();
    }

    protected final GlobalArg getGlobalArg(HttpServletRequest request) {
        return (GlobalArg) request.getAttribute(Fields.GLOBAL_PARAMS);
    }

}
