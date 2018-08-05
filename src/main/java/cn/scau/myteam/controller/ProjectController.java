package cn.scau.myteam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.scau.myteam.service.ProjectTableService;

@Controller
public class ProjectController {

	@Autowired
	private ProjectTableService projectTableService;
	
	//创建新的项目
	
	//查看我创建的项目
//	@ResponseBody
//	@RequestMapping(value="/fingMyproject",produces="application/json;charset=utf-8")
//	public String findMyproject(String user_id){
//		
//	}
}
