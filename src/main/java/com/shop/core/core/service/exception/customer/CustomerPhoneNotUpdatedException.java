package com.shop.core.core.service.exception.customer;

public class CustomerPhoneNotUpdatedException extends Exception{
    public CustomerPhoneNotUpdatedException() {
        super();
    }

    public CustomerPhoneNotUpdatedException(String message) {
        super(message);
    }

    public CustomerPhoneNotUpdatedException(String message, Throwable cause) {
        super(message, cause);
    }
}
