package com.devcrocod.spbunews.dao.impl;

import com.devcrocod.spbunews.dao.interfaces.ArticleDAO;
import com.devcrocod.spbunews.entities.Article;
import com.devcrocod.spbunews.entities.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
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
    public List<Article> getArticles() {
        List<Article> articles = createArticleList(createArticleCriteria());
        return articles;
    }

    @Transactional
    @Override
    public List<Article> getArticles(User editor) {
        List<Article> articles = createArticleList(createArticleCriteria()
                .add(Restrictions.ilike("user.name", editor.getName(), MatchMode.ANYWHERE)));
        return articles;
    }

    @Transactional
    @Override
    public List<Article> getArticles(String title) {
        List<Article> articles = createArticleList(createArticleCriteria()
                .add(Restrictions.ilike("a.title", title, MatchMode.ANYWHERE)));
        return articles;
    }

    @Transactional
    @Override
    public List<Article> getArticles(Date date) {
        List<Article> articles = createArticleList(createArticleCriteria()
                .add(Restrictions.ilike("a.date", date.toString(), MatchMode.ANYWHERE)));
        return articles;
    }

    @Override
    public void addArticle(String text, User edId, String title, java.sql.Date date) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Article article = new Article();
        article.setContent(text);
        article.setEditorArticleId(edId);
        article.setTitle(title);
        article.setDate(date);
        session.saveOrUpdate(article);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void editArticle(Article article) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(article);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void removeArticle(Article article) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(article);
        session.getTransaction().commit();
        session.close();
    }

    private DetachedCriteria createArticleCriteria() {
        DetachedCriteria articleListCriteria = DetachedCriteria.forClass(Article.class, "a");
        createAliases(articleListCriteria);
        return articleListCriteria;
    }

    private void createAliases(DetachedCriteria criteria) {
        criteria.createAlias("a.editorArticleId", "user");
    }

    private List<Article> createArticleList(DetachedCriteria articleListCriteria) {
        Criteria criteria = articleListCriteria.getExecutableCriteria(sessionFactory.getCurrentSession());
        criteria.addOrder(Order.asc("a.title"))
                .setProjection(articleProjection)
                .setResultTransformer(Transformers.aliasToBean(Article.class));
        return criteria.list();
    }
}
