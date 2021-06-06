package com.mock.api.util;

public class ProductException extends RuntimeException  {

    private ApiError message;

    public ProductException(ApiError apiError) {
        super(apiError.name());
        this.message = apiError;
    }
}
