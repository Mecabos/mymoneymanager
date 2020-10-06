package com.bij.mymoneymanager.model;

import com.bij.mymoneymanager.dto.category.CategoryDto;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CategoryUT {

    private static final ModelMapper modelmapper = new ModelMapper();

    @Test
    public void checkCategoryMapping() {
        CategoryDto categoryDtoToMap = new CategoryDto();
        categoryDtoToMap.setName("test_category");
        categoryDtoToMap.setColor("65489");

        Category category = modelmapper.map(categoryDtoToMap, Category.class);
        assertEquals(categoryDtoToMap.getName(), category.getName());
        assertEquals(categoryDtoToMap.getColor(), category.getColor());

        Category categoryToMap = new Category();
        categoryToMap.setName("test_category2");
        categoryToMap.setName("FFFFFF");
        CategoryDto categoryDto = modelmapper.map(categoryToMap, CategoryDto.class);
        assertEquals(categoryToMap.getName(), categoryDto.getName());
        assertEquals(categoryToMap.getColor(), categoryDto.getColor());
    }
}
