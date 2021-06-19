package com.shop.core.core.service;

import com.shop.core.core.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee addNewEmployee(Employee newEmployee);
    public Boolean removeEmployee(Long employeeId);
    public List<Employee> getAllEmployees();
    public Employee updateEmployee(Employee updatedEmployee);
}
