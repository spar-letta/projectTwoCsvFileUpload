package com.simiyu.projectTwo.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.simiyu.projectTwo.model.User;
@Component
public interface UserDao {

	public void process(List<String> filesPath);
	
	public List<User> findAll();
}
