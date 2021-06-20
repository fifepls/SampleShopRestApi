package com.shop.core.core.service.impl;

import com.shop.core.core.entity.Cart;
import com.shop.core.core.entity.Product;
import com.shop.core.core.repository.CartRepository;
import com.shop.core.core.service.CartService;
import com.shop.core.core.service.ProductService;
import com.shop.core.core.service.exception.cart.ProductNotAddedToCartException;
import com.shop.core.core.service.exception.cart.ProductNotRemovedFromCartException;
import com.shop.core.core.service.exception.customer.CustomerGetProductsByCustomerIdException;
import com.shop.core.core.service.exception.product.ProductNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    private final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);
    private final CartRepository cartRepository;
    private final ProductService productService;

    public CartServiceImpl(CartRepository cartRepository, ProductService productService) {
        this.cartRepository = cartRepository;
        this.productService = productService;
    }

    @Override
    public List<Product> getProductsFromCartByCustomerId(Long customerId) throws CustomerGetProductsByCustomerIdException {
        try{
            if(customerId == null){
                throw new CustomerGetProductsByCustomerIdException("customer id is null");
            }
            return cartRepository.findCartByCustomerId(customerId).getProducts();
        }catch(CustomerGetProductsByCustomerIdException e){
            logger.error("customer id is null");
            throw new CustomerGetProductsByCustomerIdException("customer id is null",e);
        }
    }

    @Override
    @Transactional
    public Boolean addProductToCart(Cart cart, Long productId) throws ProductNotAddedToCartException {
        try{
            if (cart == null){
                throw new ProductNotAddedToCartException("customer id is null");
            }

            if (productId == null){
                throw new ProductNotAddedToCartException("product id is null");
            }

            List<Product> notUpdatedCart = cart.getProducts();

            //updating cart
            List<Product> updatedCart = new ArrayList<>(notUpdatedCart);
            try {
                updatedCart.add(productService.getProductById(productId));
            }catch (ProductNotFoundException e){
                throw new ProductNotAddedToCartException("product not found");
            }
            //setting updated cart
            cart.setProducts(updatedCart);

            cartRepository.save(cart);
            return true;
        }catch (ProductNotAddedToCartException e){
            logger.error("product not added",e);
            throw new ProductNotAddedToCartException("product not added",e);
        }
    }

    @Override
    @Transactional
    public Boolean removeProductFromCart(Cart cart, Long productId) throws ProductNotRemovedFromCartException {
        try{
            if(cart == null){
                throw new ProductNotRemovedFromCartException("cart id is null");
            }
            if(productId == null){
                throw new ProductNotRemovedFromCartException("product id is null");
            }

                List<Product> products = cart.getProducts();
                products.removeIf(notUpdatedProduct -> notUpdatedProduct.getId().equals(productId));
                cart.setProducts(products);
                cartRepository.save(cart);
                return true;
        }catch (ProductNotRemovedFromCartException e){
            logger.error("product not removed from cart",e);
            throw new ProductNotRemovedFromCartException("product not removed from cart",e);
        }
    }
}
