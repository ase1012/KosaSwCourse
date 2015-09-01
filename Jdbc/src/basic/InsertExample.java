package basic;

import java.sql.*;

public class InsertExample {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// url : ���Ṯ�ڿ�(Connection String)
			// 1.ip 2.port 3.db name
			conn = DriverManager.getConnection(
					"jdbc:mysql://blueskii.iptime.org:3306/team2", 
					"team2", "123456");
			
			String sql = "insert into user5_boards (board_title,board_content,board_writer,board_date) values(?,?,?,now())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "������ ȭ����");
			pstmt.setString(2,"�������");
			pstmt.setString(3, "������");
			pstmt.executeUpdate();
			
			System.out.println("1���� ���� �����");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {pstmt.close();} catch (SQLException e1) {}
			try {conn.close();} catch (SQLException e) {}
		}
	}
}
