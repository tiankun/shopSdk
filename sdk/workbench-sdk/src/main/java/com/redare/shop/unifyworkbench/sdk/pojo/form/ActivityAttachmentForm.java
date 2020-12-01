package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * 学堂管理-素材附件管理(ActivityAttachment)Form
 *
 * @author dengchj
 * @since 2020-10-19 18:03:17
 */
public class ActivityAttachmentForm {

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

    public static class GetByActivityId {
        private Long activityId;
        private String fileType;
        List<Long> activityIds;


        public String getFileType() {
            return fileType;
        }

        public List<Long> getActivityIds() {
            return activityIds;
        }

        public GetByActivityId setActivityIds(List<Long> activityIds) {
            this.activityIds = activityIds;
            return this;
        }

        public GetByActivityId setFileType(String fileType) {
            this.fileType = fileType;
            return this;

        }

        public Long getActivityId() {
            return activityId;
        }

        public GetByActivityId setActivityId(Long activityId) {
            this.activityId = activityId;
            return this;
        }
    }
    public static class BatchDel {
        List<Long> activityId;
        String fileType;

        public List<Long> getActivityId() {
            return activityId;
        }

        public BatchDel setActivityId(List<Long> activityId) {
            this.activityId = activityId;
            return this;
        }

        public String getFileType() {
            return fileType;
        }

        public BatchDel setFileType(String fileType) {
            this.fileType = fileType;
            return this;
        }
    }

    public static class Add {
        private Long activityId;
        private String name;
        private String url;
        private Integer size;
        private Date createTime;
        private String status;
        private String fileType;

        public Long getActivityId() {
            return activityId;
        }

        public Add setActivityId(Long activityId) {
            this.activityId = activityId;
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

    public static class BatchAdd {
        /**
         * 批量新增
         */
        private List<ActivityAttachmentForm.Add> addList;

        public List<Add> getAddList() {
            return addList;
        }

        public BatchAdd setAddList(List<Add> addList) {
            this.addList = addList;
            return this;
        }
    }

    public static  class Del{
        private Long uid;
        private Long activityId;
        private String fileType;

        public Long getUid() {
            return uid;
        }

        public Del setUid(Long uid) {
            this.uid = uid;
            return this;
        }

        public Long getActivityId() {
            return activityId;
        }

        public Del setActivityId(Long activityId) {
            this.activityId = activityId;
            return this;
        }

        public String getFileType() {
            return fileType;
        }

        public Del setFileType(String fileType) {
            this.fileType = fileType;
            return this;
        }
    }


    }