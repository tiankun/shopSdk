package com.redare.shop.unifyworkbench.sdk.pojo.form;

import java.util.Date;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/7/29 10:11
 * @version: 1.1
 */
public class LoginLogForm {

    public static class Search{
        private String key;
        private Date startTime;
        private Date endTime;

        public String getKey() {
            return key;
        }

        public Search setKey(String key) {
            this.key = key;
            return this;
        }

        public Date getStartTime() {
            return startTime;
        }

        public Search setStartTime(Date startTime) {
            this.startTime = startTime;
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

    public static class Add{
        private String classify;
        private String operator;
        private String content;
        private Date createTime;
        private String source;

        public String getSource() {
            return source;
        }

        public Add setSource(String source) {
            this.source = source;
            return this;
        }

        public String getClassify() {
            return classify;
        }

        public Add setClassify(String classify) {
            this.classify = classify;
            return this;
        }

        public String getOperator() {
            return operator;
        }

        public Add setOperator(String operator) {
            this.operator = operator;
            return this;
        }

        public String getContent() {
            return content;
        }

        public Add setContent(String content) {
            this.content = content;
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
}
