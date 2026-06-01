package com.harshith.product.controller;

import com.harshith.product.dto.CategoryDto;
import com.harshith.product.dto.ProductDto;
import com.harshith.product.exception.CategoryAlreadyExistException;
import com.harshith.product.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import java.util.List;

@Tag(
        name = "Category RestAPI CRUD Operation",
        description = "CRUD controller for category"
)
@RestController
@RequestMapping("api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Operation(
            summary = "Creates new category",
            description = "create new category in database"
    )
    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategoryDto categoryDto)
    {
        CategoryDto savedCategory = categoryService.createCategory(categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }
    @Operation(
            summary = "Fetch Categories",
            description = "fetch all the categories available in database"
    )
    @GetMapping
    public List<CategoryDto> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @Operation(
            summary = "Fetch the category by id",
            description = "fetch the category by id given by user"
    )
    @GetMapping("/{id}")
    public CategoryDto getElementById(@PathVariable Long id)
    {
        return categoryService.getCategoryById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete the category",
            description = "delete the category based on id"
    )
    public String deleteMapping(@PathVariable Long id)
    {
        return categoryService.deleteCategory(id);
    }






}
