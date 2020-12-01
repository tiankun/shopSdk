package com.redare.shop.unifyworkbench.sdk.pojo;

public class AssignStatistics {

    private String areaCode;

    private String orgId;

    private String orgName;

    private String completionRate;

    private Long totalCount;

    private Long completionCount;

    private String sort;

    public String getAreaCode() {
        return areaCode;
    }

    public AssignStatistics setAreaCode(String areaCode) {
        this.areaCode = areaCode;
        return this;
    }

    public String getOrgId() {
        return orgId;
    }

    public AssignStatistics setOrgId(String orgId) {
        this.orgId = orgId;
        return this;
    }

    public String getOrgName() {
        return orgName;
    }

    public AssignStatistics setOrgName(String orgName) {
        this.orgName = orgName;
        return this;
    }

    public String getCompletionRate() {
        return completionRate;
    }

    public AssignStatistics setCompletionRate(String completionRate) {
        this.completionRate = completionRate;
        return this;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public AssignStatistics setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    public Long getCompletionCount() {
        return completionCount;
    }

    public AssignStatistics setCompletionCount(Long completionCount) {
        this.completionCount = completionCount;
        return this;
    }

    public String getSort() {
        return sort;
    }

    public AssignStatistics setSort(String sort) {
        this.sort = sort;
        return this;
    }
}
