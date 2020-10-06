package com.bij.mymoneymanager.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public @Data
class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id ;
    @Column(unique = true)
    private String username;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<DayEntry> dayEntryList;
    @ManyToMany
    private Set<Role> roleSet;

}
