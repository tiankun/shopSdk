package com.redare.shop.unifyworkbench.sdk;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.PendingItem;

import java.util.List;

/**
 * 待办事项
 */
public interface PendingItemSdk {

    CommonResult<Page<PendingItem>> queryPendingItemPage(PendingItem form, int curPage, int pageSize);

    CommonResult<List<PendingItem>> queryPendingItemList(PendingItem form, int curPage, int pageSize);

    CommonResult<List<PendingItem>> queryPendingItemList(PendingItem form);

    CommonResult<PendingItem> queryItemCount(PendingItem form);
}
