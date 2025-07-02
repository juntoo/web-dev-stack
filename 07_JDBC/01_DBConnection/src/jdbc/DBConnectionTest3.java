package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import config.ServerInfo;

public class DBConnectionTest3 {
	
	public static void main(String[] args) {
		Connection connect = null;
		PreparedStatement ps = null;
		try {
			// 1. 드라이버 로딩
			Class.forName(ServerInfo.DRIVER);
			// 2. 데이터베이스 연결
			connect = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			// 3. PreparedStatement - 쿼리 : UPDATE(user_no를 선택해서 email 수정)
			String query = "UPDATE user_info SET email = ? WHERE user_no = ?";
			ps = connect.prepareStatement(query);
			
			ps.setString(1, "test@naver.com");
			ps.setInt(2, 6);
			// 쿼리문 실행
			System.out.println(ps.executeUpdate()+"명 업데이트 완료");
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
