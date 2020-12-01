package com.redare.shop.unifyworkbench.sdk.pojo;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description: 住址机构实体
 * @author: zlx
 * @date: Created in 2020/10/16 11:35
 * @version:
 */
public class Organization {
    /**
     * 自增主键，不要用
     */
    private Long id;
    /**
     * 组织机构Id
     */
    private String orgId;
    /**
     * 机构名称
     */
    private String orgName;
    /**
     * 机构简称
     */
    private String shortName;
    /**
     * 行政编码
     */
    private String areaCode;
    /**
     * 行政机构层级
     */
    private Integer areaLevel;
    /**
     * 行政名称
     */
    private String areaName;
    /**
     *机构类型code
     */
    private String orgTypeCode;
    /**
     *组织分类：hx-横向组织；zx-纵向组织
     */
    private String orgClassify;
    /**
     * 机构类型名称
     */
    private String orgTypeName;
    /**
     * 组织介绍
     */
    private String orgIntroduce;
    /**
     * 妇联主席
     */
    private String chairman;
    /**
     * 联系人
     */
    private String contact;
    /**
     * 联系人电话
     */
    private String telephone;
    /**
     * 父Id
     */
    private String parentId;
    /**
     * 层级
     */
    private Integer level;
    /**
     * 是否节点
     */
    private Integer isLeaf;
    /**
     * 备注
     */
    private String remark;
    /**
     * 组织机构的管理人员列表
     */
    private String orgManageUserIdList;
    /**
     * 组织机构Id层级标识
     */
    private String orgIdTag;
    /**
     * 组织机构IDLevel
     */
    private String orgIdLevel;
    /**
     * 组织机构名称层级
     */
    private String orgNameLevel;
    /**
     * 操作人员id
     */
    private Long userId;
    /**
     * 操作人员名称
     */
    private String userName;
    /**
     * 状态1：正常，0：，-1:删除
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 部门信息
     */
    private List<Department> departmentList;
    /**
     * 换届信息
     */
    private List<OrganizeChangeTerm> organizeChangeTermList;
    /**
     * 组织荣誉信息
     */
    private List<OrganizeHonor> organizeHonorList;

    private Map<String,Object> statistics;

    public Map<String, Object> getStatistics() {
        return statistics;
    }

    public Organization setStatistics(Map<String, Object> statistics) {
        this.statistics = statistics;
        return this;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public Organization setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
        return this;
    }

    public List<OrganizeChangeTerm> getOrganizeChangeTermList() {
        return organizeChangeTermList;
    }

    public Organization setOrganizeChangeTermList(List<OrganizeChangeTerm> organizeChangeTermList) {
        this.organizeChangeTermList = organizeChangeTermList;
        return this;
    }

    public List<OrganizeHonor> getOrganizeHonorList() {
        return organizeHonorList;
    }

    public Organization setOrganizeHonorList(List<OrganizeHonor> organizeHonorList) {
        this.organizeHonorList = organizeHonorList;
        return this;
    }

    public Integer getAreaLevel() {
        return areaLevel;
    }

    public Organization setAreaLevel(Integer areaLevel) {
        this.areaLevel = areaLevel;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Organization setId(Long id) {
        this.id = id;
        return this;
    }

    public String getOrgId() {
        return orgId;
    }

    public Organization setOrgId(String orgId) {
        this.orgId = orgId;
        return this;
    }

    public String getOrgName() {
        return orgName;
    }

    public Organization setOrgName(String orgName) {
        this.orgName = orgName;
        return this;
    }

    public String getShortName() {
        return shortName;
    }

    public Organization setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public Organization setAreaCode(String areaCode) {
        this.areaCode = areaCode;
        return this;
    }

    public String getAreaName() {
        return areaName;
    }

    public Organization setAreaName(String areaName) {
        this.areaName = areaName;
        return this;
    }

    public String getOrgTypeCode() {
        return orgTypeCode;
    }

    public Organization setOrgTypeCode(String orgTypeCode) {
        this.orgTypeCode = orgTypeCode;
        return this;
    }

    public String getOrgClassify() {
        return orgClassify;
    }

    public Organization setOrgClassify(String orgClassify) {
        this.orgClassify = orgClassify;
        return this;
    }

    public String getOrgTypeName() {
        return orgTypeName;
    }

    public Organization setOrgTypeName(String orgTypeName) {
        this.orgTypeName = orgTypeName;
        return this;
    }

    public String getOrgIntroduce() {
        return orgIntroduce;
    }

    public Organization setOrgIntroduce(String orgIntroduce) {
        this.orgIntroduce = orgIntroduce;
        return this;
    }

    public String getChairman() {
        return chairman;
    }

    public Organization setChairman(String chairman) {
        this.chairman = chairman;
        return this;
    }

    public String getContact() {
        return contact;
    }

    public Organization setContact(String contact) {
        this.contact = contact;
        return this;
    }

    public String getTelephone() {
        return telephone;
    }

    public Organization setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public String getParentId() {
        return parentId;
    }

    public Organization setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    public Integer getLevel() {
        return level;
    }

    public Organization setLevel(Integer level) {
        this.level = level;
        return this;
    }

    public Integer getIsLeaf() {
        return isLeaf;
    }

    public Organization setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public Organization setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getOrgManageUserIdList() {
        return orgManageUserIdList;
    }

    public Organization setOrgManageUserIdList(String orgManageUserIdList) {
        this.orgManageUserIdList = orgManageUserIdList;
        return this;
    }

    public String getOrgIdTag() {
        return orgIdTag;
    }

    public Organization setOrgIdTag(String orgIdTag) {
        this.orgIdTag = orgIdTag;
        return this;
    }

    public String getOrgIdLevel() {
        return orgIdLevel;
    }

    public Organization setOrgIdLevel(String orgIdLevel) {
        this.orgIdLevel = orgIdLevel;
        return this;
    }

    public String getOrgNameLevel() {
        return orgNameLevel;
    }

    public Organization setOrgNameLevel(String orgNameLevel) {
        this.orgNameLevel = orgNameLevel;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public Organization setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public Organization setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Organization setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Organization setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public Organization setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}
