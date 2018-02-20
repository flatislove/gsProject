package com.flatislove.service;

import com.flatislove.model.Employee;
import com.flatislove.model.SecurityUserDetails;
import com.flatislove.model.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public SecurityUserDetailsService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> employeeOptional = employeeRepository.findByFirstname(username);

        return employeeOptional
                .map(SecurityUserDetails::new)
                .orElseThrow(()->new UsernameNotFoundException("Username not found"));
    }
}
