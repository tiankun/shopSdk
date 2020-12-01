package com.redare.shop.unifyworkbench.sdk.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 人员荣誉信息表(TUserHonor)实体类
 *
 * @author zhangsq
 * @since 2020-10-19 14:13:59
 */
public class UserHonor implements Serializable {
    private static final long serialVersionUID = 235669905664929161L;
    /**
     * 自增主键
     */
    private Long id;
    /**
     * 人员Id
     */
    private Long userId;
    /**
     * 荣誉名称
     */
    private String honorName;
    /**
     * 荣誉类型Id(字典表id)
     */
    private Long honorTypeId;
    /**
     * 荣誉类型名称
     */
    private String honorTypeName;
    /**
     * 荣誉获得时间
     */
    private Date honorTime;
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

    public Long getId() {
        return id;
    }

    public UserHonor setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public UserHonor setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getHonorName() {
        return honorName;
    }

    public UserHonor setHonorName(String honorName) {
        this.honorName = honorName;
        return this;
    }

    public Long getHonorTypeId() {
        return honorTypeId;
    }

    public UserHonor setHonorTypeId(Long honorTypeId) {
        this.honorTypeId = honorTypeId;
        return this;
    }

    public String getHonorTypeName() {
        return honorTypeName;
    }

    public UserHonor setHonorTypeName(String honorTypeName) {
        this.honorTypeName = honorTypeName;
        return this;
    }

    public Date getHonorTime() {
        return honorTime;
    }

    public UserHonor setHonorTime(Date honorTime) {
        this.honorTime = honorTime;
        return this;
    }

    public String getOperator() {
        return operator;
    }

    public UserHonor setOperator(String operator) {
        this.operator = operator;
        return this;
    }

    public Integer getDel() {
        return del;
    }

    public UserHonor setDel(Integer del) {
        this.del = del;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public UserHonor setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public UserHonor setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}