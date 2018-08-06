package cn.scau.myteam.mapper;

import java.util.ArrayList;

import cn.scau.myteam.pojo.ProjectTable;
import cn.scau.myteam.pojo.Task;
import cn.scau.myteam.pojo.User;

public interface MultiTableMapper {
	
	//根据输入的用户id返回用户所参与的项目列表(ProjectUserServiceImpl)
	public ArrayList<ProjectTable> findByUserId(int uid);
	//根据一个子任务的id查找其父任务(SubTaskServiceImpl)
	public ArrayList<Task> findBySubTaskId(int subTaskId);
	//查找一个任务下的子任务，返回子任务列表(SubTaskServiceImpl)
	public ArrayList<Task> findByTaskId(int tid);
	//根据任务的id查找改任务的成员（TaskUsersServiceImpl）
	public ArrayList<User> findByTaskId2(int tid);
	//根据用户的id查询其参与的所有任务（TaskUsersServiceImpl）
	public ArrayList<Task> findByUserId2(int id);
	
}
