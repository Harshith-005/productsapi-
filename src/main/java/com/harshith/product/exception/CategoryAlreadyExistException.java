package com.harshith.product.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestClient;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class CategoryAlreadyExistException
        extends RuntimeException {

    public CategoryAlreadyExistException(String message) {
        super(message);
    }
}
