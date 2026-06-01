package com.harshith.product.controller;

import com.harshith.product.dto.ProductDto;
import com.harshith.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(

        name = "Product RestApi Crud Operation",
        description = "CRUD Controller for product"
)
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
    @Operation(
            summary = "Fetch all products",
            description = "Get all the product details from database"
    )
    @GetMapping

    public List<ProductDto> getAllProduct()
    {
        return productService.getAllProduct();
    }
    @Operation(
            summary = "Fetch specific product",
            description = "Show the details of specific product from database"

    )
    @GetMapping("/{id}")
    public ProductDto getElementById(@PathVariable Long id)
    {
        return productService.getElementById(id);
    }

    @Operation(
            summary = "Create products",
            description = "Create a new product and insert into database"
    )
    @PutMapping("/{id}")
    public ProductDto updateProduct(@PathVariable Long id ,@RequestBody ProductDto productDto)
    {
        return productService.updateProduct(id,productDto);
    }


    @Operation(
            summary = "delete product by id",
            description = "delete the product of given id"
    )
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id)
    {
        return productService.deleteProduct(id);
    }
}
