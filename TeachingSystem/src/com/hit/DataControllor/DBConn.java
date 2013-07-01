package com.hit.DataControllor;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConn {
	private static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String dbURL = "jdbc:sqlserver://localhost:1433;database=";
	private static String username = "sa";
	private static String password = "123456";
	private static Connection con = null;
	private static Statement st = null;
	
	public static Connection getConnection(){
		String database = "TeachingDB";
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(dbURL + database, username,
					password);
			st = con.createStatement();
			return con;
		} catch (Exception e) {
			e.printStackTrace();
			return con;
		}
	}
	
}
