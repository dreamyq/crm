package com.sprint.crm.mapper;

import com.sprint.crm.pojo.PageBean;
import com.sprint.crm.pojo.Roles;
import com.sprint.crm.pojo.User;
import com.sprint.crm.pojo.UserRoles;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {




    int insertSelective(User record);


    User selectByPrimaryKey(Integer userId);



    int updateByPrimaryKeySelective(User record);
    

    /**
     * 通过角色名查该角色的所有用户
     * @param 角色名
     * @return 用户集合
     */
    List<User> selectZiXunShis(String name);
    /**
     * 验证密码是否正确
     * @param loginName验证账号
     * @param password密码
     * @return 用户
     */
    User validatePassword(@Param("loginName") String loginName,@Param("password") String password);
    /**
     * 修改密码
     * @param loginName
     * @param password
     * @return
     */
    int changePassword(@Param("loginName") String loginName,@Param("password") String password);
    
    
    /**
	 * 分页查询
	 * 
	 * @return
	 */
	List<User> getPage(PageBean pageBean);

	/**
	 * 总条数
	 * 
	 * @param pageBean
	 * @return
	 */

	int getSum(PageBean pageBean);

	/**
	 * 登录
	 * 
	 * @param loginName
	 * @return
	 */
	User getUserByNameAndPwd(String loginName);

	/**
	 * 查询角色名称
	 * 
	 * @param userId
	 * @return
	 */
	List<String> getRoleNamesByUserId(Integer userId);

	/**
	 * 如果密码错误修改密码错误次数
	 * 
	 * @param loginName
	 * @return
	 */
	int updatePsdWrongTimeByPassword1(String loginName);

	/**
	 * 解锁用户
	 */
	int updateLockByUn(String loginName);

	/**
	 * 锁定用户
	 */
	int updateIsLockOutAndTime(String loginName);

	/**
	 * 添加用户
	 * 
	 * @return
	 */
	int insertUser(User user);

	/**
	 * 重置密码
	 * 
	 * @param userId
	 * @return
	 */
	int updatePwd(Integer userId);

	/**
	 * 锁定用户
	 */
	int updateLock(Integer userId);

	/**
	 * 解锁用户
	 */
	int updateUnLock(Integer userId);

	/**
	 * 修改用户
	 * 
	 * @param user
	 * @return
	 */
	int updateUser(User user);

	/**
	 * 删除用户
	 * 
	 * @param userId
	 * @return
	 */
	int delUser(String userId);

	/**
	 * 查询所有角色
	 */
	List<Roles> selectRole();

	/**
	 * 查询用户所拥有的角色
	 */
	List<Roles> selectUserRole(Integer userId);

	/**
	 * 添加用户角色
	 */
	int addUserRole(Integer userId, Integer roleId);

	/**
	 * 删除用户角色 .
	 */
	int delUserRole(Integer userId, Integer roleId);

	/**
	 * 根据用户id查询拥有的角色
	 * 
	 * @param id
	 * @return
	 */
	/*List<UserRoles> getUserRoleByuid(int userId);*/

	/**
	 * 获取角色
	 * 
	 * @param id
	 * @param rid
	 * @return
	 */
	List<Roles> getUserRoleById(Integer id, Integer rid);

	/**
	 * 查询锁定状态
	 * 
	 * @param userId
	 * @return
	 */
	String getUserLockById(int userId);

	/**
	 * 最后更新的时间
	 * 
	 * @param uId
	 * @return
	 */
	int updateUserLastLoginTime(int userId);

}