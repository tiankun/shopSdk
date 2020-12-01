package com.redare.shop.unifyworkbench.appapi.controller.base;

import com.google.common.collect.ImmutableMap;
import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.utils.JsonUtils;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.devframework.smsgateway.sdk.SmsSendSdk;
import com.redare.devframework.smsgateway.sdk.pojo.arg.SmsSendArg;
import com.redare.devframework.sso.webserver.pojo.SsoToken;
import com.redare.devframework.webplatform.sdk.core.AccountSdk;
import com.redare.devframework.webplatform.sdk.core.UserSdk;
import com.redare.devframework.webplatform.sdk.core.arg.AccountArg;
import com.redare.devframework.webplatform.sdk.core.pojo.Account;
import com.redare.devframework.webplatform.sdk.core.pojo.User;
import com.redare.shop.unifyworkbench.appapi.config.AppApiConfig;
import com.redare.shop.unifyworkbench.appapi.controller.BaseApiController;
import com.redare.shop.unifyworkbench.appapi.pojo.UserSearchForm;
import com.redare.shop.unifyworkbench.appapi.pojo.base.UserArg;
import com.redare.shop.unifyworkbench.appapi.pojo.base.form.AccountForm;
import com.redare.shop.unifyworkbench.appapi.utils.BsUtils;
import com.redare.shop.unifyworkbench.appapi.utils.DesUtils;
import com.redare.shop.unifyworkbench.appapi.utils.Fields;
import com.redare.shop.unifyworkbench.sdk.LoginLogSdk;
import com.redare.shop.unifyworkbench.sdk.common.BaseUserInfoSdk;
import com.redare.shop.unifyworkbench.sdk.common.pojo.BaseUserInfo;
import com.redare.shop.unifyworkbench.sdk.pojo.form.LoginLogForm;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class LoginController extends BaseApiController {
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    UserSdk userSdk;

    @Autowired
    AppApiConfig config;

    @Autowired
    SmsSendSdk smsSendSdk;

    @Autowired
    AccountSdk accountSdk;


    @Autowired
    LoginLogSdk loginLogSdk;
    @Autowired
    BaseUserInfoSdk baseUserInfoSdk;

    @Transactional
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonResult<User> login(
            @RequestBody UserArg.Login form,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        if (StringUtils.isBlank(form.getAccount())) {
            return CommonResult.returnFailsWrapper("请输入账号");
        }
        if (StringUtils.isBlank(form.getPwd())) {
            return CommonResult.returnFailsWrapper("请输入密码");
        }
        User user = userSdk.getUser(new AccountArg.Get()
                .setAccount(form.getAccount()).setIncPwd(true)).getData();
        if (user == null) {
            return CommonResult.returnFailsWrapper("账号或密码错误");
        }
        if (user.getStatus() != 0) {
            LoginLogForm.Add addForm = new LoginLogForm.Add();
            addForm.setClassify("登录日志");
            addForm.setOperator(form.getAccount());
            addForm.setContent("账号异常，请联系管理员");
            addForm.setSource("手机端登录");
            addForm.setCreateTime(new Date());
            loginLogSdk.addLoginLog(addForm);
            return CommonResult.returnFailsWrapper("账号异常，请联系管理员");

        }
        String passWord = DigestUtils.md5Hex(form.getPwd());
        if (!passWord.equalsIgnoreCase(user.getPwd())) {
            LoginLogForm.Add addForm = new LoginLogForm.Add();
            addForm.setClassify("登录日志");
            addForm.setOperator(form.getAccount());
            addForm.setContent("账号或密码错误");
            addForm.setSource("手机端登录");
            addForm.setCreateTime(new Date());
            loginLogSdk.addLoginLog(addForm);
            return CommonResult.returnFailsWrapper("账号或密码错误");
        }
        user.setPwd(null);
        LoginLogForm.Add addForm = new LoginLogForm.Add();
        addForm.setClassify("登录日志");
        addForm.setOperator(form.getAccount());
        addForm.setContent("登录成功");
        addForm.setSource("手机端登录");
        addForm.setCreateTime(new Date());
        loginLogSdk.addLoginLog(addForm);

        //合并用户信息
        BaseUserInfo baseUserInfo = new BaseUserInfo();
        if (user.getPlatform().equals("shop")) {
            BaseUserInfo baseUserInfoForm = new BaseUserInfo();
            BeanUtils.copyProperties(user, baseUserInfoForm);
            baseUserInfoForm.setOrgId(user.getUserPlatform());
            //再次去查询用户基本信息（组织和区域等）
            baseUserInfo = baseUserInfoSdk.queryBaseUserInfo(baseUserInfoForm).getData();
            if(baseUserInfo == null){
                return CommonResult.returnFailsWrapper("用户没有分配组织");
            }
        }
        BeanUtils.copyProperties(user, baseUserInfo);


        return CommonResult.returnSuccessWrapper(baseUserInfo);
    }

    /**
     * 检查手机号是否存在base_account表中
     *
     * @param form
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/checkPhoneNumExist", method = RequestMethod.POST)
    public CommonResult checkPhoneNumExist(
            @RequestBody AccountForm.checkPhoneExist form,
            HttpServletRequest request
    ) {
        CommonResult result = ValidationUtils.simpleValidate(form);
        if (result.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(result.getMessage());
        }
        User user = userSdk.getUser(new AccountArg.Get().setAccount(form.getPhoneNum())).getData();
        if (user != null) {
            if (user.getStatus() != 0) {
                return CommonResult.returnSuccessWrapper(Fields.CODE_USER_ERROR);//"账号异常，请联系管理员"
            }
        } else {
            return CommonResult.returnSuccessWrapper(Fields.CODE_APP_UNREGISTERED);//账号未注册
        }

        String verifyCode = BsUtils.randomInt(6);
        smsSendSdk.sendSms((SmsSendArg.Send) new SmsSendArg.Send()
                .setMobile(Arrays.asList(form.getPhoneNum()))
                .setTemplateCode("captcha")
                .setTemplateArgs(ImmutableMap.of(
                        "op", form.getOperate(),
                        "number", verifyCode))
                .setSysCode(config.getSmsBsId())
        );
        Map map = new HashMap();
        map.put("message", "验证码发送成功");
        map.put("verifyCode", verifyCode);
        map.put("mobile", form.getPhoneNum());
        map.put("user", user);
        return CommonResult.returnSuccessWrapper(map);
    }

    /**
     * 修改密码
     *
     * @param form
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public CommonResult changePassword(
            @RequestBody AccountForm.verifyPwd form,
            HttpServletRequest request
    ) {
        CommonResult result = ValidationUtils.simpleValidate(form);
        if (result.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(result.getMessage());
        }
        if (StringUtils.isBlank(form.getPhoneNum())) {
            return CommonResult.returnFailsWrapper("手机号不能为空");
        }
        Account account = accountSdk.getAccount(new AccountArg.Get().setAccount(form.getPhoneNum())).getData();
        if (account == null) {
            return CommonResult.returnFailsWrapper("用户不存");
        }
        if (!form.getPwd().equals(form.getConfirmPwd())) {
            return CommonResult.returnFailsWrapper("密码与确认密码不一致");
        }
        AccountArg.Pwd pwd = new AccountArg.Pwd()
                .setPwd(form.getPwd().trim())
                .setAccountId(account.getId());
        return userSdk.modifyPwd(pwd);
    }

    /**
     * 加密
     *
     * @param
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/encode", method = RequestMethod.POST)
    public CommonResult<String> encode(
            @RequestParam(value = "code", required = true) String code,
            HttpServletRequest request
    ) throws Exception {
        if (StringUtils.isNotEmpty(code)) {
            return CommonResult.returnSuccessWrapper(DesUtils.encode(code));
        } else {
            return CommonResult.returnSuccessWrapper(null);
        }
    }

    /**
     * 解密
     *
     * @param
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/decode", method = RequestMethod.POST)
    public CommonResult<String> decode(
            @RequestParam(value = "code", required = true) String code,
            HttpServletRequest request
    ) throws Exception {
        if (StringUtils.isNotEmpty(code)) {
            return CommonResult.returnSuccessWrapper(DesUtils.decode(code));
        } else {
            return CommonResult.returnSuccessWrapper(null);
        }
    }
}
