package cn.scau.myteam.service;

import java.util.ArrayList;

import cn.scau.myteam.pojo.Task;

public interface TaskService {
	public boolean save(Task task);
	public boolean delete(int id);
	public boolean update(Task task);
	public Task findById(int id);
	public ArrayList<Task> findAll();
}
