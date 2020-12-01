package com.redare.shop.unifyworkbench.appapi.controller.base;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.webplatform.sdk.core.AccountSdk;
import com.redare.devframework.webplatform.sdk.core.UserSdk;
import com.redare.devframework.webplatform.sdk.core.arg.AccountArg;
import com.redare.devframework.webplatform.sdk.core.arg.UserArg;
import com.redare.devframework.webplatform.sdk.core.pojo.Account;
import com.redare.devframework.webplatform.sdk.core.pojo.User;
import com.redare.shop.unifyworkbench.appapi.controller.BaseApiController;
import com.redare.shop.unifyworkbench.sdk.ActivitySdk;
import com.redare.shop.unifyworkbench.sdk.common.BaseUserInfoSdk;
import com.redare.shop.unifyworkbench.sdk.common.pojo.BaseUserInfo;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserOrgForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/base/user")
public class UserController extends BaseApiController {

    @Autowired
    UserSdk userSdk;

    @Autowired
    AccountSdk accountSdk;

    @Autowired
    BaseUserInfoSdk baseUserInfoSdk;

    @Autowired
    ActivitySdk activitySdk;

    @ResponseBody
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public CommonResult<User> getUser(
            @RequestBody AccountArg.Get form,
            HttpServletRequest request
    ) {

        return userSdk.getUser(form);
    }

    @ResponseBody
    @RequestMapping(value = "/user/modify/pwd", method = RequestMethod.POST)
    public CommonResult modifyPwd(
            @RequestParam(value = "userId", required = true) Long userId,
            @RequestParam(value = "pwd") String pwd,
            HttpServletRequest request
    ) {
        if (userId == null) {
            userId = getUserId(request);
        }

        Account account = accountSdk.getAccount(
                new AccountArg.Get().setId(userId)
        ).getData();
        if (account == null) {
            return CommonResult.returnFailsWrapper("账号不存在");
        }
        AccountArg.Pwd form = new AccountArg.Pwd();
        form.setAccountId(userId)
                .setPwd(pwd);
        return userSdk.modifyPwd(form);
    }

    @ResponseBody
    @RequestMapping(value = "/user/modify/photo", method = RequestMethod.POST)
    public CommonResult<User> modifyPhoto(
            @RequestParam(value = "photo") String photo,
            HttpServletRequest request
    ) {
        long userId = getUserId(request);
        UserArg.Edit form = new UserArg.Edit();
        form.setWhere(
                new UserArg.Edit.Where().setUserId(userId)
        ).setPhoto(photo);

        CommonResult result = userSdk.modifyUser(form);
        if (result.isSuccess()) {
            return userSdk.getUser(new AccountArg.Get()
                    .setId(userId));
        }
        return result;
    }


    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public CommonResult<List<User>> findUserList(
            @RequestBody UserArg.Search form,
            HttpServletRequest request
    ) {
        return userSdk.findUserList(form);
    }

    @ResponseBody
    @RequestMapping(value = "/list/by/OrgId", method = RequestMethod.POST)
    public CommonResult<List<com.redare.shop.unifyworkbench.sdk.pojo.User>> findUserListByOrgId(
            @RequestBody UserOrgForm.Get form,
            HttpServletRequest request
    ) {
        return activitySdk.findUserListByOrgId(form);
    }

    /**
     * @description 切换组织刷新session中的值
     * @author zlx
     * @date 2020/10/24 15:49
     * @param orgId
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.webplatform.sdk.core.pojo.User>
     */
    @Transactional
    @ResponseBody
    @RequestMapping(value = "/resetUser", method = RequestMethod.POST)
    public CommonResult<User> resetSessionUserData(
            @RequestParam(value = "orgId", required = false) String orgId,
            @RequestParam(value = "userId", required = false) Long userId
    ) {
        User user = userSdk.getUser(new AccountArg.Get()
                .setId(userId)).getData();
        BaseUserInfo baseUserInfo = new BaseUserInfo();
        if (user.getPlatform().equals("shop")) {
            BaseUserInfo form = new BaseUserInfo();
            form.setUserId(user.getUserId());
            form.setOrgId(orgId);
            //再次去查询用户基本信息（组织和区域等）
            baseUserInfo = baseUserInfoSdk.queryBaseUserInfo(form).getData();
            if(baseUserInfo == null){
                return CommonResult.returnFailsWrapper("用户没有分配组织");
            }
        }
        BeanUtils.copyProperties(user, baseUserInfo);
        return returnSuccessWrapper(baseUserInfo);
    }
}
