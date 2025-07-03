package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import model.vo.Person;

/*
 * DAO(Data Access Object)
 * - 데이터베이스에 접근해서 CRUD를 처리하는 객체
 * */
public class PersonDAO {
	
	// 싱글톤 패턴 : 실제로 생성되는 객체는 하나
	// 1. private static 객체 생성
	private static PersonDAO instance = new PersonDAO();
	
	// 2. private 생성자
	private PersonDAO() {
		try {
			Class.forName(ServerInfo.DRIVER);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 3. public static 메서드로 인스턴스 제공
	public static PersonDAO getInstance() {
		return instance;
	}
	
	public Connection getConnect() throws SQLException {
		Connection connect = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		return connect;
	}
	
	// 오버로딩
	public void close(PreparedStatement ps, Connection connect) throws SQLException{
		ps.close();
		connect.close();
	}
	
	public void close(ResultSet rs, PreparedStatement ps, Connection connect) throws SQLException{
		rs.close();
		close(ps, connect);
	}
	
	public boolean checkPerson(String name, int age, String addr) throws SQLException{
		Connection connect = getConnect();
		
		String query = "SELECT * FROM person WHERE name = ? AND age = ? AND addr = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, name);
		ps.setInt(2, age);
		ps.setString(3, addr);
		// 존재하면 true, 존재하지 않으면 false
		return ps.executeQuery().next();
	}
	
	public String addPerson(String name, int age, String addr) throws SQLException{

		Connection connect = getConnect();
//		if(checkPerson(name, age, addr)) return "이미 가입된 회원입니다";
		String query = "INSERT INTO person(name, age, addr) VALUES(?, ?, ?)";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, name);
		ps.setInt(2, age);
		ps.setString(3, addr);
		// 쿼리 실행
		int result = ps.executeUpdate();
		// 자원 반납
		close(ps, connect);

		return name + "님, 회원가입 완료";
	}
	
	// person 테이블에 있는 데이터 전체 보여주기 - SELECT
	public ArrayList<Person> searchAllPerson() throws SQLException{
		ArrayList<Person> list = new ArrayList<Person>();
		Connection connect = getConnect();
		String query = "SELECT * FROM person";
		PreparedStatement ps = connect.prepareStatement(query);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			String addr = rs.getString("addr");
//				System.out.println("id : " + id + ", 이름 : " + name 
//									+ ", 나이 : " + age + ", 주소 : " + addr);
			list.add(new Person(id, name, age, addr));
		}
		
		close(rs, ps, connect);
		
		return list;
	}
	
	// person 테이블에서 데이터 한개만 가져오기 - SELECT -> id이용
	public Person searchPerson(int id) throws SQLException{
		Connection connect = getConnect();
		String query = "SELECT * FROM person WHERE id = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		Person person = null;
		
		if (rs.next()) {
			person = new Person(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("addr"));
		}
		
		close(rs, ps, connect);
		
		return person;
	}
	
	// person 테이블에 데이터 수정 - UPDATE
	public String updatePerson(int id, String name, int age, String addr) throws SQLException{
		
		if(checkPerson(name, age, addr)) return "기존에 존재하는 회원정보 입니다";
		
		Connection connect = getConnect();
		String query = "UPDATE person SET name = ?, age = ?, addr = ? WHERE id = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, name);
		ps.setInt(2, age);
		ps.setString(3, addr);
		ps.setInt(4, id);
		
		ps.executeUpdate();
		
		close(ps, connect);
		
		return "업데이트 완료";
	}

	// person 테이블에 데이터 삭제 - DELETE
	public boolean removePerson(int id) throws SQLException{
		Connection connect = getConnect();
		String query = "DELETE FROM person WHERE id = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setInt(1, id);

		ps.executeUpdate();
		
		close(ps, connect);
		
		return true; 
	}
}
