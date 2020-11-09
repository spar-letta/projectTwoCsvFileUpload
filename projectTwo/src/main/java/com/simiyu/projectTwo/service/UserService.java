package com.simiyu.projectTwo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.simiyu.projectTwo.model.User;


public interface UserService {

	public  void process(List<String> filePath);
	
	public List<User> findAll();
}
