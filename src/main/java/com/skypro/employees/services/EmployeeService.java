package com.skypro.employees.services;

import com.skypro.employees.entities.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllEmployees();

    Employee findEmployee(String firsName, String lastName);

    Employee addEmployee(String firsName, String lastName);

    Employee removeEmployee(String firsName, String lastName);
}
