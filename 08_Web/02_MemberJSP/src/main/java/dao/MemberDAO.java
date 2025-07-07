package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;
import vo.Member;

public class MemberDAO {
	
//	private static MemberDAO instance = new MemberDAO();
	
	public MemberDAO() {
		try {
			Class.forName(ServerInfo.DRIVER);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	public static MemberDAO getInstance() {
//		return instance;
//	}
	
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
	
//	public void register(String id, String name, String pwd, int age) throws SQLException {
//		Connection connect = getConnect();
//		
//		String query = "INSERT INTO member VALUES(?, ?, ?, ?)";
//		PreparedStatement ps = connect.prepareStatement(query);
//		ps.setString(1, id);
//		ps.setString(2, name);
//		ps.setString(3, pwd);
//		ps.setInt(4, age);
//		
//		ps.executeUpdate();
//		
//		close(ps, connect);
//	}
	
	public void register(Member member) throws SQLException {
		Connection connect = getConnect();
		
		String query = "INSERT INTO member VALUES(?, ?, ?, ?)";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, member.getId());
		ps.setString(2, member.getName());
		ps.setString(3, member.getPwd());
		ps.setInt(4, member.getAge());
		
		ps.executeUpdate();
		
		close(ps, connect);
	}
}
