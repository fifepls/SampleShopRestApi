package com.shop.core.core.controller;


import com.shop.core.core.entity.Employee;
import com.shop.core.core.entity.Shop;
import com.shop.core.core.service.EmployeeService;
import com.shop.core.core.service.ShopService;
import com.shop.core.core.service.exception.employee.EmployeeNotAddedException;
import com.shop.core.core.service.exception.shop.ShopNotAddedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/test")
public class CustomerController {

    private ShopService shopService;
    private EmployeeService employeeService;

    public CustomerController(ShopService shopService, EmployeeService employeeService) {
        this.shopService = shopService;
        this.employeeService = employeeService;
    }

    @GetMapping("/shop")
    public Shop addShop (@RequestParam(name = "adr")String address){
        Shop shop = new Shop();
        shop.setAddress(address);
        try {
            return shopService.addNewShop(shop);
        } catch (ShopNotAddedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/empl")
    public boolean addEmployee(@RequestParam(value = "name") String name,
                       @RequestParam(value = "lastname") String lastName,
                       @RequestParam(value = "phone")String phone,
                       @RequestParam(value = "pay")BigDecimal pay,
                       @RequestParam(value = "shopId")Long shop
                       ){

        Employee employee = new Employee();
        employee.setHourlyPayment(pay);
        employee.setLastName(lastName);
        employee.setName(name);
        employee.setPhoneNumber(phone);
        try {
            employeeService.addNewEmployee(employee,shop);
        } catch (EmployeeNotAddedException e) {
            e.printStackTrace();
        }
        return true;

    }
}
