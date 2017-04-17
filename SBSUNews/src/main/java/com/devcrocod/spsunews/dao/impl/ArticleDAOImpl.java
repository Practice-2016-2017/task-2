package com.devcrocod.spsunews.dao.impl;

import com.devcrocod.spsunews.dao.interfaces.ArticleDAO;
import com.devcrocod.spsunews.entities.Article;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Component
public class ArticleDAOImpl implements ArticleDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private ProjectionList articleProjection;

    public ArticleDAOImpl() {
        articleProjection = Projections.projectionList();
        articleProjection.add(Projections.property("idArticle"),"idArticle");
        articleProjection.add(Projections.property("title"),"title");
        articleProjection.add(Projections.property("date"),"date");
        articleProjection.add(Projections.property("image"),"image");
        articleProjection.add(Projections.property("valueSum"),"valueSum");
        articleProjection.add(Projections.property("editorArticleId"),"editorArticleId");
        articleProjection.add(Projections.property("commentArticleId"),"commentArticleId");
    }

    @Transactional
    @Override
    public List<Article> getArticle() {

        DetachedCriteria articleListCriteria = DetachedCriteria.forClass(Article.class, "a");
        createAliases(articleListCriteria);

        List<Article> articles = createArticleList(articleListCriteria);

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

    private void createAliases(DetachedCriteria criteria) {
        criteria.createAlias("b.editorArticleId", "editor");
        criteria.createAlias("b.commentArticleId", "comment");
    }

    private List<Article> createArticleList(DetachedCriteria articleListCriteria) {
        Criteria criteria = articleListCriteria.getExecutableCriteria(sessionFactory.getCurrentSession());
        criteria.addOrder(Order.asc("a.title"))
                .setProjection(articleProjection)
                .setResultTransformer(Transformers.aliasToBean(Article.class));
        return criteria.list();
    }
}
