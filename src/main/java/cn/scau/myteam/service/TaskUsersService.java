package cn.scau.myteam.service;

import java.util.ArrayList;

import cn.scau.myteam.pojo.Task;
import cn.scau.myteam.pojo.TaskUsersKey;
import cn.scau.myteam.pojo.User;

public interface TaskUsersService {
	public boolean save(TaskUsersKey taskUsersKey);
	public boolean delete(TaskUsersKey taskUsersKey);
	public ArrayList<User> findByTaskId(int id);
	public ArrayList<Task> findByUserId(int id);
	public ArrayList<TaskUsersKey> findAll();
}
