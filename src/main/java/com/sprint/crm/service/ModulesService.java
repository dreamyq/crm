package com.sprint.crm.service;

import java.util.List;

import com.sprint.crm.pojo.Modules;

public interface ModulesService {

	int insertSelective(Modules record);

	Modules selectByPrimaryKey(Integer moduleId);

	int updateByPrimaryKeySelective(Modules record);
	
	List<Modules> getModuleById(Integer userId);

	List<Modules> getModuleByChild(List<Integer> pids);

	List<Modules> getAllModule();
	List<String> selectNameFromParent(Integer parentId);
	
	List<Modules> getModuleByChildId(Integer moduleId);
	 /**
	  * ���ģ��
	  * @param parentId
	  * @param name
	  * @param path
	  * @param weight
	  * @return
	  */
	int insertModule(Integer parentId,String name,String path,Integer weight);
	/**
	 * ����ģ��
	 * @param moduleId
	 * @param name
	 * @param path
	 * @param weight
	 * @return
	 */
	int updateModule(Integer moduleId,String name,String path,Integer weight);
	/**
	 * ɾ��ģ��
	 * @param id
	 * @return
	 */
	int delModule(Integer moduleId);
}
