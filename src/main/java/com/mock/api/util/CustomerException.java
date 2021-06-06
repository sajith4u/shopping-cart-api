package com.mock.api.util;

public class CustomerException extends RuntimeException {
    private ApiError message;

    public CustomerException(ApiError apiError) {
        super(apiError.name());
        this.message = apiError;
    }

}
