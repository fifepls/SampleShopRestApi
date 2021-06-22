package com.shop.core.core.entity;

public enum Permission {
    EMPLOYEE_ADD_NEW_PRODUCT("employee:newProduct"),
    EMPLOYEE_REM_PRODUCT("employee:remProduct"),
    EMPLOYEE_ADD_NEW_SHOP("employee:newShop"),
    EMPLOYEE_REM_SHOP("employee:remShop"),
    EMPLOYEE_REG_NEW_EMPLOYEE("employee:regEmployee"),
    EMPLOYEE_REM_EMPLOYEE("employee:remEmployee"),
    EMPLOYEE_GET_ALL_EMPLOYEES("employee:getEmployees");


    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
