package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BoardDaoSelectByPageTest {

	public static void main(String[] args) throws Exception {
		Connection conn=ConnectionManager.getConnection();
		BoardDao boardDao = new BoardDao(conn);
		List<Board> list = boardDao.selectByPage(2,10);
		
		for(Board board:list){
		System.out.print(board.getNo()+"\t");
		System.out.print(board.getTitle()+"\t");
		System.out.print(board.getDate()+"\t");
		System.out.print(board.getWriter()+"\t");
		System.out.println(+board.getHitcount()+"\t");
		}
		conn.close();
	}
}
