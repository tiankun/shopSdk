package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.ContentManage;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ContentManageForm;

import java.util.List;
import java.util.Map;

/**
 * ContentManageSdk
 *
 * @Author zlx
 * @Date 2020/5/6 14:55
 */
public interface ContentManageSdk {

    /**
     * 分页查询（t_content_manage）列表
     * @author zlx
     * @date 2020/5/6 14:58
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.ContentManage>>
     */
    CommonResult<Page<ContentManage>> findContentManagePage(ContentManageForm.Search form, int curPage, int pageSize);

    /**
     * 分页查询列表数据
     * @author zlx
     * @date 2020/5/12 11:41
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.ContentManage>>
     */
    CommonResult<List<ContentManage>> findContentManageList(ContentManageForm.Search form,int curPage,int pageSize);

    /**
     * 查询列表数据，不分页
     * @author zlx
     * @date 2020/5/12 11:42
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.ContentManage>>
     */
    CommonResult<List<ContentManage>> findContentManageList(ContentManageForm.Search form);

    /**
     * 新增（t_content_manage）列表数据
     * @author zlx
     * @date 2020/5/7 10:42
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    CommonResult<Integer> addContentManage(ContentManageForm.Add form);

    /**
     * 修改内容显示隐藏
     * @author zlx
     * @date 2020/5/7 21:41
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    CommonResult<Boolean> editStatus(ContentManageForm.EditStatus form);

    /**
     * 根据id删除（t_content_manage）表数据
     * @author zlx
     * @date 2020/5/8 9:43
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    CommonResult<Boolean> deleteContentManage(ContentManageForm.Del form);

    /**
     * 根据id查询详情
     * @author zlx
     * @date 2020/5/8 10:54
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.shop.unifyworkbench.sdk.pojo.ContentManage>
     */
    CommonResult<ContentManage> getContentManage(ContentManageForm.Get form);

    /**
     * 编辑数据
     * @author zlx
     * @date 2020/5/8 17:46
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    CommonResult<Boolean> editContentManage(ContentManageForm.Edit form);

    /**
     * 批量删除数据
     * @author zlx
     * @date 2020/5/9 11:08
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    CommonResult<Boolean> batchDelContent(ContentManageForm.BatchDel form);

    /**
     * 获取前5条通知公告
     * @author zlx
     * @date 2020/5/11 11:33
     * @param
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.Map<java.lang.String,java.lang.Object>>
     */
    CommonResult<Map<String,Object>> getContentManageTop5(ContentManageForm.GetByClassify form);

    /**
     * 根据分类进行分页查询数据
     * @author zlx
     * @date 2020/5/12 11:29
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.ContentManage>>
     */
    CommonResult<Page<ContentManage>> findContentManagePageByClassify(ContentManageForm.Search form,int curPage,int pageSize);

    /**
     * @description 根据分类集合分页查询数据
     * @author zlx
     * @date 2020/7/16 15:53
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.CommonResult<com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.ContentManage>>
     */
    CommonResult<Page<ContentManage>> findContentManagePageByClassifyList(ContentManageForm.Search form,int curPage,int pageSize);
}
