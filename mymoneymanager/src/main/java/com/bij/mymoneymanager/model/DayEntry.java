package com.bij.mymoneymanager.model;

import com.bij.mymoneymanager.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public @Data class DayEntry {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    //@DateTimeFormat(pattern = DateUtil.FORMAT_DAY_ONLY)
    /*@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtil.FORMAT_DAY_ONLY)*/
    private LocalDate date;
    @OneToMany(mappedBy = "dayEntry", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JsonManagedReference
    private List<SingleEntry> singleEntryList;
    @ManyToOne
    @JoinColumn(nullable=false)
    private User user;

}
