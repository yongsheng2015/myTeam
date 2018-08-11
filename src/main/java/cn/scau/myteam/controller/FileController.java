package cn.scau.myteam.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.scau.myteam.util.FileDomain;
import cn.scau.myteam.util.FileUtil;
import cn.scau.myteam.util.MultiFileDomain;
import cn.scau.myteam.util.UTF8Util;
@Controller
public class FileController {
	//单文件上传
	@ResponseBody
	@RequestMapping(value="/onefile",produces="application/json;charset=utf-8")
	public String upload(@ModelAttribute FileDomain fileDomain,HttpServletRequest request) throws JSONException{
		boolean flag=false;
		String realpath=request.getServletContext().getRealPath("uploadfiles");
		String filename=fileDomain.getMyfile().getOriginalFilename();
		File targetFile=new File(realpath,filename);
		if(!targetFile.exists()){
			targetFile.mkdirs();
		}
		try {
			fileDomain.getMyfile().transferTo(targetFile);
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		JSONObject json=new JSONObject();
		json.accumulate("uploadFlag", flag);
		return json.toString();
	}
	//显示文件
	@ResponseBody
	@RequestMapping(value="/showFiles",produces="application/json;charset=utf-8")
	public String showFiles(HttpServletRequest request) throws JSONException{
		String realpath=request.getServletContext().getRealPath("uploadfiles");
		ArrayList<File> list=FileUtil.getFiles(realpath);
		ArrayList<String> list2=new ArrayList<String>();
		for(File f:list){
			list2.add(f.getName());
		}
		JSONObject json=new JSONObject();
		json.accumulate("fileList",list2);
		return json.toString();
	}
	//多文件上传
<<<<<<< HEAD
	@ResponseBody
	@RequestMapping(value="/multifile",produces="application/json;charset=utf-8")
	public String multiFileUpload(@ModelAttribute MultiFileDomain multiFileDomain,HttpServletRequest request) throws JSONException{
		boolean flag=true;
=======
	@RequestMapping("/multifile")
	public String multiFileUpload(@ModelAttribute MultiFileDomain multiFileDomain,HttpServletRequest request){ 
>>>>>>> 64c9d5beb8b2e63e052e8f91e35e52df9e5f433f
		String realpath=request.getServletContext().getRealPath("uploadfiles");
		File targetDir=new File(realpath);
//		if(!targetDir.exists()){
//			targetDir.mkdirs();
//		}
		List<MultipartFile> files=multiFileDomain.getMyfile();
		for(int i=0;i<files.size();i++){
			MultipartFile file=files.get(i);
			String fileName=file.getOriginalFilename();
			File tarfFile=new File(realpath,fileName);
			//上传
			try {
				file.transferTo(tarfFile);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				flag=false;
				break;
			}
		}
		JSONObject json=new JSONObject();
		json.accumulate("multiFlag",flag);
		return json.toString();
	}
	//文件下载
	@ResponseBody
	@RequestMapping(value="downFile",produces="application/json;charset=utf-8")
	public String downFile(String filename,HttpServletRequest request,HttpServletResponse response) throws JSONException{
		boolean flag=true;
		String aFilePath=null;
		FileInputStream in=null;
		ServletOutputStream out=null;
		try {
			aFilePath=request.getServletContext().getRealPath("uploadfiles");
			response.setHeader("Content-Type", "application/x-msdownload" );
			response.setHeader("Content-Disposition", "attachment; filename="
					+ UTF8Util.toUTF8String(filename));
			//读入文件
			in=new FileInputStream(aFilePath+"//"+filename);
			//得到响应后对象的输出流，用于向客户端输出二进制数据
			out=response.getOutputStream();
			out.flush();
			int aRead=0;
			byte b[]=new byte[1024];
			while(((aRead=in.read(b))!=-1)&&in!=null){
				out.write(b,0,aRead);
			}
			out.flush();
			in.close();
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flag=false;
		}
		JSONObject json=new JSONObject();
		json.accumulate(" downFlag", flag);
		return json.toString();
	}
	//创建文件夹
	@ResponseBody
	@RequestMapping(value="createFolder",produces="application/json;charset=utf-8")
	public String createFolder(String foldername,HttpServletRequest request) throws JSONException{
		String realpath=request.getServletContext().getRealPath("uploadfiles");
		boolean flag=FileUtil.CreatFolder(realpath+"/"+foldername);		
		JSONObject json=new JSONObject();
		json.accumulate(" createFlag", flag);
		return json.toString();
	}
	//删除文件
	@ResponseBody
	@RequestMapping(value="deleteFile",produces="application/json;charset=utf-8")
	public String deleteFile(String filename,HttpServletRequest request) throws JSONException{	
		String realpath=request.getServletContext().getRealPath("uploadfiles");
		boolean flag=FileUtil.DeleteFile(realpath+"/"+filename);
		JSONObject json=new JSONObject();
		json.accumulate("deleteFlag", flag);
		return json.toString();
	}
	//删除文件夹
	@ResponseBody
	@RequestMapping(value="deleteFolder",produces="application/json;charset=utf-8")
	 public String deleteFolder(String foldername,HttpServletRequest request) throws JSONException{
		String realpath=request.getServletContext().getRealPath("uploadfiles");
		System.out.println(realpath+"/"+foldername);
		boolean flag=FileUtil.DeleteFolder(realpath+"/"+foldername);
		JSONObject json=new JSONObject();
		json.accumulate("deleteFlag", flag);
		return json.toString();
	}
}
