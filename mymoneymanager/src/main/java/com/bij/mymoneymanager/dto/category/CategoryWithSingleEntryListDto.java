package com.bij.mymoneymanager.dto.category;

import com.bij.mymoneymanager.dto.singleentry.SingleEntryWithoutCategoryDto;
import com.bij.mymoneymanager.dto.singleentry.SingleEntryWithoutDayEntryDto;
import lombok.Data;

import javax.persistence.Id;
import java.util.List;

public @Data
class CategoryWithSingleEntryListDto {

    @Id
    private Integer id;
    private String name;
    private String color;
    private List<SingleEntryWithoutCategoryDto> singleEntryList;
}
