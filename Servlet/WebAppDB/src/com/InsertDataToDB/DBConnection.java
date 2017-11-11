package com.InsertDataToDB;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBConnection {
	static Connection con=null;

	static Connection dbConnection() throws SQLException{
		
		// 1. Load The Driver
		Driver d = new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		// 2. Get DB connection via Driver
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ekart?user=root&password=yasir");
		
		return con;
	}
}
