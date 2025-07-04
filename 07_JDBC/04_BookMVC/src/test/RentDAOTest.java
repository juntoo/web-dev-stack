package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.RentDAO;

class RentDAOTest {
	
	private RentDAO dao;
	
	@BeforeEach
	void setUp() {
		dao = RentDAO.getInstance();
	}
	// @AfterEach : 각 테스트 메서드가 실행된 후에 무조건 실행
	@AfterEach
	void setDown() throws SQLException {
		dao.getConnect().prepareStatement("DELETE FROM rent").executeUpdate();
	}
	
	@Test
	void testRentBook() throws SQLException {
		String id = "asdf";
		int bookNo = 1;
		dao.rentBook(id, bookNo);
	}



}
