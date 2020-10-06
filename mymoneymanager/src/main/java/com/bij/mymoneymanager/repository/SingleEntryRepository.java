package com.bij.mymoneymanager.repository;

import com.bij.mymoneymanager.model.SingleEntry;
import org.springframework.data.repository.CrudRepository;

public interface SingleEntryRepository extends CrudRepository<SingleEntry, Integer> {
}
