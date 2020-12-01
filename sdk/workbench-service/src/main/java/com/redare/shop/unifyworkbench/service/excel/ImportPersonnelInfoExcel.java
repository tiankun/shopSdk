package com.redare.shop.unifyworkbench.service.excel;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Date;


/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/11/19 18:45
 * @version:
 */
public class ImportPersonnelInfoExcel {

    @ExcelProperty(index = 0)
    private String name;

    @ExcelProperty(index = 1)
    private String birthday;

    @ExcelProperty(index = 2)
    private String cardNo;

    @ExcelProperty(index = 3)
    private String sex;

    @ExcelProperty(index = 4)
    private String nativePlace;

    @ExcelProperty(index = 5)
    private String nation;

    @ExcelProperty(index = 6)
    private String politic;

    @ExcelProperty(index = 7)
    private String partyDate;

    @ExcelProperty(index = 8)
    private String orgName;

    @ExcelProperty(index = 9)
    private String deptName;

    @ExcelProperty(index = 10)
    private String position;

    @ExcelProperty(index = 11)
    private String positionType;

    @ExcelProperty(index = 12)
    private String positionTime;

    @ExcelProperty(index = 13)
    private String education;

    @ExcelProperty(index = 14)
    private String school;

    @ExcelProperty(index = 15)
    private String major;

    @ExcelProperty(index = 16)
    private String graduationTime;

    @ExcelProperty(index = 17)
    private String mobile;

    @ExcelProperty(index = 18)
    private String weChat;

    @ExcelProperty(index = 19)
    private String email;

    @ExcelProperty(index = 20)
    private String unit;

    @ExcelProperty(index = 21)
    private String unitPosition;

    @ExcelProperty(index = 22)
    private String servedTime;

    @ExcelProperty(index = 23)
    private String deputy;

    @ExcelProperty(index = 24)
    private String honour;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPolitic() {
        return politic;
    }

    public void setPolitic(String politic) {
        this.politic = politic;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnitPosition() {
        return unitPosition;
    }

    public void setUnitPosition(String unitPosition) {
        this.unitPosition = unitPosition;
    }

    public String getDeputy() {
        return deputy;
    }

    public void setDeputy(String deputy) {
        this.deputy = deputy;
    }

    public String getHonour() {
        return honour;
    }

    public void setHonour(String honour) {
        this.honour = honour;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPartyDate() {
        return partyDate;
    }

    public void setPartyDate(String partyDate) {
        this.partyDate = partyDate;
    }

    public String getPositionTime() {
        return positionTime;
    }

    public void setPositionTime(String positionTime) {
        this.positionTime = positionTime;
    }

    public String getGraduationTime() {
        return graduationTime;
    }

    public void setGraduationTime(String graduationTime) {
        this.graduationTime = graduationTime;
    }

    public String getServedTime() {
        return servedTime;
    }

    public void setServedTime(String servedTime) {
        this.servedTime = servedTime;
    }
}
