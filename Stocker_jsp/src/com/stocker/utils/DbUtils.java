package com.stocker.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbUtils {
	
	public static Connection getConn() throws Exception {		
		final String URL = "jdbc:mysql://localhost/stocker?serverTimezone=UTC";
		final String USER = "root";
		final String PW = "ehxhfl12";
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		
		Class.forName(DRIVER);
		
		Connection conn = DriverManager.getConnection(URL, USER, PW);
		
		System.out.println("getConn() success");
		
		return conn;
	}
	
	public static void close(Connection conn, PreparedStatement ps){
		if(ps != null) {
			try { ps.close(); } catch (Exception e) {}
		}
		
		if(conn != null) {
			try { conn.close(); } catch (Exception e) {}
		}
	}
	
	public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		if(rs != null) {
			try { rs.close(); } catch (Exception e) {}
		}
		close(conn, ps);
	}
	
}
