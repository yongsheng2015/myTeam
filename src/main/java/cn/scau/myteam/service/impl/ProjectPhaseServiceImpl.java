package cn.scau.myteam.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.scau.myteam.mapper.ProjectPhaseMapper;
import cn.scau.myteam.pojo.ProjectPhase;
import cn.scau.myteam.pojo.ProjectPhaseExample;
import cn.scau.myteam.pojo.ProjectPhaseExample.Criteria;
import cn.scau.myteam.service.ProjectPhaseService;
@Service
public class ProjectPhaseServiceImpl implements ProjectPhaseService {

	@Autowired
	private ProjectPhaseMapper projectPhaseMapper;
	@Override
	public boolean save(ProjectPhase projectPhase) {
		// TODO Auto-generated method stub
		try {
			projectPhaseMapper.insert(projectPhase);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		try {
			projectPhaseMapper.deleteByPrimaryKey(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean update(ProjectPhase projectPhase) {
		// TODO Auto-generated method stub
		try {
			projectPhaseMapper.updateByPrimaryKey(projectPhase);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public ProjectPhase findById(int id) {
		// TODO Auto-generated method stub
		return projectPhaseMapper.selectByPrimaryKey(id);
	}

	@Override
	public ArrayList<ProjectPhase> findAll() {
		// TODO Auto-generated method stub
		ProjectPhaseExample p=new ProjectPhaseExample();
		Criteria criteria=p.createCriteria();
		criteria.andIdIsNotNull();
		ArrayList<ProjectPhase> list=(ArrayList<ProjectPhase>)projectPhaseMapper.selectByExample(p);
		return list;
	}

}
