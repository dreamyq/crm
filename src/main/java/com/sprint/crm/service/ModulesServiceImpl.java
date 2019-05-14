package com.sprint.crm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sprint.crm.mapper.ModulesMapper;
import com.sprint.crm.pojo.Modules;

@Service
public class ModulesServiceImpl implements ModulesService {
	@Resource
	private ModulesMapper modulesMapper;

	@Override
	public int insertSelective(Modules record) {
		// TODO Auto-generated method stub
		return modulesMapper.insertSelective(record);
	}

	@Override
	public Modules selectByPrimaryKey(Integer moduleId) {
		// TODO Auto-generated method stub
		return modulesMapper.selectByPrimaryKey(moduleId);
	}

	@Override
	public int updateByPrimaryKeySelective(Modules record) {
		// TODO Auto-generated method stub
		return updateByPrimaryKeySelective(record);
	}
	
	@Override
	public List<Modules> getModuleById(Integer userId) {
		// TODO Auto-generated method stub
		return modulesMapper.getModuleById(userId);
	}

	@Override
	public List<Modules> getModuleByChild(List<Integer> pids) {
		// TODO Auto-generated method stub
		return modulesMapper.getModuleByChild(pids);
	}

	@Override
	public List<Modules> getAllModule() {
		// TODO Auto-generated method stub
		return modulesMapper.getAllModule();
	}

	@Override
	public List<Modules> getModuleByChildId(Integer moduleId) {
		// TODO Auto-generated method stub
		return modulesMapper.getModuleByChildId(moduleId);
	}

	@Override
	public int insertModule(Integer parentId, String name, String path,
			Integer weight) {
		// TODO Auto-generated method stub
		return modulesMapper.insertModule(parentId, name, path, weight);
	}

	@Override
	public int updateModule(Integer moduleId, String name, String path,
			Integer weight) {
		// TODO Auto-generated method stub
		return modulesMapper.updateModule(moduleId, name, path, weight);
	}

	@Override
	public int delModule(Integer moduleId) {
		// TODO Auto-generated method stub
		return modulesMapper.delModule(moduleId);
	}

	@Override
	public List<String> selectNameFromParent(Integer parentId) {
		// TODO Auto-generated method stub
		return modulesMapper.selectNameFromParent(parentId);
	}

}
