package com.shop.core.core.repository;

import com.shop.core.core.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    public Optional<Employee> findEmployeeByPhoneNumber(String phoneNumber);
}
