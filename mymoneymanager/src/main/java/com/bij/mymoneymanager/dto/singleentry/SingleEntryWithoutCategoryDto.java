package com.bij.mymoneymanager.dto.singleentry;

import com.bij.mymoneymanager.enumeration.SingleEntryType;
import lombok.Data;

import javax.persistence.Id;

public @Data
class SingleEntryWithoutCategoryDto {

    @Id
    private Integer id;
    private float value;
    private SingleEntryType type;
    private int dayEntryId;
}
