package com.shop.core.core.service.exception.customer;

public class CustomerNotAddedException extends Exception{
    public CustomerNotAddedException() {
        super();
    }

    public CustomerNotAddedException(String message) {
        super(message);
    }

    public CustomerNotAddedException(String message, Throwable cause) {
        super(message, cause);
    }
}
