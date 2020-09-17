package com.bij.mymoneymanager.controller;

import com.bij.mymoneymanager.model.Category;
import com.bij.mymoneymanager.model.DayEntry;
import com.bij.mymoneymanager.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping()
    public Category addCategory (@RequestBody Category category){
        return categoryService.add(category);
    }

    @PutMapping()
    public void updateCategory (@RequestBody Category category){
        categoryService.update(category);
    }

    @DeleteMapping("/{name}")
    public void removeCategory (@PathVariable String name){
        categoryService.remove(name);
    }

    @GetMapping()
    public List<Category> getCategory (){
        return categoryService.getAll();
    }

    @GetMapping("/{name}")
    public Category getCategories (@PathVariable String name){

        return categoryService.getByName(name);
    }
    }
