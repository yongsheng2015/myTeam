package cn.scau.myteam.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.scau.myteam.mapper.MultiTableMapper;
import cn.scau.myteam.mapper.TaskUsersMapper;
import cn.scau.myteam.pojo.Task;
import cn.scau.myteam.pojo.TaskUsersExample;
import cn.scau.myteam.pojo.TaskUsersExample.Criteria;
import cn.scau.myteam.pojo.TaskUsersKey;
import cn.scau.myteam.pojo.User;
import cn.scau.myteam.service.TaskUsersService;
@Service
public class TaskUsersServiceImpl implements TaskUsersService {

	@Autowired
	private TaskUsersMapper taskUsersMapper;
	@Autowired
	private MultiTableMapper multiTableMapper;
	
	@Override
	public boolean save(TaskUsersKey taskUsersKey) {
		// TODO Auto-generated method stub
		try {
			taskUsersMapper.insertSelective(taskUsersKey);
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

	//根据任务的id查找改任务的成员
	@Override
	public ArrayList<User> findByTaskId(int id) {
		// TODO Auto-generated method stub
		return multiTableMapper.findByTaskId2(id);
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

	//根据用户的id查询其参与的所有任务（TaskUsersServiceImpl）
	@Override
	public ArrayList<Task> findByUserId(int id) {
		// TODO Auto-generated method stub
		return multiTableMapper.findByUserId2(id);
	}

}
