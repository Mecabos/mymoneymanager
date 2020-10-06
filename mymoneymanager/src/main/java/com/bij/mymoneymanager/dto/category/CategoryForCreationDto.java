package com.bij.mymoneymanager.dto.category;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


public @Data class CategoryForCreationDto {

    private String name;
    private String color;

}
