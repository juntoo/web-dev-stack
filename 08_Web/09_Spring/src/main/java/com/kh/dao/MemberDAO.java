package com.kh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.kh.config.ServerInfo;
import com.kh.vo.Member;

@Repository
public class MemberDAO {
	
	private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO() {
		try {
			Class.forName(ServerInfo.DRIVER);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDAO getInstance() {
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
	
	public Member login(String id, String pwd) throws SQLException {
		Connection connect = getConnect();
		
		String query = "SELECT * FROM member WHERE id = ? AND pwd = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, pwd);
		
		ResultSet rs = ps.executeQuery();
		Member member = null;
		if(rs.next()) {
			member = new Member(id, rs.getString("name"), pwd, rs.getInt("age"));
		}
		
		return member;
	}
	
	public ArrayList<Member> viewAll() throws SQLException {
		Connection connect = getConnect();
		
		String query = "SELECT * FROM member";
		PreparedStatement ps = connect.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Member> list = new ArrayList<Member>();
		
		while(rs.next()) {
			list.add(new Member(rs.getString("id"), rs.getString("pwd"), rs.getString("name"), rs.getInt("age")));
		}
		
		close(rs, ps, connect);
		
		return list;
	}
	
	public Member search(String id) throws SQLException {
		Connection connect = getConnect();
		
		String query = "SELECT * FROM member WHERE id = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		Member member = null;
		if(rs.next()) {
			member = new Member(rs.getString("id"), rs.getString("pwd"), rs.getString("name"), rs.getInt("age"));
		}
		
		return member;
	}
}