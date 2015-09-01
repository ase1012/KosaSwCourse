package dao;

import java.sql.Connection;
import java.sql.SQLException;

public class BoardDaoInsertTest {

	public static void main(String[] args) throws Exception {
		Board board = new Board();
		board.setTitle("������������");
		board.setContent("��������ʹ�............");
		board.setWriter("��");

		Connection conn=ConnectionManager.getConnection();
		BoardDao boardDao = new BoardDao(conn);
		Integer pk = boardDao.insert(board);
		if (pk != null) {
			System.out.println(pk + " �� �Խù��� �����");
		} else {
			System.out.println("�������");
		}
		conn.close();
	}
}
