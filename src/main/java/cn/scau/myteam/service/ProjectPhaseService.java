package cn.scau.myteam.service;

import java.util.ArrayList;

import cn.scau.myteam.pojo.ProjectPhase;

public interface ProjectPhaseService {
	public boolean save(ProjectPhase projectPhase);
	public boolean delete(int id);
	public boolean update(ProjectPhase projectPhase);
	public ProjectPhase findById(int id);
	public ArrayList<ProjectPhase> findAll();
}
