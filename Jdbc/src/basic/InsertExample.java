package basic;

import java.sql.*;

public class InsertExample {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// url : 연결문자열(Connection String)
			// 1.ip 2.port 3.db name
			conn = DriverManager.getConnection(
					"jdbc:mysql://blueskii.iptime.org:3306/team2", 
					"team2", "123456");
			
			String sql = "insert into user5_boards (board_title,board_content,board_writer,board_date) values(?,?,?,now())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "오늘은 화요일");
			pstmt.setString(2,"배고프댜");
			pstmt.setString(3, "세은이");
			pstmt.executeUpdate();
			
			System.out.println("1개의 행의 저장됨");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {pstmt.close();} catch (SQLException e1) {}
			try {conn.close();} catch (SQLException e) {}
		}
	}
}
