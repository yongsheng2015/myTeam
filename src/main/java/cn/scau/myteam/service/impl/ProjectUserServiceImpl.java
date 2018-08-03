package cn.scau.myteam.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.scau.myteam.mapper.ProjectUsersMapper;
import cn.scau.myteam.pojo.ProjectUsersExample;
import cn.scau.myteam.pojo.ProjectUsersExample.Criteria;
import cn.scau.myteam.pojo.ProjectUsersKey;
import cn.scau.myteam.service.ProjectUserService;
@Service
public class ProjectUserServiceImpl implements ProjectUserService {

	
	@Autowired
	private ProjectUsersMapper projectUsersMapper;
	@Override
	public boolean save(ProjectUsersKey projectUser) {
		// TODO Auto-generated method stub
		try {
			projectUsersMapper.insert(projectUser);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean delete(ProjectUsersKey projectUsersKey) {
		// TODO Auto-generated method stub
		try {
			projectUsersMapper.deleteByPrimaryKey(projectUsersKey);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public ArrayList<ProjectUsersKey> findByProjectId(int id) {
		// TODO Auto-generated method stub
		ProjectUsersExample p=new ProjectUsersExample();
		Criteria c=p.createCriteria();
		c.andPtidEqualTo(id);
		ArrayList<ProjectUsersKey> list=(ArrayList<ProjectUsersKey>)projectUsersMapper.selectByExample(p);
		
		return list;
	}

	@Override
	public ArrayList<ProjectUsersKey> findAll() {
		// TODO Auto-generated method stub
		ProjectUsersExample p=new ProjectUsersExample();
		Criteria c=p.createCriteria();
		c.andPtidIsNotNull();
		ArrayList<ProjectUsersKey> list=(ArrayList<ProjectUsersKey>)projectUsersMapper.selectByExample(p);
		return list;
		
		
	}

}
