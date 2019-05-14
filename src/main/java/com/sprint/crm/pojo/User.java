package com.sprint.crm.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class User {
	private Integer userId;
	private String loginName;
	private String password;
	private String isLockout;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date lastLoginTime;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date createTime;
	private Integer psdWrongTime;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date lockTime;

	private String protectEmail;

	private String protectTel;

	private String allotSetting;

	private String signInState;

	private Integer weight;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer userId, String loginName, String password, String isLockout, Date lastLoginTime,
			Date createTime, Integer psdWrongTime, Date lockTime, String protectEmail, String protectTel,
			String allotSetting, String signInState, Integer weight) {
		super();
		this.userId = userId;
		this.loginName = loginName;
		this.password = password;
		this.isLockout = isLockout;
		this.lastLoginTime = lastLoginTime;
		this.createTime = createTime;
		this.psdWrongTime = psdWrongTime;
		this.lockTime = lockTime;
		this.protectEmail = protectEmail;
		this.protectTel = protectTel;
		this.allotSetting = allotSetting;
		this.signInState = signInState;
		this.weight = weight;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIsLockout() {
		return isLockout;
	}

	public void setIsLockout(String isLockout) {
		this.isLockout = isLockout;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getPsdWrongTime() {
		return psdWrongTime;
	}

	public void setPsdWrongTime(Integer psdWrongTime) {
		this.psdWrongTime = psdWrongTime;
	}

	public Date getLockTime() {
		return lockTime;
	}

	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}

	public String getProtectEmail() {
		return protectEmail;
	}

	public void setProtectEmail(String protectEmail) {
		this.protectEmail = protectEmail;
	}

	public String getProtectTel() {
		return protectTel;
	}

	public void setProtectTel(String protectTel) {
		this.protectTel = protectTel;
	}

	public String getAllotSetting() {
		return allotSetting;
	}

	public void setAllotSetting(String allotSetting) {
		this.allotSetting = allotSetting;
	}

	public String getSignInState() {
		return signInState;
	}

	public void setSignInState(String signInState) {
		this.signInState = signInState;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public User(String loginName, String password) {
		super();
		this.loginName = loginName;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", loginName=" + loginName + ", password=" + password + ", isLockout="
				+ isLockout + ", lastLoginTime=" + lastLoginTime + ", createTime=" + createTime + ", psdWrongTime="
				+ psdWrongTime + ", lockTime=" + lockTime + ", protectEmail=" + protectEmail + ", protectTel="
				+ protectTel + ", allotSetting=" + allotSetting + ", signInState=" + signInState + ", weight=" + weight
				+ "]";
	}

}
