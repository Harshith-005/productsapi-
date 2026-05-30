package com.harshith.product.mapper;

import com.harshith.product.dto.CategoryDto;
import com.harshith.product.entity.Category;

public class CategoryMapper {

    public static CategoryDto toCategoryDto(
            Category category)
    {
        if(category == null)
        {
            return null;
        }

        CategoryDto categoryDto =
                new CategoryDto();

        categoryDto.setId(category.getId());

        categoryDto.setName(category.getName());

        if(category.getProduct() != null)
        {
            categoryDto.setProduct(

                    category.getProduct()
                            .stream()
                            .map(ProductMapper::toProductDto)
                            .toList()

            );
        }

        return categoryDto;
    }

    public static Category toCategoryEntity(CategoryDto categoryDto)
    {
        Category category = new Category();
        category.setName(categoryDto.getName());
        return category;
    }

}
