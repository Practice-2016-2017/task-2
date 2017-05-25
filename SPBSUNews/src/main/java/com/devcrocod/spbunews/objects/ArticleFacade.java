package com.devcrocod.spbunews.objects;

import com.devcrocod.spbunews.dao.interfaces.ArticleDAO;
import com.devcrocod.spbunews.entities.Article;
import com.devcrocod.spbunews.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("articleFacade")
@Scope("singleton")
public class ArticleFacade {

    @Autowired
    private ArticleDAO articleDAO;

    @Autowired
    private SearchCriteria searchCriteria;


    private List<Article> articles;


    public void setArticleDAO(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
        articles = articleDAO.getArticles();
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void searchArticleByText() {
        switch (searchCriteria.getSearchType()) {
            case TITLE:
                articles = articleDAO.getArticles(searchCriteria.getText());
                break;
            case EDITOR:
                articles = articleDAO.getArticles(new User(searchCriteria.getText()));
                break;
            case DATE:
                articles = articleDAO.getArticles(searchCriteria.getDate());
                break;
        }
    }
}
