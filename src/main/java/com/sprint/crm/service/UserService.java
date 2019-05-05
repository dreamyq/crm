package com.sprint.crm.service;

import java.util.List;

import com.sprint.crm.pojo.User;

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

}