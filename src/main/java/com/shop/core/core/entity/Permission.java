package com.shop.core.core.entity;

public enum Permission {
    //employee permissions
    EMPLOYEE_ADD_NEW_PRODUCT("employee:newProduct"),
    EMPLOYEE_REM_PRODUCT("employee:remProduct"),
    EMPLOYEE_ADD_NEW_SHOP("employee:newShop"),
    EMPLOYEE_REM_SHOP("employee:remShop"),
    EMPLOYEE_REG_NEW_EMPLOYEE("employee:regEmployee"),
    EMPLOYEE_REM_EMPLOYEE("employee:remEmployee"),
    EMPLOYEE_GET_ALL_EMPLOYEES("employee:getEmployees"),

    //customer permissions

    CUSTOMER_UPDATE_PASSWORD("customer:updatePassword"),
    CUSTOMER_UPDATE_PHONE("customer:updatePhone"),
    CUSTOMER_ADD_PRODUCT_TO_CART("customer:addProductToCart"),
    CUSTOMER_REM_PRODUCT_FROM_CART("customer:remProductFromCart"),
    CUSTOMER_GET_PRODUCTS_FROM_CART("customer:getProductsFromCart")
    ;


    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
