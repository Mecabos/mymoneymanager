package com.bij.mymoneymanager.service;

import com.bij.mymoneymanager.dto.singleentry.SingleEntryDto;
import com.bij.mymoneymanager.model.SingleEntry;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SingleEntryService {

    SingleEntry add(SingleEntry singleEntry);

    List<SingleEntry> addAll(List<SingleEntry> singleEntryList);

    SingleEntry get(int id);

    List<SingleEntry> getAll();

    void update(SingleEntry singleEntry);

    void remove(int id);
}
