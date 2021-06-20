package com.shop.core.core.service.exception.customer;

public class CustomerGetProductsByCustomerIdException extends Exception{
    public CustomerGetProductsByCustomerIdException() {
        super();
    }

    public CustomerGetProductsByCustomerIdException(String message) {
        super(message);
    }

    public CustomerGetProductsByCustomerIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
