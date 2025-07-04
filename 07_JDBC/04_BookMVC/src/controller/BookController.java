package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.BookDAO;
import vo.Book;

public class BookController {
	
	BookDAO dao = BookDAO.getInstance();
	// 1. 전체 책 조회
	public ArrayList<Book> printBookAll(){
		
		try {
			return dao.printBookAll();
		} catch (SQLException e) {
			return null;
		}
	}
	
	// 2. 책 등록
	public boolean registerBook(String title, String author, int accessAge) {
		// 기존 제목, 저자, 제한, 나이까지 동일한 책이 있으면 안되게
		
		try {
			if(dao.checkBook(title, author, accessAge)) {
				return false;
			}
			dao.registerBook(title, author, accessAge);
			return true;
		} catch (SQLException e) {
			System.out.println("관리자에게 문의하세요");
			return false;
		}
	}
	
	// 3. 책 삭제
	public String sellBook(String title) {
		// 빌리고 있는 책을 삭제 못하게
		try {
			int bookNo = dao.serchBook(title);
			boolean check = dao.checkRent(bookNo);
			if(!check) {
				if(dao.sellBook(bookNo)==1)	return "삭제완료";
				else return "해당하는 책이 없습니다";
			} return "해당 책은 대여 중이라 삭제가 불가능합니다";
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
