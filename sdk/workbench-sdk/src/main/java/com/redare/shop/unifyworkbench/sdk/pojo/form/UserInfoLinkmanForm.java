package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotNull;
import java.util.Date;
/**
 * ：UserInfoLinkmanForm
 * 表：t_user_info_linkman
 * @author yj
 * @email yangj@redare.cn
 * @date 2020-08-25
 */
public class UserInfoLinkmanForm {
public static class Search {
    private Long ztktUserId;

    public Long getZtktUserId() {
        return ztktUserId;
    }

    public Search setZtktUserId(Long ztktUserId) {
        this.ztktUserId = ztktUserId;
        return this;
    }
}

public static class Get {
    private Long id;

    /**
     * 统一门户用户id
     */
    private Long ztktUserId;
    /**
     * 通讯录userId
     */
    private String userId;

    public Long getId(){
        return id;
    }
    public Get setId(Long id){
        this.id = id;
        return this;
    }

    public Long getZtktUserId() {
        return ztktUserId;
    }

    public Get setZtktUserId(Long ztktUserId) {
        this.ztktUserId = ztktUserId;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public Get setUserId(String userId) {
        this.userId = userId;
        return this;
    }
}

public static class Add {
    private Long ztktUserId;
    private String userId;
    private Integer linkCount;
    private Date createTime;
    private Date updateTime;

    public Long getZtktUserId(){
        return ztktUserId;
    }
    public Add setZtktUserId(Long ztktUserId){
        this.ztktUserId = ztktUserId;
        return this;
    }
    public String getUserId(){
        return userId;
    }
    public Add setUserId(String userId){
        this.userId = userId;
        return this;
    }
    public Integer getLinkCount(){
        return linkCount;
    }
    public Add setLinkCount(Integer linkCount){
        this.linkCount = linkCount;
        return this;
    }
    public Date getCreateTime(){
        return createTime;
    }
    public Add setCreateTime(Date createTime){
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public Add setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}

public static class Edit {
    @NotNull(message = "主键不能为空")
    private Long id;
    private Long ztktUserId;
    private String userId;
    private Integer linkCount;
    private Date createTime;
    private Date updateTime;

    public Long getId(){
        return id;
    }
    public Edit setId(Long id){
        this.id = id;
        return this;
    }
    public Long getZtktUserId(){
        return ztktUserId;
    }
    public Edit setZtktUserId(Long ztktUserId){
        this.ztktUserId = ztktUserId;
        return this;
    }
    public String getUserId(){
        return userId;
    }
    public Edit setUserId(String userId){
        this.userId = userId;
        return this;
    }
    public Integer getLinkCount(){
        return linkCount;
    }
    public Edit setLinkCount(Integer linkCount){
        this.linkCount = linkCount;
        return this;
    }
    public Date getCreateTime(){
        return createTime;
    }
    public Edit setCreateTime(Date createTime){
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public Edit setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}

public static class Del {
    @NotNull(message = "id不能为空")
    private Long id;
    public Long getId() {
        return id;
    }
    public Del setId(Long id) {
        this.id = id;
        return this;
    }
}
}
