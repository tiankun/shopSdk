package com.redare.shop.unifyworkbench.sdk.pojo.form;


import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * 待办任务接收人表：UserGtasksReceiveuserForm
 * 表：t_user_gtasks_receiveuser
 * @author yj
 * @email yangj@redare.cn
 * @date 2020-06-16
 */
public class UserGtasksReceiveuserForm {
    public static class Search {
        private String key;
        public String getKey() {
            return key;
        }
        public Search setKey(String key) {
            this.key = key;
            return this;
        }
    }



    public static class Get {

        /**
         * 流程id
         */
        @NotNull(message = "流程id不能为空")
        private String flowId;

        /**
         * 任务节点Id
         */
        @NotNull(message = "任务节点id不能为空")
        private String nodeId;

        private String userId;


        public String getFlowId() {
            return flowId;
        }

        public Get setFlowId(String flowId) {
            this.flowId = flowId;
            return this;
        }

        public String getNodeId() {
            return nodeId;
        }

        public Get setNodeId(String nodeId) {
            this.nodeId = nodeId;
            return this;
        }

        public String getUserId() {
            return userId;
        }

        public Get setUserId(String userId) {
            this.userId = userId;
            return this;
        }
    }

    public static class Add {
        private Long gtasksId;
        /**
         * 流程实例id(各业务系统流程id、待办任务id)
         */
        private String flowId;
        private String userId;
        private String userAccount;
        private String userName;
        private String departmentId;
        private String departmentName;
        private Long ztktUserId;
        /**
         * 状态 0:待办 1：已办
         */
        private Integer status;
        /**
         * 任务节点Id
         */
        private String nodeId;
        /**
         * 任务节点名称
         */
        private String nodeName;
        /**
         * 处理结果
         */
        private String result;

        private Date startTime;

        private Date endTime;

        private String url;

        private String mobileUrl;

        public Long getGtasksId() {
            return gtasksId;
        }

        public Add setGtasksId(Long gtasksId) {
            this.gtasksId = gtasksId;
            return this;
        }

        public String getFlowId() {
            return flowId;
        }

        public Add setFlowId(String flowId) {
            this.flowId = flowId;
            return this;
        }

        public String getUserId() {
            return userId;
        }

        public Add setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public String getUserAccount() {
            return userAccount;
        }

        public Add setUserAccount(String userAccount) {
            this.userAccount = userAccount;
            return this;
        }

        public String getUserName() {
            return userName;
        }

        public Add setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public String getDepartmentId() {
            return departmentId;
        }

        public Add setDepartmentId(String departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public String getDepartmentName() {
            return departmentName;
        }

        public Add setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
            return this;
        }

        public Long getZtktUserId() {
            return ztktUserId;
        }

        public Add setZtktUserId(Long ztktUserId) {
            this.ztktUserId = ztktUserId;
            return this;
        }

        public Integer getStatus() {
            return status;
        }

        public Add setStatus(Integer status) {
            this.status = status;
            return this;
        }

        public String getNodeName() {
            return nodeName;
        }

        public Add setNodeName(String nodeName) {
            this.nodeName = nodeName;
            return this;
        }

        public String getResult() {
            return result;
        }

        public Add setResult(String result) {
            this.result = result;
            return this;
        }

        public String getNodeId() {
            return nodeId;
        }

        public Add setNodeId(String nodeId) {
            this.nodeId = nodeId;
            return this;
        }

        public Date getStartTime() {
            return startTime;
        }

        public Add setStartTime(Date startTime) {
            this.startTime = startTime;
            return this;
        }

        public Date getEndTime() {
            return endTime;
        }

        public Add setEndTime(Date endTime) {
            this.endTime = endTime;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Add setUrl(String url) {
            this.url = url;
            return this;
        }

        public String getMobileUrl() {
            return mobileUrl;
        }

        public Add setMobileUrl(String mobileUrl) {
            this.mobileUrl = mobileUrl;
            return this;
        }
    }

