package com.smarthome.service.model;

import java.util.Date;

public class Device extends BaseModel {
    private Long deviceId;

    private String deviceCode;

    private String deviceName;

    private String deviceAlias;

    private String devicePwd;

    private String deviceType;

    private String deviceStatus;

    private Long districtId;

    private Long areaId;

    private Long buildingId;

    private Long unitId;

    private Long roomId;

    private String position;

    private String coordinate;

    private String districtGateFlag;

    private String createdUser;

    private Date createdTime;

    private String updatedUser;

    private Date updatedTime;

    private String deviceIp;

    private String deviceMac;

    private Long loginUserid;

    private String loginStatus;

    private String devicebgUrl;

    private String unitdoorNo;

    private String version;

    private String sipid;

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode == null ? null : deviceCode.trim();
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    public String getDeviceAlias() {
        return deviceAlias;
    }

    public void setDeviceAlias(String deviceAlias) {
        this.deviceAlias = deviceAlias == null ? null : deviceAlias.trim();
    }

    public String getDevicePwd() {
        return devicePwd;
    }

    public void setDevicePwd(String devicePwd) {
        this.devicePwd = devicePwd == null ? null : devicePwd.trim();
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType == null ? null : deviceType.trim();
    }

    public String getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus == null ? null : deviceStatus.trim();
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate == null ? null : coordinate.trim();
    }

    public String getDistrictGateFlag() {
        return districtGateFlag;
    }

    public void setDistrictGateFlag(String districtGateFlag) {
        this.districtGateFlag = districtGateFlag == null ? null : districtGateFlag.trim();
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser == null ? null : createdUser.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedUser() {
        return updatedUser;
    }

    public void setUpdatedUser(String updatedUser) {
        this.updatedUser = updatedUser == null ? null : updatedUser.trim();
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getDeviceIp() {
        return deviceIp;
    }

    public void setDeviceIp(String deviceIp) {
        this.deviceIp = deviceIp == null ? null : deviceIp.trim();
    }

    public String getDeviceMac() {
        return deviceMac;
    }

    public void setDeviceMac(String deviceMac) {
        this.deviceMac = deviceMac == null ? null : deviceMac.trim();
    }

    public Long getLoginUserid() {
        return loginUserid;
    }

    public void setLoginUserid(Long loginUserid) {
        this.loginUserid = loginUserid;
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus == null ? null : loginStatus.trim();
    }

    public String getDevicebgUrl() {
        return devicebgUrl;
    }

    public void setDevicebgUrl(String devicebgUrl) {
        this.devicebgUrl = devicebgUrl == null ? null : devicebgUrl.trim();
    }

    public String getUnitdoorNo() {
        return unitdoorNo;
    }

    public void setUnitdoorNo(String unitdoorNo) {
        this.unitdoorNo = unitdoorNo == null ? null : unitdoorNo.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getSipid() {
        return sipid;
    }

    public void setSipid(String sipid) {
        this.sipid = sipid == null ? null : sipid.trim();
    }
}