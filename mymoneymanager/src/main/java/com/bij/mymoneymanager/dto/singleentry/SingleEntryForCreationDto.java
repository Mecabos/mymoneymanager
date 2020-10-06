package com.bij.mymoneymanager.dto.singleentry;

import com.bij.mymoneymanager.enumeration.SingleEntryType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;
import lombok.Data;

//@JsonInclude(value = JsonInclude.Include.NON_NULL)
//@JsonIgnoreProperties(ignoreUnknown = true)
public @Data class SingleEntryForCreationDto {

    private float value ;
    private SingleEntryType type;
    private int categoryId;
    private int dayEntryId;
}
