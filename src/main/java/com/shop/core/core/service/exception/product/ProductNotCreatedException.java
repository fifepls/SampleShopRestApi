package com.shop.core.core.service.exception.product;

public class ProductNotCreatedException extends Exception {
    public ProductNotCreatedException() {
        super();
    }

    public ProductNotCreatedException(String message) {
        super(message);
    }

    public ProductNotCreatedException(String message, Throwable cause) {
        super(message, cause);
    }
}
