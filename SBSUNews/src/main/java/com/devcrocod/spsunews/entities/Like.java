package com.devcrocod.spsunews.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;


@Entity
public class Like {
    private int idLike;
    private byte[] value;

    @Id
    @Column(name = "id_like")
    public int getIdLike() {
        return idLike;
    }

    public void setIdLike(int idLike) {
        this.idLike = idLike;
    }

    @Basic
    @Column(name = "value")
    public byte[] getValue() {
        return value;
    }

    public void setValue(byte[] value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Like like = (Like) o;

        if (idLike != like.idLike) return false;
        if (!Arrays.equals(value, like.value)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idLike;
        result = 31 * result + Arrays.hashCode(value);
        return result;
    }
}
