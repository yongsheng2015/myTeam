package cn.scau.myteam.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.scau.myteam.mapper.SubTaskMapper;
import cn.scau.myteam.pojo.SubTaskExample;
import cn.scau.myteam.pojo.SubTaskExample.Criteria;
import cn.scau.myteam.pojo.SubTaskKey;
import cn.scau.myteam.service.SubTaskService;
@Service
public class SubTaskServiceImpl implements SubTaskService {

	@Autowired
	private SubTaskMapper  subTaskMapper;
	@Override
	public boolean save(SubTaskKey subTask) {
		// TODO Auto-generated method stub
		try {
			subTaskMapper.insert(subTask);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean delete(SubTaskKey subTaskKey) {
		// TODO Auto-generated method stub
		try {
			subTaskMapper.deleteByPrimaryKey(subTaskKey);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public ArrayList<SubTaskKey> findBySubTaskId(int id) {
		// TODO Auto-generated method stub
		SubTaskExample s=new SubTaskExample();
		Criteria c=s.createCriteria();
		c.andSubTaskIdEqualTo(id);
		ArrayList<SubTaskKey> list=(ArrayList<SubTaskKey>)subTaskMapper.selectByExample(s);
		return list;
	}

	@Override
	public ArrayList<SubTaskKey> findAll() {
		// TODO Auto-generated method stub
		SubTaskExample s=new SubTaskExample();
		Criteria c=s.createCriteria();
		c.andSubTaskIdIsNotNull();
		ArrayList<SubTaskKey> list=(ArrayList<SubTaskKey>)subTaskMapper.selectByExample(s);
		return list;
	}

}
