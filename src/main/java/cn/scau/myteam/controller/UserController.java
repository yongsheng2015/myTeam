package cn.scau.myteam.controller;
/*
import org.json.JSONException;
import org.json.JSONObject;*/
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.scau.myteam.pojo.User;
import cn.scau.myteam.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	//新增用户
	@ResponseBody
	@RequestMapping(value="/addUser",produces="application/json;charset=utf-8")
	public String addUser(String id,String name,String password) throws JSONException{
		System.out.println(id+"  "+name+"  "+password);
		User user=new User();
		user.setId(Integer.valueOf(id));
		user.setName(name);
		user.setPassword(password);
		boolean flag=userService.save(user);
		JSONObject json=new JSONObject();
		json.accumulate("addFlag", flag);
		return json.toString();
	}
	
	//用户注销
	@ResponseBody
	@RequestMapping(value="/deleteUser",produces="application/json;charset=utf-8")
	public String deleteUser(String id) throws JSONException{
		boolean flag=userService.delete(Integer.valueOf(id));
		JSONObject json=new JSONObject();
		json.accumulate("deleteFalg", flag);
		return json.toString();
	}
	//用户修改个人信息
	@ResponseBody
	@RequestMapping(value="/deleteUser",produces="application/json;charset=utf-8")
	public String updateUser(User user) throws JSONException{
		boolean flag=userService.update(user);
		JSONObject json=new JSONObject();
		json.accumulate("updateFlag", flag);
		return json.toString();
	}
	//用户查看个人信息
	@ResponseBody
	@RequestMapping(value="/viewUser",produces="application/json;charset=utf-8")
	public String viewUser(String id) throws JSONException{
		User user=userService.findById(Integer.valueOf(id));
		JSONObject json=new JSONObject();
		json.accumulate("user", user);
		return json.toString();
	}
	
}
