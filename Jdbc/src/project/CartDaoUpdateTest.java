package project;

import java.sql.Connection;
import java.sql.SQLException;

public class CartDaoUpdateTest {

	public static void main(String[] args) throws Exception {
		
		Cart cart = new Cart();
		cart.setCartNo(2);
		cart.setCartCount(7);
		
		Connection conn=ConnectionManager.getConnection();
		CartDao cartDao = new CartDao(conn);
		int rows = cartDao.update(cart);
		if (rows == 1) {
			System.out.println(cart.getCartNo() + " �� �Խù��� ������");
		} else {
			System.out.println(cart.getCartNo() + " �� �Խù��� �������� ����");
		}
		conn.close();
	}
}
