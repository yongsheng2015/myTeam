package cn.scau.myteam.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.scau.myteam.mapper.ProjectTableMapper;
import cn.scau.myteam.pojo.ProjectTable;
import cn.scau.myteam.pojo.ProjectTableExample;
import cn.scau.myteam.pojo.ProjectTableExample.Criteria;
import cn.scau.myteam.service.ProjectTableService;
@Service
public class ProjectTableServiceImpl implements ProjectTableService {

	@Autowired
	private ProjectTableMapper projectTableMapper;
	@Override
	public boolean save(ProjectTable projectTable) {
		// TODO Auto-generated method stub
		try {
			projectTableMapper.insert(projectTable);
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
			projectTableMapper.deleteByPrimaryKey(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean update(ProjectTable projectTable) {
		// TODO Auto-generated method stub
		try {
			projectTableMapper.updateByPrimaryKey(projectTable);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public ProjectTable findById(int id) {
		// TODO Auto-generated method stub
		return projectTableMapper.selectByPrimaryKey(id);
	}

	@Override
	public ArrayList<ProjectTable> findAll() {
		// TODO Auto-generated method stub
		ProjectTableExample pro=new ProjectTableExample();
		Criteria criteria=pro.createCriteria();
		criteria.andIdIsNotNull();
		ArrayList<ProjectTable> list=(ArrayList<ProjectTable>)projectTableMapper.selectByExample(pro);
		return list;
	}

}
