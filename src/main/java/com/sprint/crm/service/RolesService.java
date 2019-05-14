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
     * ��ҳ��ѯ
     * @return
     */
	List<Roles> getPage(RolesPageBean rolesPageBean);
	/**
	 * ������
	 * @param pageBean
	 * @return
	 */
	int getSum(RolesPageBean rolesPageBean);
	

	//��ȡָ����ɫ�µ��û���Ϣ
    List<User> getUserByRname(String rName);
    
    int getRIdByRname(String rName);
    
    /**
     * ��ӽ�ɫ
     * @param roles
     * @return
     */
    int addRole(Roles roles);
    /**
     *���½�ɫ
     * @param roles
     * @return
     */
    int updateRole(Roles roles); 
    /**
     * ɾ���û�
     * @param roleId
     * @return
     */
    int dele(String roleId);
    List<Modules> getUserByRole(Integer roleId);
    int delAllRoles(int roleId);
    int setRoles(int id,int ids);

}