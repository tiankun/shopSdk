package com.redare.shop.unifyworkbench.service.excel;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Date;

public class DelegateRosterUserModel {

    @ExcelProperty(index = 0)
    private String name;
    @ExcelProperty(index = 1)
    private String workUnit;
    @ExcelProperty(index = 2)
    private String nation;
    @ExcelProperty(index = 3)
    private String nativePlace;
    @ExcelProperty(index = 4)
    private Date birthday;
    @ExcelProperty(index = 5)
    private String idCardNo;
    @ExcelProperty(index = 6)
    private Date workDate;
    @ExcelProperty(index = 7)
    private String education;
    @ExcelProperty(index = 8)
    private String parties;
    @ExcelProperty(index = 9)
    private String title;
    @ExcelProperty(index = 10)
    private String mobile;
    @ExcelProperty(index = 11)
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getParties() {
        return parties;
    }

    public void setParties(String parties) {
        this.parties = parties;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
