package dao;

import java.sql.Connection;
import java.sql.SQLException;

public class BoardDaoUpdateTest {

	public static void main(String[] args) throws Exception {
		
		Board board = new Board();
		board.setNo(25);
		board.setTitle("완전 졸려..ㅠㅠ");
		board.setContent("집보내주세여...ㅎㅎ");
		board.setHitcount(2);
		
		Connection conn=ConnectionManager.getConnection();
		BoardDao boardDao = new BoardDao(conn);
		int rows = boardDao.update(board);
		if (rows == 1) {
			System.out.println(board.getNo() + " 번 게시물이 수정됨");
		} else {
			System.out.println(board.getNo() + " 번 게시물이 존재하지 않음");
		}
		conn.close();
	}
}
