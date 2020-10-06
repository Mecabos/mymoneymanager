package com.bij.mymoneymanager.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
public @Data class Category {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String name;
    private String color ="cc8282";
    @OneToMany(mappedBy = "category")
    //@JsonManagedReference
    private List<SingleEntry> singleEntryList;
}
