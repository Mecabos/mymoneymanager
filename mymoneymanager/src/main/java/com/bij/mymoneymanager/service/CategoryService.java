package com.bij.mymoneymanager.service;

import com.bij.mymoneymanager.enumeration.CategoryName;
import com.bij.mymoneymanager.model.Category;

import java.util.List;

public interface CategoryService {

    Category add(Category category);
    void update(Category category);
    void remove(String name);
    Category getByName(String name);
    List<Category> getAll();
}
