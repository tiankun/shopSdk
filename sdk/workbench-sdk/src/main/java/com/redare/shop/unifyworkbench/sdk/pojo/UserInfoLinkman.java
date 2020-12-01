package com.redare.shop.unifyworkbench.sdk.pojo;

import java.util.Date;
/**
 * ：UserInfoLinkman
 * 表：t_user_info_linkman
 * @author yj
 * @email yangj@redare.cn
 * @date 2020-08-25
 */
public class UserInfoLinkman {
    /**
    * 主键
    */
    private Long id;
    /**
    * 统一门户userId
    */
    private Long ztktUserId;
    /**
    * 通讯录userId
    */
    private String userId;
    /**
    * 拨打次数
    */
    private Integer linkCount;
    /**
    * 创建时间
    */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
    
    public Long getId(){
        return id;
    }
    public UserInfoLinkman setId(Long id){
        this.id = id;
        return this;
    }
    public Long getZtktUserId(){
        return ztktUserId;
    }
    public UserInfoLinkman setZtktUserId(Long ztktUserId){
        this.ztktUserId = ztktUserId;
        return this;
    }
    public String getUserId(){
        return userId;
    }
    public UserInfoLinkman setUserId(String userId){
        this.userId = userId;
        return this;
    }
    public Integer getLinkCount(){
        return linkCount;
    }
    public UserInfoLinkman setLinkCount(Integer linkCount){
        this.linkCount = linkCount;
        return this;
    }
    public Date getCreateTime(){
        return createTime;
    }
    public UserInfoLinkman setCreateTime(Date createTime){
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public UserInfoLinkman setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}
