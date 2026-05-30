package com.harshith.product.mapper;

import com.harshith.product.dto.CategoryDto;
import com.harshith.product.dto.ProductDto;
import com.harshith.product.entity.Category;
import com.harshith.product.entity.Product;
import org.hibernate.event.spi.PreInsertEvent;

public class ProductMapper {

    public static ProductDto toProductDto(Product product)
    {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getId()
        );
    }

    public static Product toProductEntity(ProductDto productDto, Category category)
    {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setCategory(category);
        return product;
    }
}
