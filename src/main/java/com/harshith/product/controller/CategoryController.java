package com.harshith.product.controller;

import com.harshith.product.dto.CategoryDto;
import com.harshith.product.dto.ProductDto;
import com.harshith.product.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public CategoryDto createCategory(@RequestBody CategoryDto categoryDto)
    {
        return categoryService.createCategory(categoryDto);
    }
    /*@GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable Long id)
    {
        return categoryService.
    }*/
    @GetMapping
    public List<CategoryDto> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public CategoryDto getElementById(@PathVariable Long id)
    {
        return categoryService.getCategoryById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteMapping(@PathVariable Long id)
    {
        return categoryService.deleteCategory(id);
    }






}
