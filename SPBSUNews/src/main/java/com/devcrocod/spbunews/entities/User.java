package com.devcrocod.spbunews.entities;

import javax.persistence.*;


@Entity
public class User {
    private int idUser;
    private String name;
    private String lastName;
    private String password;
    private Comment commentUserId;
    private Like likeUserId;
    private Roles roles;

    public User() {
    }

    public User(int idUser, String name, String lastName, String password, Comment commentUserId, Like likeUserId, Roles roles) {
        this.idUser = idUser;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.commentUserId = commentUserId;
        this.likeUserId = likeUserId;
        this.roles = roles;
    }

    @Id
    @Column(name = "id_user")
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToOne
    @JoinColumn(name = "comment_user_id")
    public Comment getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(Comment commentUserId) {
        this.commentUserId = commentUserId;
    }

    @ManyToOne
    @JoinColumn(name = "like_user_id")
    public Like getLikeUserId() {
        return likeUserId;
    }

    public void setLikeUserId(Like likeUserId) {
        this.likeUserId = likeUserId;
    }

    @OneToOne
    @JoinColumn(name = "roles")
    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (idUser != user.idUser) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (commentUserId != null ? !commentUserId.equals(user.commentUserId) : user.commentUserId != null) return false;
        if (likeUserId != null ? !likeUserId.equals(user.likeUserId) : user.likeUserId != null) return false;
        if (roles != null ? !roles.equals(user.roles) : user.roles != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (commentUserId != null ? commentUserId.hashCode() : 0);
        result = 31 * result + (likeUserId != null ? likeUserId.hashCode() : 0);
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        return result;
    }
}
