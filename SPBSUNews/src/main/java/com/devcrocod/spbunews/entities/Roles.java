package com.devcrocod.spbunews.entities;

import javax.persistence.*;

/**
 * This class describes roles
 * 
 */
@Entity
@Table(name = "roles")
public class Roles {
    private int idRoles;
    private String userRole;

    /**
     *
     */
    public Roles() {
    }

    /**
     * Initiates role
     *
     * @param idRoles
     * @param userRole
     */
    public Roles(int idRoles, String userRole) {
        this.idRoles = idRoles;
        this.userRole = userRole;
    }

    /**
     * Gets role id
     *
     * @return idRoles
     */
    @Id
    @Column(name = "id_roles")
    public int getIdRoles() {
        return idRoles;
    }

    /**
     * Sets role id
     * 
     * @param idRoles to be set
     */
    public void setIdRoles(int idRoles) {
        this.idRoles = idRoles;
    }

    /**
     * Gets user role
     *
     * @return userRole
     */
    @Basic
    @Column(name = "user_role")
    public String getUserRole() {
        return userRole;
    }

    /**
     * Sets user role
     *
     * @param userRole to be set
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
