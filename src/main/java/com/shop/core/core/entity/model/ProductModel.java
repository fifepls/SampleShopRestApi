package com.shop.core.core.entity.model;

import com.shop.core.core.entity.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductModel {
    private Long id;
    private String productName;
    private String productDescription;
    private BigDecimal price;

    public ProductModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public static ProductModel productToModel(Product product){
        ProductModel productModel = new ProductModel();
        productModel.setId(product.getId());
        productModel.setPrice(product.getProductPrice());
        productModel.setProductDescription(product.getProductDescription());
        productModel.setProductName(product.getProductName());
        return productModel;
    }

    public static List<ProductModel> productListToModel(List<Product> products){
        List<ProductModel> productModels = new ArrayList<>();
        for (Product product : products) {
            ProductModel productModel = new ProductModel();
            productModel.setId(product.getId());
            productModel.setPrice(product.getProductPrice());
            productModel.setProductDescription(product.getProductDescription());
            productModel.setProductName(product.getProductName());
        }
        return productModels;
    }
}
