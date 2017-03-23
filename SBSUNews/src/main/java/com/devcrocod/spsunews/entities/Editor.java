package com.devcrocod.spsunews.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Editor {
    private int idEditor;
    private String name;

    @Id
    @Column(name = "id_editor")
    public int getIdEditor() {
        return idEditor;
    }

    public void setIdEditor(int idEditor) {
        this.idEditor = idEditor;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Editor editor = (Editor) o;

        if (idEditor != editor.idEditor) return false;
        if (name != null ? !name.equals(editor.name) : editor.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEditor;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
