package com.shop.core.core.service;

import com.shop.core.core.entity.Employee;
import com.shop.core.core.service.exception.employee.EmployeeNotAddedException;
import com.shop.core.core.service.exception.employee.EmployeeNotRemovedException;
import com.shop.core.core.service.exception.employee.EmployeeNotUpdatedException;

import java.util.List;

public interface EmployeeService {
    public Employee addNewEmployee(Employee newEmployee,Long shopId) throws EmployeeNotAddedException;
    public Boolean removeEmployee(Long employeeId) throws EmployeeNotRemovedException;
    public List<Employee> getAllEmployees();
    public Employee updateEmployee(Employee updatedEmployee) throws EmployeeNotUpdatedException;
}
