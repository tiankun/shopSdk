package com.redare.shop.unifyworkbench.sdk.pojo.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * ContentManageForm
 * 表：t_content_manage
 *
 * @Author zlx
 * @Date 2020/5/6 14:46
 */
public class ContentManageForm {

    public static class Search{
        private String key;
        private String title;
        private Integer classify;
        private Integer status;
        private Date startTime;
        private Date endTime;
        private Long publishId;
        private Boolean bool = false;
        private List<Integer> classifyList;

        public List<Integer> getClassifyList() {
            return classifyList;
        }

        public Search setClassifyList(List<Integer> classifyList) {
            this.classifyList = classifyList;
            return this;
        }

        public Long getPublishId() {
            return publishId;
        }

        public Search setPublishId(Long publishId) {
            this.publishId = publishId;
            return this;
        }

        public String getKey() {
            return key;
        }

        public Search setKey(String key) {
            this.key = key;
            return this;
        }

        public String getTitle() {
            return title;
        }

        public Search setTitle(String title) {
            this.title = title;
            return this;
        }

        public Integer getClassify() {
            return classify;
        }

        public Search setClassify(Integer classify) {
            this.classify = classify;
            return this;
        }

        public Integer getStatus() {
            return status;
        }

        public Search setStatus(Integer status) {
            this.status = status;
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

        public Boolean getBool() {
            return bool;
        }

        public Search setBool(Boolean bool) {
            this.bool = bool;
            return this;
        }
    }

    public static class Add{
        @NotBlank(message = "标题不能为空")
        private String title;
        private String content;
        private String cover;
        private String enclosure;
        @NotNull(message = "分类不能为空")
        private Integer classify;
        private Integer syncToSite;
        private Long publishId;
        private Date publishTime;
        private Integer status;
        private Date createTime;
        @NotBlank(message = "接收组织不能为空")
        private String orgIds;
        private String orgNames;

        public String getOrgIds() {
            return orgIds;
        }

        public Add setOrgIds(String orgIds) {
            this.orgIds = orgIds;
            return this;
        }

        public String getOrgNames() {
            return orgNames;
        }

        public Add setOrgNames(String orgNames) {
            this.orgNames = orgNames;
            return this;
        }

        public String getTitle() {
            return title;
        }

        public Add setTitle(String title) {
            this.title = title;
            return this;
        }

        public String getContent() {
            return content;
        }

        public Add setContent(String content) {
            this.content = content;
            return this;
        }

        public String getCover() {
            return cover;
        }

        public Add setCover(String cover) {
            this.cover = cover;
            return this;
        }

        public String getEnclosure() {
            return enclosure;
        }

        public Add setEnclosure(String enclosure) {
            this.enclosure = enclosure;
            return this;
        }

        public Integer getClassify() {
            return classify;
        }

        public Add setClassify(Integer classify) {
            this.classify = classify;
            return this;
        }

        public Integer getSyncToSite() {
            return syncToSite;
        }

        public Add setSyncToSite(Integer syncToSite) {
            this.syncToSite = syncToSite;
            return this;
        }

        public Long getPublishId() {
            return publishId;
        }

        public Add setPublishId(Long publishId) {
            this.publishId = publishId;
            return this;
        }

        public Date getPublishTime() {
            return publishTime;
        }

        public Add setPublishTime(Date publishTime) {
            this.publishTime = publishTime;
            return this;
        }

        public Integer getStatus() {
            return status;
        }

        public Add setStatus(Integer status) {
            this.status = status;
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

    public static class EditStatus{
        @NotNull(message = "主键id不能为空")
        private Long id;
        private Integer status;

        public Long getId() {
            return id;
        }

        public EditStatus setId(Long id) {
            this.id = id;
            return this;
        }

        public Integer getStatus() {
            return status;
        }

        public EditStatus setStatus(Integer status) {
            this.status = status;
            return this;
        }
    }

    public static class Del{
        @NotNull(message = "主键id不能为空")
        private Long id;

        public Long getId() {
            return id;
        }

        public Del setId(Long id) {
            this.id = id;
            return this;
        }
    }

    public static class Get{
        @NotNull(message = "主键id不能为空")
        private Long id;
        private Long userMsgId;

        public Long getUserMsgId() {
            return userMsgId;
        }

        public Get setUserMsgId(Long userMsgId) {
            this.userMsgId = userMsgId;
            return this;
        }

        public Long getId() {
            return id;
        }

        public Get setId(Long id) {
            this.id = id;
            return this;
        }
    }

    public static class Edit{
        @NotNull(message = "主键id不能为空")
        private Long id;
        @NotBlank(message = "标题不能为空")
        private String title;
        private String content;
        private String cover;
        private String enclosure;
        @NotNull(message = "分类不能为空")
        private Integer classify;
        private Integer syncToSite;
        private Long publishId;
        private Integer browse;
        private Date publishTime;
        private Integer status;
        private Date createTime;
        @NotBlank(message = "接收组织不能为空")
        private String orgIds;
        private String orgNames;

        public String getOrgIds() {
            return orgIds;
        }

        public Edit setOrgIds(String orgIds) {
            this.orgIds = orgIds;
            return this;
        }

        public String getOrgNames() {
            return orgNames;
        }

        public Edit setOrgNames(String orgNames) {
            this.orgNames = orgNames;
            return this;
        }

        public Long getId() {
            return id;
        }

        public Edit setId(Long id) {
            this.id = id;
            return this;
        }

        public String getTitle() {
            return title;
        }

        public Edit setTitle(String title) {
            this.title = title;
            return this;
        }

        public String getContent() {
            return content;
        }

        public Edit setContent(String content) {
            this.content = content;
            return this;
        }

        public String getCover() {
            return cover;
        }

        public Edit setCover(String cover) {
            this.cover = cover;
            return this;
        }

        public String getEnclosure() {
            return enclosure;
        }

        public Edit setEnclosure(String enclosure) {
            this.enclosure = enclosure;
            return this;
        }

        public Integer getClassify() {
            return classify;
        }

        public Edit setClassify(Integer classify) {
            this.classify = classify;
            return this;
        }

        public Integer getSyncToSite() {
            return syncToSite;
        }

        public Edit setSyncToSite(Integer syncToSite) {
            this.syncToSite = syncToSite;
            return this;
        }

        public Long getPublishId() {
            return publishId;
        }

        public Edit setPublishId(Long publishId) {
            this.publishId = publishId;
            return this;
        }

        public Integer getBrowse() {
            return browse;
        }

        public Edit setBrowse(Integer browse) {
            this.browse = browse;
            return this;
        }

        public Date getPublishTime() {
            return publishTime;
        }

        public Edit setPublishTime(Date publishTime) {
            this.publishTime = publishTime;
            return this;
        }

        public Integer getStatus() {
            return status;
        }

        public Edit setStatus(Integer status) {
            this.status = status;
            return this;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public Edit setCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }
    }

    public static class BatchDel{
        List<Long> ids;

        public List<Long> getIds() {
            return ids;
        }

        public BatchDel setIds(List<Long> ids) {
            this.ids = ids;
            return this;
        }
    }

    public static class GetByClassify{
        private Integer classify;

        public Integer getClassify() {
            return classify;
        }

        public GetByClassify setClassify(Integer classify) {
            this.classify = classify;
            return this;
        }
    }
}
