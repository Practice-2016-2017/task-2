package com.devcrocod.spbunews.dao.interfaces;


import com.devcrocod.spbunews.entities.Article;
import com.devcrocod.spbunews.entities.User;

import java.util.Date;
import java.util.List;

public interface ArticleDAO {

    List<Article> getArticles();
    List<Article> getArticles(String title);
    List<Article> getArticles(Date date);
    List<Article> getArticles(User editor);
}
