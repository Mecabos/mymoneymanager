package com.bij.mymoneymanager.dto.singleentry;

import com.bij.mymoneymanager.enumeration.SingleEntryType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Id;


public @Data
class SingleEntryWithoutDayEntryDto {

    @Id
    private Integer id;
    private float value;
    private SingleEntryType type;
    private int categoryId;

}
