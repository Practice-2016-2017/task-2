package com.devcrocod.spbunews.objects;

import com.devcrocod.spbunews.dao.interfaces.ArticleDAO;
import com.devcrocod.spbunews.entities.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleFacade {

    private ArticleDAO articleDAO;
    private List<Article> articles;

    @Autowired
    public void setArticleDAO(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
        articles = articleDAO.getArticles();
    }

    public List<Article> getArticles() {
        return articles;
    }
}
