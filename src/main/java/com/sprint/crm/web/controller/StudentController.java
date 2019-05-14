package com.sprint.crm.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sprint.crm.pojo.Paging;
import com.sprint.crm.pojo.Students;
import com.sprint.crm.service.StudentsService;

@Controller
@RequestMapping("students")
public class StudentController {

	@Autowired
	private StudentsService studentsService;

	@RequestMapping("mystudent")
	public String list() {
		return "students/mystudent";
	}

	@ResponseBody
	@RequestMapping("pageData")
	public Map<String, Object> pageData(Students students, int page, int rows) {
		int start = (page - 1) * rows;
		Map<String, Object> map = new HashMap<String, Object>();// ��map����
		map.put("total", studentsService.pageCount(students));// �����Ʒ�ܸ���
		map.put("rows", studentsService.pageData(students, start, rows));// ���������Ʒ
		return map;// ��������
	}
	/**
	 * ���ݶ��ѧ��id��ѯѧ������
	 * @param students
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping("fenpeis")
	public List<Students> fenpeis(String ids) {
		return studentsService.fenpeis(ids);
	}
	
	/**
	 * ��������
	 * @param ids
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("updatefenpeis")
	public Integer updatefenpeis(@Param("ids") String ids,@Param("userId") int userId) {
		return studentsService.updatefenpeis(ids, userId);
	}
	
	@ResponseBody
	@RequestMapping("delete")
	public Integer delete(@Param("studentId") int studentId) {
		return studentsService.deleteByStudentId(studentId);
	}
	
	@ResponseBody
	@RequestMapping("deletes")
	public Integer deletes(@Param("ids") String ids) {
		return studentsService.deleteByStudentIds(ids);
	}
	@ResponseBody
	@RequestMapping("add")
	public Integer add(Students record,HttpSession session) {
		//�����ѧ����ʱ�� �������ʱ��
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String creatTime=sdf.format(new Date());
		record.setCreatTime(creatTime);
		
		  Integer userId1= (Integer) session.getAttribute("user_id");
		  record.setUserId1(userId1);
		
		return studentsService.insertSelective(record);
	}
	@ResponseBody
	@RequestMapping("update")
	public Integer update(Students record) {
		System.out.println(record.getName());
		return studentsService.updateByPrimaryKeySelective(record);
	}

}
