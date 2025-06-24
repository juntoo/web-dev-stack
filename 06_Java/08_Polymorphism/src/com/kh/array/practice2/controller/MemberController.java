package com.kh.array.practice2.controller;

import com.kh.array.practice2.model.Member;

public class MemberController {
	private Member[] members = {new Member(), new Member(), new Member()};
	
	/** 회원수 찾는지 여부 */
	public boolean checkFull() {
		for(Member member : members) {
			if(member.getId() == null) return false;
			}
		return true;
	}
	
	/**앞에서부터 회원수 추가*/
	public String addMember(String id, String name, String pwd, String email, char gender, int age) {
		for(int i = 0; i < members.length; i++) {
			if(members[i].getId() == null) {
				members[i] = new Member(id, name, pwd, email, gender, age);
				break;
			}
		}
		return "회원가입을 축하합니다";
	}
	
	/**중복아이디 여부 true = 있음, false = 없음*/
	public boolean idCheck(String id) {
		for(Member member : members) {
			if(member.getId() != null && member.getId().equals(id)) return true;		
		}
		return false;
	}
	
	/**아이디 입력받아 회원 정보 수정*/
	public String editMember(String id, String name, String pwd, String email) {
		for(Member member : members) {
			if(members != null && member.getId().equals(id)) {
				member.setName(name);
				member.setEmail(email);
				member.setPwd(pwd);
				break;
			}
		}
		return "수정이 완료되었습니다";
	}
	
	/**회원정보출력*/
	public String printInfo(int a) {
		if(a < members.length && members[a].getId() != null) return members[a].toString();
		else return null;
	}
	
	/**현재 회원 수 반환*/
	public int memberCount() {
		int count = 0;
		for(Member member : members) {
			if(member.getId() != null) count++;
		}
		return count;
	}
}
