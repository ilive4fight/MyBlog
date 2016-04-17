package com.blog.service.impl;

import com.blog.dao.ArticleDao;
import com.blog.model.Article;
import com.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by semen on 14.04.2016.
 */
@Transactional
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDao articleDao;

    @Override
    public Article findById(int id) {
        return articleDao.findById(id);
    }

    @Override
    public void saveArticle(Article article) {
        articleDao.saveArticle(article);
    }

    @Override
    public List<Article> getAllArticles() {
        return articleDao.getAllArticles();
    }

    @Override
    public void deleteArticle(Article article) {
        articleDao.deleteArticle(article);
    }
}