    public static class Edit {
        @NotNull(message = "id不能为空")
        private Long id;
        private Long gtasksId;
        /**
         * 流程实例id(各业务系统流程id、待办任务id)
         */
        private String flowId;
        private String userId;
        private String userAccount;
        private String userName;
        private String departmentId;
        private String departmentName;
        private Long ztktUserId;
        /**
         * 状态 0:待办 1：已办
         */
        private Integer status;
        /**
         * 任务节点Id
         */
        private String nodeId;
        /**
         * 任务节点名称
         */
        private String nodeName;

        private Date startTime;

        private Date endTime;

        private String url;

        private String mobileUrl;

        public Long getId() {
            return id;
        }
        /**
         * 处理结果
         */
        private String result;

        public Edit setId(Long id) {
            this.id = id;
            return this;
        }

        public Long getGtasksId() {
            return gtasksId;
        }

        public Edit setGtasksId(Long gtasksId) {
            this.gtasksId = gtasksId;
            return this;
        }

        public String getFlowId() {
            return flowId;
        }

        public Edit setFlowId(String flowId) {
            this.flowId = flowId;
            return this;
        }

        public String getUserId() {
            return userId;
        }

        public Edit setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public String getUserAccount() {
            return userAccount;
        }

        public Edit setUserAccount(String userAccount) {
            this.userAccount = userAccount;
            return this;
        }

        public String getUserName() {
            return userName;
        }

        public Edit setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public String getDepartmentId() {
            return departmentId;
        }

        public Edit setDepartmentId(String departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public String getDepartmentName() {
            return departmentName;
        }

        public Edit setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
            return this;
        }

        public Long getZtktUserId() {
            return ztktUserId;
        }

        public Edit setZtktUserId(Long ztktUserId) {
            this.ztktUserId = ztktUserId;
            return this;
        }

        public Integer getStatus() {
            return status;
        }

        public Edit setStatus(Integer status) {
            this.status = status;
            return this;
        }

        public String getNodeName() {
            return nodeName;
        }

        public Edit setNodeName(String nodeName) {
            this.nodeName = nodeName;
            return this;
        }

        public String getResult() {
            return result;
        }

        public Edit setResult(String result) {
            this.result = result;
            return this;
        }

        public String getNodeId() {
            return nodeId;
        }

        public Edit setNodeId(String nodeId) {
            this.nodeId = nodeId;
            return this;
        }

        public Date getStartTime() {
            return startTime;
        }

        public Edit setStartTime(Date startTime) {
            this.startTime = startTime;
            return this;
        }

        public Date getEndTime() {
            return endTime;
        }

        public Edit setEndTime(Date endTime) {
            this.endTime = endTime;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Edit setUrl(String url) {
            this.url = url;
            return this;
        }

        public String getMobileUrl() {
            return mobileUrl;
        }

        public Edit setMobileUrl(String mobileUrl) {
            this.mobileUrl = mobileUrl;
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

    public static class BatchDel{
        private String flowId;

        public String getFlowId() {
            return flowId;
        }

        public BatchDel setFlowId(String flowId) {
            this.flowId = flowId;
            return this;
        }
    }

    public static class BatchAdd{

        //主表id
        private Long gtasksId;
        @NotNull(message = "userId不能为空")
        private Long userId;//统一门户用户id

        private List<UserGtasksReceiveuserForm.Add> addList;

        public Long getGtasksId() {
            return gtasksId;
        }

        public BatchAdd setGtasksId(Long gtasksId) {
            this.gtasksId = gtasksId;
            return this;
        }

        public Long getUserId() {
            return userId;
        }

        public BatchAdd setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public List<Add> getAddList() {
            return addList;
        }

        public BatchAdd setAddList(List<Add> addList) {
            this.addList = addList;
            return this;
        }
    }

    public static class BatchEdit{
        private List<UserGtasksReceiveuserForm.Edit> editList;

        public List<Edit> getEditList() {
            return editList;
        }

        public BatchEdit setEditList(List<Edit> editList) {
            this.editList = editList;
            return this;
        }
    }

}
