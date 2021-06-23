package com.shop.core.core.controller;

import com.shop.core.core.entity.Product;
import com.shop.core.core.entity.model.ShopModel;
import com.shop.core.core.service.CartService;
import com.shop.core.core.service.CustomerService;
import com.shop.core.core.service.ProductService;
import com.shop.core.core.service.ShopService;
import com.shop.core.core.service.exception.customer.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final ProductService productService;
    private final CustomerService customerService;
    private final ShopService shopService;
    private final CartService cartService;

    public CustomerController(ProductService productService, CustomerService customerService, ShopService shopService, CartService cartService) {
        this.productService = productService;
        this.customerService = customerService;
        this.shopService = shopService;
        this.cartService = cartService;
    }


    @GetMapping("/get/allProducts")
    public List<Product> getProducts(){
        return productService.getAllProducts();
    }


    @GetMapping("/get/allShops")
    public List<ShopModel> getShops(){
        return ShopModel.shopListToModel(shopService.getAllShops());
    }


    @PreAuthorize("hasAuthority('customer:addProductToCart')")
    @PostMapping("/add/product/toCart/")
    public boolean addProductToCart(@RequestParam(value = "CustomerId") Long customerId,
                                    @RequestParam(value = "ProductId") Long productId){
        try {
            customerService.customerAddProductToCart(customerId,productId);
            return true;
        } catch (CustomerProductNotAddedException e) {
            return false;
        }
    }


    @PreAuthorize("hasAuthority('customer:remProductFromCart')")
    @DeleteMapping("/rem/product/fromCart/")
    public boolean remProductToCart(@RequestParam(value = "CustomerId") Long customerId,
                                    @RequestParam(value = "ProductId") Long productId){
        try {
            customerService.customerRemoveProductFormCart(customerId,productId);
            return true;
        } catch (CustomerProductNotRemovedException e) {
            return false;
        }
    }


    @PreAuthorize("hasAuthority('customer:updatePassword')")
    public Boolean customerUpdatePassword(@RequestParam(value = "customerPhone")String customerPhone,
                                          @RequestParam(value = "customerOldPassword") String customerOldPassword,
                                          @RequestParam(value = "customerNewPassword")String customerNewPassword){
        try {
            return customerService.customerUpdatePassword(customerPhone, customerOldPassword, customerNewPassword);
        } catch (CustomerPasswordNotUpdatedException e) {
            return false;
        }

    }

    @PreAuthorize("hasAuthority('customer:updatePhone')")
    public Boolean customerUpdatePhone(@RequestParam(value = "customerPhone") String customerPhone,
                                       @RequestParam(value = "customerPassword") String customerPassword,
                                       @RequestParam(value = "customerNewPhone") String customerNewPhone){
        try {
            return customerService.customerUpdatePhone(customerPhone, customerPassword, customerNewPhone);
        } catch (CustomerPhoneNotUpdatedException e) {
            return false;
        }
    }


    @PreAuthorize("hasAuthority('customer:getProductsFromCart')")
    public List<Product> getProductsFromCartByCustomerId(@RequestParam(value = "customerId") Long customerId){
        try {
            return cartService.getProductsFromCartByCustomerId(customerId);
        } catch (CustomerGetProductsByCustomerIdException e) {
            return Collections.emptyList();
        }
    }
}
