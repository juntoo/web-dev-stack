package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.BookController;
import controller.MemberController;
import controller.RentController;
import vo.Book;
import vo.Member;

public class BookRentApp {
	
	private Scanner sc = new Scanner(System.in);
	
	private Member member = new Member();
	
	private BookController bc = new BookController();
	private MemberController mc = new MemberController();
	private RentController rc = new RentController();
	
	public static void main(String[] args) {
		BookRentApp app = new BookRentApp();
		
		app.menu();
	}
	
	public void menu() {
		while(true) {
			System.out.println("1. 전체 책 조회");
			System.out.println("2. 책 등록");
			System.out.println("3. 책 삭제");
			System.out.println("4. 회원가입");
			System.out.println("5. 로그인");
			System.out.println("1. 전체 책 조회");
			
			System.out.print("메뉴 선택 > ");
			int select = Integer.parseInt(sc.nextLine());
			
			switch(select) {
				case 1: 
					printBookAll();
					break;
				case 2:
					registerBook();
					break;
				case 4: 
					register();
					break;
				case 5:
					login();
					break;
			}
		}
	}
	
	public void printBookAll() {
		ArrayList<Book> list = bc.printBookAll();
		if(list!=null) {
			if(list.size() > 0) {
				for(Book b : list) {
					System.out.println(b);
				}
			}else System.out.println("도서 목록이 없습니다");
		}
	}
	
	public void registerBook() {
		try {
			System.out.print("등록한 책 제목 : ");
			String title = sc.nextLine();
			
			System.out.print("저자 : ");
			String author = sc.nextLine();
			
			System.out.print("연령제한 : ");
			int accessAge = Integer.parseInt(sc.nextLine());
			
			boolean check = bc.registerBook(title, author, accessAge);
			if(check) System.out.println("성공적으로 등록되었습니다");
			else System.out.println("등록에 실패했습니다");
		} catch (NumberFormatException e) {
			System.out.println("연령제한에는 숫자만 입력해주세요");
		}
		
	}
	
	public void register() {
		Member member = new Member();
		System.out.print("아이디 : ");
		member.setId(sc.nextLine());
		
		System.out.print("패스워드 : ");
		member.setPwd(sc.nextLine());
		
		System.out.print("이름 : ");
		member.setName(sc.nextLine());
		
		System.out.print("나이 : ");
		member.setAge(Integer.parseInt(sc.nextLine()));
		
		System.out.println(mc.register(member));
	}
	
	public void login() {
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		
		System.out.print("패스워드 : ");
		String pwd = sc.nextLine();
		
		Member member = mc.login(id, pwd);
		
		if(member==null) {
			System.out.println("아이디나 비밀번호를 확인해주세요");
		}else {
			System.out.println("환영합니다. " + member.getName() + "님");
		}
	}
}
