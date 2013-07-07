package com.hit.DataControllor;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBControllor {
	private static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String dbURL = "jdbc:sqlserver://localhost:1433;database=";
	private static String username = "sa";
	private static String password = "123456";
	private static Connection con = null;
	private static Statement st = null;
	private static boolean connected = false;

	public static boolean connctTo(String database) {
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(dbURL + database, username,
					password);
			st = con.createStatement();
			// com.Bean.User dUser = new com.Bean.User();
			connected = true;
			return true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		// return true;
	}
//查询语句
	public static ResultSet excuteQuery(String sql) {
		try {
			ResultSet rs;
			Statement st = con.createStatement();
			rs = st.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			printError("DBControllor.excuteQuery异常");
			return null;
		}
	}
//更新数据库
	public static boolean excuteUpdate(String sql) {
		try {
			st.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			printError("DBControllor.excuteUpdate异常");
			return false;
		}
	}

//	public static ResultSet exec_proc(String sql,String... values) {
//		try {
//			CallableStatement statement = con.prepareCall(sql);
//			for(int i=0; i<values.length; i++)
//				statement.setString(i+1, values[i]);
//			statement.execute();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			printError("exec_proc出错");
//		}
//		
//		return null;
//	}

	public static boolean isConnected() {
		return connected;
	}

	private static void printError(String s) {
		System.out.println(s);
	}
}
