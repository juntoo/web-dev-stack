package controller;

import java.util.ArrayList;

import model.dao.PersonDAO;
import model.vo.Person;

public class PersonController {

	// ------- 변동적인 반복 : DAO(Database Access Object)
	
	
	// person 테이블에 데이터 추가 - INSERT	
//	public int addPerson(String name, int age, String addr) throws SQLException{
//		int num = 0;
//		Connection connect = getConnect();
//		String query = "INSERT INTO person(name, age, addr) VALUES(?, ?, ?)";
//		PreparedStatement ps = connect.prepareStatement(query);
//		ps.setString(1, name);
//		ps.setInt(2, age);
//		ps.setString(3, addr);
//
//		num = ps.executeUpdate();
//		
//		close(ps, connect);
//		
//		return num;
//	}
	
	private PersonDAO dao = PersonDAO.getInstance();
	
	public String addPerson(String name, int age, String addr) {
		try {
			boolean check = dao.checkPerson(name, age, addr);
			if(check) return "이미 가입된 회원입니다";
			return dao.addPerson(name, age, addr);
		}catch (Exception e) {
			return "회원가입 실패";
		}
	}
	
	// person 테이블에 있는 데이터 전체 보여주기 - SELECT
	public ArrayList<Person> searchAllPerson() {
		try {
			return dao.searchAllPerson();
		} catch (Exception e) {
			return null;
		}
	}
	
	// person 테이블에서 데이터 한개만 가져오기 - SELECT -> id이용
	public Person searchPerson(int id) {
		try {
			return dao.searchPerson(id);
		} catch (Exception e) {
			return null;
		}
	}
	
	// person 테이블에 데이터 수정 - UPDATE
	public String updatePerson(int id, String name, int age, String addr) {
		try {
			return dao.updatePerson(id, name, age, addr);
		} catch (Exception e) {
			return "업데이트 실패";
		}
		
		
	}

	// person 테이블에 데이터 삭제 - DELETE
	public String removePerson(int id) {
		try {
			if(dao.removePerson(id)) {
				return "ID : " + id + " 삭제 되었습니다.";
			}
			return "삭제실패";
		} catch (Exception e) {
			return "관리자에게 문의하세요";
		}
	}
}
