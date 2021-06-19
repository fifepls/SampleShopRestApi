package com.shop.core.core.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_name", nullable = false)
    private String name;

    @Column(name = "employee_last_name", nullable = false)
    private String lastName;

    @Column(name = "employee_phone_number",nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "employee_hourly_payment", nullable = false)
    private BigDecimal hourlyPayment;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BigDecimal getHourlyPayment() {
        return hourlyPayment;
    }

    public void setHourlyPayment(BigDecimal hourlyPayment) {
        this.hourlyPayment = hourlyPayment;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
