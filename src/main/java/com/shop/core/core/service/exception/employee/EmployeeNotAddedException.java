package com.shop.core.core.service.exception.employee;

public class EmployeeNotAddedException extends Exception{

    public EmployeeNotAddedException() {
        super();
    }

    public EmployeeNotAddedException(String message) {
        super(message);
    }

    public EmployeeNotAddedException(String message, Throwable cause) {
        super(message, cause);
    }
}
