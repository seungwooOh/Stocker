package com.stocker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.stocker.model.User;
import com.stocker.utils.DbUtils;

public class UserDao {

	public static User select(User dto) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT id, email, nm FROM t_user WHERE email = ?  AND pw = ?";

		try {
			conn = DbUtils.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getEmail());
			ps.setString(2, dto.getPw());
			rs = ps.executeQuery();

			if (rs.next()) {
				User data = new User();

				data.setId(rs.getInt("id"));
				data.setEmail(rs.getString("email"));
				data.setNm(rs.getString("nm"));

				return data;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(conn, ps, rs);
		}

		return null;
	}

	public static int insert(User dto) {

		Connection conn = null;
		PreparedStatement ps = null;

		String sql = "INSERT INTO t_user (email, nm, pw) VALUES (?, ?, ?)";

		try {
			conn = DbUtils.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getEmail());
			ps.setString(2, dto.getNm());
			ps.setString(3, dto.getPw());

			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(conn, ps);
		}

		return 0;
	}

	public static int update(User dto) {

		Connection conn = null;
		PreparedStatement ps = null;

		String sql = "UPDATE t_user SET nm = ? WHERE id = ?";

		try {
			conn = DbUtils.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getNm());
			ps.setInt(2, dto.getId());

			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(conn, ps);
		}

		return 0;
	}

	public static int delete(User dto) {

		Connection conn = null;
		PreparedStatement ps = null;

		String sql = "DELETE FROM t_user WHERE id = ?";

		try {
			conn = DbUtils.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dto.getId());
			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(conn, ps);
		}

		return 0;
	}

}
