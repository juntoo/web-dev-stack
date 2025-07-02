package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnectionTest2 {
	
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/erp";
	public static final String USER = "root"; 
	public static final String PASSWORD = "qwer1234"; 
	
	
	public static void main(String[] args) {
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName(DRIVER);
			System.out.println("1. 드라이버 로딩..!");
			
			connect = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("2. 데이터베이스 연결..!");
			
			String query = "INSERT INTO user_info(id, password, name) VALUES(?, ?, ?)";
			ps = connect.prepareStatement(query);
			
			ps.setString(1, "user01");
			ps.setString(2, "1111");
			ps.setString(3, "이승민");
			
			System.out.println(ps.executeUpdate() + "명 추가");
			
			ps = connect.prepareStatement("SELECT * FROM user_info");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String pw = rs.getString("password");
				
				System.out.println("ID : " + id + ", PW : " + pw + ", NAME : " + name);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
