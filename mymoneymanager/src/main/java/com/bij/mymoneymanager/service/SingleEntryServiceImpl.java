package com.bij.mymoneymanager.service;

import com.bij.mymoneymanager.dto.singleentry.SingleEntryDto;
import com.bij.mymoneymanager.model.SingleEntry;
import com.bij.mymoneymanager.repository.SingleEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SingleEntryServiceImpl implements SingleEntryService{

    @Autowired
    SingleEntryRepository singleEntryRepository;

    @Override
    public SingleEntry add(SingleEntry singleEntry) {
        return singleEntryRepository.save(singleEntry);
    }

    @Override
    public List<SingleEntry> addAll(List<SingleEntry> singleEntryList) {
        List<SingleEntry> singleEntryListResult = new ArrayList<>();
        singleEntryRepository.saveAll(singleEntryList).forEach(singleEntryListResult::add);
        return singleEntryListResult ;
    }

    @Override
    public SingleEntry get(int id) {
        //TODO: check if present
        return singleEntryRepository.findById(id).get();
    }

    @Override
    public List<SingleEntry> getAll() {
        List<SingleEntry> singleEntryList = new ArrayList<>();
        singleEntryRepository.findAll().forEach(singleEntryList::add);
        return singleEntryList;
    }

    @Override
    public void update(SingleEntry singleEntry) {
        singleEntryRepository.save(singleEntry);
    }

    @Override
    public void remove(int id) {
        singleEntryRepository.deleteById(id);
    }
}
