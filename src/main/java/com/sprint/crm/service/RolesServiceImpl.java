package com.sprint.crm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sprint.crm.mapper.RolesMapper;
import com.sprint.crm.pojo.Modules;
import com.sprint.crm.pojo.Roles;
import com.sprint.crm.pojo.RolesPageBean;
import com.sprint.crm.pojo.User;

@Service
public class RolesServiceImpl implements RolesService {
	@Resource
	private RolesMapper rolesMapper;

	@Override
	public int insertSelective(Roles record) {
		// TODO Auto-generated method stub
		return rolesMapper.insertSelective(record);
	}

	@Override
	public Roles selectByPrimaryKey(Integer roleId) {
		// TODO Auto-generated method stub
		return rolesMapper.selectByPrimaryKey(roleId);
	}

	@Override
	public int updateByPrimaryKeySelective(Roles record) {
		// TODO Auto-generated method stub
		return rolesMapper.updateByPrimaryKeySelective(record);
	}
	
	@Override
	public List<Roles> getPage(RolesPageBean rolesPageBean) {
		// TODO Auto-generated method stub
		return rolesMapper.getPage(rolesPageBean);
	}

	@Override
	public int getSum(RolesPageBean rolesPageBean) {
		// TODO Auto-generated method stub
		return rolesMapper.getSum(rolesPageBean);
	}

	@Override
	public List<User> getUserByRname(String rName) {
		// TODO Auto-generated method stub
		return rolesMapper.getUserByRname(rName);
	}

	@Override
	public int getRIdByRname(String rName) {
		// TODO Auto-generated method stub
		return rolesMapper.getRIdByRname(rName);
	}

	@Override
	public int addRole(Roles roles) {
		// TODO Auto-generated method stub
		return rolesMapper.addRole(roles);
	}

	@Override
	public int updateRole(Roles roles) {
		// TODO Auto-generated method stub
		return rolesMapper.updateRole(roles);
	}

	@Override
	public int dele(String roleId) {
		// TODO Auto-generated method stub
		return rolesMapper.dele(roleId);
	}

	@Override
	public List<Modules> getUserByRole(Integer roleId) {
		// TODO Auto-generated method stub
		return rolesMapper.getUserByRole(roleId);
	}

	@Override
	public int delAllRoles(int roleId) {
		// TODO Auto-generated method stub
		return rolesMapper.delAllRoles(roleId);
	}

	@Override
	public int setRoles(int id, int ids) {
		// TODO Auto-generated method stub
		return rolesMapper.setRoles(id, ids);
	}

}
