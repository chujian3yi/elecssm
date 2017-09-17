package com.it.elec.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Administrator on 2017/9/16.
 */
public class ElecosUser {

    private Integer userId;
    private int jctId;
    private String userName;
    private String logonName;
    private String logonPwd;
    private int sexId;
    private Timestamp birthday;
    private String address;
    private String contactTel;
    private String email;
    private String mobile;
    private String isDuty;
    private int postId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public int getJctId() {
        return jctId;
    }

    public void setJctId(int jctId) {
        this.jctId = jctId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLogonName() {
        return logonName;
    }

    public void setLogonName(String logonName) {
        this.logonName = logonName;
    }

    public String getLogonPwd() {
        return logonPwd;
    }

    public void setLogonPwd(String logonPwd) {
        this.logonPwd = logonPwd;
    }

    public int getSexId() {
        return sexId;
    }

    public void setSexId(int sexId) {
        this.sexId = sexId;
    }

   

    public Timestamp getBirthday() {
		return birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIsDuty() {
        return isDuty;
    }

    public void setIsDuty(String isDuty) {
        this.isDuty = isDuty;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public Date getOndutyDate() {
        return ondutyDate;
    }

    public void setOndutyDate(Date ondutyDate) {
        this.ondutyDate = ondutyDate;
    }

    public Date getOffdutyDate() {
        return offdutyDate;
    }

    public void setOffdutyDate(Date offdutyDate) {
        this.offdutyDate = offdutyDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    private Date ondutyDate;
    private Date offdutyDate;
    private String remark;
    private String state;
    private Date createTime;
    private Date updateTime;

}
