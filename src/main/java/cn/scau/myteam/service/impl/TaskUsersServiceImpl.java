package cn.scau.myteam.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.scau.myteam.mapper.TaskUsersMapper;
import cn.scau.myteam.pojo.TaskUsersExample;
import cn.scau.myteam.pojo.TaskUsersExample.Criteria;
import cn.scau.myteam.pojo.TaskUsersKey;
import cn.scau.myteam.service.TaskUsersService;
@Service
public class TaskUsersServiceImpl implements TaskUsersService {

	@Autowired
	private TaskUsersMapper taskUsersMapper;
	@Override
	public boolean save(TaskUsersKey taskUsersKey) {
		// TODO Auto-generated method stub
		try {
			taskUsersMapper.insert(taskUsersKey);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean delete(TaskUsersKey taskUsersKey) {
		// TODO Auto-generated method stub
		try {
			taskUsersMapper.deleteByPrimaryKey(taskUsersKey);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public ArrayList<TaskUsersKey> findByTaskId(int id) {
		// TODO Auto-generated method stub
		TaskUsersExample t=new TaskUsersExample();
		Criteria c=t.createCriteria();
		c.andTidEqualTo(id);
		ArrayList<TaskUsersKey> list=(ArrayList<TaskUsersKey>)taskUsersMapper.selectByExample(t);
		return list;
	}

	@Override
	public ArrayList<TaskUsersKey> findAll() {
		// TODO Auto-generated method stub
		TaskUsersExample t=new TaskUsersExample();
		Criteria c=t.createCriteria();
		c.andTidIsNotNull();
		ArrayList<TaskUsersKey> list=(ArrayList<TaskUsersKey>)taskUsersMapper.selectByExample(t);
		return list;
	}

}
