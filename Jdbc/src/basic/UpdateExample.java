package basic;

import java.sql.*;

public class UpdateExample {

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
			
			
			String sql = "update user5_boards set board_title=?,board_content=?,board_writer=? where board_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "�ĳĳ�~");
			pstmt.setString(2, "������");
			pstmt.setString(3, "ȣȣȣ");
			pstmt.setInt(4, 1);
			int rows=pstmt.executeUpdate();
			
			System.out.println(rows+" ���� ���� ������");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {pstmt.close();} catch (SQLException e1) {}
			try {conn.close();} catch (SQLException e) {}
		}
	}
}
