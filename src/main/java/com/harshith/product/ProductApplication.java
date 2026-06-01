package com.harshith.product;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "Product API",
                version = "1.0",
                description = "API for managing products and categories",
                contact = @Contact(
                        name = "Harshith",
                        email = "harshith1276@gmail.com"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "url for external documentation",
                url = "www.google.com"
        )
)
@SpringBootApplication
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

}
