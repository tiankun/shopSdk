package com.redare.shop.unifyworkbench.sdk.common.pojo;

import com.redare.devframework.common.pojo.LevelTreeQuery;

/**
 * 树形查询条件扩展
 * @Author: guangrongyang
 * @Date: 2020/10/22 19:28
 */

public class BaseLevelTreeQuery extends LevelTreeQuery {
    /**
     * 是否拼接上root节点
     */
    private Boolean includeRoot = false;

    public Boolean getIncludeRoot() {
        return includeRoot;
    }

    public void setIncludeRoot(Boolean includeRoot) {
        this.includeRoot = includeRoot;
    }
}
