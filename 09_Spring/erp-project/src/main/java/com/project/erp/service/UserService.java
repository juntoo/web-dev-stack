package com.project.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.erp.mapper.UserMapper;
import com.project.erp.model.vo.UserInfo;

@Service
public class UserService {
	
	@Autowired
	private UserMapper mapper;
	
	public void addUser(UserInfo user) {
		mapper.addUser(user);
	}
	
	public List<UserInfo> viewUser(){
		return mapper.viewUser();
	}
}
