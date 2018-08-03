package cn.scau.myteam.service;

import java.util.ArrayList;

import cn.scau.myteam.pojo.FileTable;

public interface FileTableService {
	public boolean save(FileTable fileTable);
	public boolean delete(int id);
	public boolean update(FileTable fileTable);
	public FileTable findById(int id);
	public ArrayList<FileTable> findAll();
	
}
