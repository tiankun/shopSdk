package com.redare.shop.unifyworkbench.appapi.controller.base;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.webplatform.sdk.common.DictionarySdk;
import com.redare.devframework.webplatform.sdk.common.arg.DictionaryArg;
import com.redare.devframework.webplatform.sdk.common.pojo.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by tiankun on 2020-07-21
 */
@Controller
@RequestMapping("/base/dictionary")
public class BaseDictionaryController {
    @Autowired
    DictionarySdk dictionarySdk;

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public CommonResult<List<Dictionary>> findDictionaryList(
            @RequestBody DictionaryArg.Search form
    ) {
        return dictionarySdk.findDictionaryList(form);
    }

    @ResponseBody
    @RequestMapping(value = "/getDictionary", method = RequestMethod.POST)
    public CommonResult<Dictionary> getDictionary(@RequestBody DictionaryArg.Get form) {
        return dictionarySdk.getDictionary(form);
    }

}
