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

    /**
     * Sets ArticleDAO and puts articles from db into list
     *
     * @param articleDAO to be set
     */
    public void setArticleDAO(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
        articles = articleDAO.getArticles();
    }

    /**
     * Gets list of articles
     *
     * @return articles
     */
    public List<Article> getArticles() {
        return articles;
    }

    /**
     * Chooses type of search and searches articles
     *
     */
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
