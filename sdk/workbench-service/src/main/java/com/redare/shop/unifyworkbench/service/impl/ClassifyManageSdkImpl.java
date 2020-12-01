package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.shop.unifyworkbench.sdk.ClassifyManageSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.ClassifyManage;
import com.redare.shop.unifyworkbench.service.service.ClassifyManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassifyManageSdkImpl
 *
 * @Author zlx
 * @Date 2020/5/9 12:04
 */
@Service
public class ClassifyManageSdkImpl implements ClassifyManageSdk {

    @Autowired
    ClassifyManageService classifyManageService;

    /**
     *  查询所有的分类数据
     * @author zlx
     * @date 2020/5/9 12:05
     * @param
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.ClassifyManage>
     */
    @Override
    public CommonResult<List<ClassifyManage>> findClassifyList() {
        List<ClassifyManage> list = classifyManageService.findClassifyList();
        return CommonResult.returnSuccessWrapper(list);
    }
}
