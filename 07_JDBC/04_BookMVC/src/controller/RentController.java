package controller;

import java.util.ArrayList;

import dao.RentDAO;
import vo.Rent;

public class RentController {
	
	RentDAO dao = RentDAO.getInstance();
	
	// 로그인도니 경우만 접근 가능 View에서 조건 걸어서 안보이게 하기
	
	// 7. 책 대여
//	public String rentBook(String id, int bookNo) {
//		
//		try {
//			// 한 사람 당 대여할 수 있는 책을 총 5권
//			if(printRentBook(id).size() > 4) {
//				return "한 사람 당 5권까지만 대여 가능합니다";
//			}
//			// 중복 책 대여 불가능
//			if(dao.distinctCheck(id, bookNo)) {
//				return "이미 대여한 책입니다";
//			}
//			// 각 책들마다 가능한 대여가 2권까지만
//			if(dao.bookRentList(bookNo).size() > 1) {
//				return "해당 책의 대여 권수가 초과하였습니다";
//			}
//			// 나이 제한 걸리는 책도 대여 불가능
//			if(dao.checkAge(id, bookNo)) {
//				return "연령제한으로 대여 불가능 합니다";
//			}
//			dao.rentBook(id, bookNo);
//			return "대여 완료";
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "대여에 실패했습니다";
//		}
//	}
	
	public String rentBook(String id, String title) {
		
		try {
			int bookNo = dao.bookNoSearch(title);
			// 한 사람 당 대여할 수 있는 책을 총 5권
			if(printRentBook(id).size() > 4) {
				return "한 사람 당 5권까지만 대여 가능합니다";
			}
			// 중복 책 대여 불가능
			if(dao.distinctCheck(id, bookNo)) {
				return "이미 대여한 책입니다";
			}
			// 각 책들마다 가능한 대여가 2권까지만
			if(dao.bookRentList(bookNo).size() > 1) {
				return "해당 책의 대여 권수가 초과하였습니다";
			}
			// 나이 제한 걸리는 책도 대여 불가능
			if(dao.checkAge(id, bookNo)) {
				return "연령제한으로 대여 불가능 합니다";
			}
			dao.rentBook(id, bookNo);
			return "대여 완료";
		} catch (Exception e) {
			e.printStackTrace();
			return "대여에 실패했습니다";
		}
	}
	
	// 8. 내가 대여한 책 조회
	public ArrayList<Rent> printRentBook(String id) {
		try {
			return dao.printRentBook(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 9. 대여 취소
	public String deleteRent(int rentNo) {
		try {
			dao.deleteRent(rentNo);
			return "반납 성공";
		} catch (Exception e) {
			e.printStackTrace();
			return "반납오류:관리자에게 문의하세요";
		}
		
	}
}
