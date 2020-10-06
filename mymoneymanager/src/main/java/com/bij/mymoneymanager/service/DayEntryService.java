package com.bij.mymoneymanager.service;

import com.bij.mymoneymanager.model.Category;
import com.bij.mymoneymanager.model.DayEntry;

import java.time.LocalDate;
import java.util.List;

public interface DayEntryService {

    DayEntry add(DayEntry dayEntry);

    DayEntry get(int id);

    DayEntry getByDate(LocalDate date);

    void update(DayEntry dayEntry);

    void remove(int id);

    List<DayEntry> getAll();

}
