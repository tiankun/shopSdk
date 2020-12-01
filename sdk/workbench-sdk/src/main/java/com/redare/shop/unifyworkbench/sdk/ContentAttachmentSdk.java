package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.shop.unifyworkbench.sdk.pojo.ContentAttachment;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ContentAttachmentForm;

import java.util.List;

/**
 * ContentAttachmentSdk
 *
 * @Author zlx
 * @Date 2020/5/7 18:34
 */
public interface ContentAttachmentSdk {

    /**
     * 批量添加文件附件
     * @author zlx
     * @date 2020/5/7 18:36
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    CommonResult<Boolean> batchAddAttachment(ContentAttachmentForm.BatchAdd form);

    /**
     * 删除表（t_content_attachment）数据
     * @author zlx
     * @date 2020/5/8 9:59
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    CommonResult<Boolean> deleteAttachment(ContentAttachmentForm.Del form);

    /**
     * 根据内容id查询所有附件
     * @author zlx
     * @date 2020/5/8 11:12
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.ContentAttachment>>
     */
    CommonResult<List<ContentAttachment>> findAttachmentList(ContentAttachmentForm.GetByContentId form);

    /**
     * 根据内容id批量删除数据
     * @author zlx
     * @date 2020/5/9 11:17
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    CommonResult<Boolean> batchDelAttachmentByContentId(ContentAttachmentForm.BatchDel form);
}
