package com.devcrocod.spsunews.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;


@Entity
public class Like {
    private int idLike;
    private Integer articleLikeId;
    private Integer userLikeId;

    @Id
    @Column(name = "id_like")
    public int getIdLike() {
        return idLike;
    }

    public void setIdLike(int idLike) {
        this.idLike = idLike;
    }

//    @ManyToOne
    @JoinColumn(name = "article_like_id")
    public Integer getArticleLikeId() {
        return articleLikeId;
    }

    public void setArticleLikeId(Integer articleLikeId) {
        this.articleLikeId = articleLikeId;
    }

//    @ManyToOne
    @JoinColumn(name = "user_like_id")
    public Integer getUserLikeId() {
        return userLikeId;
    }

    public void setUserLikeId(Integer userLikeId) {
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
