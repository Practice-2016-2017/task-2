package com.devcrocod.spbunews.entities;

import javax.persistence.*;

/**
 * This class describes likes
 * 
 */
@Entity
@Table(name = "like")
public class Like {
    private int idLike;
    private Article articleLikeId;
    private User userLikeId;

    /**
     *
     */
    public Like() {

    }

    /**
     * Initiates like
     * 
     * @param idLike
     * @param articleLikeId
     * @param userLikeId
     */
    public Like(int idLike, Article articleLikeId, User userLikeId) {
        this.idLike = idLike;
        this.articleLikeId = articleLikeId;
        this.userLikeId = userLikeId;
    }

    /**
     * Gets like id
     * 
     * @return idLike
     */
    @Id
    @Column(name = "id_like")
    public int getIdLike() {
        return idLike;
    }

    /**
     * Sets like id
     * 
     * @param idLike to be set
     */
    public void setIdLike(int idLike) {
        this.idLike = idLike;
    }

    /**
     * Gets article id that was liked
     *
     * @return articleLikeId
     */
    @ManyToOne
    @JoinColumn(name = "article_like_id")
    public Article getArticleLikeId() {
        return articleLikeId;
    }

    /**
     * Sets article id that was liked
     *
     * @param articleLikeId to be liked
     */
    public void setArticleLikeId(Article articleLikeId) {
        this.articleLikeId = articleLikeId;
    }

    /**
     * Gets user id that was liking
     *
     * @return userLikeId
     */
    @ManyToOne
    @JoinColumn(name = "user_like_id")
    public User getUserLikeId() {
        return userLikeId;
    }

    /**
     * Sets "liker" id
     *
     * @param userLikeId to be set
     */
    public void setUserLikeId(User userLikeId) {
        this.userLikeId = userLikeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Like like = (Like) o;

        if (idLike != like.idLike) return false;
        if (!articleLikeId.equals(like.articleLikeId)) return false;
        if (!userLikeId.equals(like.userLikeId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idLike;
//        result = 31 * result + articleLikeId.hashCode();
//        result = 31 * result + userLikeId.hashCode();
        return result;
    }
}
