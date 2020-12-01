package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.PendingItemSdk;
import com.redare.shop.unifyworkbench.sdk.pojo.PendingItem;
import com.redare.shop.unifyworkbench.service.service.PendingItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PendingItemSdkImpl implements PendingItemSdk {
    @Autowired
    PendingItemService pendingItemService;
    @Override
    public CommonResult<Page<PendingItem>> queryPendingItemPage(PendingItem form, int curPage, int pageSize) {
        if(form.getHandleState()==0){
            return CommonResult.returnSuccessWrapper(pendingItemService.queryPendingItemPage(form,curPage,pageSize));
        }else{
            return CommonResult.returnSuccessWrapper(pendingItemService.queryHandledItemPage(form,curPage,pageSize));
        }
    }

    @Override
    public CommonResult<List<PendingItem>> queryPendingItemList(PendingItem form, int curPage, int pageSize) {
        if(form.getHandleState()==0){
            return CommonResult.returnSuccessWrapper(pendingItemService.queryPendingItemList(form,curPage,pageSize));
        }else{
            return CommonResult.returnSuccessWrapper(pendingItemService.queryHandledItemList(form,curPage,pageSize));
        }
    }

    @Override
    public CommonResult<List<PendingItem>> queryPendingItemList(PendingItem form) {
        if(form.getHandleState()==0){
            return CommonResult.returnSuccessWrapper(pendingItemService.queryPendingItemList(form));
        }else{
            return CommonResult.returnSuccessWrapper(pendingItemService.queryHandledItemList(form));
        }
    }

    @Override
    public CommonResult<PendingItem> queryItemCount(PendingItem form) {
        return CommonResult.returnSuccessWrapper(pendingItemService.queryItemCount(form));
    }

}
