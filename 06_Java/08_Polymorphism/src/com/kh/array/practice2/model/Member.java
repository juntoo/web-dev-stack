package com.kh.array.practice2.model;

public class Member {
	private String id;
	private String name;
	private String pwd;
	private String email;
	private char gender;
	private int age;
	
	public Member() {
	}
	
	@Override
	public boolean equals(Object obj) {
		Member m = (Member) obj;
		return m.id == this.id;
	}
	
	public Member(String id, String name, String pwd, String email, char gender, int age) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.email = email;
		this.gender = gender;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "아이디 : " + id + ", 이름 : " + name + ", 비밀번호 : " + pwd 
				+ ", 이메일 : " + email + ", 성별 : " + gender + ", 나이 : " + age;
	}
}
