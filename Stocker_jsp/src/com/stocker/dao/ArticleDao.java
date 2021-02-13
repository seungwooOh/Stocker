package com.stocker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.stocker.dto.ArticleDto;
import com.stocker.model.Article;
import com.stocker.utils.DbUtils;

public class ArticleDao {
	
	public static ArticleDto select(ArticleDto param) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT "
				+ "title, caption, regdate, file_nm ,nm AS author_nm "
				+ "FROM t_article AS a "
				+ "JOIN t_user AS u "
				+ "ON a.author_id = u.id "
				+ "WHERE a.id = ?";
		
		try {
			conn = DbUtils.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, param.getId());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				ArticleDto dto = new ArticleDto();
				
				dto.setId(param.getId());
				dto.setTitle(rs.getString("title"));
				dto.setCaption(rs.getString("caption"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setFile_nm(rs.getString("file_nm"));
				dto.setAuthor_nm(rs.getString("author_nm"));
				
				return dto;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(conn, ps, rs);
		}
		
		
		return null;
	}
	
	public static List<ArticleDto> selectAll() {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select a.id, title, nm as author_nm, file_nm from t_article as a join t_user as u on author_id = u.id order by regdate desc;";
		
		try {
			conn = DbUtils.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			List<ArticleDto> list = new ArrayList<ArticleDto>();
			
			while(rs.next()) {
//				System.out.println(rs.getInt("id"));
//				System.out.println(rs.getString("title"));
//				System.out.println(rs.getString("author_nm"));				
//				System.out.println(rs.getString("file_nm"));
				
				ArticleDto dto = new ArticleDto();
				
				dto.setId(rs.getInt("id"));
				dto.setTitle(rs.getString("title"));
				dto.setAuthor_nm(rs.getString("author_nm"));
				dto.setFile_nm(rs.getString("file_nm"));

				list.add(dto);
			}
			
			return list;
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(conn, ps, rs);
		}
		
		return null;
	}
	
}
