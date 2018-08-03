package cn.scau.myteam.service;

import java.util.ArrayList;

import cn.scau.myteam.pojo.Message;

public interface MessageService {
	public boolean save(Message message);
	public boolean delete(int id);
	public boolean update(Message user);
	public Message findById(int id);
	public ArrayList<Message> findAll();
}
