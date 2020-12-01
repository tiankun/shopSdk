package com.redare.shop.unifyworkbench.sdk.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @date 2020-12-01 13:43:00
 * Created by tiankun
 */
public class HjmallindCard implements Serializable {

    /**
     * 自增主键
     */
    private Long id;

    /**
     *
     */
    private Integer storeId;

    /**
     * 卡券名称
     */
    private String name;

    /**
     * 卡券图片
     */
    private String picUrl;

    /**
     * 卡券描述
     */
    private String content;

    /**
     *
     */
    private Integer isDelete;

    /**
     *
     */
    private Integer addtime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public HjmallindCard setId(Long id) {
        this.id = id;
        return this;
    }


    public Integer getStoreId() {
        return storeId;
    }

    public HjmallindCard setStoreId(Integer storeId) {
        this.storeId = storeId;
        return this;
    }


    public String getName() {
        return name;
    }

    public HjmallindCard setName(String name) {
        this.name = name;
        return this;
    }


    public String getPicUrl() {
        return picUrl;
    }

    public HjmallindCard setPicUrl(String picUrl) {
        this.picUrl = picUrl;
        return this;
    }


    public String getContent() {
        return content;
    }

    public HjmallindCard setContent(String content) {
        this.content = content;
        return this;
    }


    public Integer getIsDelete() {
        return isDelete;
    }

    public HjmallindCard setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
        return this;
    }


    public Integer getAddtime() {
        return addtime;
    }

    public HjmallindCard setAddtime(Integer addtime) {
        this.addtime = addtime;
        return this;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public HjmallindCard setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public HjmallindCard setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

}