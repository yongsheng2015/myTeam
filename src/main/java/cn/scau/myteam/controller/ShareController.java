package cn.scau.myteam.controller;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.scau.myteam.pojo.Share;
import cn.scau.myteam.service.ShareService;

@Controller
public class ShareController {

	@Autowired
	private ShareService shareService;
	
	//添加分享
	@ResponseBody
	@RequestMapping(value="/addShare",produces="application/json;charset=utf-8")
	public String addShare(String userid,Share share) throws JSONException{
		boolean flag=shareService.save(share);
		JSONObject json=new JSONObject();
		json.accumulate("addFlag", flag);
		return json.toString();
	}
	
	//删除分享
	@ResponseBody
	@RequestMapping(value="/deleteShare",produces="application/json;charset=utf-8")
	public String deleteShare(String shareid) throws JSONException{
		boolean flag=shareService.delete(Integer.valueOf(shareid));
		JSONObject json=new JSONObject();
		json.accumulate("deleteFlag", flag);
		return json.toString();	
	}
	
	//根据用户id查询其分享
	@ResponseBody
	@RequestMapping(value="/findUserShare",produces="application/json;charset=utf-8")
	public String findUserShare(String userid) throws JSONException{
		ArrayList<Share> list=shareService.findByShareId(Integer.valueOf(userid));
		JSONObject json=new JSONObject();
		json.accumulate("userShare", list);
		return json.toString();	
	}
	
	//根据项目的id查询分享
	@ResponseBody
	@RequestMapping(value="/findProjectShare",produces="application/json;charset=utf-8")
	public String findProShare(String projectid) throws JSONException{
		ArrayList<Share> list=shareService.findByProjectId(Integer.valueOf(projectid));
		JSONObject json=new JSONObject();
		json.accumulate("projectShare", list);
		return json.toString();	
	}
	
	//根据任务的id查询分享
	@ResponseBody
	@RequestMapping(value="/findTaskShare",produces="application/json;charset=utf-8")
	public String findTaskShare(String taskid) throws JSONException{
		ArrayList<Share> list=shareService.findByTaskId(Integer.valueOf(taskid));
		JSONObject json=new JSONObject();
		json.accumulate("TaskShare", list);
		return json.toString();	
	}
	
}
