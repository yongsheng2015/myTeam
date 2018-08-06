package cn.scau.myteam.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.scau.myteam.mapper.MultiTableMapper;
import cn.scau.myteam.mapper.SubTaskMapper;
import cn.scau.myteam.mapper.TaskMapper;
import cn.scau.myteam.pojo.SubTaskExample;
import cn.scau.myteam.pojo.SubTaskExample.Criteria;
import cn.scau.myteam.pojo.SubTaskKey;
import cn.scau.myteam.pojo.Task;
import cn.scau.myteam.service.SubTaskService;
@Service
public class SubTaskServiceImpl implements SubTaskService {

	@Autowired
	private SubTaskMapper  subTaskMapper;
	@Autowired
	private MultiTableMapper multiTableMapper;
	@Override
	public boolean save(SubTaskKey subTask) {
		// TODO Auto-generated method stub
		try {
			subTaskMapper.insertSelective(subTask);
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

	//根据一个子任务的id查找其父任务
	@Override
	public ArrayList<Task> findBySubTaskId(int id) {
		// TODO Auto-generated method stub
		return multiTableMapper.findBySubTaskId(id);
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

	//查找一个任务下的子任务，返回子任务列表
	@Override
	public ArrayList<Task> findByTaskId(int id) {
		// TODO Auto-generated method stub
		return multiTableMapper.findByTaskId(id);
	}

}
