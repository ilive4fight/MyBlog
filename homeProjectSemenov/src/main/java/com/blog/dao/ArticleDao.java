package com.blog.dao;

import com.blog.model.Article;

import java.util.List;

/**
 * Created by semen on 14.04.2016.
 */
public interface ArticleDao {

    Article findById(int id);

    void saveArticle(Article article);

    List<Article> getAllArticles();

    void deleteArticle(Article article);

}
