package com.redare.shop.unifyworkbench.sdk.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 评论表(SchoolComment)实体类
 *
 * @author dengchj
 * @since 2020-10-13 14:21:05
 */
public class SchoolComment implements Serializable {
    private static final long serialVersionUID = 388674802730578475L;
    /**
     * 主键Id
     */
    private Integer id;
    /**
     * 素材Id
     */
    private Integer materialId;
    /**
     * 内容
     */
    private String content;
    /**
     * 用户Id
     */
    private Integer userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 状态
     */
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialid(Integer materialId) {
        this.materialId = materialId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserid(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreatetime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdatetime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}