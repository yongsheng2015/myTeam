package cn.scau.myteam.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.scau.myteam.service.ShareService;

@Controller
public class ShareController {

	@Autowired
	private ShareService shareService;
	
	
	@ResponseBody
	@RequestMapping(value="/addShare",produces="application/json;charset=utf-8")
	public String addShare(String userid,String ptid,String tid){
		return null;
	}
}
