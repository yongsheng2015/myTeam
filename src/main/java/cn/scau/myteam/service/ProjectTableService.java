package cn.scau.myteam.service;

import java.util.ArrayList;

import cn.scau.myteam.pojo.ProjectTable;

public interface ProjectTableService {
	public boolean save(ProjectTable projectTable);
	public boolean delete(int id);
	public boolean update(ProjectTable projectTable);
	public ProjectTable findById(int id);
	public ArrayList<ProjectTable> findAll();
}
