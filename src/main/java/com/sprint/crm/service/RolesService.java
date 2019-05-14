package com.sprint.crm.service;

import java.util.List;

import com.sprint.crm.pojo.Modules;
import com.sprint.crm.pojo.Roles;
import com.sprint.crm.pojo.RolesPageBean;
import com.sprint.crm.pojo.User;

public interface RolesService {

	int insertSelective(Roles record);

	Roles selectByPrimaryKey(Integer roleId);

	int updateByPrimaryKeySelective(Roles record);
	
	 /**
     * 分页查询
     * @return
     */
	List<Roles> getPage(RolesPageBean rolesPageBean);
	/**
	 * 总条数
	 * @param pageBean
	 * @return
	 */
	int getSum(RolesPageBean rolesPageBean);
	

	//获取指定角色下的用户信息
    List<User> getUserByRname(String rName);
    
    int getRIdByRname(String rName);
    
    /**
     * 添加角色
     * @param roles
     * @return
     */
    int addRole(Roles roles);
    /**
     *更新角色
     * @param roles
     * @return
     */
    int updateRole(Roles roles); 
    /**
     * 删除用户
     * @param roleId
     * @return
     */
    int dele(String roleId);
    List<Modules> getUserByRole(Integer roleId);
    int delAllRoles(int roleId);
    int setRoles(int id,int ids);

}