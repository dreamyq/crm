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
    /**
     * ��ѯ��ɫ��ID
     * @param rName
     * @return
     */
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
    /**
     * ��ѯ��ɫ��ӵ�е�ģ��
     * @param roleId
     * @return
     */
    List<Modules> getUserByRole(Integer roleId);

    /**
     * ɾ����ɫ��Ȩ��
     * @param roleId
     * @return
     */
    int delAllRoles(int roleId);
    
    int setRoles(int id,int ids);


}