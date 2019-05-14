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
	 * 所有咨询师
	 * 
	 * @return 咨询师集合
	 */
	@ResponseBody
	@RequestMapping("selectZiXunShis")
	public List<User> selectZiXunShis() {
		return userService.selectZiXunShis("咨询师");
	}

	/**
	 * 修改密码jsp页面路径
	 * 
	 * @return
	 */
	@RequestMapping("changePasswordList")
	public String changePasswordList() {

		return "user/changePassword";
	}

	/**
	 * 验证当前密码密码
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("validatePassword")
	public Boolean validatePassword(HttpSession session, String password) {
		// User user = (User) session.getAttribute("user");
		// String loginName = user.getLoginName();拿到Session的用户名
		//String loginName = "咨询师1";
		if (userService.validatePassword((String) session.getAttribute("username"), password) != null) {
			return true;
		}
		return false;
	}

	/**
	 * 修改密码
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("changePassword")
	public Boolean changePassword(HttpSession session, String password) {
		// User user = (User) session.getAttribute("user");
		// String loginName = user.getLoginName();拿到Session的用户名
		//String loginName = "咨询师1";
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
	 * 分页数据
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
	 * 锁定用户
	 * @param id
	 * @return
	 */
	@RequestMapping("updateLock")
	@ResponseBody
	public Map<String, Object> updateLock(Integer id) {
		Map<String, Object> map = CommonUtil.getResultMap();
		System.out.println(id);
	String islock=userService.getUserLockById(id);
		
		if("否".equals(islock)){
			int r = userService.updateLock(id);
			if(r>0){
				map.put("success", true);
				map.put("message", "已成功锁定用户");
			}else{
				map.put("message", "锁定失败！");
			}
		}else{
			map.put("message", "用户不能重复被锁定");
		}
		return map;
	}
	/**
	 * 解锁用户
	 * @param id
	 * @return
	 */
	@RequestMapping("updateUnLock")
	@ResponseBody
	public Map<String, Object> updateUnLock(Integer id) {
		Map<String, Object> map = CommonUtil.getResultMap();
		String islock=userService.getUserLockById(id);
		if("是".equals(islock)){
			int r = userService.updateUnLock(id);
			if(r>0){
				map.put("success", true);
				map.put("message", "已成功解锁用户");
			}else{
				map.put("message", "解锁失败！");
			}
		}else{
			map.put("message", "用户不能重复被解锁");
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
		int searchCid = rolesService.getRIdByRname("管理员");
		System.out.println(list);
		System.out.println(searchCid);
	if(list.size()>0){
			map.put("seccess", false);
			map.put("message", "已拥有此角色");
		}else{
			int u=0;
			u = userService.addUserRole(id, rid);
			System.out.println(u);
			if(u>0){
				map.put("success", true);
				map.put("message", "添加角色成功");
			}else{
				map.put("message", "添加角色失败");
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
			maps.put("message", "退出成功...更新最后登录时间成功");
		}else{
			maps.put("message", "退出失败...更新最后登陆时间失败");
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
					maps.put("message", "删除成功");
				}else{
					maps.put("message", "删除失败");
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
				map.put("message", "角色移除成功！");
			}else{
				map.put("message", "角色移除失败！");
			}
		}else{
			map.put("message", "角色移除失败！");
		}
		return map;
	}

}
