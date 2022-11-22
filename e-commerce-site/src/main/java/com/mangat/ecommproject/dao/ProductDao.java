package com.mangat.ecommproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mangat.ecommproject.model.Cart;
import com.mangat.ecommproject.model.Product;

public class ProductDao {
	private Connection con;
	private String query;
	private ResultSet rs;
	PreparedStatement pstt ;
	
	public ProductDao(Connection con) {
		
		this.con = con	;
	}
	
	public List<Product> getAllProducts(){
		
		List<Product> products = new ArrayList<>();
			
			
			try {
				query = "select * from products";
				pstt = this.con.prepareStatement(query);
				rs= pstt.executeQuery();
				while(rs.next()) {
					Product pdt = new Product();
					pdt.setPid(rs.getInt("id"));
					pdt.setPdtname(rs.getString("pdtname"));
					pdt.setPdtcategory(rs.getString("category"));
					pdt.setPdtprice(rs.getInt("price"));
					pdt.setPdtimage(rs.getString("image"));
					
					products.add(pdt);
				}
				} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
		
		return products;
		
	}
	
	public List<Cart> getCartProducts(ArrayList<Cart> cartList){
		
		List<Cart> products = new ArrayList<Cart>();
		try {
			if(cartList.size()>0) {
				for(Cart item:cartList) {
					query="select * from mangatstore.products where id = ?;";
					pstt = this.con.prepareStatement(query);
					pstt.setInt(1, item.getPid());
					rs = pstt.executeQuery();
					while(rs.next()) {
						Cart crt = new Cart();
						crt.setPid(rs.getInt("id"));
						crt.setPdtname(rs.getString("pdtname"));
						crt.setPdtcategory(rs.getString("category"));
						crt.setPdtprice(rs.getInt("price")*item.getQuantity());
						crt.setQuantity(item.getQuantity());
						products.add(crt);
					}
					
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return products;
		
	}
	
	public int getTotalCartPrice(ArrayList<Cart> cartList) {
		
		int summ = 0;
		try {
			
			if(cartList.size()>0) {
				for(Cart item:cartList) {
					query="select price from products where id = ?;";
					pstt = this.con.prepareStatement(query);
					pstt.setInt(1, item.getPid());
					rs = pstt.executeQuery();
					while(rs.next()) {
						summ += rs.getInt("price")*item.getQuantity();
					}
					
				}
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return summ;
		
		
	}

	public Product getSigleProduct(int pdtid) {
		Product pdt = null;
		
		try {
			query = "select * from products where id=?";
			pstt = this.con.prepareStatement(query);
			pstt.setInt(1, pdtid);
			rs= pstt.executeQuery();
			while(rs.next()) {
				pdt=new Product();
				pdt.setPid(rs.getInt("id"));
				pdt.setPdtname(rs.getString("pdtname"));
				pdt.setPdtcategory(rs.getString("category"));
				pdt.setPdtprice(rs.getInt("price"));
				pdt.setPdtimage(rs.getString("image"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return pdt;
	}
	
}
