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
}
