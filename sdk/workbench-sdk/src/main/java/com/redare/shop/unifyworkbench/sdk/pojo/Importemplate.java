package com.redare.shop.unifyworkbench.sdk.pojo;

import java.util.Date;

/**
 * Excel导入模板表：Importemplate
 * 表：t_import_template
 * @author yj
 * @email yangj@redare.cn
 * @date 2020-03-17
 */
public class Importemplate {
    /**
    * 
    */
    private Long id;
    /**
    * 导入模板名称
    */
    private String name;
    /**
    * 模板类型staff:员工花名册,training:培训,job:职位变动
    */
    private String type;
    /**
    * 模板文件名称
    */
    private String fileName;
    /**
    * 模板文件下载路径
    */
    private String fileUrl;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 创建人Id
    */
    private Long createUserId;
    /**
    * 创建人姓名
    */
    private String createUserName;

    /**
     * 更新时间
     */
    private Date updateTime;

    private Integer status;
    
    public Long getId(){
        return id;
    }
    public Importemplate setId(Long id){
        this.id = id;
        return this;
    }
    public String getName(){
        return name;
    }
    public Importemplate setName(String name){
        this.name = name;
        return this;
    }
    public String getType(){
        return type;
    }
    public Importemplate setType(String type){
        this.type = type;
        return this;
    }
    public String getFileName(){
        return fileName;
    }
    public Importemplate setFileName(String fileName){
        this.fileName = fileName;
        return this;
    }
    public String getFileUrl(){
        return fileUrl;
    }
    public Importemplate setFileUrl(String fileUrl){
        this.fileUrl = fileUrl;
        return this;
    }
    public Date getCreateTime(){
        return createTime;
    }
    public Importemplate setCreateTime(Date createTime){
        this.createTime = createTime;
        return this;
    }
    public Long getCreateUserId(){
        return createUserId;
    }
    public Importemplate setCreateUserId(Long createUserId){
        this.createUserId = createUserId;
        return this;
    }
    public String getCreateUserName(){
        return createUserName;
    }
    public Importemplate setCreateUserName(String createUserName){
        this.createUserName = createUserName;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public Importemplate setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Importemplate setStatus(Integer status) {
        this.status = status;
        return this;
    }
}
