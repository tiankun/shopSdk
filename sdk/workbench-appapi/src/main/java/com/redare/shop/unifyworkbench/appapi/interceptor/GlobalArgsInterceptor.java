package com.redare.shop.unifyworkbench.appapi.interceptor;

import com.redare.devframework.common.spring.interceptor.BaseInterceptor;
import com.redare.devframework.common.utils.JsonUtils;
import com.redare.shop.unifyworkbench.appapi.pojo.GlobalArg;
import com.redare.shop.unifyworkbench.appapi.utils.Fields;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;

public class GlobalArgsInterceptor extends BaseInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        GlobalArg arg = null;
        String user = request.getHeader("user");
        if (StringUtils.isNotBlank(user)) {
            arg = JsonUtils.parseJson(URLDecoder.decode(user, "UTF-8"), GlobalArg.class);
        }
        if (arg == null) {
            arg = new GlobalArg();
        }
        request.setAttribute(Fields.GLOBAL_PARAMS, arg);
        return true;
    }
}
