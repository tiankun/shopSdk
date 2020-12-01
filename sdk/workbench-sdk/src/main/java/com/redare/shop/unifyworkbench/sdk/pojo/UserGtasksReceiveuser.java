package com.redare.shop.unifyworkbench.sdk.pojo;

import java.util.Date;
/**
 * 待办任务接收人表：UserGtasksReceiveuser
 * 表：t_user_gtasks_receiveuser
 * @author yj
 * @email yangj@redare.cn
 * @date 2020-06-16
 */
public class UserGtasksReceiveuser {
    /**
    * 主键
    */
    private Long id;
    /**
    * 待办任务id
    */
    private Long gtasksId;
    /**
     * 流程实例id(各业务系统流程id、待办任务id)
     */
    private String flowId;
    /**
    * 接收人id
    */
    private String userId;
    /**
    * 接收人账号
    */
    private String userAccount;
    /**
    * 接收人姓名
    */
    private String userName;
    /**
    * 接收人部门id
    */
    private String departmentId;
    /**
    * 接收人部门名称
    */
    private String departmentName;
    /**
    * 接收人统一平台userId
    */
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
     * 处理结果(结果信息，可以为：审批通过、审批驳回、审批撤销等描述信息)
     */
    private String result;

    private Date startTime;

    private Date endTime;

    private String url;

    private String mobileUrl;
    
    public Long getId(){
        return id;
    }
    public UserGtasksReceiveuser setId(Long id){
        this.id = id;
        return this;
    }
    public Long getGtasksId(){
        return gtasksId;
    }
    public UserGtasksReceiveuser setGtasksId(Long gtasksId){
        this.gtasksId = gtasksId;
        return this;
    }
    public String getUserId(){
        return userId;
    }
    public UserGtasksReceiveuser setUserId(String userId){
        this.userId = userId;
        return this;
    }
    public String getUserAccount(){
        return userAccount;
    }
    public UserGtasksReceiveuser setUserAccount(String userAccount){
        this.userAccount = userAccount;
        return this;
    }
    public String getUserName(){
        return userName;
    }
    public UserGtasksReceiveuser setUserName(String userName){
        this.userName = userName;
        return this;
    }
    public String getDepartmentId(){
        return departmentId;
    }
    public UserGtasksReceiveuser setDepartmentId(String departmentId){
        this.departmentId = departmentId;
        return this;
    }
    public String getDepartmentName(){
        return departmentName;
    }
    public UserGtasksReceiveuser setDepartmentName(String departmentName){
        this.departmentName = departmentName;
        return this;
    }
    public Long getZtktUserId(){
        return ztktUserId;
    }
    public UserGtasksReceiveuser setZtktUserId(Long ztktUserId){
        this.ztktUserId = ztktUserId;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public UserGtasksReceiveuser setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getNodeName() {
        return nodeName;
    }

    public UserGtasksReceiveuser setNodeName(String nodeName) {
        this.nodeName = nodeName;
        return this;
    }

    public String getResult() {
        return result;
    }

    public UserGtasksReceiveuser setResult(String result) {
        this.result = result;
        return this;
    }

    public String getFlowId() {
        return flowId;
    }

    public UserGtasksReceiveuser setFlowId(String flowId) {
        this.flowId = flowId;
        return this;
    }

    public String getNodeId() {
        return nodeId;
    }

    public UserGtasksReceiveuser setNodeId(String nodeId) {
        this.nodeId = nodeId;
        return this;
    }

    public Date getStartTime() {
        return startTime;
    }

    public UserGtasksReceiveuser setStartTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    public Date getEndTime() {
        return endTime;
    }

    public UserGtasksReceiveuser setEndTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public UserGtasksReceiveuser setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getMobileUrl() {
        return mobileUrl;
    }

    public UserGtasksReceiveuser setMobileUrl(String mobileUrl) {
        this.mobileUrl = mobileUrl;
        return this;
    }
}
