package basic;

import java.sql.*;

public class ConnectionExample {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// url : ���Ṯ�ڿ�(Connection String)
			// 1.ip 2.port 3.db name
			conn = DriverManager.getConnection(
					"jdbc:mysql://blueskii.iptime.org:3306/team2", 
					"team2", "123456");
			System.out.println("���Ἲ��");
		} catch (Exception e) {
			System.out.println("�������");
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {}
		}
	}
}
