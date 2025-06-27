package com.kh.practice2_1.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.kh.practice2_1.model.Book;
import com.kh.practice2_1.model.Member;

public class BookController {
	
	private Map<String, Integer> bookCount = new HashMap<>();
	
	public Object rentBook(Book book, Member member) {
		// 대여 한도 3권 초과
		ArrayList<Book> list = member.getBookList();
		if(list.size() > 2) return "더이상 대여할 수 없습니다";
		
		// 기존에 list 에 들어간 책일 경우
		if(list.contains(book)) return "이미 대여한 책입니다";
		
		// 나이제한에 걸릴경우
		if(member.getCoupon() == 0 && 
				book.getAccessAge() > member.getAge()) {
			 return "나이 제한으로 대여 불가능한 책입니다";
		}
		String title = book.getTitle();
		if(!bookCount.isEmpty() && bookCount.get(title) != null
				&& bookCount.get(title) > 2){
			return "대여 가능 권수가 초과한 책입니다";
		}
		
		
		// 대여 가능할 시
		
		if(book.isCoupon()) member.setCoupon(member.getCoupon()+1);
		
		if(book.getAccessAge() > member.getAge()) {
			member.setCoupon(member.getCoupon()-1);
		}
		
		list.add(book);
		
		bookCount.put(title, bookCount.getOrDefault(title, 0)+1);
		member.setBookList(list);
		return member;
	}
}
