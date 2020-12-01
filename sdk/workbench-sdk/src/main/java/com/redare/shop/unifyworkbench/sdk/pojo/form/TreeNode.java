package com.redare.shop.unifyworkbench.sdk.pojo.form;

import java.io.Serializable;
import java.util.List;

/**
 * 选择树模型（参考antd的前端组件规范）
 *
 * @Author: yanggr
 * @Date: 2020/7/26 17:35
 */
public class TreeNode implements Serializable {

    private boolean selectable = true;//	是否可选	boolean	true
    private boolean checkable = true;//当树为 Checkbox 时，设置独立节点是否展示 Checkbox	boolean	-
    private boolean disableCheckbox;//禁掉 Checkbox	boolean	false
    private boolean disabled;//是否禁用	boolean	false
    private boolean isLeaf;//是否是叶子节点	boolean	false
    private String key;//此项必须设置（其值在整个树范围内唯一）	string	-
    private String title;//	树节点显示的内容	string | ReactNode	---
    private String value;//	默认根据此属性值进行筛选（其值在整个树范围内唯一）	string
    private List<TreeNode> children;
    private String parentId;
    /**
     * 树层级
     */
    private Integer level;
    /**
     * ID层级链路 逗号隔开
     */
    private String idLevel;
    /**
     * 名称层级链路 逗号隔开
     */
    private String nameLevel;

    public boolean isSelectable() {
        return selectable;
    }

    public void setSelectable(boolean selectable) {
        this.selectable = selectable;
    }

    public boolean isCheckable() {
        return checkable;
    }

    public void setCheckable(boolean checkable) {
        this.checkable = checkable;
    }

    public boolean isDisableCheckbox() {
        return disableCheckbox;
    }

    public void setDisableCheckbox(boolean disableCheckbox) {
        this.disableCheckbox = disableCheckbox;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getIdLevel() {
        return idLevel;
    }

    public void setIdLevel(String idLevel) {
        this.idLevel = idLevel;
    }

    public String getNameLevel() {
        return nameLevel;
    }

    public void setNameLevel(String nameLevel) {
        this.nameLevel = nameLevel;
    }
}
