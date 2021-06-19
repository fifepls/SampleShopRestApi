package com.shop.core.core.service.exception.customer;

public class CustomerProductNotRemovedException extends Exception{
    public CustomerProductNotRemovedException() {
        super();
    }

    public CustomerProductNotRemovedException(String message) {
        super(message);
    }

    public CustomerProductNotRemovedException(String message, Throwable cause) {
        super(message, cause);
    }
}
