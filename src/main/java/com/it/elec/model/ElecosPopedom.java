package com.it.elec.model;
// Generated 2017-7-6 14:59:26 by Hibernate Tools 3.6.0

import java.util.Date;

/**
 * ElecosPopedom generated by hbm2java
 */
public class ElecosPopedom implements java.io.Serializable {

	private static final long serialVersionUID = -4802636439751686071L;
	private String mid;
	private String pid;
	private String popedomName;
	private String url;
	private String icon;
	private String target;
	private boolean isParent;
	private boolean isMenu;
	private Date createTime;
	private Date updateTime;

	public ElecosPopedom() {
	}

	public ElecosPopedom(String popedomName, String url, String icon, String target,
			boolean isParent, boolean isMenu, Date createTime) {
		
		this.popedomName = popedomName;
		this.url = url;
		this.icon = icon;
		this.target = target;
		this.isParent = isParent;
		this.isMenu = isMenu;
		this.createTime = createTime;
	}


	public ElecosPopedom(String mid, String pid, String popedomName, String url, String icon, String target,
			boolean isParent, boolean isMenu, Date createTime, Date updateTime) {
		super();
		this.mid = mid;
		this.pid = pid;
		this.popedomName = popedomName;
		this.url = url;
		this.icon = icon;
		this.target = target;
		this.isParent = isParent;
		this.isMenu = isMenu;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public ElecosPopedom( String popedomName, String url, String icon, String target,
			boolean isParent, boolean isMenu, Date createTime, Date updateTime) {
		
		this.popedomName = popedomName;
		this.url = url;
		this.icon = icon;
		this.target = target;
		this.isParent = isParent;
		this.isMenu = isMenu;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public ElecosPopedom(String mid, String pid, String popedomName ,String url) {

		this.mid=mid;
		this.pid =pid;
		this.popedomName =popedomName;
		this.url = url;
	}


	public String getPopedomName() {
		return this.popedomName;
	}

	public void setPopedomName(String popedomName) {
		this.popedomName = popedomName;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTarget() {
		return this.target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public boolean isIsParent() {
		return this.isParent;
	}

	public void setIsParent(boolean isParent) {
		this.isParent = isParent;
	}

	public boolean isIsMenu() {
		return this.isMenu;
	}

	public void setIsMenu(boolean isMenu) {
		this.isMenu = isMenu;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	
	
	/*******************非持久化bean属性***********************/
	
	/**在ElecPopedom对象添加一个标识flag ;如果flag==1：此时页面的复选框被选中;如果flag==2：此时页面的复选框不被选中*/
	private String flag;

	/**页面传递的权限数组*/
	private String[] selectoper;
	
	/**页面传递的用户数组*/
	private String[] selectuser;
	
	/**页面传递的角色id*/
	private Integer roleId;
	

	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String[] getSelectoper() {
		return selectoper;
	}

	public void setSelectoper(String[] selectoper) {
		this.selectoper = selectoper;
	}

	public String[] getSelectuser() {
		return selectuser;
	}

	public void setSelectuser(String[] selectuser) {
		this.selectuser = selectuser;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
}
