package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.shop.unifyworkbench.sdk.ContentAttachmentSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.ContentAttachment;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ContentAttachmentForm;
import com.redare.shop.unifyworkbench.service.service.ContentAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ContentAttachmentSdkImpl
 *
 * @Author zlx
 * @Date 2020/5/7 18:50
 */
@Service
public class ContentAttachmentSdkImpl implements ContentAttachmentSdk {

    @Autowired
    ContentAttachmentService contentAttachmentService;

    /**
     * 批量添加附件
     * @author zlx
     * @date 2020/5/7 18:53
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    @Override
    public CommonResult<Boolean> batchAddAttachment(ContentAttachmentForm.BatchAdd form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        Boolean bool = contentAttachmentService.batchAddAttachment(form).length>0;
        return CommonResult.returnBoolWrapper(bool,"批量添加失败");
    }

    /**
     * 删除数据
     * @author zlx
     * @date 2020/5/8 10:09
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    @Override
    public CommonResult<Boolean> deleteAttachment(ContentAttachmentForm.Del form) {
        contentAttachmentService.deleteAttachment(form);
        return CommonResult.returnBoolWrapper(true,"删除数据失败");
    }

    /**
     * 根据内容id查询附件
     * @author zlx
     * @date 2020/5/8 11:22
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.ContentAttachment>>
     */
    @Override
    public CommonResult<List<ContentAttachment>> findAttachmentList(ContentAttachmentForm.GetByContentId form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()){
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        List<ContentAttachment> list = contentAttachmentService.findContentAttachmentList(form);
        return CommonResult.returnSuccessWrapper(list);
    }

    /**
     * 根据内容id批量删除数据
     * @author zlx
     * @date 2020/5/9 11:23
     * @param form
     * @return com.redare.devframework.common.pojo.CommonResult<java.lang.Boolean>
     */
    @Override
    public CommonResult<Boolean> batchDelAttachmentByContentId(ContentAttachmentForm.BatchDel form) {
        if (form == null){
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        if (form.getContentId() == null || form.getContentId().size()<=0){
            return CommonResult.returnFailsWrapper("请传入id值");
        }
        Boolean bool = contentAttachmentService.batchDelAttachmentByContentId(form);
        return CommonResult.returnBoolWrapper(bool,"删除失败");
    }
}
