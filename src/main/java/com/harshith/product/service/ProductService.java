package com.harshith.product.service;

import com.harshith.product.dto.ProductDto;
import com.harshith.product.entity.Category;
import com.harshith.product.entity.Product;
import com.harshith.product.exception.CategoryNotFoundException;
import com.harshith.product.exception.ProductNotFoundException;
import com.harshith.product.mapper.ProductMapper;
import com.harshith.product.repository.CategoryRepository;
import com.harshith.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    public ProductDto createProduct(ProductDto productDto)
    {
        Category category =  categoryRepository.findById(productDto.getCategoryId()).orElseThrow(()->new CategoryNotFoundException("category id "+productDto.getCategoryId()+" not found"));
        Product product = ProductMapper.toProductEntity(productDto,category);
        product = productRepository.save(product);
        return ProductMapper.toProductDto(product);
    }

    public List<ProductDto> getAllProduct()
    {
        return productRepository.findAll().stream().map(ProductMapper::toProductDto).toList();
    }

    public ProductDto getElementById(Long id)
    {
       Product product = productRepository.findById(id).orElseThrow(()->new ProductNotFoundException("product not found"));
       return ProductMapper.toProductDto(product);

    }
    public ProductDto updateProduct(Long id,ProductDto productDto)
    {
        Product product = productRepository.findById(id).orElseThrow(()->new RuntimeException("product not found"));
        Category category = categoryRepository.findById(productDto.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found"));
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setCategory(category);
        productRepository.save(product);
        return ProductMapper.toProductDto(product);
    }

    public String deleteProduct(Long id)
    {
        if(productRepository.existsById(id))
        {
            productRepository.deleteById(id);
            return "product " + id + " deleted successfully";
        }

        return "product not found";
    }




}
