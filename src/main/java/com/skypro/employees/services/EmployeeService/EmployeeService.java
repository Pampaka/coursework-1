package com.skypro.employees.services.EmployeeService;

import com.skypro.employees.models.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllEmployees();

    Employee findEmployee(String firsName, String lastName);

    Employee addEmployee(String firsName, String lastName, int salary, int department);

    Employee removeEmployee(String firsName, String lastName);
}
