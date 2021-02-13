package com.stocker.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stocker.dao.ArticleDao;
import com.stocker.dto.ArticleDto;

@WebServlet("/article")
public class Article extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArticleDto aDto_id = new ArticleDto();
		String id = request.getParameter("id");
		
		aDto_id.setId(Integer.parseInt(id));
		ArticleDto dto = ArticleDao.select(aDto_id);
		
		System.out.println(aDto_id);
		System.out.println(dto);
		
		
		ObjectMapper mapper = new ObjectMapper();
//		String json = "{\"title\": \""+ dto.getTitle() +"\"}";	objectmapper가 자동으로 변경해줌
		String json = mapper.writeValueAsString(dto);
		
		response.setContentType("application/json");
		response.getWriter().print(json);
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
