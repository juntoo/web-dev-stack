package jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class DBConnectionTest4 {

	public static void main(String[] args) {
		Connection connect = null;
		PreparedStatement ps = null;
		
		try {
			Properties p = new Properties();
			p.load(new FileInputStream("src/config/db.properties"));
			// 1. 드라이버 로딩
			Class.forName(p.getProperty("driver"));
			// 2. 데이터베이스 연결
			connect = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"), p.getProperty("password"));
			// 3. PreparedStatement
			String query = "DELETE FROM user_info WHERE user_no = ?";
			ps =  connect.prepareStatement(query);
			
			ps.setInt(1, 1);
			// 4. 쿼리문 실행
			System.out.println(ps.executeUpdate()+"명 삭제 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
