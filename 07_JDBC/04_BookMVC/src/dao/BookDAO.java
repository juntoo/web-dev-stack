package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import vo.Book;

public class BookDAO {
	
	private static BookDAO instance = new BookDAO();
	
	private BookDAO() {
		try {
			Class.forName(ServerInfo.DRIVER);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static BookDAO getInstance() {
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
	
	
	// 1. 전체 책 조회
	public ArrayList<Book> printBookAll() throws SQLException{
		ArrayList<Book> list = new ArrayList<Book>();
		Connection connect = getConnect();
		
		String query = "SELECT * FROM book";
		PreparedStatement ps = connect.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			list.add(new Book(rs.getInt("book_no"), rs.getString("title"), rs.getString("author"), rs.getInt("access_age")));
		}
		
		close(rs, ps, connect);
		
		return list;
	}
	
	// 2. 책 등록
	public void registerBook(String title, String author, int accessAge) throws SQLException {
		Connection connect = getConnect();
		
		String query = "INSERT ITO book(title, author, access_age) VALUES(?, ?, ?)";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, title);
		ps.setString(2, author);
		ps.setInt(3, accessAge);
		
		ps.executeUpdate();
		
		close(ps, connect);
	}
	
	// 3. 책 삭제
	public void sellBook(int bookNo) throws SQLException {
		Connection connect = getConnect();
		
		String query = "DELETE FROM book WHERE book_no = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setInt(1, bookNo);
		
		ps.executeUpdate();
		
		close(ps, connect);
	}
	
	// 책 중복 체크용. true = 전체 목록에 있음
	public boolean checkBook(String title, String author, int accessAge) throws SQLException {
		Connection connect = getConnect();
		
		String query = "SELECT * FROM book";
		PreparedStatement ps = connect.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		close(rs, ps, connect);
		
		return rs.next();
	}
	
	public boolean checkRent(int bookNo) throws SQLException {
		Connection connect = getConnect();
		
		String query = "SELECT * FROM rent WHERE book_no = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setInt(1, bookNo);
		ResultSet rs = ps.executeQuery();
		
		close(rs, ps, connect);
		
		return rs.next();
	}
}
