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
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static BookDAO getInstance() {
		return instance;
	}
	
	public Connection connect() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}

	// 1. 전체 책 조회
	public ArrayList<Book> printBookAll() throws SQLException {
		Connection connect = connect();
		String query = "SELECT * FROM book";
		PreparedStatement ps = connect.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		ArrayList<Book> list = new ArrayList<>();
		while(rs.next()) {
			list.add(new Book(rs.getInt("book_no"), rs.getString("title"), 
					rs.getString("author"), rs.getInt("access_age")));
		}
		return list;
	}
	
	// 타이틀, 저자, 접근제한이 완전히 일치한 경우 조회
	public boolean checkBook(String title, String author, int accessAge) throws SQLException {
		Connection connect = connect();
		String query = "SELECT * FROM book WHERE title = ? AND author = ? AND access_age = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, title);
		ps.setString(2, author);
		ps.setInt(3, accessAge);
		
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}
	
	// 2. 책 등록
	public void registerBook(String title, String author, int accessAge) throws SQLException {
		Connection connect = connect();
		String query = "INSERT INTO book(title, author, access_age) VALUES(?, ?, ?)";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, title);
		ps.setString(2, author);
		ps.setInt(3, accessAge);
		ps.executeUpdate();
	}
	
	// 제목으로 책 조회 -> PRIMARY KEY만 조회
	public int searchBook(String title) throws SQLException {
		Connection connect = connect();
		String query = "SELECT book_no FROM book WHERE title = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, title);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			return rs.getInt("book_no");
		}
		return -1;
	}
	
	// 3. 책 삭제
	public int sellBook(int bookNo) throws SQLException {
		Connection connect = connect();
		String query = "DELETE FROM book WHERE book_no = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setInt(1, bookNo);
		return ps.executeUpdate();
	}
	
}
