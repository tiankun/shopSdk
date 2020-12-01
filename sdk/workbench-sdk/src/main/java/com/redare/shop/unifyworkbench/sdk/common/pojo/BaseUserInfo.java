package com.redare.shop.unifyworkbench.sdk.common.pojo;

import com.redare.shop.unifyworkbench.sdk.pojo.BaseUser;

/**
 * 完整用户信息
 * base_account
 * base_user
 * t_organization
 * t_user_org
 *
 * @Author: guangrongyang
 * @Date: 2020/10/20 11:38
 */

public class BaseUserInfo extends BaseUser {

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
     * 机构类型Id
     */
    private String orgTypeCode;
    /**
     * 机构类型Id
     */
    private String orgClassify;
    /**
     * 机构类型名称
     */
    private String orgTypeName;

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
     * org父Id
     */
    private String parentId;
    /**
     * 层级
     */
    private Integer level;

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
     * 部门Id
     */
    private String deptId;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 妇联职位Id(字典表id)
     */
    private Integer womenPositionId;
    /**
     * 妇联职位
     */
    private String womenPosition;

    /**
     * 行政父级编码
     */
    private String parentCode;
    /**
     * 行政区域级别
     */
    private Integer arealevel;
    /**
     * 是否叶子
     */
    private Integer areaLeaf;

    /**
     * 行政区域的管理列表
     */
    private String areaManageUserIdList;
    /**
     * 行政区域Id层级标识
     */
    private String areaIdTag;
    /**
     * 行政区域IDLevel
     */
    private String areaIdLevel;
    /**
     * 行政区域名称层级
     */
    private String areaNameLevel;
    /**
     * 否开启修改密码 no-无，remind:提醒 mandatory:强制
     */
    private String changePasswordSwitch ="no";

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public Integer getAreaLevel() {
        return areaLevel;
    }

    public void setAreaLevel(Integer areaLevel) {
        this.areaLevel = areaLevel;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getOrgTypeCode() {
        return orgTypeCode;
    }

    public BaseUserInfo setOrgTypeCode(String orgTypeCode) {
        this.orgTypeCode = orgTypeCode;
        return this;
    }

    public String getOrgClassify() {
        return orgClassify;
    }

    public BaseUserInfo setOrgClassify(String orgClassify) {
        this.orgClassify = orgClassify;
        return this;
    }

    public String getOrgTypeName() {
        return orgTypeName;
    }

    public void setOrgTypeName(String orgTypeName) {
        this.orgTypeName = orgTypeName;
    }

    public String getChairman() {
        return chairman;
    }

    public void setChairman(String chairman) {
        this.chairman = chairman;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getOrgManageUserIdList() {
        return orgManageUserIdList;
    }

    public void setOrgManageUserIdList(String orgManageUserIdList) {
        this.orgManageUserIdList = orgManageUserIdList;
    }

    public String getOrgIdTag() {
        return orgIdTag;
    }

    public void setOrgIdTag(String orgIdTag) {
        this.orgIdTag = orgIdTag;
    }

    public String getOrgIdLevel() {
        return orgIdLevel;
    }

    public void setOrgIdLevel(String orgIdLevel) {
        this.orgIdLevel = orgIdLevel;
    }

    public String getOrgNameLevel() {
        return orgNameLevel;
    }

    public void setOrgNameLevel(String orgNameLevel) {
        this.orgNameLevel = orgNameLevel;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public Integer getArealevel() {
        return arealevel;
    }

    public void setArealevel(Integer arealevel) {
        this.arealevel = arealevel;
    }

    public Integer getAreaLeaf() {
        return areaLeaf;
    }

    public void setAreaLeaf(Integer areaLeaf) {
        this.areaLeaf = areaLeaf;
    }

    public String getAreaManageUserIdList() {
        return areaManageUserIdList;
    }

    public void setAreaManageUserIdList(String areaManageUserIdList) {
        this.areaManageUserIdList = areaManageUserIdList;
    }

    public String getAreaIdTag() {
        return areaIdTag;
    }

    public void setAreaIdTag(String areaIdTag) {
        this.areaIdTag = areaIdTag;
    }

    public String getAreaIdLevel() {
        return areaIdLevel;
    }

    public void setAreaIdLevel(String areaIdLevel) {
        this.areaIdLevel = areaIdLevel;
    }

    public String getAreaNameLevel() {
        return areaNameLevel;
    }

    public void setAreaNameLevel(String areaNameLevel) {
        this.areaNameLevel = areaNameLevel;
    }

    public String getChangePasswordSwitch() {
        return changePasswordSwitch;
    }

    public void setChangePasswordSwitch(String changePasswordSwitch) {
        this.changePasswordSwitch = changePasswordSwitch;
    }

    @Override
    public String getDeptId() {
        return deptId;
    }

    @Override
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    @Override
    public String getDeptName() {
        return deptName;
    }

    @Override
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public Integer getWomenPositionId() {
        return womenPositionId;
    }

    @Override
    public void setWomenPositionId(Integer womenPositionId) {
        this.womenPositionId = womenPositionId;
    }

    @Override
    public String getWomenPosition() {
        return womenPosition;
    }

    @Override
    public void setWomenPosition(String womenPosition) {
        this.womenPosition = womenPosition;
    }

    @Override
    public String toString() {
        return "BaseUserInfo{" +
                "areaCode='" + areaCode + '\'' +
                ", areaLevel=" + areaLevel +
                ", areaName='" + areaName + '\'' +
                ", orgTypeCode='" + orgTypeCode + '\'' +
                ", orgClassify='" + orgClassify + '\'' +
                ", orgTypeName='" + orgTypeName + '\'' +
                ", chairman='" + chairman + '\'' +
                ", contact='" + contact + '\'' +
                ", telephone='" + telephone + '\'' +
                ", parentId='" + parentId + '\'' +
                ", level=" + level +
                ", orgManageUserIdList='" + orgManageUserIdList + '\'' +
                ", orgIdTag='" + orgIdTag + '\'' +
                ", orgIdLevel='" + orgIdLevel + '\'' +
                ", orgNameLevel='" + orgNameLevel + '\'' +
                ", deptId='" + deptId + '\'' +
                ", deptName='" + deptName + '\'' +
                ", womenPositionId=" + womenPositionId +
                ", womenPosition='" + womenPosition + '\'' +
                ", parentCode='" + parentCode + '\'' +
                ", arealevel=" + arealevel +
                ", areaLeaf=" + areaLeaf +
                ", areaManageUserIdList='" + areaManageUserIdList + '\'' +
                ", areaIdTag='" + areaIdTag + '\'' +
                ", areaIdLevel='" + areaIdLevel + '\'' +
                ", areaNameLevel='" + areaNameLevel + '\'' +
                '}';
    }
}
