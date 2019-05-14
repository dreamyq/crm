package com.sprint.crm.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sprint.crm.pojo.PageBean;
import com.sprint.crm.pojo.Roles;
import com.sprint.crm.pojo.User;
import com.sprint.crm.service.RolesService;
import com.sprint.crm.service.UserService;
import com.sprint.crm.util.CommonUtil;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	RolesService rolesService;
	/**
	 * ������ѯʦ
	 * 
	 * @return ��ѯʦ����
	 */
	@ResponseBody
	@RequestMapping("selectZiXunShis")
	public List<User> selectZiXunShis() {
		return userService.selectZiXunShis("��ѯʦ");
	}

	/**
	 * �޸�����jspҳ��·��
	 * 
	 * @return
	 */
	@RequestMapping("changePasswordList")
	public String changePasswordList() {

		return "user/changePassword";
	}

	/**
	 * ��֤��ǰ��������
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("validatePassword")
	public Boolean validatePassword(HttpSession session, String password) {
		// User user = (User) session.getAttribute("user");
		// String loginName = user.getLoginName();�õ�Session���û���
		//String loginName = "��ѯʦ1";
		if (userService.validatePassword((String) session.getAttribute("username"), password) != null) {
			return true;
		}
		return false;
	}

	/**
	 * �޸�����
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("changePassword")
	public Boolean changePassword(HttpSession session, String password) {
		// User user = (User) session.getAttribute("user");
		// String loginName = user.getLoginName();�õ�Session���û���
		//String loginName = "��ѯʦ1";
		if (userService.changePassword((String) session.getAttribute("username"), password) > 0) {
			return true;
		}
		return false;
	}
	
	@RequestMapping("yh")
	public String get2(){
		return "sys/yh";
	}
	@InitBinder
	protected void initbinder(WebDataBinder binder){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class,new CustomDateEditor(sdf, true));
	}
	/**
	 * ��ҳ����
	 * @param pageBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("usergetPageAll")
    public Map<String, Object> list(PageBean pageBean){
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("total",userService.getSum(pageBean));
    	map.put("rows",userService.getPage(pageBean));
    	return map;
    }
	/**
	 * �����û�
	 * @param id
	 * @return
	 */
	@RequestMapping("updateLock")
	@ResponseBody
	public Map<String, Object> updateLock(Integer id) {
		Map<String, Object> map = CommonUtil.getResultMap();
		System.out.println(id);
	String islock=userService.getUserLockById(id);
		
		if("��".equals(islock)){
			int r = userService.updateLock(id);
			if(r>0){
				map.put("success", true);
				map.put("message", "�ѳɹ������û�");
			}else{
				map.put("message", "����ʧ�ܣ�");
			}
		}else{
			map.put("message", "�û������ظ�������");
		}
		return map;
	}
	/**
	 * �����û�
	 * @param id
	 * @return
	 */
	@RequestMapping("updateUnLock")
	@ResponseBody
	public Map<String, Object> updateUnLock(Integer id) {
		Map<String, Object> map = CommonUtil.getResultMap();
		String islock=userService.getUserLockById(id);
		if("��".equals(islock)){
			int r = userService.updateUnLock(id);
			if(r>0){
				map.put("success", true);
				map.put("message", "�ѳɹ������û�");
			}else{
				map.put("message", "����ʧ�ܣ�");
			}
		}else{
			map.put("message", "�û������ظ�������");
		}
		return map;
	}
	@RequestMapping("findAllRole")
	@ResponseBody
	public List<Roles> findAllRole(){
		List<Roles> list = userService.selectRole();
		return list;
	} 
	@RequestMapping("findAllUserRole")
	@ResponseBody
	public List<Roles> findAllRole(Integer id){
		List<Roles> list = userService.selectUserRole(id);
		return list;
	} 
	@RequestMapping("insertUserRole")
	@ResponseBody
	public Map<String, Object> insertUserRole(Integer id, Integer rid) {
		Map<String, Object> map = CommonUtil.getResultMap();
	    List<Roles> list = userService.getUserRoleById(id, rid);
		int searchCid = rolesService.getRIdByRname("����Ա");
		System.out.println(list);
		System.out.println(searchCid);
	if(list.size()>0){
			map.put("seccess", false);
			map.put("message", "��ӵ�д˽�ɫ");
		}else{
			int u=0;
			u = userService.addUserRole(id, rid);
			System.out.println(u);
			if(u>0){
				map.put("success", true);
				map.put("message", "��ӽ�ɫ�ɹ�");
			}else{
				map.put("message", "��ӽ�ɫʧ��");
			}
		}
		return map;
	}
	@RequestMapping("addyh")
	public void addyh(User user,HttpServletResponse re) throws IOException{
		System.out.println(user);
         PrintWriter out = re.getWriter();
         re.setCharacterEncoding("utf-8");
 		re.setContentType("text/html;charset=utf-8");
           int num = 0;
		if(user.getUserId()==null){
		   num = userService.insertUser(user);
		}else{
			num = userService.updateUser(user);
		}
		if(num>0){
			out.print(true);
		}else{
		out.print(false);
		}
	}
	@RequestMapping("userOut")
	@ResponseBody
	public Map<String, Object> userOut(HttpSession session){
		Map<String, Object> maps=CommonUtil.getResultMap();
		int uId=(Integer)session.getAttribute("user_id");
		int r=userService.updateUserLastLoginTime(uId);
		if(r>0){
			maps.put("success", "true");
			maps.put("message", "�˳��ɹ�...��������¼ʱ��ɹ�");
		}else{
			maps.put("message", "�˳�ʧ��...��������½ʱ��ʧ��");
		}
		return maps;
	}
	@RequestMapping("dele")
	@ResponseBody
	public Map<String, Object> dele(@RequestParam(value="ids") String ids) throws IOException{
		Map<String, Object> maps=CommonUtil.getResultMap();
			String[] id1 = ids.split(",");
			for(String id : id1){
				int num = userService.delUser(id);
				if(num>0){
					maps.put("success", "true");
					maps.put("message", "ɾ���ɹ�");
				}else{
					maps.put("message", "ɾ��ʧ��");
				}
			}
			return maps;
}
	@RequestMapping("deltUserRole")
	@ResponseBody
	public Map<String, Object> delUserRole(Integer id, Integer rid,HttpSession session){
		Map<String, Object> map = CommonUtil.getResultMap();
	//	List<Roles> roles = userService.selectRole();
		//int getRid = 0,getNid=0;
		int r=-1;
		int a=1;
		if(r!=0){
			r = userService.delUserRole(id, rid);
			if(r>0){
				map.put("success", true);
				map.put("message", "��ɫ�Ƴ��ɹ���");
			}else{
				map.put("message", "��ɫ�Ƴ�ʧ�ܣ�");
			}
		}else{
			map.put("message", "��ɫ�Ƴ�ʧ�ܣ�");
		}
		return map;
	}

}
