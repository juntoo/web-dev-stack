package com.kh.practice1;

import com.kh.practice1.model.UserInfo;

public class Application {
	
	public static void main(String[] args) {
		UserInfo userInfo = new UserInfo();
		
		userInfo.changeName("이승민");
		
		System.out.println(userInfo.printName());
	}
}
