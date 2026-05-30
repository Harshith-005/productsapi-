package com.harshith.product.controller;

import com.harshith.product.dto.ProductDto;
import com.harshith.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto)
    {
        return productService.createProduct(productDto);


    }
    @GetMapping
    public List<ProductDto> getAllProduct()
    {
        return productService.getAllProduct();
    }

    @GetMapping("/{id}")
    public ProductDto getElementById(@PathVariable Long id)
    {
        return productService.getElementById(id);
    }

    public ProductDto updateProduct(@PathVariable Long id ,@RequestBody ProductDto productDto)
    {
        return productService.updateProduct(id,productDto);
    }


    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id)
    {
        return productService.deleteProduct(id);
    }
}
