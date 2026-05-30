package com.harshith.product.service;


import com.harshith.product.dto.CategoryDto;
import com.harshith.product.entity.Category;
import com.harshith.product.mapper.CategoryMapper;
import com.harshith.product.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    //create category
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryDto createCategory(CategoryDto categoryDto)
    {
        Category category = CategoryMapper.toCategoryEntity(categoryDto);
        category = categoryRepository.save(category);
        return CategoryMapper.toCategoryDto(category);
    }

    public List<CategoryDto> getAllCategories()
    {
        return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDto).toList();


    }

    public CategoryDto getCategoryById(Long id)
    {
        Category category = categoryRepository.findById(id).orElseThrow(()->new RuntimeException("id not found"));
        return CategoryMapper.toCategoryDto(category);
    }

    public String deleteCategory(Long id)
    {

        if(categoryRepository.existsById(id))
        {
            categoryRepository.deleteById(id);
            return "category "+id+" deleted successfully" ;
        }

        return "category not found" ;
    }




}
