package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import config.ServerInfo;

public class TransactionTest2 {
	
	public static void main(String[] args) {
		
		/*
		 * 지은 -> 지연 : 3만원씩 이체
		 * 지은님의 잔액이 마이너스가 될 경우 이체 취소
		 * UPDATE 2개, SELECT 1개
		 * */
		try {
			Class.forName(ServerInfo.DRIVER);
			Connection connect = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			
			connect.setAutoCommit(false);
			
			String send = "지은";
			String to = "지연";
			
			String query1 = "UPDATE bank SET balance = balance-? WHERE name = ?";
			PreparedStatement ps1 = connect.prepareStatement(query1);
			ps1.setInt(1, 30000);
			ps1.setString(2, send);
			ps1.executeUpdate();
			
			String query2 = "UPDATE bank SET balance = balance+? WHERE name = ?";
			PreparedStatement ps2 = connect.prepareStatement(query2);
			ps2.setInt(1, 30000);
			ps2.setString(2, to);
			ps2.executeUpdate();
			
			PreparedStatement ps3 = connect.prepareStatement("SELECT * FROM bank WHERE name = ?");
			ps3.setString(1, send);
			
			ResultSet rs = ps3.executeQuery();
						
			if(rs.next()) {
				if(rs.getInt("balance") < 0) {
					System.out.println("잔액 부족");
					connect.rollback();
				}else {
					System.out.println("이체 성공");
					connect.commit();
				}
			} 
			
			connect.setAutoCommit(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
