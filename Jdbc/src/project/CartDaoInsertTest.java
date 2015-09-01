package project;

import java.sql.Connection;
import java.sql.SQLException;

import dao.Board;

public class CartDaoInsertTest {

	public static void main(String[] args) throws Exception {
		Cart cart = new Cart();
		cart.setProductNo(22);
		cart.setMemberId("aa");
		cart.setCartCount(6);
		cart.setCartPrice(50000);

		Connection conn=ConnectionManager.getConnection();
		CartDao cartDao = new CartDao(conn);
		Integer pk = cartDao.insert(cart);

		if (pk != null) {
			System.out.println(pk + " �� �Խù��� �����");
		} else {
			System.out.println("�������");
		}
		conn.close();
	}
}
