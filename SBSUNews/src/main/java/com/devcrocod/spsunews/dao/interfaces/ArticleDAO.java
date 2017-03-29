package com.devcrocod.spsunews.dao.interfaces;


import com.devcrocod.spsunews.entities.Article;

import java.util.Date;
import java.util.List;

public interface ArticleDAO {

    List<Article> getArticle();
    List<Article> getArticle(String name);
    List<Article> getArticle(Date date);
}
