package com.bij.mymoneymanager.model;

import com.bij.mymoneymanager.enumeration.CategoryName;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String name;
    private String color ="cc8282";

    public Category() {
    }

    public Category(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
