package com.bij.mymoneymanager.service;

import com.bij.mymoneymanager.model.DayEntry;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class DayEntryService {

    List<DayEntry> tempList = Arrays.asList(
            new DayEntry(1, new Date(), null, null),
            new DayEntry(2, new Date(), null, null)
    );

    public List<DayEntry> getAll() {
        return tempList;
    }

    public DayEntry get(int id) {
        return tempList.stream().filter(d -> d.getId() == id).findFirst().get();
    }

}
