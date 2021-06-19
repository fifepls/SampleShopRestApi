package com.shop.core.core.service;

import com.shop.core.core.entity.Product;

import java.util.List;

public interface ProductService {
    public Product createNewProduct(Product newProduct);
    public Boolean deleteProduct(Long productId);
    public List<Product> getAllProducts();
}
