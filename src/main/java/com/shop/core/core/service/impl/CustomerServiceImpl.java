package com.shop.core.core.service.impl;

import com.shop.core.core.entity.Customer;
import com.shop.core.core.repository.CustomerRepository;
import com.shop.core.core.service.CartService;
import com.shop.core.core.service.CustomerService;
import com.shop.core.core.service.exception.cart.ProductNotAddedToCartException;
import com.shop.core.core.service.exception.cart.ProductNotRemovedFromCartException;
import com.shop.core.core.service.exception.customer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
    private final CustomerRepository customerRepository;
    private final CartService cartService;

    public CustomerServiceImpl(CustomerRepository customerRepository, CartService cartService) {
        this.customerRepository = customerRepository;
        this.cartService = cartService;
    }

    @Override
    public Customer addNewCustomer(Customer newCustomer) throws CustomerNotAddedException {
        try{
            if(newCustomer == null){
                throw new CustomerNotAddedException("new customer is null");
            }
            return customerRepository.save(newCustomer);
        }catch (CustomerNotAddedException e){
            logger.error("new customer is null",e);
            throw new CustomerNotAddedException("new customer is null",e);
        }
    }

    @Override
    public Boolean removeCustomer(Long id) throws CustomerNotRemovedException {
        try{
            if(id == null){
                throw new CustomerNotRemovedException("id is null");
            }
            customerRepository.deleteById(id);
            return true;
        }catch (CustomerNotRemovedException e){
            logger.error("customer not removed",e);
            throw new CustomerNotRemovedException("customer not removed",e);
        }
    }

    @Override
    public Boolean customerUpdatePassword(String customerPhone, String customerOldPassword, String customerNewPassword) throws CustomerPasswordNotUpdatedException {
        try {
            if (customerPhone == null) {
                throw new CustomerPasswordNotUpdatedException("customer phone is null");
            }
            if (customerOldPassword == null) {
                throw new CustomerPasswordNotUpdatedException("customer old password is null");
            }
            if (customerNewPassword == null) {
                throw new CustomerPasswordNotUpdatedException("customer new password is null");
            }

            Customer customer = customerRepository.getCustomerByCustomerPhone(customerPhone);
                if(customer.getCustomerPassword().equals(customerOldPassword)){
                    customer.setCustomerPassword(customerNewPassword);
                }else{
                    throw new CustomerPasswordNotUpdatedException("invalid old password");
                }
                customerRepository.save(customer);
                return true;
        }catch (CustomerPasswordNotUpdatedException e){
            logger.error("password not updated",e);
            throw new CustomerPasswordNotUpdatedException("password not updated",e);
        }
    }

    @Override
    public Boolean customerUpdatePhone(String customerPhone, String customerPassword, String customerNewPhone) throws CustomerPhoneNotUpdatedException {
        try {
            if (customerPhone == null) {
                throw new CustomerPhoneNotUpdatedException("customer phone is null");
            }
            if (customerPassword == null) {
                throw new CustomerPhoneNotUpdatedException("customer password is null");
            }
            if (customerNewPhone == null) {
                throw new CustomerPhoneNotUpdatedException("customer customer new phone is null");
            }

            Customer customer = customerRepository.getCustomerByCustomerPhone(customerPhone);

            if(customer.getCustomerPassword().equals(customerPassword)){
                customer.setCustomerPhone(customerNewPhone);
            }else{
                throw new CustomerPhoneNotUpdatedException("invalid old password");
            }
            customerRepository.save(customer);
            return true;
        }catch (CustomerPhoneNotUpdatedException e){
            logger.error("phone not updated",e);
            throw new CustomerPhoneNotUpdatedException("phone not updated",e);
        }
    }

    @Override
    public Boolean customerAddProductToCart(Long customerId, Long productId) throws CustomerProductNotAddedException {
        try{
            if(customerId == null){
                throw new CustomerProductNotAddedException("customer id is null");
            }
            if(productId == null){
                throw new CustomerProductNotAddedException("product id is null");
            }

            Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
            if(optionalCustomer.isPresent()) {
                try {
                    cartService.addProductToCart(optionalCustomer.get().getCustomerCart(), productId);
                    return true;
                }catch (ProductNotAddedToCartException e){
                    throw new CustomerProductNotAddedException("product not found ",e);
                }
            }else{
                throw new CustomerProductNotAddedException("customer not found");
            }
        }catch (CustomerProductNotAddedException e){
            logger.error("customer product not added to cart",e);
            throw new CustomerProductNotAddedException("customer product not added to cart",e);
        }
    }

    @Override
    public Boolean customerRemoveProductFormCart(Long customerId, Long productId) throws CustomerProductNotRemovedException {
        try{
            if(customerId == null){
                throw new CustomerProductNotRemovedException("customer id is null");
            }
            if(productId == null){
                throw new CustomerProductNotRemovedException("product id is null");
            }

            Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
            if(optionalCustomer.isPresent()){
                try {
                    cartService.removeProductFromCart(optionalCustomer.get().getCustomerCart(), productId);
                    return true;
                }catch (ProductNotRemovedFromCartException e){
                    throw new CustomerProductNotRemovedException("product not found",e);
                }
            }else {
                throw new CustomerProductNotRemovedException("customer not found");
            }

        }catch (CustomerProductNotRemovedException e){
            logger.error("customer product not removed from cart",e);
            throw new CustomerProductNotRemovedException("customer product not removed from cart",e);
        }
    }
}
