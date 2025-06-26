package com.kh.practice2.controller;

import java.util.HashMap;
import java.util.Map;

import com.kh.practice2.model.Book;
import com.kh.practice2.model.Member;

public class BookController {
	// 선택사항
	private Map<String, Integer> bookCount = new HashMap<>();
	
	// 책 대여
	public String rentBook(Book book, Member member) {
		
		if(member.getBookList().size() > 2) return "더 이상 대여할 수 없습니다";
		
		if(!bookCount.isEmpty() && bookCount.get(book.getTitle()) != null 
				&& bookCount.get(book.getTitle()) > 2) return "3권 모두 대여중입니다";
		
		if(book.getAccessAge() > member.getAge()) {
			if(book.isCoupon() == false) return "나이 제한으로 대여 불가능 합니다";
		}
		
		for(Book b : member.getBookList()) {
			if(b.getTitle().equals(book.getTitle())) return "이미 대여한 책입니다";
		}
		
		member.getBookList().add(book);
		
		bookCount.put(book.getTitle(), bookCount.getOrDefault(book.getTitle(), 0)+1);
		
		return "성공적으로 대여되었습니다.";
	}
}
