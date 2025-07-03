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
			boolean check = dao.checkBook(title, author, accessAge);
			if(!check) {
				dao.registerBook(title, author, accessAge);
				return true;
			}
		} catch (SQLException e) {
			System.out.println("관리자에게 문의하세요");
			return false;
		}
		
		return false;
	}
	
	// 3. 책 삭제
	public boolean sellBook(int bookNo) {
		// 빌리고 있는 책을 삭제 못하게
		try {
			boolean check = dao.checkRent(bookNo);
			if(!check) {
				dao.sellBook(bookNo);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
}
