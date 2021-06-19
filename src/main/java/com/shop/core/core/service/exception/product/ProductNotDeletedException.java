package com.shop.core.core.service.exception.product;

public class ProductNotDeletedException  extends Exception {
    public ProductNotDeletedException() {
        super();
    }

    public ProductNotDeletedException(String message) {
        super(message);
    }

    public ProductNotDeletedException(String message, Throwable cause) {
        super(message, cause);
    }
}
