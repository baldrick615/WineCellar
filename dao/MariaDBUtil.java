package com.trm.winecellar.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MariaDBUtil {
	
	private static String connectionUrl = 
			"jdbc:mariadb://localhost:3306/winecellar?user=root&password=StrongPassword";
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(connectionUrl);
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void main(String[] args) throws SQLException {
		Connection conn = MariaDBUtil.getConnection();
		if(null != conn) {
			System.out.println("Connection successful");
			
			DatabaseMetaData metaData = conn.getMetaData();
			ResultSet rs = metaData.getTables(null, null, "%", null);
			
			while (rs.next()) {
				System.out.println(rs.getString("table_name"));
			}
		} else {
			System.out.println("No connection made.");
		}
		
		
		 

	}

}
