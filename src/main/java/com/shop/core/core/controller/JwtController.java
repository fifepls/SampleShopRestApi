package com.shop.core.core.controller;

import com.shop.core.core.entity.Employee;
import com.shop.core.core.repository.EmployeeRepository;
import com.shop.core.core.security.JwtProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/loginJwt")
public class JwtController {

    private final AuthenticationManager authenticationManager;
    private final EmployeeRepository employeeRepository;
    private final JwtProvider jwtProvider;

    public JwtController(AuthenticationManager authenticationManager, EmployeeRepository employeeRepository, JwtProvider jwtProvider) {
        this.authenticationManager = authenticationManager;
        this.employeeRepository = employeeRepository;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequestDTO request){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getPhoneNumber(),request.getPassword()));
            Employee employee = employeeRepository.findEmployeeByPhoneNumber(request.getPhoneNumber()).orElseThrow(() -> new UsernameNotFoundException("employee doesnt exists"));
            String token = jwtProvider.createToken(request.getPhoneNumber(),employee.getRole().name());
            Map<Object, Object> response = new HashMap<>();
            response.put("phone", request.getPhoneNumber());
            response.put("token", token);
            return  ResponseEntity.ok(response);
        }catch (AuthenticationException e ){
            return new ResponseEntity<>("invalid phone number / password combination", HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response){
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request,response,null);
    }
}
