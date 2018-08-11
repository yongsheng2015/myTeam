package cn.scau.myteam.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.scau.myteam.pojo.Task;
import cn.scau.myteam.service.TaskService;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	//01 添加任务
	@ResponseBody
	@RequestMapping(value="/addTask",produces="application/json;charset=utf-8")
	public String addTask() {
		Task task = new Task();
		boolean addTaskFlag = taskService.save(task);
		JSONObject json = new JSONObject();
		json.accumulate("task",task);
		json.accumulate("addTaskFlag", addTaskFlag);
		return json.toString();
	}
	
	//02 删除任务
	@ResponseBody
	@RequestMapping(value="/deleteTask",produces="application/json;charset=utf-8")
	public String deleteTask(String id) {
		Task task = taskService.findById(Integer.parseInt(id));
		boolean deleteTaskFlag = taskService.delete(Integer.parseInt(id));
		
		JSONObject json = new JSONObject();
		json.accumulate("task",task);
		json.accumulate("deleteTaskFlag", deleteTaskFlag);
		return json.toString();
	}
	
	//03 查询任务
	@ResponseBody
	@RequestMapping(value="/getTask",produces="application/json;charset=utf-8")
	public String getTask(String id) {
		Task task = taskService.findById(Integer.parseInt(id));
		boolean getTaskFlag = false;
		if(task!=null) getTaskFlag=true;
		
		JSONObject json = new JSONObject();
		json.accumulate("task",task);
		json.accumulate("getTaskFlag", getTaskFlag);
		return json.toString();
	}
	
	//04 查询任务列表（根据项目阶段id）
	@ResponseBody
	@RequestMapping(value="/getTaskList",produces="application/json;charset=utf-8")
	public String getTaskList(String ppid) {
		List<Task> list = taskService.findAll(Integer.parseInt(ppid)); 
		boolean getTaskListFlag = false;
		if(list!=null) getTaskListFlag=true;
		
		JSONObject json = new JSONObject();
		json.accumulate("taskList",list);
		json.accumulate("getTaskListFlag", getTaskListFlag);
		return json.toString();
	}
	
	//05 修改任务内容
	@ResponseBody
	@RequestMapping(value="/updateTaskContent",produces="application/json;charset=utf-8")
	public String updateTaskContent(String id,String content) {
		Task task = taskService.findById(Integer.parseInt(id));
		task.setContent(content);
		boolean updateTaskContentFlag = taskService.update(task);
		System.out.println("Task content = "+task.getContent());
		JSONObject json = new JSONObject();
		json.accumulate("task",task);
		json.accumulate("updateTaskContentFlag", updateTaskContentFlag);
		return json.toString();
	}
	
	//06 添加任务的执行者
	@ResponseBody
	@RequestMapping(value="/addTaskUserId",produces="application/json;charset=utf-8")
	public String addTaskUserId(String id,String uid) {
		Task task = taskService.findById(Integer.parseInt(id));
		task.setUid(Integer.parseInt(uid));
		boolean addTaskUserIdFlag = taskService.update(task);
		task = taskService.findById(Integer.parseInt(id));
		
		JSONObject json = new JSONObject();//add return
		json.accumulate("task",task);
		json.accumulate("addTaskUserIdFlag", addTaskUserIdFlag);
		return json.toString();
	}
	
	//07 删除任务的执行者
	@ResponseBody
	@RequestMapping(value="/deleteTaskUserId",produces="application/json;charset=utf-8")
	public String deleteTaskUserId(String id) {
		Task task = taskService.findById(Integer.parseInt(id));
		task.setUid(null);
		boolean deleteTaskUserIdFlag = taskService.update(task);
		task = taskService.findById(Integer.parseInt(id));
		
		JSONObject json = new JSONObject();//add return
		json.accumulate("task",task);
		json.accumulate("deleteTaskUserIdFlag", deleteTaskUserIdFlag);
		return json.toString();
	}
	
	//08 设置开始时间
	@ResponseBody
	@RequestMapping(value="/setTaskCreateTime",produces="application/json;charset=utf-8")
	public String setTaskCreateTime(String id,String createTime) {
		Task task = taskService.findById(Integer.parseInt(id));
		boolean setTaskCreateTimeFlag = false;
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd HH:mm:ss" );
		try {
			Date date = sdf.parse(createTime);
			task.setCreateTime(date);
			setTaskCreateTimeFlag=taskService.update(task);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JSONObject json = new JSONObject();
		json.accumulate("task",task);
		json.accumulate("setTaskCreateTimeFlag", setTaskCreateTimeFlag);
		return json.toString();
	}
	
	//09 设置结束时间
	@ResponseBody
	@RequestMapping(value="/setTaskEndTime",produces="application/json;charset=utf-8")
	public String setTaskEndTime(String id,String endTime) {
		Task task = taskService.findById(Integer.parseInt(id));
		boolean setTaskEndTimeFlag = false;
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd HH:mm:ss" );
		try {
			Date date = sdf.parse(endTime);
			task.setEndTime(date);
			setTaskEndTimeFlag=taskService.update(task);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JSONObject json = new JSONObject();
		json.accumulate("task",task);
		json.accumulate("setTaskEndTimeFlag", setTaskEndTimeFlag);
		return json.toString();
	}
	
	//10 设置任务重复
	@ResponseBody
	@RequestMapping(value="/setTaskRepeat",produces="application/json;charset=utf-8")
	public String setTaskRepeat(String id,String setRepeat) {
		Task task = taskService.findById(Integer.parseInt(id));
		task.setSetRepeat(setRepeat);
		boolean setTaskRepeatFlag = taskService.update(task);
		
		JSONObject json = new JSONObject();
		json.accumulate("task",task);
		json.accumulate("setTaskRepeatFlag", setTaskRepeatFlag);
		return json.toString();
	}
	
	//11 设置任务提醒
	@ResponseBody
	@RequestMapping(value="/setTaskRemind",produces="application/json;charset=utf-8")
	public String setTaskRemind(String id,String setRemind) {
		Task task = taskService.findById(Integer.parseInt(id));
		boolean setTaskRemindFlag = false;
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd HH:mm:ss" );
		try {
			Date date = sdf.parse(setRemind);
			task.setSetRemind(date);
			setTaskRemindFlag=taskService.update(task);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JSONObject json = new JSONObject();
		json.accumulate("task",task);
		json.accumulate("setTaskRemindFlag", setTaskRemindFlag);
		return json.toString();
	}
	
	//12 修改任务备注
	@ResponseBody
	@RequestMapping(value="/updateTaskRemark",produces="application/json;charset=utf-8")
	public String updateTaskRemark(String id,String remark) {
		Task task = taskService.findById(Integer.parseInt(id));
		task.setRecord(remark);
		boolean updateTaskRemarktFlag = taskService.update(task);
		
		JSONObject json = new JSONObject();
		json.accumulate("task",task);
		json.accumulate("updateTaskRemarktFlag", updateTaskRemarktFlag);
		return json.toString();
	}
	
	//13 选择任务优先级
	@ResponseBody
	@RequestMapping(value="/selectTaskPriority",produces="application/json;charset=utf-8")
	public String selectTaskPriority(String id,String priority) {
		Task task = taskService.findById(Integer.parseInt(id));
		task.setPriority(priority);
		boolean selectTaskPriorityFlag = taskService.update(task);
		
		JSONObject json = new JSONObject();
		json.accumulate("task",task);
		json.accumulate("selectTaskPriorityFlag", selectTaskPriorityFlag);
		return json.toString();
	}
	
	//14 选择任务标签
	@ResponseBody
	@RequestMapping(value="/selectTaskLabel",produces="application/json;charset=utf-8")
	public String selectTaskLabel(String id,String label) {
		Task task = taskService.findById(Integer.parseInt(id));
		task.setLabel(label);
		boolean selectTaskLabelFlag = taskService.update(task);
		
		JSONObject json = new JSONObject();
		json.accumulate("task",task);
		json.accumulate("selectTaskLabelFlag", selectTaskLabelFlag);
		return json.toString();
	}
	
	//15 添加任务动态记录
	@ResponseBody
	@RequestMapping(value="/addTaskRecord",produces="application/json;charset=utf-8")
	public String addTaskRecord(String id,String record) {
		Task task = taskService.findById(Integer.parseInt(id));
		task.setRecord(record);
		boolean addTaskRecordFlag = taskService.update(task);
		task = taskService.findById(Integer.parseInt(id));
		
		JSONObject json = new JSONObject();//add return
		json.accumulate("task",task);
		json.accumulate("addTaskRecordFlag", addTaskRecordFlag);
		return json.toString();
	}
	
}
