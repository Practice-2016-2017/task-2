package com.devcrocod.spsunews.dao.impl;

import com.devcrocod.spsunews.dao.interfaces.ArticleDAO;
import com.devcrocod.spsunews.entities.Article;
import com.devcrocod.spsunews.entities.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
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
        articleProjection.add(Projections.property("idArticle"), "idArticle");
        articleProjection.add(Projections.property("title"), "title");
        articleProjection.add(Projections.property("date"), "date");
        articleProjection.add(Projections.property("image"), "image");
        articleProjection.add(Projections.property("valueSum"), "valueSum");
        articleProjection.add(Projections.property("editorArticleId"), "editorArticleId");
        articleProjection.add(Projections.property("commentArticleId"), "commentArticleId");
    }

    @Transactional
    @Override
    public List<Article> getArticle() {
        List<Article> articles = createArticleList(createArticleCriteria());
        return articles;
    }

    @Transactional
    @Override
    public List<Article> getArticle(User editor) {
        List<Article> articles = createArticleList(createArticleCriteria()
                .add(Restrictions.ilike("editor.name", editor.getName(), MatchMode.ANYWHERE)));
        return articles;
    }

    @Transactional
    @Override
    public List<Article> getArticle(String title) {
        List<Article> articles = createArticleList(createArticleCriteria()
                .add(Restrictions.ilike("a.title", title, MatchMode.ANYWHERE)));
        return articles;
    }

    @Transactional
    @Override
    public List<Article> getArticle(Date date) {
        List<Article> articles = createArticleList(createArticleCriteria()
                .add(Restrictions.ilike("date", date.toString(), MatchMode.ANYWHERE)));
        return articles;
    }

    private DetachedCriteria createArticleCriteria() {
        DetachedCriteria articleListCriteria = DetachedCriteria.forClass(Article.class, "a");
        createAliases(articleListCriteria);
        return articleListCriteria;
    }

    private void createAliases(DetachedCriteria criteria) {
        criteria.createAlias("a.date", "date");
        criteria.createAlias("a.editorArticleId", "editor");
    }

    private List<Article> createArticleList(DetachedCriteria articleListCriteria) {
        Criteria criteria = articleListCriteria.getExecutableCriteria(sessionFactory.getCurrentSession());
        criteria.addOrder(Order.asc("a.title"))
                .setProjection(articleProjection)
                .setResultTransformer(Transformers.aliasToBean(Article.class));
        return criteria.list();
    }
}
