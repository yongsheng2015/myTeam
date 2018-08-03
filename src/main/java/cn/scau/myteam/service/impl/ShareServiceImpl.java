package cn.scau.myteam.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.scau.myteam.mapper.ShareMapper;
import cn.scau.myteam.pojo.Share;
import cn.scau.myteam.pojo.ShareExample;
import cn.scau.myteam.pojo.ShareExample.Criteria;
import cn.scau.myteam.service.ShareService;
@Service
public class ShareServiceImpl implements ShareService {

	@Autowired
	private ShareMapper shareMapper;
	@Override
	public boolean save(Share share) {
		// TODO Auto-generated method stub
		try {
			shareMapper.insert(share);
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
			shareMapper.deleteByPrimaryKey(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean update(Share share) {
		// TODO Auto-generated method stub
		try {
			shareMapper.updateByPrimaryKey(share);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public Share findById(int id) {
		// TODO Auto-generated method stub
		return shareMapper.selectByPrimaryKey(id);
	}

	@Override
	public ArrayList<Share> findAll() {
		// TODO Auto-generated method stub
		ShareExample shareExample=new ShareExample();
		Criteria c=shareExample.createCriteria();
		c.andIdIsNotNull();
		ArrayList<Share> list=(ArrayList<Share>)shareMapper.selectByExample(shareExample);
		return list;
		
	}

}
