package cn.scau.myteam.service;

import java.util.ArrayList;

import cn.scau.myteam.pojo.SubTaskKey;
import cn.scau.myteam.pojo.Task;

public interface SubTaskService {
	public boolean save(SubTaskKey subTask);
	public boolean delete(SubTaskKey subTask);
	public ArrayList<Task> findBySubTaskId(int id);
	public ArrayList<SubTaskKey> findAll();
	public ArrayList<Task> findByTaskId(int id);
}
