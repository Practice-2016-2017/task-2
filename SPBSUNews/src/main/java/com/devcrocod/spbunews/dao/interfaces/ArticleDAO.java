package com.devcrocod.spbunews.dao.interfaces;


import com.devcrocod.spbunews.entities.Article;
import com.devcrocod.spbunews.entities.User;

import java.util.Date;
import java.util.List;

public interface ArticleDAO {

    List<Article> getArticle();
    List<Article> getArticle(String title);
    List<Article> getArticle(Date date);
    List<Article> getArticle(User editor);
}
