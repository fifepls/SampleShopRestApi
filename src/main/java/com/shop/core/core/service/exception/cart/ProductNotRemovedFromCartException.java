package com.shop.core.core.service.exception.cart;

public class ProductNotRemovedFromCartException extends Exception {

    public ProductNotRemovedFromCartException() {
        super();
    }

    public ProductNotRemovedFromCartException(String message) {
        super(message);
    }

    public ProductNotRemovedFromCartException(String message, Throwable cause) {
        super(message, cause);
    }
}
