package com.bij.mymoneymanager.repository;

import com.bij.mymoneymanager.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

    @Transactional
    void deleteByName(String name);

    Category findByName(String name);
}
