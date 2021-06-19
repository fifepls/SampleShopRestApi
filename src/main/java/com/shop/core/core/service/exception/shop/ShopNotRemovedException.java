package com.shop.core.core.service.exception.shop;

public class ShopNotRemovedException extends Exception{

    public ShopNotRemovedException() {
        super();
    }

    public ShopNotRemovedException(String message) {
        super(message);
    }

    public ShopNotRemovedException(String message, Throwable cause) {
        super(message, cause);
    }
}
