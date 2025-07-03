package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import vo.Rent;

public class RentDAO {
	
	private static RentDAO instance = new RentDAO();

	private RentDAO() {
		try {
			Class.forName(ServerInfo.DRIVER);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static RentDAO getInstance() {
		return instance;
	}

	public Connection getConnect() throws SQLException {
		Connection connect = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		return connect;
	}

	// 오버로딩
	public void close(PreparedStatement ps, Connection connect) throws SQLException {
		ps.close();
		connect.close();
	}

	public void close(ResultSet rs, PreparedStatement ps, Connection connect) throws SQLException {
		rs.close();
		close(ps, connect);
	}
	
	
	// 7. 책 대여
	public void rentBook(String id, int bookNo) throws SQLException {
		Connection connect = getConnect();
		
		String query = "INSERT INTO rent(id, book_no) VALUES(?, ?))";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);
		ps.setInt(2, bookNo);
		
		ps.executeUpdate();
	}
	
	
	
	// 8. 내가 대여한 책 조회
	public ArrayList<Rent> printRentBook() {
		return null;
	}
	
	// 9. 대여 취소
	public void deleteRent(int rentNo) {
		
	}
}
