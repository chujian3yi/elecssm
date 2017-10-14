package com.it.elec.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Created by Administrator on 2017/9/16.
 */
public class ElecosUser {

    private Integer userId;
    private String jctId;
    private String userName;
    private String logonName;
    private String logonPwd;
    private String sexId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")  
    private Date birthday;
    private String address;
    private String contactTel;
    private String email;
    private String mobile;
    private String isDuty;
    private String postId;
    private String remark;
  
    private String state;
    private Date createTime;
    private Date updateTime;
    private String jctUnitId;
    

    public String getJctUnitId() {
		return jctUnitId;
	}

	public void setJctUnitId(String jctUnitId) {
		this.jctUnitId = jctUnitId;
	}

	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getJctId() {
        return jctId;
    }

    public void setJctId(String jctId) {
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

    public String getSexId() {
        return sexId;
    }

    public void setSexId(String sexId) {
        this.sexId = sexId;
    }

   



	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
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

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
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

	public void setSexId(Integer sexId2) {
		// TODO Auto-generated method stub
		
	}

  /*******************非持久化javabean**********************/
	
	private Date ondutyDate;
	
	private Date offdutyDate;

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
    
    /**
     * 判断页面跳转的是编辑用户页面还是查看用户页面
     * viewflag==null:编辑页面
     * viewflag=="1":查看用户页面
     */
	private String viewflag;
	
	public String getViewflag() {
		return viewflag;
	}

	public void setViewflag(String viewflag) {
		this.viewflag = viewflag;
	}



	/**
	 * 		  message=1:表示登录名不能为空
	 *        message=2:表示登录名在数据库中已经存在，此时不能保存
	 *        message=3:表示登录名在数据库表不存在，此时可以保存
	 */
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 记住登录密码
	 */
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	/**判断用户是否选中：1:选中 	2：未选中 */
	 
	private String flag;


	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
}
