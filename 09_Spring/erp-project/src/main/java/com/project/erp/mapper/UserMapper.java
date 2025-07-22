package com.project.erp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.erp.model.vo.UserInfo;

@Mapper
public interface UserMapper {
	
	void addUser(UserInfo user);
	
	List<UserInfo> viewUser();
}
