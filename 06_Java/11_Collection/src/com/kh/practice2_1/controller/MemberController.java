package com.kh.practice2_1.controller;

import java.util.ArrayList;
import java.util.List;

import com.kh.practice2_1.model.Member;


public class MemberController {
	private List<Member> members = new ArrayList<Member>();
	
	private Member member = null;
	
	public boolean registerAndLogin(String name, int age) {
//		memebers.add(new Member(name, age));
		// 이름과 나이가 같은 경우
		for(Member m : members) {
			if(m.getName().equals(name) && m.getAge() == age) {
				// 로그인 처리
				this.member = new Member();
				this.member.setName(name);
				this.member.setAge(age);
				member = m;
				return true;
			}
		}
		
		// 동일한 이름이 있을 시 거부
		for(Member member : members) {
			if(member.getName().equals(name)) {
				return false;
			}
		}
		
		// 없을 시 생성
		Member m = new Member();
		m.setName(name);;
		m.setAge(age);
		members.add(m);
		this.member = m;
		return true;
	}
	
	public void logout() {
		member = null;
	}
	
	public Member getMember() {
		return this.member;
	}
	
	public void setMember(Member member) {
    	for(int i = 0; i < members.size(); i++) {
    		Member m = members.get(i);
    		if(m.getName().equals(member.getName())) {
    			members.set(i, member);
    		}
    	}
    }
}
