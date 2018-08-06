package cn.scau.myteam.service;

import java.util.ArrayList;

import cn.scau.myteam.pojo.ProjectTable;
import cn.scau.myteam.pojo.ProjectUsersKey;

public interface ProjectUserService {
	public boolean save(ProjectUsersKey projectUser);
	public boolean delete(ProjectUsersKey projectUsersKey);
	public ArrayList<ProjectUsersKey> findByProjectId(int projectid);
	public ArrayList<ProjectUsersKey> findAll();
	public ArrayList<ProjectTable> findByUserId(int userid); 
}
