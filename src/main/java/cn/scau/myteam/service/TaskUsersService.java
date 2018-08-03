package cn.scau.myteam.service;

import java.util.ArrayList;

import cn.scau.myteam.pojo.TaskUsersKey;

public interface TaskUsersService {
	public boolean save(TaskUsersKey taskUsersKey);
	public boolean delete(TaskUsersKey taskUsersKey);
	public ArrayList<TaskUsersKey> findByTaskId(int id);
	public ArrayList<TaskUsersKey> findAll();
}
