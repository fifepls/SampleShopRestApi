package com.shop.core.core.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

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

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "employee_hourly_payment", nullable = false)
    private BigDecimal hourlyPayment;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    @JsonBackReference
    private Shop shop;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Role role;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id.equals(employee.id) && name.equals(employee.name) && lastName.equals(employee.lastName) && phoneNumber.equals(employee.phoneNumber) && hourlyPayment.equals(employee.hourlyPayment) && shop.equals(employee.shop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, phoneNumber, hourlyPayment, shop);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
