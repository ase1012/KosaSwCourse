package project;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.Board;

public class CartDaoSelectAllTest {

	public static void main(String[] args) throws Exception {
		Connection conn=ConnectionManager.getConnection();
		CartDao cartDao = new CartDao(conn);
		List<Cart> list =cartDao.selectAll("aa");
		for(Cart cart:list){
			System.out.print("��ǰ��ȣ : " + cart.getProductNo()+"\t");
			System.out.print("��ǰ�� : " + cart.getProductName()+"\t");
			System.out.print("���� : " + cart.getCartCount()+"\t");
			System.out.println("���� : " + cart.getCartPrice());
		}
		conn.close();
	}
}
