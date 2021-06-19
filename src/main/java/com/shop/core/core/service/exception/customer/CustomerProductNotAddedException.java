package com.shop.core.core.service.exception.customer;

public class CustomerProductNotAddedException extends Exception{
    public CustomerProductNotAddedException() {
        super();
    }

    public CustomerProductNotAddedException(String message) {
        super(message);
    }

    public CustomerProductNotAddedException(String message, Throwable cause) {
        super(message, cause);
    }
}
