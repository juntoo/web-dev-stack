package com.kh.practice2.controller;

import java.util.ArrayList;

import com.kh.practice2.model.Book;
import com.kh.practice2.model.Member;

public class MemberController {
	ArrayList<Member> members = new ArrayList<Member>();
	
	private Member loginMember = null;
	
    
    public boolean login(String name, int age) {
    	if(members.isEmpty()) {
    		members.add(new Member(name, age, 1, new ArrayList<Book>()));
    		loginMember = members.get(0);
    		return true;
    	}
    	for(Member m : members) {
    		if(m.getName().equals(name) && !(m.getAge() == age)) return false;
    	}
    	for(Member m : members) {
    		if(m.getName().equals(name) && m.getAge() == age) {
    			loginMember = m;
    			return true;
    		}
    		else if(!m.getName().equals(name)) {
    			members.add(new Member(name, age, 1, new ArrayList<Book>()));
    			loginMember = members.getLast();
    			return true;
    		}
    	}
    	return false;
    }
    
    public void logout() {
    	loginMember = null;
    }
    
    public Member getMember() {
    	return loginMember;
    }
}
