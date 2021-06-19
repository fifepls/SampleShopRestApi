package com.shop.core.core.service.exception.customer;

public class CustomerPasswordNotUpdatedException extends Exception{
    public CustomerPasswordNotUpdatedException() {
        super();
    }

    public CustomerPasswordNotUpdatedException(String message) {
        super(message);
    }

    public CustomerPasswordNotUpdatedException(String message, Throwable cause) {
        super(message, cause);
    }
}
