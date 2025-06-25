package com.kh.practice.controller;

import java.time.LocalDate;

import com.kh.practice.model.Department;
import com.kh.practice.model.UserInfo;

public class Controller {
	private UserInfo userInfo = new UserInfo();
	Department dept = new Department();
	
//	private int count = 0;
	
//	public UserInfo login(String id, String password) {
//		for(UserInfo user : userInfo) {
//			if(id.equals(user.getId()) && password.equals(user.getPassword())) {
//				return user;
//			}
//		}
//		return null;
//	}
	
	public void addEmp(int userNo, String id, String password, String email, String name) {
		userInfo.setUserNo(userNo);
		userInfo.setId(id);
		userInfo.setPassword(password);
		userInfo.setEmail(email);
		userInfo.setName(name);
	}
	
	public void addEmp(String phone, String addr, String gender, LocalDate birthDate, Department dept) {
		userInfo.setPhone(phone);
		userInfo.setAddr(addr);
		userInfo.setGender(gender);
		userInfo.setBirthDate(birthDate);
		userInfo.setDepartment(dept);
	}
	
	public int login(String id, String password) {
		if(userInfo.getId().equals(id) && userInfo.getPassword().equals(password)) return 1;
		return 0;
	}
	
	public void updateEmp(UserInfo user) {
		userInfo = user;
	}
	
	public UserInfo user() {
		return userInfo;
	}
	
//	public void changePhone(String phone) {
//		userInfo.setPhone(phone);
//	}
//	
//	public void changeBirthDate(LocalDate birthDate) {
//		userInfo.setBirthDate(birthDate);
//	}
//	
//	public void changeDepartment(String deptName) {
//		dept.setDeptName(deptName);
//		userInfo.setDepartment(dept);
//	}
	
	public void empData() {
		System.out.println("직원 번호 : " + userInfo.getUserNo());
		System.out.println("직원 아이디 : " + userInfo.getId());
		System.out.println("직원 비밀번호 : " + userInfo.getPassword());
		System.out.println("직원 이메일 : " + userInfo.getEmail());
		System.out.println("직원 이름 : " + userInfo.getName());
		System.out.println("직원 전화번호 : " + userInfo.getPhone());
		System.out.println("직원 주소 : " + userInfo.getAddr());
		System.out.println("직원 성별 : " + userInfo.getGender());
		System.out.println("직원 생년월일 : " + userInfo.getBirthDate());
		System.out.println("직원 부서 : " + userInfo.getDepartment());
	}
}
