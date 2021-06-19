package com.shop.core.core.service.exception.employee;

public class EmployeeNotRemovedException extends Exception {

    public EmployeeNotRemovedException() {
        super();
    }

    public EmployeeNotRemovedException(String message) {
        super(message);
    }

    public EmployeeNotRemovedException(String message, Throwable cause) {
        super(message, cause);
    }
}
