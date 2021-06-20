package com.shop.core.core.service.impl;

import com.shop.core.core.entity.Product;
import com.shop.core.core.repository.ProductRepository;
import com.shop.core.core.service.ProductService;
import com.shop.core.core.service.exception.product.ProductNotCreatedException;
import com.shop.core.core.service.exception.product.ProductNotDeletedException;
import com.shop.core.core.service.exception.product.ProductNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public Product createNewProduct(Product newProduct) throws ProductNotCreatedException {
        try{
            if(newProduct == null){
                throw new ProductNotCreatedException("new product is null");
            }
            return productRepository.save(newProduct);
        }catch (ProductNotCreatedException e){
            logger.error("new product is null",e);
            throw new ProductNotCreatedException("new product is null",e);
        }
    }

    @Override
    @Transactional
    public Boolean deleteProduct(Long productId) throws ProductNotDeletedException {
        try{
            if(productId == null){
                throw new ProductNotDeletedException("productId is null");
            }
            productRepository.deleteById(productId);
            return true;
        }catch (ProductNotDeletedException e){
            logger.error("product id is null",e);
            throw new ProductNotDeletedException("productId is null",e);
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long productId) throws ProductNotFoundException {
        try{
            if(productId == null){
                throw new ProductNotFoundException("product id is null");
            }

            Optional<Product> productOptional = productRepository.findById(productId);

            if(productOptional.isPresent()){
                return productOptional.get();
            }else{
                throw new ProductNotFoundException("no product with this id");
            }
        }catch (ProductNotFoundException e){
            logger.error("product not found",e);
            throw new ProductNotFoundException("product not found",e);
        }
    }
}
