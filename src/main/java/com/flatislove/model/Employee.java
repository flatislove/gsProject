package com.flatislove.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private int employeeId;
    @Column(name = "employee_firstname")
    private String firstname;
    @Column(name = "employee_lastname")
    private String lastname;
    @Column(name = "employee_position")
    private int employeePosition;
    @Column(name = "employee_password")
    private String password;
    @Column(name = "employee_email")
    private String email;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "employee_role", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set<Role> roles;

    public Employee(String firstname, String lastname) {
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public Employee(String firstname, String lastname, int employeePosition) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.employeePosition = employeePosition;
    }

    public Employee(Employee employee) {
        this.employeePosition = employee.getEmployeePosition();
        this.firstname = employee.getFirstname();
        this.lastname = employee.getLastname();
        this.password = employee.getPassword();
        this.email = employee.getEmail();
        this.roles = employee.getRoles();
        this.employeeId = employee.getEmployeeId();
    }

    public Employee(String firstname, String lastname, int employeePosition, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.employeePosition = employeePosition;
        this.email = email;
        this.password = password;
    }
}