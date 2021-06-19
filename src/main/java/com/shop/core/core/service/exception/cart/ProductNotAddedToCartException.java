package com.shop.core.core.service.exception.cart;

public class ProductNotAddedToCartException extends Exception{

    public ProductNotAddedToCartException() {
        super();
    }

    public ProductNotAddedToCartException(String message) {
        super(message);
    }

    public ProductNotAddedToCartException(String message, Throwable cause) {
        super(message, cause);
    }
}
