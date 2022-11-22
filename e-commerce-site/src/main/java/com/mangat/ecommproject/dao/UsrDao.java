package com.mangat.ecommproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mangat.ecommproject.model.User;

public class UsrDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public UsrDao(Connection con) {
		
		this.con = con;
	}
	
	public User userlogin(String usremail,String passwrd) {
		User user = null;
		try {
			query = "select * from users where usremail=? and passwrd=?";
			
			pst = this.con.prepareStatement(query);
			pst.setString(1, usremail);
			pst.setString(2, passwrd);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsrname(rs.getString("usrname"));
				user.setUsremail(rs.getString("usremail"));
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
		
	}
	public User getSingleUser(int id) {
		User user = null;
		try {
			query = "select * from users where id=?";
			
			pst = this.con.prepareStatement(query);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsrname(rs.getString("usrname"));
				user.setUsremail(rs.getString("usremail"));
				user.setAddress("Address");
				user.setPhonenumber("PhoneNumber");
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
		
	}
}
