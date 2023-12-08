package com.jdbc.cfg;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class JdbcConnection {
	public static Connection getConnection() {

		String userName = "root";
		String password = "placeholder";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("step 1");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/rentalshopDB",
							userName, password);
			System.out.println("step 2");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
}