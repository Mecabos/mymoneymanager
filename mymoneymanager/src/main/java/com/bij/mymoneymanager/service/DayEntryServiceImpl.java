package com.bij.mymoneymanager.service;

import com.bij.mymoneymanager.model.Category;
import com.bij.mymoneymanager.model.DayEntry;
import com.bij.mymoneymanager.repository.DayEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DayEntryServiceImpl implements DayEntryService{

    @Autowired
    private DayEntryRepository dayEntryRepository;

    @Override
    public DayEntry add(DayEntry dayEntry) {
        return dayEntryRepository.save(dayEntry);
    }

    @Override
    public DayEntry get(int id) {
        //TODO: check if present
        return dayEntryRepository.findById(id).get();
    }

    @Override
    public DayEntry getByDate(LocalDate date) {
        return dayEntryRepository.findByDate(date).get();
    }

    @Override
    public void update(DayEntry dayEntry) {
        dayEntryRepository.save(dayEntry);
    }

    @Override
    public void remove(int id) {
        dayEntryRepository.delete(dayEntryRepository.findById(id).get());
    }


    @Override
    public List<DayEntry> getAll() {
        List<DayEntry> dayEntryList = new ArrayList<>();
        dayEntryRepository.findAll().forEach(dayEntryList::add);
        return dayEntryList.stream().sorted(Comparator.comparing(DayEntry::getDate)).collect(Collectors.toList());
    }
}
