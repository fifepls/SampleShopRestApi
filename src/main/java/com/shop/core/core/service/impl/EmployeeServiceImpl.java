package com.shop.core.core.service.impl;

import com.shop.core.core.entity.Employee;
import com.shop.core.core.entity.Shop;
import com.shop.core.core.repository.EmployeeRepository;
import com.shop.core.core.repository.ShopRepository;
import com.shop.core.core.service.EmployeeService;
import com.shop.core.core.service.exception.employee.EmployeeNotAddedException;
import com.shop.core.core.service.exception.employee.EmployeeNotRemovedException;
import com.shop.core.core.service.exception.employee.EmployeeNotUpdatedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ShopRepository shopRepository;

    private final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ShopRepository shopRepository) {
        this.employeeRepository = employeeRepository;
        this.shopRepository = shopRepository;
    }

    @Override
    @Transactional
    public Employee addNewEmployee(Employee newEmployee,Long shopId) throws EmployeeNotAddedException {
        try {
            if(newEmployee == null){
                throw new EmployeeNotAddedException("newEmployee is null");
            }
            Optional<Shop> optionalShop = shopRepository.findById(shopId);
                if(optionalShop.isPresent()) {
                    newEmployee.setShop(optionalShop.get());
                    return employeeRepository.save(newEmployee);
                }else {
                    throw new EmployeeNotAddedException("no shop with this id");
                }
        }catch (EmployeeNotAddedException e){
            logger.error("employee not added",e);
            throw new EmployeeNotAddedException("newEmployee is null",e);
        }
    }

    @Override
    @Transactional
    public Boolean removeEmployee(Long employeeId) throws EmployeeNotRemovedException {
        try{
            if(employeeId == null){
                throw new EmployeeNotRemovedException("employeeId is null");
            }
            employeeRepository.deleteById(employeeId);
            return true;
        }catch (EmployeeNotRemovedException e){
            logger.error("newEmployee is null",e);
            throw new EmployeeNotRemovedException("newEmployee is null",e);
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee updatedEmployee) throws EmployeeNotUpdatedException {
        try{
            if(updatedEmployee == null){
                throw new EmployeeNotUpdatedException("updated employee is null");
            }
            return employeeRepository.save(updatedEmployee);
        }catch (EmployeeNotUpdatedException e){
            logger.error("updated employee is null",e);
            throw new EmployeeNotUpdatedException("updated employee is null",e);
        }
    }
}
