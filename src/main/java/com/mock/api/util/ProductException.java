package com.mock.api.util;

public class ProductException extends RuntimeException  {

    public ProductException(ApiError apiError) {
        super(apiError.name());
    }
}
