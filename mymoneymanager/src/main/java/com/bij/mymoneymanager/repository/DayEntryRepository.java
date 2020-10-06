package com.bij.mymoneymanager.repository;

import com.bij.mymoneymanager.model.DayEntry;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DayEntryRepository extends CrudRepository<DayEntry, Integer> {

    Optional<DayEntry> findByDate(LocalDate date);
}
