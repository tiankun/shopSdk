package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.shop.unifyworkbench.sdk.pojo.ClassifyManage;

import java.util.List;

/**
 * ClassifyManageSdk
 *
 * @Author zlx
 * @Date 2020/5/9 11:57
 */
public interface ClassifyManageSdk {

    /**
     * 查询所有的分类数据
     * @return
     */
    CommonResult<List<ClassifyManage>> findClassifyList();
}
