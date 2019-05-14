package com.sprint.crm.pojo;

public class UserRoles {
    private Integer id;

    private Integer userId;

    private Integer roleId;

	
	

	public UserRoles() {
		super();
	}

	public UserRoles(Integer id, Integer userId, Integer roleId) {
		super();
		this.id = id;
		this.userId = userId;
		this.roleId = roleId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "Userroles [id=" + id + ", userId=" + userId + ", roleId=" + roleId + "]";
	}

    
}