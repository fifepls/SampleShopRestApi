package com.shop.core.core.service;

import com.shop.core.core.entity.Cart;
import com.shop.core.core.entity.Product;

import java.util.List;

public interface CartService {
    public List<Product> getProductsFromCartByCustomerId(Long customerId);
    public Boolean addProductToCart(Cart cart, Product product);
    public Boolean removeProductFromCart(Cart cart, Product product);
}
