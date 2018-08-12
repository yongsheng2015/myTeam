package cn.scau.myteam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.scau.myteam.pojo.SubTaskKey;
import cn.scau.myteam.pojo.Task;
import cn.scau.myteam.service.SubTaskService;
import cn.scau.myteam.service.TaskService;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("")
public class SubTaskController {
	
	@Autowired
	SubTaskService subTaskService;
	@Autowired
	TaskService taskService;
	
	//01 添加子任务
	@ResponseBody
	@RequestMapping(value="/addSubTask",produces="application/json;charset=utf-8")
	public String addSubTask(String tid) {
		Task subTask = new Task();
		taskService.save(subTask);
		
		SubTaskKey subTaskKey = new SubTaskKey();
		subTaskKey.setTid(Integer.parseInt(tid));
		subTaskKey.setSubTaskId(subTask.getId());
		boolean addSubTaskFlag = subTaskService.save(subTaskKey);
		
		JSONObject json = new JSONObject();
		json.accumulate("subTaskKey",subTaskKey);
		json.accumulate("addSubTaskFlag", addSubTaskFlag);
		return json.toString();
	}
	
	//02 删除子任务
	@ResponseBody
	@RequestMapping(value="/deleteSubTask",produces="application/json;charset=utf-8")
	public String deleteSubTask(String tid,String subTaskId) {
		SubTaskKey subTaskKey = new SubTaskKey();
		subTaskKey.setTid(Integer.parseInt(tid));
		subTaskKey.setSubTaskId(Integer.parseInt(subTaskId));
		boolean deleteSubTaskFlag = subTaskService.delete(subTaskKey);//删除subTask表的记录
		boolean deleteOriginalTaskFlag=taskService.delete(Integer.parseInt(subTaskId));//同时删除task表的任务
		
		JSONObject json = new JSONObject();
		json.accumulate("subTaskKey",subTaskKey);
		json.accumulate("deleteSubTaskFlag", deleteSubTaskFlag);
		json.accumulate("deleteOriginalTaskFlag", deleteOriginalTaskFlag);
		return json.toString();
	}
	
	//03 查看子任务列表
	@ResponseBody
	@RequestMapping(value="/getSubTaskList",produces="application/json;charset=utf-8")
	public String getSubTaskList(String tid) {
		List<Task> list = subTaskService.findByTaskId(Integer.parseInt(tid));
		boolean getSubTaskListFlag = false;
		if(list!=null) getSubTaskListFlag = true;
		
		JSONObject json = new JSONObject();
		json.accumulate("subTaskList",list);
		json.accumulate("getSubTaskListFlag", getSubTaskListFlag);
		return json.toString();
	}
	
	//04 删除子任务(多选)
	@ResponseBody
	@RequestMapping(value="/deleteSubTaskList",produces="application/json;charset=utf-8")
	public String deleteSubTaskList(String tid,List<String> subTaskIdList) {
		SubTaskKey subTaskKey = new SubTaskKey();
		boolean deleteSubTaskListFlag = true;
		boolean deleteOriginalTaskListFlag = true;
		for (String subTaskId : subTaskIdList) {
			subTaskKey.setTid(Integer.parseInt(tid));
			subTaskKey.setSubTaskId(Integer.parseInt(subTaskId));
			deleteSubTaskListFlag = subTaskService.delete(subTaskKey);//删除subTask表的记录
			deleteOriginalTaskListFlag = taskService.delete(Integer.parseInt(subTaskId));//同时删除task表的任务
		}
		
		JSONObject json = new JSONObject();
		json.accumulate("deleteSubTaskListFlag", deleteSubTaskListFlag);
		json.accumulate("deleteOriginalTaskListFlag", deleteOriginalTaskListFlag);
		return json.toString();
	}
	
	//test
}
