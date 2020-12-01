package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.UserHonor;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserHonorForm;

import java.util.List;

/**
 * @author : zhangsq
 * @version :
 * @description：人员荣誉接口
 * @date ：Created in 2020-10-20 14:41
 */
public interface UserHonorSdk {
    /**
     * @description: 分页查询
     * @author: zhangsq
     * @date: Created in 2020-10-20 14:26
     * @param form
     * @param curPage
     * @param pageSize
     * @return: com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.UserHonor>>
     * @exception:
     */
    CommonResult<Page<UserHonor>> findUserHonorPage(UserHonorForm.Search form, int curPage, int pageSize);
    /**
     * @description: 分页查询列表数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 14:26
     * @param form
     * @param curPage
     * @param pageSize
     * @return: com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserHonor>>
  Honor* @exception:
     */
    CommonResult<List<UserHonor>> findUserHonorPageList(UserHonorForm.Search form, int curPage, int pageSize);
    /**
     * @description: 查询所有数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 14:26
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.UserHonor>>
     * @exception:
     */
    CommonResult<List<UserHonor>> findUserHonorList(UserHonorForm.Search form);
    /**
     * @description: 根据荣誉id查询数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 14:27
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.UserHonor>
     * @exception:
     */
    CommonResult<UserHonor> findUserHonor(UserHonorForm.Get form);
    /**
     * @description: 添加数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 14:27
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    CommonResult<Boolean> addUserHonor(UserHonorForm.Add form);

    /**
     * @description: 批量添加
     * @author: zhangsq
     * @date: Created in 2020-10-21 11:13
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    CommonResult<Boolean> batchAddUserHonor(UserHonorForm.BatchAdd form);

    /**
     * @description: 编辑数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 14:27
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    CommonResult<Boolean> editUserHonor(UserHonorForm.Edit form);
    /**
     * @description: 删除数据
     * @author: zhangsq
     * @date: Created in 2020-10-20 14:27
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    CommonResult<Boolean> delUserHonor(UserHonorForm.Del form);

    /**
     * @description: 批量删除
     * @author: zhangsq
     * @date: Created in 2020-10-21 10:59
     * @param form
     * @return: com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     * @exception:
     */
    CommonResult<Boolean> batchDelUserHonor(UserHonorForm.BatchDel form);
}
