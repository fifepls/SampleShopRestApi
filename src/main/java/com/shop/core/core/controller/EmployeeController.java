package com.shop.core.core.controller;

import com.shop.core.core.entity.Employee;
import com.shop.core.core.entity.Product;
import com.shop.core.core.entity.Shop;
import com.shop.core.core.service.EmployeeService;
import com.shop.core.core.service.ProductService;
import com.shop.core.core.service.ShopService;
import com.shop.core.core.service.exception.employee.EmployeeNotAddedException;
import com.shop.core.core.service.exception.employee.EmployeeNotRemovedException;
import com.shop.core.core.service.exception.product.ProductNotCreatedException;
import com.shop.core.core.service.exception.product.ProductNotDeletedException;
import com.shop.core.core.service.exception.shop.ShopNotAddedException;
import com.shop.core.core.service.exception.shop.ShopNotRemovedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final ShopService shopService;
    private final ProductService productService;
    private final EmployeeService employeeService;


    public EmployeeController(ShopService shopService, ProductService productService, EmployeeService employeeService) {
        this.shopService = shopService;
        this.productService = productService;
        this.employeeService = employeeService;
    }


    @PreAuthorize("hasAuthority('employee:newProduct')")
    @PostMapping("/add/product")
    public boolean addProduct(@RequestBody Product product) {
        try {
            productService.createNewProduct(product);
            return true;
        } catch (ProductNotCreatedException e) {
            return false;
        }
    }


    @PreAuthorize("hasAuthority('employee:remProduct')")
    @DeleteMapping("/rem/product")
    public boolean removeProduct(@RequestParam(value ="productId") Long productId){
        try {
            return productService.deleteProduct(productId);
        } catch (ProductNotDeletedException e) {
            return false;
        }
    }


    @PreAuthorize("hasAuthority('employee:newShop')")
    @PostMapping("/add/shop")
    public boolean addShop (Shop newShop){
        try {
            shopService.addNewShop(newShop);
            return true;
        } catch (ShopNotAddedException e) {
            return false;
        }
    }


    @PreAuthorize("hasAuthority('employee:remShop')")
    @DeleteMapping("/rem/shop")
    public boolean removeShop (@RequestParam(value = "shopId") Long shopId){
        try {
            return shopService.removeShop(shopId);
        } catch (ShopNotRemovedException e) {
            return false;
        }
    }


    @PreAuthorize("hasAuthority('employee:regEmployee')")
    @PostMapping("/reg/employee")
    public boolean regNewEmployee(@RequestBody Employee employee, @RequestParam(value = "shopId")Long shopId){
        try {
            employeeService.addNewEmployee(employee, shopId);
            return true;
        } catch (EmployeeNotAddedException e) {
            return false;
        }
    }


    @PreAuthorize("hasAuthority('employee:remEmployee')")
    @DeleteMapping("/rem/employee")
    public boolean remEmployee(@RequestParam(value = "employeeId")Long employeeId){
        try {
            return employeeService.removeEmployee(employeeId);
        } catch (EmployeeNotRemovedException e) {
            return false;
        }
    }


    @PreAuthorize("hasAuthority('employee:getEmployees')")
    @GetMapping("/get/allEmployee")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/get/allShops")
    public List<Shop> getShops(){
        return shopService.getAllShops();
    }
}
