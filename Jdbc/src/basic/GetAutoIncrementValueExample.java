package basic;

import java.sql.*;

public class GetAutoIncrementValueExample {

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
			pstmt = conn.prepareStatement(sql,new String[]{"board_no"});
			pstmt.setString(1, "오늘은 화요일");
			pstmt.setString(2,"피고니해");
			pstmt.setString(3, "센");
			int row=pstmt.executeUpdate();
			int boardNo=0;
			if(row==1){
				ResultSet rs=pstmt.getGeneratedKeys();
				if(rs.next()){
					boardNo=rs.getInt(1);
				}
				rs.close();
			}
			
			System.out.println(boardNo+" 번 게시물이 저장됨");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {pstmt.close();} catch (SQLException e1) {}
			try {conn.close();} catch (SQLException e) {}
		}
	}
}
