package com.harshith.product.exception;

import com.harshith.product.dto.ExceptionResponceDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CategoryAlreadyExistException.class)
    public ResponseEntity<ExceptionResponceDto> handleCategoryAlreadyExistException(CategoryAlreadyExistException ex, WebRequest webRequest)
    {
        ExceptionResponceDto exceptionResponceDto = new ExceptionResponceDto(
                webRequest.getDescription(false),
                HttpStatus.CONFLICT,
                ex.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionResponceDto);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ExceptionResponceDto> handelCategoryNotFoundException(CategoryNotFoundException ex,WebRequest webRequest)
    {
        ExceptionResponceDto exceptionResponceDto = new ExceptionResponceDto(
                webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponceDto);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String>
    handleProductNotFoundException(
            ProductNotFoundException ex)
    {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponceDto>
    handleGlobalException(
            Exception ex,
            WebRequest webRequest)
    {

        ExceptionResponceDto response =
                new ExceptionResponceDto(
                        webRequest.getDescription(false),
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        ex.getMessage(),
                        LocalDateTime.now()
                );

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}
