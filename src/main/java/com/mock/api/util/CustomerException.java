package com.mock.api.util;

public class CustomerException extends RuntimeException {

    public CustomerException(ApiError apiError) {
        super(apiError.name());
    }

}
