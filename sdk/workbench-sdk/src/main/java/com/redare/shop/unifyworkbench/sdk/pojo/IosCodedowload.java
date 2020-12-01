package com.redare.shop.unifyworkbench.sdk.pojo;

/**
 * @description: IosCodedowload
 * @author: zlx
 * @date: Created in 2020/7/17 11:09
 * @version: 1.1
 */
public class IosCodedowload {
    /**
     * 主键
     */
    private Long id;
    /**
     * 下载code
     */
    private String code;
    /**
     * 下载地址
     */
    private String url;
    /**
     * 状态(0-未使用，1-已使用)
     */
    private Integer status;

    public Long getId() {
        return id;
    }

    public IosCodedowload setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public IosCodedowload setCode(String code) {
        this.code = code;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public IosCodedowload setUrl(String url) {
        this.url = url;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public IosCodedowload setStatus(Integer status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        return "IosCodedowload{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", url='" + url + '\'' +
                ", status=" + status +
                '}';
    }
}
