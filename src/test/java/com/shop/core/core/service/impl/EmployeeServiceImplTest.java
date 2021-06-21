package com.shop.core.core.service.impl;

import com.shop.core.core.entity.Employee;
import com.shop.core.core.entity.Shop;
import com.shop.core.core.repository.EmployeeRepository;
import com.shop.core.core.repository.ShopRepository;
import com.shop.core.core.service.exception.employee.EmployeeNotAddedException;
import com.shop.core.core.service.exception.employee.EmployeeNotRemovedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeServiceImplTest {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @MockBean
    private ShopRepository shopRepository;


    //add new employee, phone is free
    @Test
    void addNewEmployee() throws EmployeeNotAddedException {
    Employee newEmployee = new Employee();
    newEmployee.setPhoneNumber("89999999999");
    newEmployee.setName("name1");
    newEmployee.setLastName("lastName1");
    newEmployee.setHourlyPayment(new BigDecimal(500));
    newEmployee.setId(1L);

    Shop shop = new Shop();
    shop.setAddress("shop adr");
    shop.setId(1L);

        Mockito.doReturn(Optional.of(shop)).when(shopRepository).findById(1L);
        Mockito.doReturn(Optional.empty()).when(employeeRepository).findEmployeeByPhoneNumber(newEmployee.getPhoneNumber());
        Mockito.doReturn(newEmployee).when(employeeRepository).save(newEmployee);
        Employee addedEmployee = employeeService.addNewEmployee(newEmployee,shop.getId());

        Assertions.assertEquals(newEmployee.getName(), addedEmployee.getName());
        Assertions.assertEquals(newEmployee.getPhoneNumber(), addedEmployee.getPhoneNumber());
        Assertions.assertEquals(newEmployee.getLastName(), addedEmployee.getLastName());
        Assertions.assertEquals(newEmployee.getId(), addedEmployee.getId());
        Assertions.assertEquals(newEmployee.getHourlyPayment(), newEmployee.getHourlyPayment());
        Assertions.assertEquals(newEmployee.getShop(), newEmployee.getShop());

        Mockito.verify(shopRepository,Mockito.times(1)).findById(1L);
        Mockito.verify(employeeRepository,Mockito.times(1)).findEmployeeByPhoneNumber(newEmployee.getPhoneNumber());
        Mockito.verify(employeeRepository,Mockito.times(1)).save(newEmployee);
    }

    @Test
    void removeEmployee() throws EmployeeNotRemovedException {
        Employee newEmployee = new Employee();
        newEmployee.setPhoneNumber("89999999999");
        newEmployee.setName("name");
        newEmployee.setLastName("lastName");
        newEmployee.setHourlyPayment(new BigDecimal(500));
        newEmployee.setId(1L);

        Assertions.assertTrue(employeeService.removeEmployee(1L));
        Mockito.verify(employeeRepository).deleteById(1L);

    }

    @Test
    void getAllEmployees() {
        Employee newEmployee = new Employee();
        newEmployee.setPhoneNumber("89999999999");
        newEmployee.setName("name");
        newEmployee.setLastName("lastName");
        newEmployee.setHourlyPayment(new BigDecimal(500));
        newEmployee.setId(1L);

        Employee newEmployee1 = new Employee();
        newEmployee1.setPhoneNumber("88888888888");
        newEmployee1.setName("name2");
        newEmployee1.setLastName("lastName2");
        newEmployee1.setHourlyPayment(new BigDecimal(500));
        newEmployee1.setId(2L);

        List<Employee> employeeList = Stream.of(newEmployee,newEmployee1).collect(Collectors.toList());

        Mockito.doReturn(employeeList).when(employeeRepository).findAll();

        List<Employee> employeesFromService = employeeService.getAllEmployees();

        Mockito.verify(employeeRepository,Mockito.times(1)).findAll();
        Assertions.assertEquals(employeeList,employeesFromService);
    }

    @Test
    void updateEmployee() {
    }
}