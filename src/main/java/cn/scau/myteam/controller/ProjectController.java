package cn.scau.myteam.controller;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.scau.myteam.pojo.ProjectTable;
import cn.scau.myteam.pojo.User;
import cn.scau.myteam.service.ProjectTableService;
import cn.scau.myteam.service.ProjectUserService;

@Controller
public class ProjectController {

	@Autowired
	private ProjectTableService projectTableService;
	
	@Autowired
	private ProjectUserService projectUserService;
	
	//创建新的项目
	@ResponseBody
	@RequestMapping(value="/addProject",produces="application/json;charset=utf-8")
	public String addProject(String user_id,String title,String intro) throws JSONException{
		ProjectTable p=new ProjectTable();
		p.setCreatorId(Integer.valueOf(user_id));
		p.setTitle(title);
		p.setIntro(intro);
		boolean flag=projectTableService.save(p);
		JSONObject json=new JSONObject();
		json.accumulate("addFlag", flag);
		return json.toString();
	}
	//删除项目
	@ResponseBody
	@RequestMapping(value="/deleteProject",produces="application/json;charset=utf-8")
	public String deleteProject(String pro_id) throws JSONException{
		boolean flag=projectTableService.delete(Integer.valueOf(pro_id));
		JSONObject json=new JSONObject();
		json.accumulate("deleteFlag", flag);
		return json.toString();
	}
	
	//更新项目信息
	@ResponseBody
	@RequestMapping(value="/updateProject",produces="application/json;charset=utf-8")
	public String updateProject(String pro_id,String title,String intro) throws JSONException{
//		ProjectTable p=projectTableService.findById(Integer.valueOf(pro_id));
		ProjectTable p=new ProjectTable();
		p.setId(Integer.valueOf(pro_id));
		p.setTitle(title);
		p.setIntro(intro);
		boolean flag=projectTableService.update(p);
		JSONObject json=new JSONObject();
		json.accumulate("updateFlag", flag);
		return json.toString();
	}
	
	//查看我创建的项目
	@ResponseBody
	@RequestMapping(value="/fingMyproject",produces="application/json;charset=utf-8")
	public String findMyproject(String user_id) throws JSONException{
		ArrayList<ProjectTable> list=projectTableService.findByCreatorId(Integer.valueOf(user_id));
		JSONObject json=new JSONObject();
		json.accumulate("myprojects", list);
		return json.toString();
	}
	
	//查看我所参与的项目
	@ResponseBody
	@RequestMapping(value="/fingProject",produces="application/json;charset=utf-8")
	public String findProject(String user_id) throws JSONException{
		ArrayList<ProjectTable> list=projectUserService.findByUserId(Integer.valueOf(user_id));
		JSONObject json=new JSONObject();
		json.accumulate("projects", list);
		return json.toString();
	}
}
