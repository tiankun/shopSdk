package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Excel导入模板表：ImportemplateForm
 * 表：t_import_template
 * @author yj
 * @email yangj@redare.cn
 * @date 2020-03-17
 */
public class ImportemplateForm {
public static class Search {
    private String key;
    private String type;
    private Integer status;
    private Date beginTime; //导入开始时间
    private Date endTime; //导入截止时间
    public String getKey() {
        return key;
    }
    public Search setKey(String key) {
        this.key = key;
        return this;
    }

    public String getType() {
        return type;
    }

    public Search setType(String type) {
        this.type = type;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Search setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public Search setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
        return this;
    }

    public Date getEndTime() {
        return endTime;
    }

    public Search setEndTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }
}

public static class Get {
    private Long id;

    public Long getId(){
        return id;
    }
    public Get setId(Long id){
        this.id = id;
        return this;
    }
}

public static class Add {
    private String name;
    private String type;
    private String fileName;
    private String fileUrl;
    private Date createTime;
    private Long createUserId;
    private String createUserName;

    public String getName(){
        return name;
    }
    public Add setName(String name){
        this.name = name;
        return this;
    }
    public String getType(){
        return type;
    }
    public Add setType(String type){
        this.type = type;
        return this;
    }
    public String getFileName(){
        return fileName;
    }
    public Add setFileName(String fileName){
        this.fileName = fileName;
        return this;
    }
    public String getFileUrl(){
        return fileUrl;
    }
    public Add setFileUrl(String fileUrl){
        this.fileUrl = fileUrl;
        return this;
    }
    public Date getCreateTime(){
        return createTime;
    }
    public Add setCreateTime(Date createTime){
        this.createTime = createTime;
        return this;
    }
    public Long getCreateUserId(){
        return createUserId;
    }
    public Add setCreateUserId(Long createUserId){
        this.createUserId = createUserId;
        return this;
    }
    public String getCreateUserName(){
        return createUserName;
    }
    public Add setCreateUserName(String createUserName){
        this.createUserName = createUserName;
        return this;
    }

}

public static class Edit {
    @NotNull(message = "不能为空}")
    private Long id;
    private String name;
    private String type;
    private String fileName;
    private String fileUrl;
    private Date createTime;
    private Long createUserId;
    private String createUserName;
    private Integer status;

    public Long getId(){
        return id;
    }
    public Edit setId(Long id){
        this.id = id;
        return this;
    }
    public String getName(){
        return name;
    }
    public Edit setName(String name){
        this.name = name;
        return this;
    }
    public String getType(){
        return type;
    }
    public Edit setType(String type){
        this.type = type;
        return this;
    }
    public String getFileName(){
        return fileName;
    }
    public Edit setFileName(String fileName){
        this.fileName = fileName;
        return this;
    }
    public String getFileUrl(){
        return fileUrl;
    }
    public Edit setFileUrl(String fileUrl){
        this.fileUrl = fileUrl;
        return this;
    }
    public Date getCreateTime(){
        return createTime;
    }
    public Edit setCreateTime(Date createTime){
        this.createTime = createTime;
        return this;
    }
    public Long getCreateUserId(){
        return createUserId;
    }
    public Edit setCreateUserId(Long createUserId){
        this.createUserId = createUserId;
        return this;
    }
    public String getCreateUserName(){
        return createUserName;
    }
    public Edit setCreateUserName(String createUserName){
        this.createUserName = createUserName;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Edit setStatus(Integer status) {
        this.status = status;
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

    public enum GroupField {
        TYPE("type"),
        STATUS("status");

        private String field;
        public String getField() {
            return field;
        }
        GroupField(String field){
            this.field = field;
        }
    }

    public static class Group {
        private Search search;
        @NotEmpty(message = "分组字段不能为空")
        private List<GroupField> groupFieldList;

        public Search getSearch() {
            return search;
        }

        public Group setSearch(Search search) {
            this.search = search;
            return this;
        }

        public List<GroupField> getGroupFieldList() {
            return groupFieldList;
        }

        public Group setGroupFieldList(List<GroupField> groupFieldList) {
            this.groupFieldList = groupFieldList;
            return this;
        }
    }
}
