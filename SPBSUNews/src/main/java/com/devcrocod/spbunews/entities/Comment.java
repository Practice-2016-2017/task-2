package com.devcrocod.spbunews.entities;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "comment")
public class Comment {
    private int idComment;
    private Date date;
    private String text;
    private Article articleCommentId;
    private User userCommentId;

    public Comment() {
    }

    public Comment(int idComment, Date date, String text, Article articleCommentId, User userCommentId) {
        this.idComment = idComment;
        this.date = date;
        this.text = text;
        this.articleCommentId = articleCommentId;
        this.userCommentId = userCommentId;
    }

    @Id
    @Column(name = "id_comment")
    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
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
    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @ManyToOne
    @JoinColumn(name = "article_comment_id")
    public Article getArticleCommentId() {
        return articleCommentId;
    }

    public void setArticleCommentId(Article articleCommentId) {
        this.articleCommentId = articleCommentId;
    }

    @ManyToOne
    @JoinColumn(name = "user_comment_id")
    public User getUserCommentId() {
        return userCommentId;
    }

    public void setUserCommentId(User userCommentId) {
        this.userCommentId = userCommentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (idComment != comment.idComment) return false;

        if (date != null ? !date.equals(comment.date) : comment.date != null) return false;
        if (text != null ? !text.equals(comment.text) : comment.text != null) return false;
        if (!articleCommentId.equals(comment.articleCommentId)) return false;
        if (!userCommentId.equals(comment.userCommentId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idComment;
//        result = 31 * result + date.hashCode();
//        result = 31 * result + text.hashCode();
//        result = 31 * result + articleCommentId.hashCode();
//        result = 31 * result + userCommentId.hashCode();
        return result;
    }
}
