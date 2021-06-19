package com.shop.core.core.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shop_address",unique = true, nullable = false)
    private String address;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> shopEmployees;


    @Column (name = "products")
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "shop_warehouse",
            joinColumns = @JoinColumn(name = "shop_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;


    public Shop() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Employee> getShopEmployees() {
        return shopEmployees;
    }

    public void setShopEmployees(List<Employee> shopEmployees) {
        this.shopEmployees = shopEmployees;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return id.equals(shop.id) && address.equals(shop.address) && shopEmployees.equals(shop.shopEmployees) && products.equals(shop.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, shopEmployees, products);
    }
}
