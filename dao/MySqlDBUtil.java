package com.trm.winecellar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDBUtil {
	
	private static String connectionUrl = "jdbc:mysql://localhost:3306/winecellar?" + "user=root&password=StrongPassword";
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(connectionUrl);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void main(String[] args) {
		Connection connection = MySqlDBUtil.getConnection();
		if(null != connection) {
			System.out.println("connection was made");
		} else {
			System.out.println("Uh oh - no connection!");
		}

	}

}
