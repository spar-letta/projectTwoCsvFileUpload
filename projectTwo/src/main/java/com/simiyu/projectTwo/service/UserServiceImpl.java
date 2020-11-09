package com.simiyu.projectTwo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simiyu.projectTwo.dao.UserDao;
import com.simiyu.projectTwo.model.User;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	@Override
	public void process(List<String> filePath) {
		userDao.process(filePath);
		
	}
	@Override
	public List<User> findAll() {
		
		return userDao.findAll();
	}


	

}
