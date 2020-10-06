package com.bij.mymoneymanager.model;

import com.bij.mymoneymanager.enumeration.SingleEntryType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import javax.persistence.*;

@Entity
public @Data class SingleEntry {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id ;
    private float value ;
    @Enumerated(EnumType.STRING)
    private SingleEntryType type;
    @ManyToOne
    @JoinColumn(nullable=false)
    //@JsonBackReference
    private Category category;
    @ManyToOne
    @JoinColumn(nullable=false)
    //@JsonBackReference
    private DayEntry dayEntry;
}
