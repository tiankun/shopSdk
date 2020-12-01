package com.redare.shop.unifyworkbench.appapi.controller.base;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.utils.JsonUtils;
import com.redare.devframework.webplatform.sdk.app.AppVersionSdk;
import com.redare.devframework.webplatform.sdk.app.arg.AppVersionArg;
import com.redare.devframework.webplatform.sdk.app.pojo.AppVersion;
import com.redare.shop.unifyworkbench.appapi.controller.BaseApiController;
import com.redare.shop.unifyworkbench.sdk.pojo.App;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by taoyuandi on 05/06/2017.
 */
@Controller
public class AppVersionController extends BaseApiController {

    @Autowired
    AppVersionSdk appVersionSdk;

    @ResponseBody
    @RequestMapping(value = "/appversion/newest", method = RequestMethod.POST)
    public CommonResult<AppVersion> getNewestAppVersion(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        App app = new App();
        String deviceInfo = request.getHeader("__deviceInfo");
        if (StringUtils.isNotBlank(deviceInfo)) {
            app = JsonUtils.parseJson(URLDecoder.decode(deviceInfo, "UTF-8"), App.class);
        }
        AppVersionArg.GetNewest getNewest=new AppVersionArg.GetNewest().setAppType("default").setCurVersionCode(app.getVersionCode());
        if(StringUtils.isBlank(app.getSystemName())){
            app.setSystemName("default");
        }
        if("android".equals(app.getSystemName().toLowerCase())){
            getNewest.setAppOs("android");
        }else if("ios".equals(app.getSystemName().toLowerCase())){
            getNewest.setAppOs("ios");
        }
        AppVersion appVersion = appVersionSdk.getVersion(getNewest).getData();
        if(appVersion!=null){
            return CommonResult.returnSuccessWrapper(appVersion);
        }
        if (appVersion == null || appVersion.getVersionCode() <= app.getVersionCode()) {

            return CommonResult.returnSuccessWrapper();
        }
        return CommonResult.returnSuccessWrapper(appVersion);
    }

    @ResponseBody
    @RequestMapping(value = "/appversion/force/version", method = RequestMethod.POST)
    public CommonResult<AppVersion> getForceAppVersion(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        App app = new App();
        String deviceInfo = request.getHeader("__deviceInfo");
        if (StringUtils.isNotBlank(deviceInfo)) {
            app = JsonUtils.parseJson(URLDecoder.decode(deviceInfo, "UTF-8"), App.class);
        }
        AppVersion appVersion = appVersionSdk.getVersion(
                new AppVersionArg.GetNewest()
                        .setAppOs("android")
                        .setAppType("default")
                        .setCurVersionCode(app.getVersionCode())
                        .setForce(true)).getData();
        if (appVersion == null || appVersion.getVersionCode() <= app.getVersionCode()) {
            return CommonResult.returnFailsWrapper("当前已经是最新版本");
        }
        appVersion = appVersionSdk.getVersion(
                new AppVersionArg.GetNewest()
                        .setAppOs("android")
                        .setAppType("default")
                        .setCurVersionCode(app.getVersionCode())).getData();
        return CommonResult.returnSuccessWrapper(appVersion);
    }
}
