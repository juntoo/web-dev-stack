package com.project.erp.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class UserInfo {
	private int userNo;
	private String id;
	private String password;
	private String name;
	private String phone;
	private String email;
	private String deptName;
	private String position;
}