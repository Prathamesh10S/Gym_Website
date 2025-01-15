package com.royal_gym;

import java.sql.Connection;
import java.sql.DriverManager;

public class db_con {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_website", "root", "Pratham@10");
		} catch (Exception e) {
			System.err.println("Database connection error: " + e.getMessage());
			e.printStackTrace();
		}
		return con;
	}
}
