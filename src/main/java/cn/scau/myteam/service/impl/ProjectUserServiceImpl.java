package cn.scau.myteam.service.impl;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.scau.myteam.mapper.ProjectTableMapper;
import cn.scau.myteam.mapper.ProjectUsersMapper;
import cn.scau.myteam.pojo.ProjectTable;
import cn.scau.myteam.pojo.ProjectUsersExample;
import cn.scau.myteam.pojo.ProjectUsersExample.Criteria;
import cn.scau.myteam.pojo.ProjectUsersKey;
import cn.scau.myteam.service.ProjectTableService;
import cn.scau.myteam.service.ProjectUserService;
@Service
public class ProjectUserServiceImpl implements ProjectUserService {

	
	@Autowired
	private ProjectUsersMapper projectUsersMapper;
	@Autowired
	private ProjectTableMapper projectTableMapper;
	
	@Override
	public boolean save(ProjectUsersKey projectUser) {
		// TODO Auto-generated method stub
		try {
			projectUsersMapper.insertSelective(projectUser);
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
	public ArrayList<ProjectUsersKey> findByProjectId(int projectid) {
		// TODO Auto-generated method stub
		ProjectUsersExample p=new ProjectUsersExample();
		Criteria c=p.createCriteria();
		c.andPtidEqualTo(projectid);
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

	//根据输入的用户id返回用户所参与的项目列表
	@Override
	public ArrayList<ProjectTable> findByUserId(int userid) {
		// TODO Auto-generated method stub
		ProjectUsersExample p=new ProjectUsersExample();
		Criteria c=p.createCriteria();
		c.andUidEqualTo(userid);
		ArrayList<ProjectUsersKey> list=(ArrayList<ProjectUsersKey>)projectUsersMapper.selectByExample(p);
		ArrayList<ProjectTable> pros=new ArrayList<ProjectTable>();
		for(ProjectUsersKey puk:list){
			pros.add(projectTableMapper.selectByPrimaryKey(puk.getPtid()));
		}
		return pros;
	}

}
