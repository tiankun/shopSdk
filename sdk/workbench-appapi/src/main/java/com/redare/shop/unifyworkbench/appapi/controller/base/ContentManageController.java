package com.redare.shop.unifyworkbench.appapi.controller.base;

import com.redare.devframework.common.pojo.CommonResult;

import com.redare.shop.unifyworkbench.sdk.ContentManageSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.ContentManage;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ContentManageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tiankun on 2020-05-12
 */
@Controller
@RequestMapping("/content")
public class ContentManageController {
    @Autowired
    ContentManageSdk contentManageSdk;

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public CommonResult<List<ContentManage>> findContentList(
            @RequestBody ContentManageForm.Search form,
            @RequestParam(value = "curPage", required = false, defaultValue = "1") int curPage,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        return contentManageSdk.findContentManageList(form, curPage, pageSize);
    }
    @ResponseBody
    @RequestMapping(value = "/getContentManage", method = RequestMethod.POST)
    public CommonResult<ContentManage> getContentManage(@RequestBody ContentManageForm.Get form) {
        return contentManageSdk.getContentManage(form);
    }

}
