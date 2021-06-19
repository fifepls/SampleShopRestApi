package com.shop.core.core.entity;

import javax.persistence.*;
import java.util.Objects;

//customer
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cart_id")
    private Cart customerCart;

    @Column(name = "customer_phone", unique = true,nullable = false)
    private String customerPhone;

    @Column(name = "customer_password", nullable = false)
    private String customerPassword;

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cart getCustomerCart() {
        return customerCart;
    }

    public void setCustomerCart(Cart customerCart) {
        this.customerCart = customerCart;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id.equals(customer.id) && customerCart.equals(customer.customerCart) && customerPhone.equals(customer.customerPhone) && customerPassword.equals(customer.customerPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerCart, customerPhone, customerPassword);
    }
}
