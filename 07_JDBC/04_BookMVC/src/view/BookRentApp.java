package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.BookController;
import controller.MemberController;
import controller.RentController;
import vo.Book;
import vo.Member;
import vo.Rent;

public class BookRentApp {
	
	private Scanner sc = new Scanner(System.in);
	
	private Member member = null;
	
	private BookController bc = new BookController();
	private MemberController mc = new MemberController();
	private RentController rc = new RentController();
	
	public static void main(String[] args) {
		BookRentApp app = new BookRentApp();
		
		app.menu();
		
		
	}
	
	public void menu() {
		while(true) {
			if (member == null) {
				loginMenu();
			} else if (member.getId().equals("admin") && member.getPwd().equals("1234")) {
				adminMenu();
			}else {
				mainMenu();
			}
		}
	}
	
	public void loginMenu() {
		try {
			while(true) {
				System.out.println("1. 회원가입");
				System.out.println("2. 로그인");
				System.out.println("3. 전체 책 조회");
				
				System.out.print("메뉴 선택 > ");
				int select = Integer.parseInt(sc.nextLine());
				
				switch(select) {
					case 1: 
						register();
						break;
					case 2:
						login();
						break;
					case 3:
						printBookAll();
						break;
				}
				
				if(this.member != null) return;
			}
		} catch (NumberFormatException e) {
			System.out.println("숫자를 입력해주세요");
		}
		
	}
	
	public void mainMenu() {
		while(true) {
			System.out.println("1. 책 대여");
			System.out.println("2. 대여한 책 조회");
			System.out.println("3. 대여 취소");
			System.out.println("4. 회원탈퇴");
			System.out.println("5. 로그아웃");
			
			System.out.print("메뉴 선택 > ");
			int select = Integer.parseInt(sc.nextLine());
			
			switch(select) {
				case 1: 
					rentBook();
					break;
				case 2:
					printRentBook();
					break;
				case 3: 
					deleteRent();
					break;
				case 4:
					registerDelete();
					this.member = null;
					return;
				case 5:
					this.member = null;
					return;
			}
		}
	}
	
	public void adminMenu() {
		while(true) {
			System.out.println("1. 책 등록");
			System.out.println("2. 책 삭제");
			System.out.println("3. 로그아웃");
			
			System.out.print("메뉴 선택 > ");
			int select = Integer.parseInt(sc.nextLine());
			
			switch(select) {
				case 1: 
					registerBook();
					break;
				case 2:
					sellBook();
					break;
				case 3:
					this.member = null;
					return;
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
		
		this.member = mc.login(id, pwd);
		
		if(member==null) {
			System.out.println("아이디나 비밀번호를 확인해주세요");
		}else {
			System.out.println("환영합니다. " + member.getName() + "님");
		}
	}
	
	public void registerBook() {
		try {
			System.out.print("등록할 책 제목 : ");
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
	
//	public void sellBook() {
//		printBookAll();
//		System.out.print("삭제할 책의 번호 : ");
//		int bookNo = Integer.parseInt(sc.nextLine());
//		
//		System.out.println(bc.sellBook(bookNo));
//	}
	public void sellBook() {
		printBookAll();
		System.out.print("삭제할 책 제목 : ");
		String title = sc.nextLine();
		
		System.out.println(bc.sellBook(title));
	}

	public void registerDelete() {
		System.out.print("정말 탈퇴하시겠습니까? y / n > ");
		char select  = sc.nextLine().charAt(0);
		
		if(select == 'y') {
			mc.delete(member.getId());
			System.out.println("그동안 감사했습니다. 안녕히 가세요");
		}
	}
	
//	public void rentBook() {
//		printBookAll();
//		System.out.print("대여할 책의 번호 : ");
//		int bookNo = Integer.parseInt(sc.nextLine());
//		
//		System.out.println(rc.rentBook(this.member.getId(), bookNo));
//	}
	public void rentBook() {
		printBookAll();
		System.out.print("대여할 책의 제목 : ");
		String title = sc.nextLine();
		
		System.out.println(rc.rentBook(this.member.getId(), title));
	}
	
	public void printRentBook() {
		ArrayList<Rent> list = rc.printRentBook(this.member.getId());
		if(list!=null) {
			if(list.size() > 0) {
				for(Rent r : list) {
					System.out.println("대여번호 : "+r.getRentNo() + ", 책 : " + r.getBook()+", 대여일 : "+r.getRentDate());
				}
			}else System.out.println("대여 내역이 없습니다");
		}
	}
	
	public void deleteRent() {
		printRentBook();
		System.out.print("반납할 책의 대여번호를 입력하세요 : ");
		int rentNo = Integer.parseInt(sc.nextLine());
		
		System.out.println(rc.deleteRent(rentNo));
	}
}
