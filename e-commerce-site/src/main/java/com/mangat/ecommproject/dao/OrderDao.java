package com.mangat.ecommproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.List;

import com.mangat.ecommproject.database.DdConn;
import com.mangat.ecommproject.model.Order;
import com.mangat.ecommproject.model.Product;

public class OrderDao {
	private Connection con;
	private String query;
	private ResultSet rs;
	PreparedStatement pst ;
	public OrderDao(Connection con) {
		
		this.con = con;
	}
	
	public boolean insertOrder(Order order) {
		
		boolean result = false;
		
		try {
			
			query ="insert into orders (pdt_id,usr_id,quantity,orddate) values(?,?,?,?)";
			pst = this.con.prepareStatement(query);
			pst.setInt(1, order.getPid());
			pst.setInt(2, order.getUid());
			pst.setInt(3, order.getQuantity());
			pst.setString(4, order.getOdate());
			pst.executeUpdate();
			result=true;	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	public List<Order> userOrders(int id){
		
		List<Order> list = new ArrayList<>();
		try{
			query = "select * from orders where usr_id =? order by orders.ord_id desc";
			pst= this.con.prepareStatement(query);
			pst.setInt(1,id);
			rs= pst.executeQuery();
			
			while(rs.next()) {
				Order order = new Order();
				ProductDao dao = new ProductDao(this.con);
				int pdtid = rs.getInt("pdt_id");
				
				Product product = dao.getSigleProduct(pdtid);
				order.setOrderId(rs.getInt("ord_id"));
				order.setPid(pdtid);
				order.setPdtname(product.getPdtname());
				order.setPdtcategory(product.getPdtcategory());
				order.setPdtprice(product.getPdtprice()*rs.getInt("quantity"));
				order.setQuantity(rs.getInt("quantity"));
				order.setOdate(rs.getString("orddate"));
				list.add(order);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
}
