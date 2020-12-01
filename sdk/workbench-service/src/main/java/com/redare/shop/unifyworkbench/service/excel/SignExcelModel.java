package com.redare.shop.unifyworkbench.service.excel;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Date;

public class SignExcelModel {

    @ExcelProperty(index = 0)
    private String userName;
    @ExcelProperty(index = 1)
    private String sex;
    @ExcelProperty(index = 2)
    private Date birthDate;
    @ExcelProperty(index = 3)
    private String telphone;
    @ExcelProperty(index = 4)
    private String educationLevel;
    @ExcelProperty(index = 5)
    private Date signTime;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }
}
