package project;

import java.sql.Connection;

public class CartDaoDeleteTest {

	public static void main(String[] args)throws Exception {
		Connection conn=ConnectionManager.getConnection();
		CartDao cartDao = new CartDao(conn);
		
		int rows = cartDao.deleteOne(21,"aa");
		if (rows == 1) {
			System.out.println(1 + " 번 게시물이 삭제됨");
		} else {
			System.out.println(1 + " 번 게시물이 존재하지 않음");
		}
		conn.close();
	}
}
