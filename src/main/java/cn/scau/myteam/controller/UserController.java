package cn.scau.myteam.controller;
<<<<<<< HEAD

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

=======
/*
>>>>>>> 64c9d5beb8b2e63e052e8f91e35e52df9e5f433f
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
import cn.scau.myteam.util.MD5Util;
import cn.scau.myteam.util.ValidateCode;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	//用户注册
	@ResponseBody
	@RequestMapping(value="/addUser",produces="application/json;charset=utf-8")
	public String addUser(String id,String name,String password) throws JSONException{
		User user=new User();
		user.setId(Integer.valueOf(id));
		user.setName(name);
		String pw=MD5Util.md5(password);
		user.setPassword(pw);
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
		json.accumulate("deleteFlag", flag);
		return json.toString();
	}
	//用户修改个人信息
	@ResponseBody
	@RequestMapping(value="/updateUser",produces="application/json;charset=utf-8")
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
	//用户登录(1.用户不存在  2.管理员登录  3.用户登录成功   4.密码错误  5.验证码错误)
	@ResponseBody
	@RequestMapping(value="/loginUser",produces="application/json;charset=utf-8")
	public String login(String userid,String password,String code,HttpSession session){
		String code2=(String)session.getAttribute("code");
		if(code.equals(code2))
			return "5";
		String res=null;
		String pw=MD5Util.md5(password);
		User user=userService.findById(Integer.valueOf(userid));
		if(user==null){
			res="1";
		}else if(user.getName().equals("admin")&&user.getPassword().equals(pw)){
			res="2";
		}
		else if(user.getPassword().equals(password)){
			res="3";
		}else {
			res="4";
		}
		return res;
	}
	
	//生成验证码
	@RequestMapping(value="/article/validateCode")
	public String validateCode(HttpServletRequest request,HttpServletResponse response) throws Exception{
		// 设置响应的类型格式为图片格式
		response.setContentType("image/jpeg");
		//禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		HttpSession session = request.getSession();
		ValidateCode vCode = new ValidateCode(120,40,5,100);
		//将生成的验证码存储在session中
		session.setAttribute("code", vCode.getCode());
		vCode.write(response.getOutputStream());
		return null;
	}
	
	
	
}
