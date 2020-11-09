package com.simiyu.projectTwo.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.simiyu.projectTwo.model.User;



public class CommonUtils {

	public static String getFileExtension(String name) {
		if(name.lastIndexOf(".") != -1 && name.lastIndexOf(".") != 0) {
			return name.substring(name.lastIndexOf(".") + 1);
		}else {
			return "";
		}
	}
	public static List<User> readCsv(String filePath){
		List<User> list = new ArrayList<User>();
		BufferedReader buffer = null;
		String line = "";
		String splitBy = "," ;
		try {
		buffer = new BufferedReader(new FileReader(filePath));
		while((line=buffer.readLine())!=null) {
			String[] data = line.split(splitBy);
			User user = new User();
			user.setFirst_name(data[0]);
			user.setLast_name(data[1]);
			user.setDob(Date.valueOf(data[2]));
			user.setPostal_address(data[3]);
			user.setNational_id(Integer.valueOf(data[4]));
			user.setGender(data[5]);
			
			list.add(user);
			
		}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(buffer !=null) {
				try {
					buffer.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
}
