package com.bij.mymoneymanager.service;

import com.bij.mymoneymanager.dto.category.CategoryDto;
import com.bij.mymoneymanager.model.Category;
import com.bij.mymoneymanager.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category add(Category category) {
        return categoryRepository.save(category);
    }
    /*public CategoryDto add(CategoryDto categoryDto) {
        return CategoryMapper.toCategoryDto(
                categoryRepository.save(CategoryMapper.toCategory(categoryDto))
        );
    }*/

    @Override
    public void update(Category category) {
        categoryRepository.save(category);
    }
    /*public void update(CategoryDto categoryDto) {
        categoryRepository.save(CategoryMapper.toCategory(categoryDto));
    }*/

    @Override
    public void remove(String name) {
        categoryRepository.deleteByName(name);
    }



    @Override
    public Category getByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public List<Category> getAll() {
        List<Category> categoryList = new ArrayList<>();
        categoryRepository
                .findAll()
                .forEach(categoryList::add);
        return categoryList;
    }
}
