package cn.scau.myteam.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.scau.myteam.mapper.UserMapper;
import cn.scau.myteam.pojo.User;
import cn.scau.myteam.pojo.UserExample;
import cn.scau.myteam.pojo.UserExample.Criteria;
import cn.scau.myteam.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Override
	public boolean save(User user) {
		// TODO Auto-generated method stub
		try {
			userMapper.insertSelective(user);
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
			userMapper.deleteByPrimaryKey(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		try {
			userMapper.updateByPrimaryKeySelective(user);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public ArrayList<User> findAll() {
		// TODO Auto-generated method stub
		UserExample userExample=new UserExample();
		Criteria criteria=userExample.createCriteria();
		criteria.andIdIsNotNull();
		ArrayList<User> list=(ArrayList<User>)userMapper.selectByExample(userExample);
		return list;
	}

}
