package com.vnet.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vnet.pojo.Article;

@Repository
public interface ArticleDao {

	public List<Article> findAllArticle();

}
