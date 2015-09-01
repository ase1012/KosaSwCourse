package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

	private Connection conn;
	
	public ProductDao(Connection conn) {
		this.conn = conn;
	}
	
	public Product selectByProductId(int id) throws SQLException {
		Product product = null;
		String sql = "SELECT * FROM products WHERE product_no=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			product = new Product();
			product.setpNo(rs.getInt("product_no"));
			product.setpName(rs.getString("product_name"));
			product.setpPrice(rs.getInt("product_price"));
		}
		
		rs.close();
		pstmt.close();
		
		return product;
	}
	
	public List<Product> selectAll() throws SQLException {
		List<Product> list = new ArrayList<Product>();
		String sql = "SELECT * FROM products";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Product product = new Product(); 
			product.setpNo(rs.getInt("product_no"));
			product.setpName(rs.getString("product_name"));
			product.setpPrice(rs.getInt("product_price"));
			list.add(product);
		}
		
		rs.close();
		pstmt.close();
		
		return list;
	}
}
