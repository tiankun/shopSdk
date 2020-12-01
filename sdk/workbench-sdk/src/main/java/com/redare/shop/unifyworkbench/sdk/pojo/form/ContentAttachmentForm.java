package com.redare.shop.unifyworkbench.sdk.pojo.form;

import java.util.Date;
import java.util.List;

/**
 * TODO
 *
 * @Author zlx
 * @Date 2020/5/7 18:25
 */
public class ContentAttachmentForm {

    public static class Add{
        private Long contentId;
        private String name;
        private String url;
        private Integer size;
        private Date createTime;
        private String status;

        public String getStatus() {
            return status;
        }

        public Add setStatus(String status) {
            this.status = status;
            return this;
        }

        public Long getContentId() {
            return contentId;
        }

        public Add setContentId(Long contentId) {
            this.contentId = contentId;
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
    }

    public static class BatchAdd{
        /**
         * 批量新增
         */
        private List<ContentAttachmentForm.Add> addList;

        public List<Add> getAddList() {
            return addList;
        }

        public BatchAdd setAddList(List<Add> addList) {
            this.addList = addList;
            return this;
        }
    }

    public static class Del{
        private Long uid;
        private Long contentId;

        public Long getUid() {
            return uid;
        }

        public Del setUid(Long uid) {
            this.uid = uid;
            return this;
        }

        public Long getContentId() {
            return contentId;
        }

        public Del setContentId(Long contentId) {
            this.contentId = contentId;
            return this;
        }
    }

    public static class GetByContentId{
        private Long contentId;

        public Long getContentId() {
            return contentId;
        }

        public GetByContentId setContentId(Long contentId) {
            this.contentId = contentId;
            return this;
        }
    }

    public static class BatchDel{
        List<Long> contentId;

        public List<Long> getContentId() {
            return contentId;
        }

        public BatchDel setContentId(List<Long> contentId) {
            this.contentId = contentId;
            return this;
        }
    }
}
