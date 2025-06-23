package com.kh.inheritance;

import com.kh.inheritance.model.Notebook;
import com.kh.inheritance.model.SmartPhone;

public class Application {
	public static void main(String[] arg) {
		Notebook notebook = new Notebook("애플", "app-01", "맥북 프로", 2390000, "M4");
		System.out.println(notebook);
		
		//SmartPhone phone = new SmartPhone("삼성", "sam-01", "갤럭시 S25 울트라", 181400, "KT");
		SmartPhone phone = new SmartPhone();
		phone.setBrand("삼성");
		phone.setpCode("sam-01");
		phone.setName("갤럭시 S25 울트라");
		phone.setPrice(1841400);
		phone.setAgency("KT");
		
		System.out.println(phone);
	}
}
