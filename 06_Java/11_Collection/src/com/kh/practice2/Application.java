package com.kh.practice2;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.practice2.controller.MemberController;
import com.kh.practice2.model.Book;

public class Application {
	
	public static void main(String[] args) {
		// 대여 가능한 책 목록
		Scanner sc = new Scanner(System.in);
		MemberController mc = new MemberController();
	    
		ArrayList<Book> books = new ArrayList<>();
	    {
	        books.add(new Book("디스 이즈 이탈리아", false, 0));
	        books.add(new Book("리얼 런던", true, 0));
	        books.add(new Book("집에서 즐기는 스페인 요리 여행", false, 0));
	        books.add(new Book("사퀴트리 샌드위치", false, 0));
	        books.add(new Book("원피스 111", true, 15));
	        books.add(new Book("귀멸의 칼날 23", false, 19));
	        books.add(new Book("진격의 거인 Before the fall 16", false, 19));
	    }
		
	    /*
	     * 이름 :
	     * 나이 :
	     * -> 회원가입/로그인 조건 : 이름과 나이가 일치한 경우
	     * -> 기존에 회원 중 이름이 있으면 "이미 존재하는 이름입니다. 다시 입력해 주세요"
	     * 
	     * ===== 메뉴 =====
	     * 1. 마이페이지 -> 본인 정보
	     * 2. 도서 대여하기
	     * 		-> 1. 한 사람 당 대여할 수 있는 책은 총 3권
	     * 				"더 이상 대여할 수 없습니다"
	     * 		-> 2. 해당 사람이 대여한 책은 대여 불가능
	     * 				"이미 대여한 책입니다"
	     * 		-> 3. 나이 제한에 걸리는 책들 대여 불가능
	     * 				"나이 제한으로 대여 불가능 합니다"
	     * 		-> 4. 쿠폰이 있는 경우 나이 제한 걸려도 대여 가능
	     * 		-> (선택사항) 5. 각 책들마다 가능한 대여가 3권까지만
	     * 						HashMap -> getOrDefault(키, 초기값)
	     * 		-> 대여 가능한 경우 : "성공적으로 대여되었습니다"
	     * 3. 로그아웃
	     * 4. 프로그램 종료
	     * */
		while(true) {
			System.out.print("이름 : ");
			String name = sc.nextLine();
			
			System.out.print("나이 : ");
			int age = Integer.parseInt(sc.nextLine());
			System.out.println(mc.login(name, age));
//				boolean run = true;
//				while(run) {
//					System.out.println("===== 메뉴 =====");
//					System.out.println("1. 마이페이지");
//					System.out.println("2. 도서 대여하기");
//					System.out.println("3. 로그아웃");
//					System.out.println("4. 프로그램 종료");
//					System.out.print("메뉴 선택 : ");
//					int select = Integer.parseInt(sc.nextLine());
//					
//					switch(select) {
//						case 3 :
//							System.out.println("로그아웃 완료");
//							run = false;
//							break; 
//					}
//				}
			}
			
			
		
	}
	
	public void login() {
		
	}
}
