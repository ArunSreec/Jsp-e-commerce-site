package com.mangat.ecommproject.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DdConn {
	private static Connection connection = null;

	public static Connection getConnection() {
		
		if(connection == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mangatstore", "root", "mysqlroot");
			} catch (Exception e) {
					
				e.printStackTrace();
			}

			
		}
		return connection;
	}
}
