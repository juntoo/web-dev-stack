package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import controller.PersonController;
import model.Person;

public class PersonView {
	
	PersonController pc = new PersonController();
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		PersonView pv = new PersonView();
		try {
			// 테스트 용도
//			pv.addPerson();
			
//			pv.searchAllPerson();
			
//			pv.searchPerson();
			
//			pv.updatePerson();
			
//			pv.removePerson();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
	public void addPerson() throws SQLException {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		
		System.out.print("주소 : ");
		String addr = sc.nextLine();
		
		if(pc.addPerson(name, age, addr) > 0) System.out.println("추가성공");
		else System.out.println("추가실패");
	}
	
	public void searchAllPerson() throws SQLException {
		ArrayList<Person> list = pc.searchAllPerson();
		if(list.size() > 0) {
			for(Person p : list) {
				System.out.println(p);
			}
		}else System.out.println("테이블에 사람이 없습니다");
	}
	
	public void searchPerson() throws SQLException {
		System.out.print("조회할 ID : ");
		int id = Integer.parseInt(sc.nextLine());
		
		Person person = pc.searchPerson(id);
		if(person != null) {
			System.out.println(person);
		}else System.out.println("해당하는 인원이 없습니다");
	}
	
	public void updatePerson() throws SQLException {
		System.out.print("변경할 사람 ID : ");
		int id = Integer.parseInt(sc.nextLine());
		
		System.out.print("변경할 이름 : ");
		String name = sc.nextLine();
		
		System.out.print("변경할 나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		
		System.out.print("변경할 주소 : ");
		String addr = sc.nextLine();
		
		System.out.println(pc.updatePerson(id, name, age, addr) + "명 수정 완료");
	}
	
	public void removePerson() throws SQLException {
		System.out.print("삭제할 사람 ID : ");
		int id = Integer.parseInt(sc.nextLine());
		
		int num = pc.removePerson(id);
		if(num > 0) System.out.println(num + "명 삭제 완료");
		else System.out.println("삭제 실패");
	}
}
