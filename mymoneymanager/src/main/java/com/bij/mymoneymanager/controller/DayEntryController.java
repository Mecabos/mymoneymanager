package com.bij.mymoneymanager.controller;

import com.bij.mymoneymanager.dto.dayentry.DayEntryDto;
import com.bij.mymoneymanager.dto.dayentry.DayEntryForCreationDto;
import com.bij.mymoneymanager.model.DayEntry;
import com.bij.mymoneymanager.service.DayEntryService;
import com.bij.mymoneymanager.util.DTO;
import com.bij.mymoneymanager.util.DateUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/DayEntries")
public class DayEntryController {

    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private DayEntryService dayEntryService;

    @PostMapping()
    public DayEntryDto addDayEntry(@DTO(DayEntryForCreationDto.class) DayEntry dayEntry) {
        return modelMapper.map(dayEntryService.add(dayEntry), DayEntryDto.class);
    }

    @GetMapping()
    public List<DayEntryDto> getDayEntries() {
        return dayEntryService.getAll()
                .stream()
                .map(e -> modelMapper.map(e, DayEntryDto.class))
                .collect(Collectors.toList());
    }

    @PutMapping
    public void updateDayEntry(@DTO(DayEntryDto.class) DayEntry dayEntry) {
        dayEntryService.update(dayEntry);
    }

    @DeleteMapping("/{id}")
    public void removeCategory(@PathVariable int id) {
        dayEntryService.remove(id);
    }

    @GetMapping("/{id}")
    public DayEntryDto getDayEntryById(@PathVariable int id) {
        return modelMapper.map(dayEntryService.get(id), DayEntryDto.class);
    }

    //HINT : Send date without ""
    @GetMapping("/date")
    public DayEntryDto getDayEntryByDate(
            @RequestParam("date")
            @DateTimeFormat(pattern = DateUtil.FORMAT_DAY_ONLY) LocalDate date) {
        /*@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)*/
        /*@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)*/
        return modelMapper.map(dayEntryService.getByDate(date), DayEntryDto.class);
    }


}
