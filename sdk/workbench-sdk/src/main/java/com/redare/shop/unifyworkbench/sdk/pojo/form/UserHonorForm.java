package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

/**
 * @author : zhangsq
 * @version :
 * @description：人员荣誉信息表(TUserHonor)实体类
 * @date ：Created in 2020-10-19 19:15
 */
public class UserHonorForm {

    /**
     * @description: 添加
     * @author: zhangsq
     * @date: Created in 2020-10-19 15:16
     * @return:
     * @exception:
     */
    public static class Add{
        /**
         * 自增主键
         */
        private Long id;
        /**
         * 人员Id
         */
        private Long userId;
        /**
         * 荣誉名称
         */
        private String honorName;
        /**
         * 荣誉类型Id(字典表id)
         */
        private Long honorTypeId;
        /**
         * 荣誉类型名称
         */
        private String honorTypeName;
        /**
         * 荣誉获得时间
         */
        private Date honorTime;
        /**
         * 操作人
         */
        private String operator;
        /**
         * 是否删除0:正常,1:删除
         */
        private Integer del;
        /**
         * 创建时间
         */
        private Date createTime;
        /**
         * 修改时间
         */
        private Date updateTime;

        public Long getId() {
            return id;
        }

        public Add setId(Long id) {
            this.id = id;
            return this;
        }

        public Long getUserId() {
            return userId;
        }

        public Add setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public String getHonorName() {
            return honorName;
        }

        public Add setHonorName(String honorName) {
            this.honorName = honorName;
            return this;
        }

        public Long getHonorTypeId() {
            return honorTypeId;
        }

        public Add setHonorTypeId(Long honorTypeId) {
            this.honorTypeId = honorTypeId;
            return this;
        }

        public String getHonorTypeName() {
            return honorTypeName;
        }

        public Add setHonorTypeName(String honorTypeName) {
            this.honorTypeName = honorTypeName;
            return this;
        }

        public Date getHonorTime() {
            return honorTime;
        }

        public Add setHonorTime(Date honorTime) {
            this.honorTime = honorTime;
            return this;
        }

        public String getOperator() {
            return operator;
        }

        public Add setOperator(String operator) {
            this.operator = operator;
            return this;
        }

        public Integer getDel() {
            return del;
        }

        public Add setDel(Integer del) {
            this.del = del;
            return this;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public Add setCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public Date getUpdateTime() {
            return updateTime;
        }

        public Add setUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
            return this;
        }
    }

    /**
     * @description: 批量添加
     * @author: zhangsq
     * @date: Created in 2020-10-21 11:17
     * @return:
     * @exception:
     */
    public static class BatchAdd {

        private List<UserHonorForm.Add> list;

        private Long userId;

        public List<Add> getList() {
            return list;
        }

        public BatchAdd setList(List<Add> list) {
            this.list = list;
            return this;
        }

        public Long getUserId() {
            return userId;
        }

        public BatchAdd setUserId(Long userId) {
            this.userId = userId;
            return this;
        }
    }

    /**
     * @description: 搜索
     * @author: zhangsq
     * @date: Created in 2020-10-19 15:11
     * @return:
     * @exception:
     */
    public static class Search{
        private String key;

        private Long userId;

        private Integer del;

        public String getKey() {
            return key;
        }

        public Search setKey(String key) {
            this.key = key;
            return this;
        }

        public Long getUserId() {
            return userId;
        }

        public Search setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Integer getDel() {
            return del;
        }

        public Search setDel(Integer del) {
            this.del = del;
            return this;
        }
    }

    /**
     * @description: 编辑
     * @author: zhangsq
     * @date: Created in 2020-10-19 15:05
     * @return:
     * @exception:
     */
    public static class Edit{
        /**
         * 自增主键
         */
        private Long id;
        /**
         * 人员Id
         */
        private Long userId;
        /**
         * 荣誉名称
         */
        private String honorName;
        /**
         * 荣誉类型Id(字典表id)
         */
        private Long honorTypeId;
        /**
         * 荣誉类型名称
         */
        private String honorTypeName;
        /**
         * 荣誉获得时间
         */
        private Date honorTime;
        /**
         * 操作人
         */
        private String operator;
        /**
         * 是否删除0:正常,1:删除
         */
        private Integer del;
        /**
         * 创建时间
         */
        private Date createTime;
        /**
         * 修改时间
         */
        private Date updateTime;

        public Long getId() {
            return id;
        }

        public Edit setId(Long id) {
            this.id = id;
            return this;
        }

        public Long getUserId() {
            return userId;
        }

        public Edit setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public String getHonorName() {
            return honorName;
        }

        public Edit setHonorName(String honorName) {
            this.honorName = honorName;
            return this;
        }

        public Long getHonorTypeId() {
            return honorTypeId;
        }

        public Edit setHonorTypeId(Long honorTypeId) {
            this.honorTypeId = honorTypeId;
            return this;
        }

        public String getHonorTypeName() {
            return honorTypeName;
        }

        public Edit setHonorTypeName(String honorTypeName) {
            this.honorTypeName = honorTypeName;
            return this;
        }

        public Date getHonorTime() {
            return honorTime;
        }

        public Edit setHonorTime(Date honorTime) {
            this.honorTime = honorTime;
            return this;
        }

        public String getOperator() {
            return operator;
        }

        public Edit setOperator(String operator) {
            this.operator = operator;
            return this;
        }

        public Integer getDel() {
            return del;
        }

        public Edit setDel(Integer del) {
            this.del = del;
            return this;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public Edit setCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public Date getUpdateTime() {
            return updateTime;
        }

        public Edit setUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
            return this;
        }
    }

    /**
     * @description: 查询
     * @author: zhangsq
     * @date: Created in 2020-10-20 14:48
     * @return:
     * @exception:
     */
    public static class Get{
        /**
         * 自增主键
         */
        private Long id;
        /**
         * 人员Id
         */
        private Long userId;

        public Long getId() {
            return id;
        }

        public Get setId(Long id) {
            this.id = id;
            return this;
        }

        public Long getUserId() {
            return userId;
        }

        public Get setUserId(Long userId) {
            this.userId = userId;
            return this;
        }
    }

    /**
     * @description: 删除
     * @author: zhangsq
     * @date: Created in 2020-10-19 15:29
     * @return:
     * @exception:
     */
    public static class Del{
        /**
         * 自增主键
         */
        private Long id;

        private Long userId;

        public Long getId() {
            return id;
        }

        public Del setId(Long id) {
            this.id = id;
            return this;
        }

        public Long getUserId() {
            return userId;
        }

        public Del setUserId(Long userId) {
            this.userId = userId;
            return this;
        }
    }

    /**
     * @description: 批量删除
     * @author: zhangsq
     * @date: Created in 2020-10-21 10:58
     * @return:
     * @exception:
     */
    public static class BatchDel{
        /**
         * '用户ID'
         */
        @NotEmpty(message = "主键不能为空")
        List<Long> userIdList;

        public List<Long> getUserIdList() {
            return userIdList;
        }

        public BatchDel setUserIdList(List<Long> userIdList) {
            this.userIdList = userIdList;
            return this;
        }
    }

}
