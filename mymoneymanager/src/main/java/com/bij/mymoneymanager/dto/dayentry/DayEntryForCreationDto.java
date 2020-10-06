package com.bij.mymoneymanager.dto.dayentry;

import com.bij.mymoneymanager.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;


public @Data
class DayEntryForCreationDto {

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtil.FORMAT_DAY_ONLY)
    private LocalDate date;

}
