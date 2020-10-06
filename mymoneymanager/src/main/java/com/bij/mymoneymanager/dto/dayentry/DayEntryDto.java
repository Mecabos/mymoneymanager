package com.bij.mymoneymanager.dto.dayentry;

import com.bij.mymoneymanager.dto.singleentry.SingleEntryWithoutDayEntryDto;
import com.bij.mymoneymanager.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;


public @Data
class DayEntryDto {

    @Id
    private Integer id;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtil.FORMAT_DAY_ONLY)
    private LocalDate date;
    private List<SingleEntryWithoutDayEntryDto> singleEntryList;
}
