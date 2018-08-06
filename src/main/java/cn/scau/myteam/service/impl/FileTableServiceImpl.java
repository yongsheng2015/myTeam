package cn.scau.myteam.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.scau.myteam.mapper.FileTableMapper;
import cn.scau.myteam.pojo.FileTable;
import cn.scau.myteam.pojo.FileTableExample;
import cn.scau.myteam.pojo.FileTableExample.Criteria;
import cn.scau.myteam.service.FileTableService;
@Service
public class FileTableServiceImpl implements FileTableService {

	@Autowired
	private FileTableMapper fileTableMapper;
	@Override
	public boolean save(FileTable fileTable) {
		// TODO Auto-generated method stub
		try {
			fileTableMapper.insert(fileTable);
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
			fileTableMapper.deleteByPrimaryKey(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean update(FileTable fileTable) {
		// TODO Auto-generated method stub
		try {
			fileTableMapper.updateByPrimaryKey(fileTable);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public FileTable findById(int id) {
		// TODO Auto-generated method stub
		return fileTableMapper.selectByPrimaryKey(id);
	}

	@Override
	public ArrayList<FileTable> findAll() {
		// TODO Auto-generated method stub
		FileTableExample f=new FileTableExample();
		Criteria c=f.createCriteria();
		c.andIdIsNotNull();
		ArrayList<FileTable> list=(ArrayList<FileTable>)fileTableMapper.selectByExample(f);
		return list;
	}


}
