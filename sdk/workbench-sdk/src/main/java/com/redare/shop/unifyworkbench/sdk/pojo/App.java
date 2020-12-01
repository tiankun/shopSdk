package com.redare.shop.unifyworkbench.sdk.pojo;

public class App {

    private String appOs;//取值ios或android	当前app版本类型
    private String appType;//app类型
    private Integer versionCode;//int类型值 例如:12	当前app的版本号
    private String versionName;//String类型值 例如:2.3.2	当前app的版本名称
    private String deviceBrand;//String类型值	当前设备厂商
    private String deviceModel;//String类型值	当前设备型号
    private String systemName;//String类型值	当前设备系统名称
    private String systemVersion;//String类型值	当前设备系统版本

    public String getAppOs() {
        return appOs;
    }

    public App setAppOs(String appOs) {
        this.appOs = appOs;
        return this;
    }

    public String getAppType() {
        return appType;
    }

    public App setAppType(String appType) {
        this.appType = appType;
        return this;
    }

    public Integer getVersionCode() {
        return versionCode;
    }

    public App setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
        return this;
    }

    public String getVersionName() {
        return versionName;
    }

    public App setVersionName(String versionName) {
        this.versionName = versionName;
        return this;
    }

    public String getDeviceBrand() {
        return deviceBrand;
    }

    public App setDeviceBrand(String deviceBrand) {
        this.deviceBrand = deviceBrand;
        return this;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public App setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
        return this;
    }

    public String getSystemName() {
        return systemName;
    }

    public App setSystemName(String systemName) {
        this.systemName = systemName;
        return this;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public App setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
        return this;
    }
}
