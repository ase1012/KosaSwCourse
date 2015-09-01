package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
	private Connection conn;
	
	public MemberDao(Connection conn) {
		this.conn = conn;
	}
	
	public Integer insert(Member member) throws SQLException{
		int rows = 0;
		String sql = "INSERT INTO members VALUES(?,?,?,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getId());
		pstmt.setString(3, member.getName());
		pstmt.setString(2, member.getPw());
		pstmt.setInt(4, member.getIsAdmin());
		
		rows = pstmt.executeUpdate();
		if(rows < 1) {
			System.out.println("입력 실패");
		}
		
		pstmt.close();
		return rows;
	}
	
	public Member selectById(String id) throws SQLException {
		Member member = null;
		String sql = "SELECT * FROM members WHERE member_id=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			member = new Member();
			member.setId(rs.getString("member_id"));
			member.setPw(rs.getString("member_password"));
			member.setName(rs.getString("member_name"));
			member.setIsAdmin(rs.getInt("member_isadmin"));
		}
		
		rs.close();
		pstmt.close();
		
		return member;
	}
}
