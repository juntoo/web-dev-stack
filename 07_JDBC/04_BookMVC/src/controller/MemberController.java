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
			return member.getName()+"님. 회원 가입을 환영합니다!";
		} catch (Exception e) {
			return "중복된 아이디 입니다.";
		}
	}
	
	// 5. 로그인
	public Member login(String id, String pwd) {
		try {
			return dao.login(id, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 6. 회원탈퇴
	public void delete(String id) {
		// 회원탈퇴시 대여중인 책 모두 기록 삭제
		try {
			dao.deleteRent(id);
			dao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("탈퇴 중 문제가 발생했습니다. 관리자에게 문의해주세요");
		}
	}
}
