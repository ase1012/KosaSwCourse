package dao;

import java.sql.Connection;
import java.sql.SQLException;

public class BoardDaoInsertTest {

	public static void main(String[] args) throws Exception {
		Board board = new Board();
		board.setTitle("졸려졸려졸려");
		board.setContent("집에가고싶다............");
		board.setWriter("센");

		Connection conn=ConnectionManager.getConnection();
		BoardDao boardDao = new BoardDao(conn);
		Integer pk = boardDao.insert(board);
		if (pk != null) {
			System.out.println(pk + " 번 게시물이 저장됨");
		} else {
			System.out.println("저장실패");
		}
		conn.close();
	}
}
