package com.devcrocod.spsunews.entities;

import javax.persistence.*;
import java.sql.Date;


@Entity
public class Comment {
    private int idComment;
    private Date date;
    private String text;
    private Integer articleCommentId;
    private Integer userCommentId;

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

    //    @ManyToOne
    @JoinColumn(name = "article_comment_id")
    public Integer getArticleCommentId() {
        return articleCommentId;
    }

    public void setArticleCommentId(Integer articleCommentId) {
        this.articleCommentId = articleCommentId;
    }

    //    @ManyToOne
    @JoinColumn(name = "user_comment_id")
    public Integer getUserCommentId() {
        return userCommentId;
    }

    public void setUserCommentId(Integer userCommentId) {
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
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + articleCommentId.hashCode();
        result = 31 * result + userCommentId.hashCode();
        return result;
    }
}
