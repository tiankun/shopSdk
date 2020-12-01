package com.redare.shop.unifyworkbench.appapi.controller.base;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.webplatform.sdk.core.AccountSdk;
import com.redare.devframework.webplatform.sdk.core.UserSdk;
import com.redare.devframework.webplatform.sdk.core.arg.AccountArg;
import com.redare.devframework.webplatform.sdk.core.arg.UserArg;
import com.redare.devframework.webplatform.sdk.core.pojo.Account;
import com.redare.devframework.webplatform.sdk.core.pojo.User;
import com.redare.shop.unifyworkbench.appapi.controller.BaseApiController;
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
}
