package com.redare.shop.unifyworkbench.sdk.pojo.form;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * 公共的form基类
 * @Author: yanggr
 * @Date: 2020/6/5 15:33
 */
public class CommonForm {
    public static class Del{
        @NotNull(message = "主键不能为空")
        private Long id;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }

    /**
     * 批量删除
     */
    public static class BatchDel{
        public BatchDel() {
        }

        @NotEmpty(message = "主键不能为空")
        List<Long> ids;

        public List<Long> getIds() {
            return ids;
        }

        public BatchDel setIds(List<Long> ids) {
            this.ids = ids;
            return this;
        }
    }

    public static class Search {
        /**
         * 关键字
         */
        private String key;

        /**
         * 开始时间
         */
        private Date beginTime;
        /**
         * 截止时间
         */
        private Date endTime;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
        public Date getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(Date beginTime) {
            this.beginTime = beginTime;
        }

        public Date getEndTime() {
            return endTime;
        }

        public void setEndTime(Date endTime) {
            this.endTime = endTime;
        }
    }
}
