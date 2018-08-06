package cn.scau.myteam.controller;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.scau.myteam.pojo.ProjectTable;
import cn.scau.myteam.service.ProjectTableService;
import cn.scau.myteam.service.ProjectUserService;

@Controller
public class ProjectController {

	@Autowired
	private ProjectTableService projectTableService;
	
	@Autowired
	private ProjectUserService projectUserService;
	
	//创建新的项目
	
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
	@RequestMapping(value="/fingMyproject",produces="application/json;charset=utf-8")
	public String findProject(String user_id) throws JSONException{
		ArrayList<ProjectTable> list=projectUserService.findByUserId(Integer.valueOf(user_id));
		JSONObject json=new JSONObject();
		json.accumulate("projects", list);
		return json.toString();
	}
}
