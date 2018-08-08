package cn.scau.myteam.util;

import java.security.MessageDigest;

public class MD5Util {
	//对用户输入的密码进行加密
	public static String md5(String password){
		StringBuffer str=new StringBuffer();
		char[] chars={ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
			    'B', 'C', 'D', 'E', 'F' };
		byte[] b=password.getBytes();
		MessageDigest mDigest=null;
		try{
			mDigest=MessageDigest.getInstance("md5");
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		byte[] md5=mDigest.digest(b);
		for(byte m:md5){
			  str.append(chars[(m >> 4) & 0x0f]);
			   str.append(chars[m & 0x0f]);
		}
		return str.toString();
	}
}
