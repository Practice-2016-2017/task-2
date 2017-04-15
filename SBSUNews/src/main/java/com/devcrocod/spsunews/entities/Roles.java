package com.devcrocod.spsunews.entities;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Roles {
    private int idRoles;
    private String userRole;

    @Id
    @Column(name = "id_roles")
    public int getIdRoles() {
        return idRoles;
    }

    public void setIdRoles(int idRoles) {
        this.idRoles = idRoles;
    }

    @Basic
    @Column(name = "user_role")
    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
