package com.bij.mymoneymanager.dto.category;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Id;


public @Data class CategoryDto {

    @Id
    private Integer id;
    private String name;
    private String color;

}
