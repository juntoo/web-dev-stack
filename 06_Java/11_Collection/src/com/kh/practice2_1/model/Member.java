package com.kh.practice2_1.model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class Member {
	private String name;
	private int age;
	private int coupon;
	private ArrayList<Book> bookList = new ArrayList<Book>();
	
	// 생성자
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
}
