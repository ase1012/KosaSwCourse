package project;

import java.sql.Connection;

public class CartDaoDeleteTest {

	public static void main(String[] args)throws Exception {
		Connection conn=ConnectionManager.getConnection();
		CartDao cartDao = new CartDao(conn);
		
		int rows = cartDao.deleteOne(21,"aa");
		if (rows == 1) {
			System.out.println(1 + " �� �Խù��� ������");
		} else {
			System.out.println(1 + " �� �Խù��� �������� ����");
		}
		conn.close();
	}
}
