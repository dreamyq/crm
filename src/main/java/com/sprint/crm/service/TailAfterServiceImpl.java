package com.sprint.crm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sprint.crm.mapper.TailAfterMapper;
import com.sprint.crm.pojo.TailAfter;
import com.sprint.crm.pojo.TailAfterExt;
import com.sprint.crm.pojo.User;

@Service
public class TailAfterServiceImpl implements TailAfterService {
	@Resource
	private TailAfterMapper tsailAfterMapper;

	@Override
	public int insertSelective(TailAfter record) {
		// TODO Auto-generated method stub
		return tsailAfterMapper.insertSelective(record);
	}

	@Override
	public TailAfter selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return tsailAfterMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(TailAfter record) {
		// TODO Auto-generated method stub
		return tsailAfterMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<TailAfterExt> selectAll(TailAfterExt t, Integer start, Integer rows, String beganTime, String endTime) {
		// TODO Auto-generated method stub
		return tsailAfterMapper.selectAll(t, start, rows, beganTime, endTime);
	}

	@Override
	public int getCount(TailAfterExt t, String beganTime, String endTime) {
		// TODO Auto-generated method stub
		return tsailAfterMapper.getCount(t, beganTime, endTime);
	}

	@Override
	public List<User> selectUserId() {
		// TODO Auto-generated method stub
		return tsailAfterMapper.selectUserId();
	}

}
