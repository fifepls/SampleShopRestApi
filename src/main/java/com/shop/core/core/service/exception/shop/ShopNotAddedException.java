package com.shop.core.core.service.exception.shop;

public class ShopNotAddedException  extends Exception{

    public ShopNotAddedException() {
        super();
    }

    public ShopNotAddedException(String message) {
        super(message);
    }

    public ShopNotAddedException(String message, Throwable cause) {
        super(message, cause);
    }
}
