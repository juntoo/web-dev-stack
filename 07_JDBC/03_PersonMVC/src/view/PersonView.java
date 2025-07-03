package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import controller.PersonController;
import model.vo.Person;

public class PersonView {
	
	PersonController pc = new PersonController();
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		PersonView pv = new PersonView();
		
		pv.menu();

		
	}
	
	public void menu() {
		while(true) {
			System.out.println("1. 추가");
			System.out.println("2. 전체 조회");
			System.out.println("3. 선택 조회");
			System.out.println("4. 회원 정보 변경");
			System.out.println("5. 회원 삭제");
			System.out.print("선택 > ");
			int select = Integer.parseInt(sc.nextLine());
			switch (select) {
				case 1:
					System.out.println(addPerson());
					break;
				case 2:
					searchAllPerson();
					break;
				case 3:
					searchPerson();
					break;
				case 4:
					System.out.println(updatePerson());
					break;
				case 5:
					System.out.println(removePerson());
					break;
			}
		}
	}
	
//	public void addPerson() throws SQLException {
//		System.out.print("이름 : ");
//		String name = sc.nextLine();
//		
//		System.out.print("나이 : ");
//		int age = Integer.parseInt(sc.nextLine());
//		
//		System.out.print("주소 : ");
//		String addr = sc.nextLine();
//		
//		if(pc.addPerson(name, age, addr) > 0) System.out.println("추가성공");
//		else System.out.println("추가실패");
//	}
	
	public String addPerson() {
		try {
			System.out.print("이름 : ");
			String name = sc.nextLine();
			
			System.out.print("나이 : ");
			int age = Integer.parseInt(sc.nextLine());
			
			System.out.print("주소 : ");
			String addr = sc.nextLine();
			
			return pc.addPerson(name, age, addr);
		} catch (NumberFormatException e) {
			return "숫자를 입력해주세요";
		}
	}
	
	public void searchAllPerson() {
		ArrayList<Person> list = pc.searchAllPerson();
		if(list!=null) {
			for(Person p : list) {
				System.out.println(p);
			}
		}else System.out.println("현재 가입된 인원이 없습니다");
		
	}
	
	public void searchPerson() {
		searchAllPerson();
		System.out.print("조회할 ID : ");
		int id = Integer.parseInt(sc.nextLine());
		
		Person person = pc.searchPerson(id);
		if(person != null) System.out.println(person);
		else System.out.println("해당하는 인원이 없습니다");
	}
	
	public String updatePerson() {
		try {
			System.out.print("변경할 사람 ID : ");
			int id = Integer.parseInt(sc.nextLine());
			
			Person person = pc.searchPerson(id);
			if(person != null) System.out.println(person);
			else {
				return "조횐된 아이디가 없습니다";
			}
			
			System.out.print("변경할 이름 : ");
			String name = sc.nextLine();
			
			System.out.print("변경할 나이 : ");
			int age = Integer.parseInt(sc.nextLine());
			
			System.out.print("변경할 주소 : ");
			String addr = sc.nextLine();
			
			return pc.updatePerson(id, name, age, addr);
		} catch (NumberFormatException e) {
			return "숫자를 입력해주세요";
		} catch (Exception e) {
			return "수정 실패했습니다";
		}
		
	}
	
	public String removePerson() {
		
		try {
			System.out.print("삭제할 사람 ID : ");
			int id = Integer.parseInt(sc.nextLine());
			
			Person person = pc.searchPerson(id);
			if(person != null) System.out.println(person);
			else {
				return "조횐된 아이디가 없습니다";
			}
			
			return pc.removePerson(id);
		} catch (NumberFormatException e) {
			return "숫자를 입력해주세요";
		}
	}
}
