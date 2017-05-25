package com.devcrocod.spbunews.entities;

import javax.persistence.*;
import java.sql.Date;

/**
 *  This class describes comments
 * 
 */
@Entity
@Table(name = "comment")
public class Comment {
    private int idComment;
    private Date date;
    private String text;
    private Article articleCommentId;
    private User userCommentId;

    /**
     *
     */
    public Comment() {
    }

    /**
     * Initiates a comment
     * 
     * @param idComment
     * @param date
     * @param text
     * @param articleCommentId
     * @param userCommentId
     */
    public Comment(int idComment, Date date, String text, Article articleCommentId, User userCommentId) {
        this.idComment = idComment;
        this.date = date;
        this.text = text;
        this.articleCommentId = articleCommentId;
        this.userCommentId = userCommentId;
    }

    /**
     * Gets comment id 
     * 
     * @return idComment
     */
    @Id
    @Column(name = "id_comment")
    public int getIdComment() {
        return idComment;
    }

    /**
     * Sets comment id
     *
     * @param idComment to set
     */
    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }

    /**
     * Gets comment date
     *
     * @return date
     */
    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    /**
     * Sets comment date
     * 
     * @param date to be set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets comment text
     *
     * @return text
     */
    @Basic
    @Column(name = "text")
    public String getText() {
        return text;
    }

    /**
     * Sets comment text
     *
     * @param text to be set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Gets article id in which comment is located
     *
     * @return articleCommentId
     */
    @ManyToOne
    @JoinColumn(name = "article_comment_id")
    public Article getArticleCommentId() {
        return articleCommentId;
    }

    /**
     * Sets article id in which comment is located
     *
     * @param articleCommentId to be st
     */
    public void setArticleCommentId(Article articleCommentId) {
        this.articleCommentId = articleCommentId;
    }

    /**
     * Gets commentator id
     *
     * @return userCommentId
     */
    @ManyToOne
    @JoinColumn(name = "user_comment_id")
    public User getUserCommentId() {
        return userCommentId;
    }

    /**
     * Sets commentator id
     *
     * @param userCommentId to be set
     */
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
