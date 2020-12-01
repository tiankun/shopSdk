package com.redare.shop.unifyworkbench.appapi.interceptor;

import com.redare.devframework.common.spring.interceptor.BaseInterceptor;
import com.redare.devframework.common.utils.http.IUrlSignature;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by taoyuandi on 9/19/15.
 */
public class ApiVerifyInterceptor extends BaseInterceptor {

    IUrlSignature signature;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (signature == null) {
            logger.error("verify api signature model not find");
            return returnFailsWrapper(response, "Http校验签名模块尚未配置");
        }

        long time = System.currentTimeMillis();
        boolean bool = signature.verifyUrlSignature(request);
        logger.debug(String.format("verify api coast time %s ms", System.currentTimeMillis() - time));
        if (!bool) {
            logger.warn("verify api fails");
            return returnFailsWrapper(response, "Http访问验证失败");
        }
        return true;
    }

    public IUrlSignature getSignature() {
        return signature;
    }

    public void setSignature(IUrlSignature signature) {
        this.signature = signature;
    }
}
