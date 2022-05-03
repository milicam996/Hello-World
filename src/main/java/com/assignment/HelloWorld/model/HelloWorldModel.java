package com.assignment.HelloWorld.model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_hello_world")

public class HelloWorldModel {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String lang;

    @Column
    private String hw_translation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getHw_translation() {
        return hw_translation;
    }

    public void setHw_translation(String hw_translation) {
        this.hw_translation = hw_translation;
    }
}
