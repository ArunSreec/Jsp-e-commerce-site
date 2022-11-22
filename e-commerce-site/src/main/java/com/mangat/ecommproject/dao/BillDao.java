package com.mangat.ecommproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mangat.ecommproject.model.Bill;
import com.mangat.ecommproject.model.Order;

public class BillDao {
	
	private Connection con;
	private String query1;
	private String query2;
	private String query3;
	private ResultSet rs;
	PreparedStatement pst ;
	public BillDao(Connection con) {
		super();
		this.con = con;
	}
	
	public Bill getOrder(int orderid) throws Exception {
		
		Bill bill = new Bill();
		Order ord = new Order(); 
		
		
			
			query1 = "select * from orders where ord_id = ?;";
			
			pst = this.con.prepareStatement(query1);
			pst.setInt(1, orderid);
			rs=pst.executeQuery();
			
			while(rs.next()) {
				bill.setQuantity(rs.getInt("quantity"));
				bill.setOdate(rs.getString("orddate"));;
				bill.setPid(Integer.parseInt(rs.getString("pdt_id")));
				bill.setOrderId(rs.getInt("ord_id"));
				bill.setUid(rs.getInt("usr_id"));
				
				
			}
			Bill bill2 = new Bill();
			bill2.setOdate(bill.getOdate());
			bill2.setOrderId(bill.getOrderId());
			bill2.setQuantity(bill.getQuantity());
			bill2.setPid(bill.getPid());
			bill2.setUid(bill.getUid());
			
			PreparedStatement pst2;
			query2 ="select * from users where id=?;";
			pst2 = this.con.prepareStatement(query2);
			pst2.setInt(1, bill.getUid());
			rs = pst2.executeQuery();
			
			while(rs.next()) {
				bill.setBname(rs.getString("usrname"));
				bill.setbAddress(rs.getString("Address"));
				bill.setBphonenumber(rs.getString("PhoneNumber"));
				
			}
			
			bill2.setBname(bill.getBname());
			bill2.setbAddress(bill.getbAddress());
			bill2.setBphonenumber(bill.getBphonenumber());
			
			
			PreparedStatement pst3;
			query3 ="select * from products where id= ?;";
			pst3 = this.con.prepareStatement(query3);
			pst3.setInt(1, bill.getPid());
			rs = pst3.executeQuery();
			
			while(rs.next()) {
				bill.setPdtname(rs.getString("pdtname"));
				bill.setPdtcategory(rs.getString("category"));
				bill.setPdtprice(rs.getInt("price"));;
				
			}
			
			
			bill2.setPdtname(bill.getPdtname());
			bill2.setPdtcategory(bill.getPdtcategory());
			bill2.setPdtprice(bill.getPdtprice());
			
			
			return bill2;
		
		
		
		
		
		
	}
}
