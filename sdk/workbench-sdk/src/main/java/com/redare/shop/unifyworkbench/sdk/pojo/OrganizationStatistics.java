package com.redare.shop.unifyworkbench.sdk.pojo;

import java.io.Serializable;

/**
 * @description: 用于横向组织和纵向组织统计
 * @author: zlx
 * @date: Created in 2020/11/2 16:24
 * @version:
 */
public class OrganizationStatistics implements Serializable {
    /**
     * 组织类型：hx—横向组织、zx-纵向组织
     */
    private String orgClassify;
    /**
     * 机构类型code
     */
    private String orgTypeCode;
    /**
     * 机构类型名称
     */
    private String orgTypeName;
    /**
     * 机构类型code计数
     */
    private String codeCount;
    /**
     * 组织类型计数
     */
    private String classifyCount;
    /**
     * 百分比
     */
    private String percentage;

    public String getOrgClassify() {
        return orgClassify;
    }

    public void setOrgClassify(String orgClassify) {
        this.orgClassify = orgClassify;
    }

    public String getOrgTypeCode() {
        return orgTypeCode;
    }

    public void setOrgTypeCode(String orgTypeCode) {
        this.orgTypeCode = orgTypeCode;
    }

    public String getOrgTypeName() {
        return orgTypeName;
    }

    public void setOrgTypeName(String orgTypeName) {
        this.orgTypeName = orgTypeName;
    }

    public String getCodeCount() {
        return codeCount;
    }

    public void setCodeCount(String codeCount) {
        this.codeCount = codeCount;
    }

    public String getClassifyCount() {
        return classifyCount;
    }

    public void setClassifyCount(String classifyCount) {
        this.classifyCount = classifyCount;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
}
