package com.shop.core.core.entity;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    ADMIN(Set.of(Permission.EMPLOYEE_ADD_NEW_PRODUCT,
            Permission.EMPLOYEE_REM_PRODUCT,
            Permission.EMPLOYEE_ADD_NEW_SHOP,
            Permission.EMPLOYEE_REM_SHOP,
            Permission.EMPLOYEE_REG_NEW_EMPLOYEE,
            Permission.EMPLOYEE_REM_EMPLOYEE,
            Permission.EMPLOYEE_GET_ALL_EMPLOYEES
            )),

    CUSTOMER(Set.of(Permission.CUSTOMER_UPDATE_PHONE,
            Permission.CUSTOMER_UPDATE_PASSWORD,
            Permission.CUSTOMER_ADD_PRODUCT_TO_CART,
            Permission.CUSTOMER_REM_PRODUCT_FROM_CART,
            Permission.CUSTOMER_GET_PRODUCTS_FROM_CART
            ))
    ;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    private final Set<Permission> permissions;

    public Set<SimpleGrantedAuthority> getAuthorities(){
        return  getPermissions().stream().map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }

}