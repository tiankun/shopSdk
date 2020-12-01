package com.redare.shop.unifyworkbench.sdk.pojo.form;

public class StatisticForm {

        private  String areaCode;
        private String areaName;
        private Integer level;

    public String getAreaCode() {
        return areaCode;
    }

    public StatisticForm setAreaCode(String areaCode) {
        this.areaCode = areaCode;
        return this;
    }

    public String getAreaName() {
        return areaName;
    }

    public StatisticForm setAreaName(String areaName) {
        this.areaName = areaName;
        return this;
    }

    public Integer getLevel() {
        return level;
    }

    public StatisticForm setLevel(Integer level) {
        this.level = level;
        return this;
    }
}
