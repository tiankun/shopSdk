package com.redare.shop.unifyworkbench.appapi.interceptor;

import com.redare.devframework.common.spring.interceptor.BaseInterceptor;
import com.redare.devframework.webplatform.sdk.core.UserSdk;
import com.redare.devframework.webplatform.sdk.core.arg.AccountArg;
import com.redare.devframework.webplatform.sdk.core.pojo.User;
import com.redare.shop.unifyworkbench.appapi.pojo.GlobalArg;
import com.redare.shop.unifyworkbench.appapi.utils.Fields;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by taoyuandi on 5/28/16.
 */
public class LoginInterceptor extends BaseInterceptor {

    @Autowired
    UserSdk userSdk;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        GlobalArg arg = (GlobalArg) request.getAttribute(Fields.GLOBAL_PARAMS);
        if (arg.getUserId() == null || arg.getUserId() < 0) {
            return returnWrapper(response, Fields.CODE_NEED_LOGIN, "需要登录");
        }

        User user = userSdk.getUser(new AccountArg.Get()
                .setId(arg.getUserId())).getData();

        if (user == null) {
            return returnWrapper(response, Fields.CODE_USER_ERROR, "账号不存在");
        }

        if (user.getStatus() != 0) {
            return returnWrapper(response, Fields.CODE_USER_ERROR, "账号异常，请联系管理员");
        }

        if (!arg.getPlatform().equals(user.getPlatform())) {
            return returnWrapper(response, Fields.CODE_NEED_LOGIN, "需要登录");
        }

        return true;
    }
}
