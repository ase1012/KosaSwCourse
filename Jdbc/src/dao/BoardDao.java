package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	private Connection conn;

	// ������ ����
	public BoardDao(Connection conn) {
		this.conn = conn;
	}

	/*
	 * //�̱������� ��� private static BoardDao singleton=new BoardDao(); private
	 * BoardDao(){}
	 * 
	 * public static BoardDao getInstance(){ return singleton; }
	 */

	// ������ �۾��޼ҵ�
	public Integer insert(Board board) throws SQLException {
		Integer pk = null;
		String sql = "insert into boards (board_title,board_content,board_writer) values(?,?,?)";
		// Connection conn = null;
		PreparedStatement pstmt = null;
		// try {
		// conn=ConnectionManager.getConnection();
		pstmt = conn.prepareStatement(sql, new String[] { "board_no" });
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getContent());
		pstmt.setString(3, board.getWriter());
		int row = pstmt.executeUpdate();

		if (row == 1) {
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				pk = rs.getInt(1);
			}
			rs.close();
			// }
		} /*
			 * catch (Exception e) { e.printStackTrace(); } finally { try
			 * {pstmt.close();} catch (SQLException e1) {} try {conn.close();}
			 * catch (SQLException e) {} }
			 */
		pstmt.close();
		return pk;
	}

	public int update(Board board) throws SQLException {
		int rows = 0;
		String sql = "update boards set board_title=?,board_content=?,board_hitcount=? where board_no=?";
		// Connection conn = null;
		PreparedStatement pstmt = conn.prepareStatement(sql);
		/*
		 * try { conn = ConnectionManager.getConnection();
		 * 
		 * 
		 */
		
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getContent());
		pstmt.setInt(3, board.getHitcount());
		pstmt.setInt(4, board.getNo());
		rows = pstmt.executeUpdate();

		/*
		 * } catch (Exception e) { e.printStackTrace(); } finally { try {
		 * pstmt.close(); } catch (SQLException e1) { } try { conn.close(); }
		 * catch (SQLException e) { } }
		 */
		pstmt.close();
		return rows;
	}

	public int delete(int boardNo) throws SQLException {
		int rows = 0;
		String sql = "delete from boards where board_no=?";
		// Connection conn = null;
		PreparedStatement pstmt = conn.prepareStatement(sql);
		/*
		 * pstmt = null; try { conn = ConnectionManager.getConnection();
		 * 
		 */
		pstmt.setInt(1, boardNo);

		rows = pstmt.executeUpdate();
		/*
		 * } catch (Exception e) { e.printStackTrace(); } finally { try {
		 * pstmt.close(); } catch (SQLException e1) { } try { conn.close(); }
		 * catch (SQLException e) { } }
		 */
		pstmt.close();
		return rows;
	}

	//�⺻Ű�� �˻�!!
	public Board selectByPk(int boardNo) throws SQLException {
		Board board = null;
		String sql = "select * from boards where board_no=?";
		// Connection conn = null;
		PreparedStatement pstmt = conn.prepareStatement(sql);
		/*
		 * try { conn = ConnectionManager.getConnection();
		 * 
		 */
		pstmt.setInt(1, boardNo);
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			board = new Board();
			board.setNo(rs.getInt("board_no"));
			board.setTitle(rs.getString("board_title"));
			board.setContent(rs.getString("board_content"));
			board.setDate(rs.getDate("board_date"));
			board.setWriter(rs.getString("board_writer"));
			board.setHitcount(rs.getInt("board_hitcount"));

		}
		rs.close();

		/*
		 * } catch (Exception e) { e.printStackTrace(); } finally { try {
		 * pstmt.close(); } catch (SQLException e1) { } try { conn.close(); }
		 * catch (SQLException e) { } }
		 */
		pstmt.close();
		return board;
	}

	/*
	 * public List<Board> selectByAll() { List<Board> list = new
	 * ArrayList<Board>(); // ���� ������ �ƹ��͵� ���� ä�� return String sql =
	 * "select * from boards"; //Connection conn = null; PreparedStatement pstmt
	 * = null; try { conn = ConnectionManager.getConnection();
	 * 
	 * pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery();
	 * 
	 * while (rs.next()) { Board board = new Board();
	 * board.setNo(rs.getInt("board_no"));
	 * board.setTitle(rs.getString("board_title"));
	 * board.setContent(rs.getString("board_content"));
	 * board.setDate(rs.getDate("board_date"));
	 * board.setWriter(rs.getString("board_writer"));
	 * board.setHitcount(rs.getInt("board_hitcount")); list.add(board);
	 * 
	 * } rs.close();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } finally { try {
	 * pstmt.close(); } catch (SQLException e1) { } try { conn.close(); } catch
	 * (SQLException e) { } } return list; }
	 */
	public List<Board> selectByPage(int pageNo, int rowsPerPage) throws SQLException {
		List<Board> list = new ArrayList<Board>();
		/*String sql = "";
		sql += "select rn, board_no, board_title, board_writer, board_date, board_hitcount ";
		sql += "from ";
		sql += "( ";
		sql += "select rownum rn, board_no, board_title, board_writer, board_date, board_hitcount ";
		sql += "from ";
		sql += "( ";
		sql += "select board_no, board_title, board_writer, board_date, board_hitcount ";
		sql += "from boards ";
		sql += "order by board_no desc ";
		sql += ") ";
		sql += "where rownum<=? ";
		sql += ") ";
		sql += "where rn>=? ";*/

		// Connection conn = null;
		String sql= "select board_no, board_title, board_writer, board_date, board_hitcount ";
		sql += "from user0_boards ";
		sql += "order by board_no desc ";;
		sql += "limit ?,?";
				
		PreparedStatement pstmt = conn.prepareStatement(sql);
		;
		/*
		 * try { conn = ConnectionManager.getConnection();
		 */
		
	/*	Oracle
		pstmt.setInt(1, pageNo * rowsPerPage);
		pstmt.setInt(2, (pageNo - 1) * rowsPerPage + 1);*/
		
		//MySQL
		pstmt.setInt(1, (pageNo - 1) * rowsPerPage);
		pstmt.setInt(2, rowsPerPage);
		
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			Board board = new Board();
			board.setNo(rs.getInt("board_no"));
			board.setTitle(rs.getString("board_title"));
			board.setDate(rs.getDate("board_date"));
			board.setWriter(rs.getString("board_writer"));
			board.setHitcount(rs.getInt("board_hitcount"));
			list.add(board);
		}
		rs.close();
		/*
		 * } catch (Exception e) { e.printStackTrace(); } finally { try {
		 * pstmt.close(); } catch (SQLException e1) { } try { conn.close(); }
		 * catch (SQLException e) { } }
		 */
		pstmt.close();
		return list;
	}
}