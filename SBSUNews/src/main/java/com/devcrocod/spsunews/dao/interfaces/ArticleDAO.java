package com.devcrocod.spsunews.dao.interfaces;


import com.devcrocod.spsunews.entities.Article;
import com.devcrocod.spsunews.entities.User;

import java.util.Date;
import java.util.List;

public interface ArticleDAO {

    List<Article> getArticle();
    List<Article> getArticle(String title);
    List<Article> getArticle(Date date);
    List<Article> getArticle(User editor);
}
