package cn.scau.myteam.service;

import java.util.ArrayList;

import cn.scau.myteam.pojo.SubTaskKey;

public interface SubTaskService {
	public boolean save(SubTaskKey subTask);
	public boolean delete(SubTaskKey subTask);
	public ArrayList<SubTaskKey> findBySubTaskId(int id);
	public ArrayList<SubTaskKey> findAll();
}
