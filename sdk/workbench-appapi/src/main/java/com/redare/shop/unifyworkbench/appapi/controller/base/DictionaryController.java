package com.redare.shop.unifyworkbench.appapi.controller.base;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.utils.JsonUtils;
import com.redare.devframework.webplatform.sdk.common.DictionarySdk;
import com.redare.devframework.webplatform.sdk.common.arg.DictionaryArg;
import com.redare.devframework.webplatform.sdk.common.pojo.Dictionary;
import com.redare.shop.unifyworkbench.appapi.controller.BaseApiController;
import com.redare.shop.unifyworkbench.appapi.pojo.AppDictionary;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/dictionary")
public class DictionaryController extends BaseApiController {

    @Autowired
    DictionarySdk dictionarySdk;

    @ResponseBody
    @RequestMapping(value = "/sync/list", method = RequestMethod.POST)
    public CommonResult findDictionaryList(
            @RequestParam(value = "localMd5", required = false) String localMd5,
            HttpServletRequest request
    ) {
        CommonResult<List<Dictionary>> r = dictionarySdk.findDictionaryList(new DictionaryArg.Search());
        if (r.isNotSuccess()) {
            return r;
        }
        List<Dictionary> list = r.getData();
        String dataMd5 = DigestUtils.md5Hex(JsonUtils.toJson(list));
        if (StringUtils.isNotBlank(localMd5)) {
            if (localMd5.equalsIgnoreCase(dataMd5)) {
                return CommonResult.returnFailsWrapper("数据未改变，无需同步");
            }
        }
        CommonResult<List<AppDictionary>> result = CommonResult.returnSuccessWrapper();
        result.setDataMd5(dataMd5);
        List<AppDictionary> dicList = new ArrayList<>();
        for (Dictionary dic : list) {
            dicList.add(new AppDictionary()
                    .setId(dic.getId())
                    .setName(dic.getDicName())
                    .setCode(dic.getDicCode())
                    .setValue(dic.getDicValue())
                    .setDes(dic.getDes())
                    .setSort(dic.getSort())
                    .setLeaf(dic.isLeaf())
                    .setParentId(dic.getParentId())
                    .setPlatform(dic.getPlatform())
                    .setExtArg(dic.getExtArg())
                    .setPlatformName(dic.getPlatformName())
            );
        }
        result.setData(dicList);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public CommonResult getDictionary(
            @RequestBody DictionaryArg.Get form,
            HttpServletRequest request
    ) {
        return dictionarySdk.getDictionary(form);
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public CommonResult deleteDictionary(
            @RequestBody DictionaryArg.Del form,
            HttpServletRequest request
    ) {
        return dictionarySdk.deleteDictionary(form);
    }

}
