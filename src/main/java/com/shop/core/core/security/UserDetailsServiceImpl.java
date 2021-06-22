package com.shop.core.core.security;


import com.shop.core.core.entity.Employee;
import com.shop.core.core.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public UserDetailsServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findEmployeeByPhoneNumber(phoneNumber).orElseThrow(() -> new UsernameNotFoundException("User doesn't exist"));
        return  SecurityUser.fromUser(employee);
    }
}