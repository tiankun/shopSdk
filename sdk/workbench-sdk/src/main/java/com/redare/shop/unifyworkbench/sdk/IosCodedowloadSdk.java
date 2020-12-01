package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.IosCodedowload;
import com.redare.shop.unifyworkbench.sdk.pojo.form.IosCodedowloadForm;

import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/7/17 11:16
 * @version: 1.1
 */
public interface IosCodedowloadSdk {
    /**
     * @description 分页查询
     * @author zlx
     * @date 2020/7/17 11:17
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.IosCodedowload>>
     */
    CommonResult<Page<IosCodedowload>> findIosCodedowloadPage(IosCodedowloadForm.Search form, int curPage, int pageSize);

    /**
     * @description 分页查询列表
     * @author zlx
     * @date 2020/7/17 11:31
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.IosCodedowload>>
     */
    CommonResult<List<IosCodedowload>> findIosCodedowloadList(IosCodedowloadForm.Search form,int curPage,int pageSize);

    /**
     * @description 查询所有数据
     * @author zlx
     * @date 2020/7/17 11:31
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.IosCodedowload>>
     */
    CommonResult<List<IosCodedowload>> findIosCodedowloadList(IosCodedowloadForm.Search form);

    /**
     * @description 根据主键id查询数据
     * @author zlx
     * @date 2020/7/17 11:33
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.IosCodedowload>
     */
    CommonResult<IosCodedowload> findIosCodedowload(IosCodedowloadForm.Get form);

    /**
     * @description 更新状态
     * @author zlx
     * @date 2020/7/17 11:34
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    CommonResult<Boolean> editIosCodedowloadStatus(IosCodedowloadForm.Edit form);
}
