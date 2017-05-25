package com.devcrocod.spbunews.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Arrays;


@Entity
@Table(name ="article")
public class Article {
    private Integer idArticle;
    private String title;
    private Date date;
    private String content;
    private byte[] image;
    private Integer valueSum;
    private User editorArticleId;
    private Comment commentArticleId;

    public Article() {

    }

    public Article(int idArticle, String title, Date date, String content, byte[] image, Integer valueSum, User editorArticleId, Comment commentArticleId) {
        this.idArticle = idArticle;
        this.title = title;
        this.date = date;
        this.content = content;
        this.image = image;
        this.valueSum = valueSum;
        this.editorArticleId = editorArticleId;
        this.commentArticleId = commentArticleId;
    }

    @Id
    @Column(name = "id_article")
    public Integer getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Integer idArticle) {
        this.idArticle = idArticle;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "image")
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Basic
    @Column(name = "value_sum")
    public Integer getValueSum() {
        return valueSum;
    }

    public void setValueSum(Integer valueSum) {
        this.valueSum = valueSum;
    }

    @ManyToOne
    @JoinColumn(name = "editor_article_id")
    public User getEditorArticleId() {
        return editorArticleId;
    }

    public void setEditorArticleId(User editorArticleId) {
        this.editorArticleId = editorArticleId;
    }

    @ManyToOne
    @JoinColumn(name = "comment_article_id")
    public Comment getCommentArticleId() {
        return commentArticleId;
    }

    public void setCommentArticleId(Comment commentArticleId) {
        this.commentArticleId = commentArticleId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        if (idArticle != article.idArticle) return false;
        if (title != null ? !title.equals(article.title) : article.title != null) return false;
        if (date != null ? !date.equals(article.date) : article.date != null) return false;
        if (content != null ? !content.equals(article.content) : article.content != null) return false;
        if (!Arrays.equals(image, article.image)) return false;
        if (valueSum != null ? !valueSum.equals(article.valueSum) : article.valueSum != null) return false;
        if (editorArticleId != article.editorArticleId) return false;
        if (commentArticleId != null ? commentArticleId.equals(article.commentArticleId) : article.commentArticleId != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = idArticle.hashCode();
//        result = 31 * result + title.hashCode();
//        result = 31 * result + date.hashCode();
//        result = 31 * result + content.hashCode();
////        result = 31 * result + Arrays.hashCode(image);
////        result = 31 * result + valueSum.hashCode();
//        result = 31 * result + editorArticleId.hashCode();
//        result = 31 * result + commentArticleId.hashCode();
        return result;
    }
}
