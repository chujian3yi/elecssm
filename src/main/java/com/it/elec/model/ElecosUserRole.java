package com.it.elec.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ElecosUserRole {

	
	private Integer roleId;
	
	private Integer userId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createTime;
	
	private Date updateTime;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
	
}
