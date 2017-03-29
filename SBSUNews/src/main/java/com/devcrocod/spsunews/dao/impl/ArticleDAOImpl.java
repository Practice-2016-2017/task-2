package com.devcrocod.spsunews.dao.impl;

import com.devcrocod.spsunews.dao.interfaces.ArticleDAO;
import com.devcrocod.spsunews.entities.Article;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Component
public class ArticleDAOImpl implements ArticleDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private List<Article> articles;

    @Transactional
    @Override
    public List<Article> getArticle() {

        articles = (List<Article>) sessionFactory.getCurrentSession()
                .createCriteria(Article.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return articles;
    }

    @Override
    public List<Article> getArticle(String name) {
        return null;
    }

    @Override
    public List<Article> getArticle(Date date) {
        return null;
    }
}
