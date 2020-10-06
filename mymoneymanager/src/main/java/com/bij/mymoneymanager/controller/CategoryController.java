package com.bij.mymoneymanager.controller;

import com.bij.mymoneymanager.dto.category.CategoryDto;
import com.bij.mymoneymanager.dto.category.CategoryForCreationDto;
import com.bij.mymoneymanager.dto.category.CategoryWithSingleEntryListDto;
import com.bij.mymoneymanager.model.Category;
import com.bij.mymoneymanager.model.DayEntry;
import com.bij.mymoneymanager.service.CategoryService;
import com.bij.mymoneymanager.util.DTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    @ResponseBody
    public CategoryDto addCategory(@DTO(CategoryForCreationDto.class) Category category) {
        return modelMapper.map(categoryService.add(category),CategoryDto.class);
    }

    @PutMapping
    public void updateCategory(@DTO(CategoryDto.class) Category category) {
        categoryService.update(category);
    }

    @DeleteMapping("/{name}")
    public void removeCategory(@PathVariable String name) {
        categoryService.remove(name);
    }

    @GetMapping
    @ResponseBody
    public List<CategoryDto> getAllCategories() {
        return categoryService.getAll().stream().map(category -> modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());
    }

    @GetMapping("/{name}")
    @ResponseBody
    public CategoryDto getCategoryByName(@PathVariable String name) {
        return modelMapper.map(categoryService.getByName(name),CategoryDto.class);
    }

    @GetMapping("/{name}/singleEntries")
    @ResponseBody
    /*@Transactional(propagation= Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)*/
    @Transactional
    public CategoryWithSingleEntryListDto getCategoryByNameWithSingleEntries(@PathVariable String name) {
        return modelMapper.map(categoryService.getByName(name),CategoryWithSingleEntryListDto.class);
    }
}
