package com.devcrocod.spbunews.dao.interfaces;


import com.devcrocod.spbunews.entities.Article;
import com.devcrocod.spbunews.entities.User;

import java.util.Date;
import java.util.List;

public interface ArticleDAO {

    /**
     * Gets all articles
     * 
     * @return articles
     */
    List<Article> getArticles();

    /**
     * Gets all articles with given title
     * 
     * @param title given title
     * @return articles
     */
    List<Article> getArticles(String title);

    /**
     * Gets all articles with given date
     *
     * @param date given date
     * @return articles
     */
    List<Article> getArticles(Date date);

    /**
     * Gets all articles with given editor
     *
     * @param editor given editor
     * @return articles
     */
    List<Article> getArticles(User editor);

    /**
     * Adds new article
     *
     * @param text
     * @param edId
     * @param title
     * @param date
     */
    void addArticle(String text, User edId, String title, java.sql.Date date);

    /**
     * Edits existing article
     *
     * @param article to add
     */
    void editArticle(Article article);

    /**
     * Removes existing article
     *
     * @param article to remove
     */
    public void removeArticle(Article article);
}
