package cn.scau.myteam.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import cn.scau.myteam.util.FileDomain;
import cn.scau.myteam.util.MultiFileDomain;
@Controller
public class FileController {
	//单文件上传
	@RequestMapping("/onefile")
	public String upload(@ModelAttribute FileDomain fileDomain,HttpServletRequest request){
		String realpath=request.getServletContext().getRealPath("uploadfiles");
		String filename=fileDomain.getMyfile().getOriginalFilename();
		File targetFile=new File(realpath,filename);
		if(!targetFile.exists()){
			targetFile.mkdirs();
		}
		try {
			fileDomain.getMyfile().transferTo(targetFile);
			System.out.println("success");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return "showOne";
	}
	//多文件上传
	@RequestMapping("/multifile")
	public String multiFileUpload(@ModelAttribute MultiFileDomain multiFileDomain,HttpServletRequest request){
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
			}
		}
		return "showMulti";
	}
	
	
}
