package com.sprint.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.crm.mapper.UserMapper;
import com.sprint.crm.pojo.PageBean;
import com.sprint.crm.pojo.Roles;
import com.sprint.crm.pojo.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		return userMapper.insertSelective(record);
	}

	@Override
	public User selectByPrimaryKey(Integer userId) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<User> selectZiXunShis(String name) {
		// TODO Auto-generated method stub
		return userMapper.selectZiXunShis(name);
	}

	@Override
	public User validatePassword(String loginName, String password) {
		// TODO Auto-generated method stub
		return userMapper.validatePassword(loginName, password);
	}

	@Override
	public int changePassword(String loginName, String password) {
		// TODO Auto-generated method stub
		return userMapper.changePassword(loginName, password);
	}
	
	@Override
	public List<User> getPage(PageBean pageBean) {
		// TODO Auto-generated method stub
		return userMapper.getPage(pageBean);
	}
	@Override
	public int getSum(PageBean pageBean) {
		// TODO Auto-generated method stub
		return userMapper.getSum(pageBean);
	}
	@Override
	public User getUserByNameAndPwd(String loginName) {
		// TODO Auto-generated method stub
		return userMapper.getUserByNameAndPwd(loginName);
	}
	@Override
	public List<String> getRoleNamesByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return userMapper.getRoleNamesByUserId(userId);
	}
	@Override
	public int updatePsdWrongTimeByPassword1(String loginName) {
		// TODO Auto-generated method stub
		return userMapper.updatePsdWrongTimeByPassword1(loginName);
	}
	@Override
	public int updateLockByUn(String loginName) {
		// TODO Auto-generated method stub
		return userMapper.updateLockByUn(loginName);
	}
	@Override
	public int updateIsLockOutAndTime(String loginName) {
		// TODO Auto-generated method stub
		return userMapper.updateIsLockOutAndTime(loginName);
	}
	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.insertUser(user);
	}
	@Override
	public int updatePwd(Integer userId) {
		// TODO Auto-generated method stub
		return userMapper.updatePwd(userId);
	}
	@Override
	public int updateLock(Integer userId) {
		// TODO Auto-generated method stub
		return userMapper.updateLock(userId);
	}
	@Override
	public int updateUnLock(Integer userId) {
		// TODO Auto-generated method stub
		return userMapper.updateUnLock(userId);
	}
	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateUser(user);
	}
	@Override
	public int delUser(String userId) {
		// TODO Auto-generated method stub
		return userMapper.delUser(userId);
	}
	@Override
	public List<Roles> selectRole() {
		// TODO Auto-generated method stub
		return userMapper.selectRole();
	}
	@Override
	public List<Roles> selectUserRole(Integer userId) {
		// TODO Auto-generated method stub
		return userMapper.selectUserRole(userId);
	}
	@Override
	public int addUserRole(Integer userId, Integer roleId) {
		// TODO Auto-generated method stub
		return userMapper.addUserRole(userId, roleId);
	}
	@Override
	public int delUserRole(Integer userId, Integer roleId) {
		// TODO Auto-generated method stub
		return userMapper.delUserRole(userId, roleId);
	}
	/*@Override
	public List<UserRoles> getUserRoleByuid(int userId) {
		// TODO Auto-generated method stub
		return userMapper.getUserRoleByuid(userId);
	}*/
	@Override
	public List<Roles> getUserRoleById(Integer id, Integer rid) {
		// TODO Auto-generated method stub
		return userMapper.getUserRoleById(id,rid);
	}
	@Override
	public String getUserLockById(int userId) {
		// TODO Auto-generated method stub
		return userMapper.getUserLockById(userId);
	}
	@Override
	public int updateUserLastLoginTime(int userId) {
		// TODO Auto-generated method stub
		return userMapper.updateUserLastLoginTime(userId);
	}

}
