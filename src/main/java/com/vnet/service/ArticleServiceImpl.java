package com.vnet.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.vnet.dao.ArticleDao;
import com.vnet.pojo.Article;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Resource
	private ArticleDao articleDao;

	public List<Article> findAllArticle() {
		return articleDao.findAllArticle();
	}

}
