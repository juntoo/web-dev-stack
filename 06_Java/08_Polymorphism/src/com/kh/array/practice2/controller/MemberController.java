package com.kh.array.practice2.controller;

import com.kh.array.practice2.model.Member;

public class MemberController {
	Member[] members = {new Member(), new Member(), new Member()};
	
	public boolean checkFull() {
		for(Member member : members) {
			if(member.getId() == null) return false;
			}
		return true;
	}
	
	public String addMember(String id, String name, String pwd, String email, char gender, int age) {
		for(int i = 0; i < members.length; i++) {
			if(members[i].getId() == null) {
				members[i] = new Member(id, name, pwd, email, gender, age);
				break;
			}
		}
		return "회원가입을 축하합니다";
	}
	
	public boolean idCheck(String id) {
		for(Member member : members) {
			if(member.getId() != null) {
				if(member.getId().equals(id)) { 
					return true;
				}
			}
		}
		return false;
	}
	
	public String editMember(String id, String name, String pwd, String email) {
		for(int i = 0; i < members.length; i++) {
			if(members[i].getId() != null) {
				if(members[i].getId().equals(id)) {
					members[i].setId(id);
					members[i].setName(name);
					members[i].setEmail(email);
					members[i].setPwd(pwd);
					break;
				}
			}
		}
		return "수정이 완료되었습니다";
	}
	
	public String printInfo(int a) {
//		for(int i = 0 ; i < members.length; i++) {
//			System.out.println(members[i].toString());
//		}
		if(members[a].getId() == null) return null;
		
		return members[a].toString();
	}
}
