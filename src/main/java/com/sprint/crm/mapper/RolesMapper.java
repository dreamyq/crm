package com.sprint.crm.mapper;

import com.sprint.crm.pojo.Modules;
import com.sprint.crm.pojo.Roles;
import com.sprint.crm.pojo.RolesPageBean;
import com.sprint.crm.pojo.User;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolesMapper {
  


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
    /**
     * 查询角色的ID
     * @param rName
     * @return
     */
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
    /**
     * 查询角色所拥有的模块
     * @param roleId
     * @return
     */
    List<Modules> getUserByRole(Integer roleId);

    /**
     * 删除角色的权限
     * @param roleId
     * @return
     */
    int delAllRoles(int roleId);
    
    int setRoles(int id,int ids);


}