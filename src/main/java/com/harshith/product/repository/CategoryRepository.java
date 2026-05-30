package com.harshith.product.repository;

import com.harshith.product.controller.CategoryController;
import com.harshith.product.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
