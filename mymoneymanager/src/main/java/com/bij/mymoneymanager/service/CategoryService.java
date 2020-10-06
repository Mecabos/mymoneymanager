package com.bij.mymoneymanager.service;

import com.bij.mymoneymanager.model.Category;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CategoryService {

    Category add(Category category);
    void update(Category category);
    void remove(String name);
    Category getByName(String name);
    List<Category> getAll();
}
