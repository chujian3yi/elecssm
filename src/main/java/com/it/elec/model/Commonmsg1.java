package com.it.elec.model;

import java.util.Date;

public class Commonmsg1 {
    private Integer comId;

    private String stationRun;

    private String devRun;

    private Date createTime;

    private Date updateTime;

    private Integer createempId;

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public String getStationRun() {
        return stationRun;
    }

    public void setStationRun(String stationRun) {
        this.stationRun = stationRun == null ? null : stationRun.trim();
    }

    public String getDevRun() {
        return devRun;
    }

    public void setDevRun(String devRun) {
        this.devRun = devRun == null ? null : devRun.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCreateempId() {
        return createempId;
    }

    public void setCreateempId(Integer createempId) {
        this.createempId = createempId;
    }
}