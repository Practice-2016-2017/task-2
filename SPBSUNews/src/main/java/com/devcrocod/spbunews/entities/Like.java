package com.devcrocod.spbunews.entities;

import javax.persistence.*;


@Entity
public class Like {
    private int idLike;
    private Article articleLikeId;
    private User userLikeId;

    public Like() {

    }

    public Like(int idLike, Article articleLikeId, User userLikeId) {
        this.idLike = idLike;
        this.articleLikeId = articleLikeId;
        this.userLikeId = userLikeId;
    }

    @Id
    @Column(name = "id_like")
    public int getIdLike() {
        return idLike;
    }

    public void setIdLike(int idLike) {
        this.idLike = idLike;
    }

    @ManyToOne
    @JoinColumn(name = "article_like_id")
    public Article getArticleLikeId() {
        return articleLikeId;
    }

    public void setArticleLikeId(Article articleLikeId) {
        this.articleLikeId = articleLikeId;
    }

    @ManyToOne
    @JoinColumn(name = "user_like_id")
    public User getUserLikeId() {
        return userLikeId;
    }

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
        result = 31 * result + articleLikeId.hashCode();
        result = 31 * result + userLikeId.hashCode();
        return result;
    }
}
