package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import model.Person;

public class PersonController {
	// 리턴 타입이나 파라미터 자유롭게 변경 가능
	// 메서드 추가 가능

	
	public PersonController() {
		try {
			Class.forName(ServerInfo.DRIVER);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 고정적으로 반복
	// 2. DB 연결
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
	
	// ------- 변동적인 반복 : DAO(Database Access Object)
	
	
	// person 테이블에 데이터 추가 - INSERT	
	public int addPerson(String name, int age, String addr) throws SQLException{
		int num = 0;
		Connection connect = getConnect();
		String query = "INSERT INTO person(name, age, addr) VALUES(?, ?, ?)";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, name);
		ps.setInt(2, age);
		ps.setString(3, addr);

		num = ps.executeUpdate();
		
		close(ps, connect);
		
		return num;
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
	public Person searchPerson(int userId) throws SQLException{
		Connection connect = getConnect();
		String query = "SELECT * FROM person WHERE id = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setInt(1, userId);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			String addr = rs.getString("addr");
			Person person = new Person(id, name, age, addr);
			return person;
		}	
		
		close(rs, ps, connect);
		
		return null;
	}
	
	// person 테이블에 데이터 수정 - UPDATE
	public int updatePerson(int id, String name, int age, String addr) throws SQLException{
		int num = 0;
		Connection connect = getConnect();
		String query = "UPDATE person SET name = ?, age = ?, addr = ? WHERE id = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, name);
		ps.setInt(2, age);
		ps.setString(3, addr);
		ps.setInt(4, id);

		num = ps.executeUpdate();
		
		close(ps, connect);
		
		return num;
	}

	// person 테이블에 데이터 삭제 - DELETE
	public int removePerson(int id) throws SQLException{
		int num = 0;
		Connection connect = getConnect();
		String query = "DELETE FROM person WHERE id = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setInt(1, id);

		num = ps.executeUpdate();
		
		close(ps, connect);
		
		return num;
	}
}
