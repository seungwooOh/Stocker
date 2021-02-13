package com.stocker.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.stocker.utils.DbUtils;

public class DbUtils_test {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DbUtils.getConn();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				DbUtils.close(conn, ps, rs);
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		}
		
	}
}
