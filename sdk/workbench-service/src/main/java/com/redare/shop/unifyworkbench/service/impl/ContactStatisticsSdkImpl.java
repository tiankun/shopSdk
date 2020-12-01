package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.shop.unifyworkbench.sdk.ContactStatisticsSdk;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ContactStatisticsSdkImpl implements ContactStatisticsSdk {
    @Override
    public CommonResult<Map<String, Object>> contactStatistics() {
        Map<String,Object> data = new HashMap<>();
        //联系群众次数
        Map<String,Object> contactPersons =  new HashMap<>();
        contactPersons.put("amount",20766);
        contactPersons.put("isUp",true);
        data.put("contactPersons",contactPersons);

        //巾帼志愿人次
        Map<String,Object> volunteerCount =  new HashMap<>();
        volunteerCount.put("amount",2388);
        volunteerCount.put("isUp",true);
        data.put("volunteerCount",volunteerCount);

        //巾帼志愿者
        Map<String,Object> volunteers =  new HashMap<>();
        volunteers.put("amount",204);
        volunteers.put("isUp",true);
        data.put("volunteers",volunteers);
        return CommonResult.returnSuccessWrapper(data);
    }
}
