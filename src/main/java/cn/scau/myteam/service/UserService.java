package cn.scau.myteam.service;

import java.util.ArrayList;

import cn.scau.myteam.pojo.User;

public interface UserService {
	public boolean save(User user);
	public boolean delete(int id);
	public boolean update(User user);
	public User findById(int id);
	public ArrayList<User> findAll();
}
