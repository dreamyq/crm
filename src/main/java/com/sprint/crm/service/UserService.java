package com.sprint.crm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sprint.crm.pojo.PageBean;
import com.sprint.crm.pojo.Roles;
import com.sprint.crm.pojo.User;
import com.sprint.crm.pojo.UserRoles;

public interface UserService {

	int insertSelective(User record);

	User selectByPrimaryKey(Integer userId);

	int updateByPrimaryKeySelective(User record);
	
	/**
     * ͨ����ɫ����ý�ɫ�������û�
     * @param ��ɫ��
     * @return �û�����
     */
    List<User> selectZiXunShis(String name);
    
    /**
     * ��֤�����Ƿ���ȷ
     * @param loginName��֤�˺�
     * @param password����
     * @return �û�
     */
    User validatePassword(@Param("loginName") String loginName,@Param("password") String password);
    
    /**
     * �޸�����
     * @param loginName
     * @param password
     * @return
     */
    int changePassword(@Param("loginName") String loginName,@Param("password") String password);
    
    /**
	 * ��ҳ����
	 * @param pageBean
	 * @return
	 */
	List<User> getPage(PageBean pageBean);
	/**
	 * ������
	 * @param pageBean
	 * @return
	 */
	int getSum(PageBean pageBean);
	/**
	 * ��¼
	 * @param loginName
	 * @return
	 */
	User getUserByNameAndPwd(String loginName);
	/**
	 * ��ѯ��ɫ����
	 * @param userId
	 * @return
	 */
	List<String> getRoleNamesByUserId(Integer userId);
	/**
	 * �����������޸�����������
	 * @param loginName
	 * @return
	 */
	int updatePsdWrongTimeByPassword1(String loginName);
	/**
	 *�����û�
	 */
    int updateLockByUn(String loginName);
    /**
	 * �����û�
	 */
    int updateIsLockOutAndTime(String loginName);
    /**
	 * ����û�
	 * @return
	 */
    int insertUser(User user);
    /**
     * ��������
     * @param userId
     * @return
     */
    int updatePwd(Integer userId);
    /**
	 * �����û�
	 */
	int updateLock(Integer userId);

	/**
	 * �����û�
	 */
	int updateUnLock(Integer userId);
	/**
	 * �޸��û�
	 * @param user
	 * @return
	 */
	int updateUser(User user);
	/**
	 * ɾ���û�
	 * @param userId
	 * @return
	 */
	int delUser(String userId);
	/**
	 * ��ѯ���н�ɫ
	 */
	List<Roles> selectRole();

	/**
	 * ��ѯ�û���ӵ�еĽ�ɫ
	 */
	List<Roles> selectUserRole(Integer userId);
	/**
	 * ����û���ɫ
	 */
	int addUserRole(Integer userId,Integer roleId);
	/**
	 * ɾ���û���ɫ
	 */
	int delUserRole(Integer userId,Integer roleId);

	/**
	 * �����û�id��ѯӵ�еĽ�ɫ
	 * @param id
	 * @return
	 */
	/*List<UserRoles> getUserRoleByuid(int userId);*/
	
	List<Roles> getUserRoleById(Integer id,Integer rid);
	 String getUserLockById(int userId);
	 int updateUserLastLoginTime(int userId);

}