package com.redare.shop.unifyworkbench.sdk.pojo;

import java.util.List;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/9/9 16:18
 * @version:
 */
public class DataReportConfigTree {

    private String type;
    private String typeName;
    private List<DataReportConfig> children;

    public String getType() {
        return type;
    }

    public DataReportConfigTree setType(String type) {
        this.type = type;
        return this;
    }

    public String getTypeName() {
        return typeName;
    }

    public DataReportConfigTree setTypeName(String typeName) {
        this.typeName = typeName;
        return this;
    }

    public List<DataReportConfig> getChildren() {
        return children;
    }

    public DataReportConfigTree setChildren(List<DataReportConfig> children) {
        this.children = children;
        return this;
    }
}
