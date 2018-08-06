package cn.scau.myteam.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.scau.myteam.mapper.MessageMapper;
import cn.scau.myteam.pojo.Message;
import cn.scau.myteam.pojo.MessageExample;
import cn.scau.myteam.pojo.MessageExample.Criteria;
import cn.scau.myteam.service.MessageService;
@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageMapper messageMapper;
	@Override
	public boolean save(Message message) {
		// TODO Auto-generated method stub
		try {
			messageMapper.insertSelective(message);
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
			messageMapper.deleteByPrimaryKey(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean update(Message user) {
		// TODO Auto-generated method stub
		try {
			messageMapper.updateByPrimaryKeySelective(user);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public Message findById(int id) {
		// TODO Auto-generated method stub
		return messageMapper.selectByPrimaryKey(id);
	}

	@Override
	public ArrayList<Message> findAll() {
		// TODO Auto-generated method stub
		MessageExample m=new MessageExample();
		Criteria c=m.createCriteria();
		c.andIdIsNotNull();
		ArrayList<Message> list=(ArrayList<Message>)messageMapper.selectByExample(m);
		return list;
	}

}
