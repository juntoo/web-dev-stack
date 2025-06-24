package com.kh.array.practice2.view;

import java.util.Scanner;

import com.kh.array.practice2.controller.MemberController;

public class MemberView {
	public void main() {
		Scanner sc = new Scanner(System.in);
		MemberController controller = new MemberController();
		boolean isTrue = true;
		
		while(isTrue) {
			String id;
			String name;
			String pwd;
			String email;
			char gender;
			int age;
			
			System.out.println("현재 등록된 회원 수는 " + controller.memberCount() + "명 입니다");
			if(controller.checkFull() == false) System.out.println("1. 새 회원 등록");
			else System.out.println("회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈합니다.");
			System.out.println("2. 회원 정보 수정");
			System.out.println("3. 전체 회원 정보 출력");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int select = Integer.parseInt(sc.nextLine());
			
			switch(select) {
				case 1 :
					if(controller.checkFull() == false) {
						while(true) {
							System.out.print("아이디 : ");
							id = sc.nextLine();
							if(controller.idCheck(id) == true) {
								System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
							} else break;
						}
						System.out.print("이름 : ");
						name = sc.nextLine();
						System.out.print("비밀번호 : ");
						pwd = sc.nextLine();
						System.out.print("이메일 : ");
						email = sc.nextLine();
						System.out.print("성별(M/F) : ");
						gender = sc.nextLine().charAt(0);
						System.out.print("나이 : ");
						age = Integer.parseInt(sc.nextLine());
						System.out.println(controller.addMember(id, name, pwd, email, gender, age));
						break;
					}else System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
					break;
				case 2 : 
					System.out.print("수정할 회원의 아이디 : ");
					id = sc.nextLine();
					if(controller.idCheck(id) == false) {
						System.out.println("회원 정보가 없습니다.");
						break;
					}
					System.out.print("수정할 이름 : ");
					name = sc.nextLine();
					System.out.print("수정할 이메일 : ");
					email = sc.nextLine();
					System.out.print("수정할 비밀번호 : ");
					pwd = sc.nextLine();
					System.out.println(controller.editMember(id, name, pwd, email));
					break;
				case 3 :
//					controller.printInfo();
					int a = 0;
					while(true) {
						if(controller.printInfo(a) == null) break;
						else System.out.println(controller.printInfo(a));
						a++;
					}
					break;
				case 9 :
					System.out.println("프로그램 종료");
					isTrue = false;
					break;
				default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
			}
		}
	}
}
