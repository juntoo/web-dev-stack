package controller;

import dao.MemberDAO;
import vo.Member;

public class MemberController {
	
	MemberDAO dao = MemberDAO.getInstance();
	
	// 4. 회원가입
	public String register(Member member) {
		// id가 primary key 에러가 남. 그거 활용
		try {
			dao.register(member);
			return "회원 가입 성공";
		} catch (Exception e) {
			return "아이디가 중복됩니다.";
		}
	}
	
	// 5. 로그인
	public Member login(String id, String pwd) {
		Member member = null;
		try {
			member = dao.login(id, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}
	
	// 6. 회원탈퇴
	public void delete(String id) {
		// 회원탈퇴시 대여중인 책 모두 기록 삭제
		
	}
}
