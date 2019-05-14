package com.sprint.crm.service;

import com.sprint.crm.pojo.TailAfter;
import com.sprint.crm.pojo.TailAfterExt;
import com.sprint.crm.pojo.User;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

public interface TailAfterService {
	List<User> selectUserId();
	   List<TailAfterExt> selectAll(@Param("t")TailAfterExt t,@Param("start")Integer start ,@Param("rows")Integer rows,@Param("beganTime")String beganTime,@Param("endTime")String endTime);
	   int  getCount(@Param("t")TailAfterExt t,@Param("beganTime")String beganTime,@Param("endTime")String endTime) ; 
	int insertSelective(TailAfter record);

	TailAfter selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(TailAfter record);

}