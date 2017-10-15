package com.it.elec.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("serial")
public class ElecCommonMsg implements java.io.Serializable {
	
	private String comId;			//主键ID
	private String stationRun;		//站点运行情况
	private String devRun;			//设备运行情况
	@DateTimeFormat(pattern = "yyyy-MM-dd ")
	private Date createTime;		//创建日期
	private Date updateTime;
	private int createempId;
	
	
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
	public int getCreateempId() {
		return createempId;
	}
	public void setCreateempId(int createempId) {
		this.createempId = createempId;
	}
	public String getComId() {
		return comId;
	}
	public void setComId(String comId) {
		this.comId = comId;
	}
	public String getStationRun() {
		return stationRun;
	}
	public void setStationRun(String stationRun) {
		this.stationRun = stationRun;
	}
	public String getDevRun() {
		return devRun;
	}
	public void setDevRun(String devRun) {
		this.devRun = devRun;
	}

	
	
	
	
}
