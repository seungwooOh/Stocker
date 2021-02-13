package com.stocker.test;

import java.util.List;

import com.stocker.dao.ArticleDao;
import com.stocker.dao.UserDao;
import com.stocker.dto.ArticleDto;
import com.stocker.model.Article;
import com.stocker.model.User;

public class ArticleDao_test {

	public static void main(String[] args) {
		
//		ArticleDto aDto = new ArticleDto();
//		aDto.setId(3);
//		
//		ArticleDto article = ArticleDao.select(aDto);
//		System.out.println("Title : " + article);
		
//		List<ArticleDto> list = ArticleDao.selectAll();
//		
//		for(ArticleDto dto : list) {
//			System.out.println(dto);
//		}
		
		
		User user = new User();
		user.setEmail("ss");
		user.setPw("ss");
		User udao = UserDao.select(user);
		System.out.println(udao.getPw());
	}

}
