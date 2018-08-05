package cn.scau.myteam.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.scau.myteam.mapper.TaskMapper;
import cn.scau.myteam.pojo.Task;
import cn.scau.myteam.pojo.TaskExample;
import cn.scau.myteam.pojo.TaskExample.Criteria;
import cn.scau.myteam.service.TaskService;
@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskMapper taskMapper;
	@Override
	public boolean save(Task task) {
		// TODO Auto-generated method stub
		try {
			taskMapper.insert(task);
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
			taskMapper.deleteByPrimaryKey(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean update(Task task) {
		// TODO Auto-generated method stub
		try {
			taskMapper.updateByPrimaryKey(task);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public Task findById(int id) {
		// TODO Auto-generated method stub
		return taskMapper.selectByPrimaryKey(id);
	}

	@Override
	public ArrayList<Task> findAll() {
		// TODO Auto-generated method stub
		TaskExample te=new TaskExample();
		Criteria c=te.createCriteria();
		c.andIdIsNotNull();
		ArrayList<Task> list=(ArrayList<Task>)taskMapper.selectByExample(te);
		return list;
	}

}