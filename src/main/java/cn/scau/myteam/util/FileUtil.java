package cn.scau.myteam.util;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class FileUtil {

	//文件读取
	public static String ReadFile(String path) {
		try {
			String realpath=path;
			File file=new File(realpath);
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file),"GBK"));
			StringBuilder sb=new StringBuilder();
			String line=null;
			while((line=br.readLine())!=null){
				sb.append(line+"\r\n");
			}
//			System.out.println(sb);
			return sb.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
			
		
	}
	//文件写入
	public static boolean WriteFile(String path,String content){
		File file=new File(path);
		try {
			if(!file.exists())
			file.createNewFile();
			BufferedWriter bw=new BufferedWriter(new FileWriter(file));
			bw.write(content);
			bw.flush();
			bw.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;		
		}
		
	}
	//删除文件
	public static boolean DeleteFile(String path){
		File file =new File(path);
		if(file.exists()&&file.isFile()){
			file.delete();
			return true;
		}
		return false;
	}
	//创建文件夹
	public static boolean CreatFolder(String name){
		File file =new File(name);
		if(!file.exists()){
		file.mkdir();
		return true;
		}
		return false;
	}
	//删除文件夹及文件夹内的东西
	public static boolean DeleteFolder(String path){
		File file=new File(path);
		if(!file.exists())
		{
			System.out.println("文件不存在");
			return false;
		}
		if(!file.isDirectory())
		{
			System.out.println("非文件夹");
			return false;
		}
		File[] filelist=file.listFiles();
		for(File f:filelist){
			System.out.println(f.getPath());
			if(f.isFile()){
				FileUtil.DeleteFile(f.getPath());
			}
			if(f.isDirectory()){
				FileUtil.DeleteFolder(f.getPath());
				f.delete();
			}
		}
		file.delete();
		return true;
	}
	
	//获取文件夹下的所有文件
	public static ArrayList<File> getFiles(String path){
		File file=new File(path);
		File[] files=file.listFiles();
		ArrayList<File> list=new ArrayList<File>();
		for(File f:files){
		  list.add(f);
		}
		return list;
	}
	public static void main(String[] args){
		ArrayList<File> list=FileUtil.getFiles("D:/");
		for(File f:list){
			System.out.println(f.getPath());
		}
	}
	
}
