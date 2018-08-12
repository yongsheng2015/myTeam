package cn.scau.myteam.service;

import java.util.ArrayList;

import cn.scau.myteam.pojo.Share;

public interface ShareService {
	public boolean save(Share share);
	public boolean delete(int id);
	public boolean update(Share share);
	public Share findById(int id);
	public ArrayList<Share> findAll();
	public ArrayList<Share> findByShareId(int id);
	public ArrayList<Share> findByProjectId(int id);
	public ArrayList<Share> findByTaskId(int id);
}
