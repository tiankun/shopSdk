package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * 素材附件管理(SchoolMaterialAttachment)Form
 *
 * @author dengchj
 * @since 2020-10-13 14:24:04
 */
public class SchoolMaterialAttachmentForm {

    public static class Edit extends CommonForm.Del {
        @NotNull(message = "状态不能为空")
        private Integer status;

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }
    }

    public static class Search extends CommonForm.Search {

        /**
         * 主键id
         */
        private Long uid;
        /**
         * 素材管理id
         */
        private Long materialId;
        /**
         * 文件名称
         */
        private String name;
        /**
         * 文件路径
         */
        private String url;
        /**
         * 文件大小
         */
        private Integer size;
        /**
         * 创建时间
         */
        private Date createTime;
        /**
         * 文件状态
         */
        private String status;
        /**
         * 文件类型
         */
        private String fileType;

        public Long getUid() {
            return uid;
        }

        public Search setUid(Long uid) {
            this.uid = uid;
            return this;
        }

        public Long getMaterialId() {
            return materialId;
        }

        public Search setMaterialId(Long materialId) {
            this.materialId = materialId;
            return this;
        }

        public String getName() {
            return name;
        }

        public Search setName(String name) {
            this.name = name;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Search setUrl(String url) {
            this.url = url;
            return this;
        }

        public Integer getSize() {
            return size;
        }

        public Search setSize(Integer size) {
            this.size = size;
            return this;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public Search setCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public String getStatus() {
            return status;
        }

        public Search setStatus(String status) {
            this.status = status;
            return this;
        }

        public String getFileType() {
            return fileType;
        }

        public Search setFileType(String fileType) {
            this.fileType = fileType;
            return this;
        }
    }

    public static class Add{
        private Long materialId;
        private String name;
        private String url;
        private Integer size;
        private Date createTime;
        private String status;
        private String fileType;

        public Long getMaterialId() {
            return materialId;
        }

        public Add setMaterialId(Long materialId) {
            this.materialId = materialId;
            return this;
        }

        public String getName() {
            return name;
        }

        public Add setName(String name) {
            this.name = name;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Add setUrl(String url) {
            this.url = url;
            return this;
        }

        public Integer getSize() {
            return size;
        }

        public Add setSize(Integer size) {
            this.size = size;
            return this;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public Add setCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public String getStatus() {
            return status;
        }

        public Add setStatus(String status) {
            this.status = status;
            return this;
        }

        public String getFileType() {
            return fileType;
        }

        public Add setFileType(String fileType) {
            this.fileType = fileType;
            return this;
        }
    }


    public static class BatchAdd{
        /**
         * 批量新增
         */
        private List<SchoolMaterialAttachmentForm.Add> addList;

        public List<SchoolMaterialAttachmentForm.Add> getAddList() {
            return addList;
        }

        public SchoolMaterialAttachmentForm.BatchAdd setAddList(List<SchoolMaterialAttachmentForm.Add> addList) {
            this.addList = addList;
            return this;
        }
    }
    public static class GetByMaterialId{
        private  Long materialId;

        public Long getMaterialId() {
            return materialId;
        }

        public GetByMaterialId setMaterialId(Long materialId) {
            this.materialId = materialId;
            return this;
        }
    }


    public static class BatchDel {
        List<Long> materialId;


        public List<Long> getMaterialId() {
            return materialId;
        }

        public BatchDel setMaterialId(List<Long> materialId) {
            this.materialId = materialId;
            return this;
        }
    }





    }