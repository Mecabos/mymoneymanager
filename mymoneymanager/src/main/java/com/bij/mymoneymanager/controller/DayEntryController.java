package com.bij.mymoneymanager.controller;

import com.bij.mymoneymanager.model.DayEntry;
import com.bij.mymoneymanager.service.DayEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/DayEntries")
public class DayEntryController {

    @Autowired
    private DayEntryService dayEntryService;

    @GetMapping()
    public List<DayEntry> getDayEntries (){
        return dayEntryService.getAll();
    }

    @GetMapping("/topics/{id}")
    public DayEntry getDayEntry (@PathVariable int id){
        return dayEntryService.get(id);
    }

    @PostMapping()
    public void addDayEntry (@RequestBody DayEntry dayEntry){

    }
}
