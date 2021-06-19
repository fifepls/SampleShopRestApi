package com.shop.core.core.service.exception.customer;

public class CustomerNotRemovedException extends Exception {
    public CustomerNotRemovedException() {
        super();
    }

    public CustomerNotRemovedException(String message) {
        super(message);
    }

    public CustomerNotRemovedException(String message, Throwable cause) {
        super(message, cause);
    }
}
