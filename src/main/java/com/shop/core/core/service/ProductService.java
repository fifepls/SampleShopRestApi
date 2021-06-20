package com.shop.core.core.service;

import com.shop.core.core.entity.Product;
import com.shop.core.core.service.exception.product.ProductNotCreatedException;
import com.shop.core.core.service.exception.product.ProductNotDeletedException;
import com.shop.core.core.service.exception.product.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    public Product createNewProduct(Product newProduct) throws ProductNotCreatedException;
    public Boolean deleteProduct(Long productId) throws ProductNotDeletedException;
    public List<Product> getAllProducts();
    public Product getProductById(Long productId) throws ProductNotFoundException;
}
