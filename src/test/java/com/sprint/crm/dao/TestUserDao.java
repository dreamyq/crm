package com.sprint.crm.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sprint.crm.BaseTest;
import com.sprint.crm.pojo.User;
import com.sprint.crm.service.UserService;
import com.sprint.crm.service.UserrolesService;

public class TestUserDao extends BaseTest{
	@Autowired
	private UserService userDao;
	@Autowired
	private UserrolesService UserrolesServiceImpl;
			
	/*@Test
	public void selectByPrimaryKey() {
		UserrolesServiceImpl.selectByPrimaryKey(1);
	}*/
	

}
