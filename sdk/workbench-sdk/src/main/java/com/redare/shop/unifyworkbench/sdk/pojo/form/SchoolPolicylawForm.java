package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 学堂管理-政策法规(SchoolPolicylaw)Form
 *
 * @author dengchj
 * @since 2020-10-13 14:24:46
 */
public class SchoolPolicylawForm {

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
         * 主键Id
         */
        private Integer id;
        /**
         * 标题
         */
        private String title;
        /**
         * 内容
         */
        private String content;
        /**
         * 发布人Id
         */
        private Integer userId;
        /**
         * 发布人名称
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
        private Integer status;
        private Integer top;

        public Integer getId() {
            return id;
        }

        public Search setId(Integer id) {
            this.id = id;
            return this;
        }

        public String getTitle() {
            return title;
        }

        public Search setTitle(String title) {
            this.title = title;
            return this;
        }

        public String getContent() {
            return content;
        }

        public Search setContent(String content) {
            this.content = content;
            return this;
        }

        public Integer getUserId() {
            return userId;
        }

        public Search setUserId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public String getUserName() {
            return userName;
        }

        public Search setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public Search setCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public Date getUpdateTime() {
            return updateTime;
        }

        public Search setUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
            return this;
        }

        public Integer getStatus() {
            return status;
        }

        public Search setStatus(Integer status) {
            this.status = status;
            return this;
        }

        public Integer getTop() {
            return top;
        }

        public Search setTop(Integer top) {
            this.top = top;
            return this;
        }
    }

    public  static  class changeStatus{
        private Integer status;
        private Long id;

        public Integer getStatus() {
            return status;
        }

        public changeStatus setStatus(Integer status) {
            this.status = status;
            return this;
        }

        public Long getId() {
            return id;
        }

        public changeStatus setId(Long id) {
            this.id = id;
            return this;
        }
    }

    public static class Top {

        @NotNull(message = "请传入id")
        private Long id;

        @NotNull(message = "请传入置顶状态")
        private Integer top;

        public Long getId() {
            return id;
        }

        public Top setId(Long id) {
            this.id = id;
            return this;
        }

        public Integer getTop() {
            return top;
        }

        public Top setTop(Integer top) {
            this.top = top;
            return this;
        }
    }

}