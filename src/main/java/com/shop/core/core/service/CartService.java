package com.shop.core.core.service;

import com.shop.core.core.entity.Cart;
import com.shop.core.core.entity.Product;
import com.shop.core.core.service.exception.cart.ProductNotAddedToCartException;
import com.shop.core.core.service.exception.cart.ProductNotRemovedFromCartException;
import com.shop.core.core.service.exception.customer.CustomerGetProductsByCustomerIdException;

import java.util.List;

public interface CartService {
    public List<Product> getProductsFromCartByCustomerId(Long customerId) throws CustomerGetProductsByCustomerIdException;
    public Boolean addProductToCart(Cart cart, Long productId) throws ProductNotAddedToCartException;
    public Boolean removeProductFromCart(Cart cart, Long productId) throws ProductNotRemovedFromCartException;
}
