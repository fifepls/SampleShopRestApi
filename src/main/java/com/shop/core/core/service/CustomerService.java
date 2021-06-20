package com.shop.core.core.service;

import com.shop.core.core.entity.Customer;
import com.shop.core.core.service.exception.customer.*;

public interface CustomerService {
    public Customer addNewCustomer(Customer newCustomer) throws CustomerNotAddedException;
    public Boolean removeCustomer(Long id) throws CustomerNotRemovedException;
    public Boolean customerUpdatePassword(String customerPhone, String customerOldPassword, String customerNewPassword) throws CustomerPasswordNotUpdatedException;
    public Boolean customerUpdatePhone(String customerPhone, String customerPassword, String customerNewPhone) throws CustomerPhoneNotUpdatedException;
    public Boolean customerAddProductToCart(Long customerId, Long productId) throws CustomerProductNotAddedException;
    public Boolean customerRemoveProductFormCart(Long customerId, Long productId) throws CustomerProductNotRemovedException;
}
