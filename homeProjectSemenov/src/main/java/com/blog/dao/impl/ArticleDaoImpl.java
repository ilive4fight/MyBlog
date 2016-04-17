package com.blog.dao.impl;

import com.blog.dao.AbstractDao;
import com.blog.dao.ArticleDao;
import com.blog.model.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by semen on 14.04.2016.
 */
@Repository("articleDao")
public class ArticleDaoImpl extends AbstractDao<Integer,Article> implements ArticleDao {
    @Override
    public Article findById(int id) {
        return findById(id);
    }

    @Override
    public void saveArticle(Article article) {
       persist(article);
    }

    @Override
    public List<Article> getAllArticles() {
        return getAll(Article.class);
    }

    @Override
    public void deleteArticle(Article article) {
        delete(article);
    }
}
