package com.redare.shop.unifyworkbench.sdk.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 人员与组织机构关联表(TUserOrg)实体类
 *
 * @author zhangsq
 * @since 2020-10-19 19:06:58
 */
public class UserOrg implements Serializable {
    private static final long serialVersionUID = -11416956010337079L;
    /**
     * 自增主键
     */
    private Long id;
    /**
     * 人员Id
     */
    private Long userId;
    /**
     * 组织机构Id
     */
    private String orgId;
    /**
     * 组织机构名称
     */
    private String orgName;
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
     * 任职类型Code
     */
    private String positionTypeCode;
    /**
     * 任职类型名称
     */
    private String positionTypeName;
    /**
     * 任职时间
     */
    private Date servedTime;
    /**
     * 操作人
     */
    private String operator;
    /**
     * 是否删除0:正常,1:删除
     */
    private Integer del;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 是否第一机构
     */
    private Boolean major;
    /**
     * 人员姓名
     */
    private String name;
    /**
     * 身份证号
     */
    private String cardNo;
    /**
     * 出生日期
     */
    private Date birthday;
    /**
     * 电话号码
     */
    private String mobile;
    /**
     * 性别
     */
    private String sex;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public UserOrg setName(String name) {
        this.name = name;
        return this;
    }

    public String getCardNo() {
        return cardNo;
    }

    public UserOrg setCardNo(String cardNo) {
        this.cardNo = cardNo;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public UserOrg setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public UserOrg setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public UserOrg setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public Boolean getMajor() {
        return major;
    }

    public UserOrg setMajor(Boolean major) {
        this.major = major;
        return this;
    }

    public Long getId() {
        return id;
    }

    public UserOrg setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public UserOrg setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getOrgId() {
        return orgId;
    }

    public UserOrg setOrgId(String orgId) {
        this.orgId = orgId;
        return this;
    }

    public String getOrgName() {
        return orgName;
    }

    public UserOrg setOrgName(String orgName) {
        this.orgName = orgName;
        return this;
    }

    public String getDeptId() {
        return deptId;
    }

    public UserOrg setDeptId(String deptId) {
        this.deptId = deptId;
        return this;
    }

    public String getDeptName() {
        return deptName;
    }

    public UserOrg setDeptName(String deptName) {
        this.deptName = deptName;
        return this;
    }

    public Integer getWomenPositionId() {
        return womenPositionId;
    }

    public UserOrg setWomenPositionId(Integer womenPositionId) {
        this.womenPositionId = womenPositionId;
        return this;
    }

    public String getWomenPosition() {
        return womenPosition;
    }

    public UserOrg setWomenPosition(String womenPosition) {
        this.womenPosition = womenPosition;
        return this;
    }

    public String getPositionTypeCode() {
        return positionTypeCode;
    }

    public UserOrg setPositionTypeCode(String positionTypeCode) {
        this.positionTypeCode = positionTypeCode;
        return this;
    }

    public String getPositionTypeName() {
        return positionTypeName;
    }

    public UserOrg setPositionTypeName(String positionTypeName) {
        this.positionTypeName = positionTypeName;
        return this;
    }

    public Date getServedTime() {
        return servedTime;
    }

    public UserOrg setServedTime(Date servedTime) {
        this.servedTime = servedTime;
        return this;
    }

    public String getOperator() {
        return operator;
    }

    public UserOrg setOperator(String operator) {
        this.operator = operator;
        return this;
    }

    public Integer getDel() {
        return del;
    }

    public UserOrg setDel(Integer del) {
        this.del = del;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public UserOrg setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public UserOrg setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}