package com.devcrocod.spsunews.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Arrays;


@Entity
public class Article {
    private int idArticle;
    private String name;
    private Date date;
    private Integer like;
    private String content;
    private byte[] image;
    private Integer valueSum;

    @Id
    @Column(name = "id_article")
    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "like")
    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        if (idArticle != article.idArticle) return false;
        if (name != null ? !name.equals(article.name) : article.name != null) return false;
        if (date != null ? !date.equals(article.date) : article.date != null) return false;
        if (like != null ? !like.equals(article.like) : article.like != null) return false;
        if (content != null ? !content.equals(article.content) : article.content != null) return false;
        if (!Arrays.equals(image, article.image)) return false;
        if (valueSum != null ? !valueSum.equals(article.valueSum) : article.valueSum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idArticle;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (like != null ? like.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(image);
        result = 31 * result + (valueSum != null ? valueSum.hashCode() : 0);
        return result;
    }
}
