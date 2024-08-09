package com.skypro.employees.services;

import com.skypro.employees.entities.Employee;

public interface EmployeeService {
    Employee findEmployee(String firsName, String lastName);

    Employee addEmployee(String firsName, String lastName);

    void removeEmployee(String firsName, String lastName);
}
