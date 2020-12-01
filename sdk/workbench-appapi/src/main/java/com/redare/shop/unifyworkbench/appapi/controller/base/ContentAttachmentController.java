package com.redare.shop.unifyworkbench.appapi.controller.base;

import com.redare.devframework.common.pojo.CommonResult;

import com.redare.shop.unifyworkbench.sdk.ContentAttachmentSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.ContentAttachment;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ContentAttachmentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tiankun on 2020-05-12
 */
@Controller
@RequestMapping("/content/attachment")
public class ContentAttachmentController {
    @Autowired
    ContentAttachmentSdk contentAttachmentSdkSdk;

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public CommonResult<List<ContentAttachment>> findContentAttachmentList(
            @RequestBody ContentAttachmentForm.GetByContentId form,
            @RequestParam(value = "curPage", required = false, defaultValue = "1") int curPage,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        return contentAttachmentSdkSdk.findAttachmentList(form);
    }
}
