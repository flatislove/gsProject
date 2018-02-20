package com.flatislove.model.repository;

import com.flatislove.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>,
        JpaRepository<Employee, Integer> {
    Optional<Employee> findByFirstname(String username);
}
