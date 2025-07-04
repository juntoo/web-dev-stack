package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import vo.Book;
import vo.Member;
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
		
		String query = "INSERT INTO rent(id, book_no) VALUES(?, ?)";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);
		ps.setInt(2, bookNo);
		
		ps.executeUpdate();
		
		close(ps, connect);
	}
	// 7-1 나이제한
	public boolean checkAge(String id, int bookNo) throws SQLException {
		Connection connect = getConnect();
		String query = "SELECT * FROM book WHERE book_no = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setInt(1, bookNo);
		ResultSet rs = ps.executeQuery();
		
		boolean check = false;
		if(rs.next()) {
			if(rs.getInt("access_age") > memberSearch(id).getAge()) {
				check = true;
			}
		}
		
		close(rs, ps, connect);
		
		return check;
	}
	// 7-2 책 중복 체크
	public boolean distinctCheck(String id, int bookNo) throws SQLException {
		boolean check = false;
		Connection connect = getConnect();
		String query = "SELECT * FROM rent WHERE id = ? AND book_no = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);
		ps.setInt(2, bookNo);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) check = true;
		
		close(rs, ps, connect);
		
		return check;
	}
	
	// 책당 최대 대여권수 2
	public ArrayList<Rent> bookRentList(int bookNo) throws SQLException {
		ArrayList<Rent> list = new ArrayList<>();
		Connection connect = getConnect();
		
		String query = "SELECT * FROM rent WHERE book_no = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setInt(1, bookNo);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			list.add(new Rent(rs.getInt("rent_no"), rs.getString("id"), rs.getInt("book_no"), rs.getDate("rent_date").toLocalDate(), null, null));
		}
		
		close(rs, ps, connect);
		
		return list;
	}
	
	// 8. 내가 대여한 책 조회
//	public ArrayList<Rent> printRentBook(String id) throws SQLException {
//		ArrayList<Rent> list = new ArrayList<>();
//		Connection connect = getConnect();
//		
//		String query = "SELECT * FROM rent WHERE id = ?";
//		PreparedStatement ps = connect.prepareStatement(query);
//		ps.setString(1, id);
//		ResultSet rs = ps.executeQuery();
//		int i = 0;
//		while(rs.next()) {
//			list.add(new Rent(rs.getInt("rent_no"), rs.getString("id"), rs.getInt("book_no"), rs.getDate("rent_date").toLocalDate(), memberSearch(id), bookSearch(id).get(i)));
//			i++;
//		}
//		
//		close(rs, ps, connect);
//		
//		return list;
//	}
	public ArrayList<Rent> printRentBook(String id) throws SQLException {
		ArrayList<Rent> list = new ArrayList<>();
		Connection connect = getConnect();
		
		String query = "SELECT *\r\n"
				+ "FROM book\r\n"
				+ "JOIN rent USING(book_no)\r\n"
				+ "JOIN member USING(id)\r\n"
				+ "WHERE id = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Book book = new Book(rs.getInt("book_no"), rs.getString("title"), rs.getString("author"), rs.getInt("access_age"));
			list.add(new Rent(rs.getInt("rent_no"), rs.getString("id"), rs.getInt("book_no"), rs.getDate("rent_date").toLocalDate(), memberSearch(id), book));
		}
		
		close(rs, ps, connect);
		
		return list;
	}
	
	public Member memberSearch(String id) throws SQLException {
		Connection connect = getConnect();
		Member member = null;
		String query = "SELECT * FROM member WHERE id = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			member = new Member(rs.getString("id"), rs.getString("name"), rs.getString("pwd"), rs.getInt("age"));
		}
		
		close(rs, ps, connect);
		
		return member;
	}
//	
//	public ArrayList<Book> bookSearch(String id) throws SQLException {
//		Connection connect = getConnect();
//		ArrayList<Book> list = new ArrayList<Book>();
//		String query = "SELECT book_no, title, author, access_age\r\n"
//				+ "FROM book\r\n"
//				+ "JOIN rent USING(book_no)\r\n"
//				+ "WHERE id = ?";
//		PreparedStatement ps = connect.prepareStatement(query);
//		ps.setString(1, id);
//		ResultSet rs = ps.executeQuery();
//		
//		while(rs.next()) {
//			list.add(new Book(rs.getInt("book_no"), rs.getString("title"), rs.getString("author"), rs.getInt("access_age")));
//		}
//		
//		close(rs, ps, connect);
//		
//		return list;
//	}
	
	public int bookNoSearch(String title) throws SQLException {
		Connection connect = getConnect();
		String query = "SELECT * FROM book WHERE title = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, title);
		ResultSet rs = ps.executeQuery();
		
		int bookNo = 0;
		if(rs.next()) {
			bookNo = rs.getInt("book_no");
		}
		
		close(rs, ps, connect);
		
		return bookNo;
	}
	
	// 9. 대여 취소
	public void deleteRent(int rentNo) throws SQLException {
		Connection connect = getConnect();
		
		String query = "DELETE FROM rent WHERE rent_no = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setInt(1, rentNo);
		
		ps.executeUpdate();
		
		close(ps, connect);
	}
}
