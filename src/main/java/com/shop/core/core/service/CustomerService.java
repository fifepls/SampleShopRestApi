package com.shop.core.core.service;

import com.shop.core.core.entity.Customer;

public interface CustomerService {
    public Customer addNewCustomer(Customer newCustomer);
    public Boolean removeCustomer(Long id);
    public Boolean customerChangePassword(String customerPhone, String customerOldPassword, String customerNewPassword);
    public Boolean customerChangePhone(String customerPhone, String customerPassword, String customerNewPhone);
    public Boolean customerAddProductToCart(Long customerId, Long productId);
    public Boolean customerRemoveProductFormCart(Long customerId, Long productId);


}
