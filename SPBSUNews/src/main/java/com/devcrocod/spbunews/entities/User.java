package com.devcrocod.spbunews.entities;

import javax.persistence.*;

/**
 * This class describes user
 * 
 */
@Entity
@Table(name = "user")
public class User {
    private int idUser;
    private String name;
    private String lastName;
    private String password;
    private Comment commentUserId;
    private Like likeUserId;
    private Roles roles;

    /**
     *
     */
    public User() {
    }

    /**
     * Initiates username
     * 
     * @param name
     */
    public User(String name) {
        this.name = name;
    }

    /**
     * Initiates user
     * 
     * @param idUser
     * @param name
     * @param lastName
     * @param password
     * @param commentUserId
     * @param likeUserId
     * @param roles
     */
    public User(int idUser, String name, String lastName, String password, Comment commentUserId, Like likeUserId, Roles roles) {
        this.idUser = idUser;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.commentUserId = commentUserId;
        this.likeUserId = likeUserId;
        this.roles = roles;
    }

    /**
     * Gets user id
     * 
     * @return idUser
     */
    @Id
    @Column(name = "id_user")
    public int getIdUser() {
        return idUser;
    }

    /**
     * Sets user id
     *
     * @param idUser to be set
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    /**
     * Gets user name
     *
     * @return name
     */
    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    /**
     * Sets user name
     *
     * @param name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets user last name
     *
     * @return lastName
     */
    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets user last name
     *
     * @param lastName to be set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets user password
     *
     * @return password
     */
    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    /**
     * Sets user password
     *
     * @param password to be set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets user id from commentator
     *
     * @return commentUserId
     */
    @ManyToOne
    @JoinColumn(name = "comment_user_id")
    public Comment getCommentUserId() {
        return commentUserId;
    }

    /**
     * Sets user id to commentator
     * 
     * @param commentUserId to be set
     */
    public void setCommentUserId(Comment commentUserId) {
        this.commentUserId = commentUserId;
    }

    /**
     * Gets user id from like
     *
     * @return likeUserId
     */
    @ManyToOne
    @JoinColumn(name = "like_user_id")
    public Like getLikeUserId() {
        return likeUserId;
    }

    /**
     * Sets user id to like
     *
     * @param likeUserId to be set
     */
    public void setLikeUserId(Like likeUserId) {
        this.likeUserId = likeUserId;
    }

    /**
     * Gets user role
     * 
     * @return roles
     */
    @OneToOne
    @JoinColumn(name = "roles")
    public Roles getRoles() {
        return roles;
    }

    /**
     * Set user role
     *
     * @param roles to be set
     */
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
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        result = 31 * result + lastName.hashCode();
//        result = 31 * result + password.hashCode();
//        result = 31 * result + commentUserId.hashCode();
//        result = 31 * result + (likeUserId != null ? likeUserId.hashCode() : 0);
//        result = 31 * result + roles.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return name;
    }
}
