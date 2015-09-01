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
			System.out.print("상품번호 : " + cart.getProductNo()+"\t");
			System.out.print("상품명 : " + cart.getProductName()+"\t");
			System.out.print("수량 : " + cart.getCartCount()+"\t");
			System.out.println("가격 : " + cart.getCartPrice());
		}
		conn.close();
	}
}
