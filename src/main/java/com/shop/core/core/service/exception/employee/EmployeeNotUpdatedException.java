package com.shop.core.core.service.exception.employee;

public class EmployeeNotUpdatedException extends Exception {
    public EmployeeNotUpdatedException() {
        super();
    }

    public EmployeeNotUpdatedException(String message) {
        super(message);
    }

    public EmployeeNotUpdatedException(String message, Throwable cause) {
        super(message, cause);
    }
}
