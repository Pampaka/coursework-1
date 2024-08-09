package com.skypro.employees.services;

import com.skypro.employees.configuration.EmployeeConfig;
import com.skypro.employees.entities.Employee;
import com.skypro.employees.exeptions.EmployeeAlreadyAddedException;
import com.skypro.employees.exeptions.EmployeeNotFoundException;
import com.skypro.employees.exeptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final int MAX_COUNT_EMPLOYEES;
    private final List<Employee> employees = new ArrayList<>();

    public EmployeeServiceImpl(EmployeeConfig config) {
        MAX_COUNT_EMPLOYEES = config.getMaxSize();
    }

    @Override
    public List<Employee> findAllEmployees() {
        return Collections.unmodifiableList(employees);
    }

    @Override
    public Employee findEmployee(String firsName, String lastName) {
        Employee employee = new Employee(firsName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee addEmployee(String firsName, String lastName) {
        if (employees.size() >= MAX_COUNT_EMPLOYEES) {
            throw new EmployeeStorageIsFullException();
        }

        Employee employee = new Employee(firsName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }

        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firsName, String lastName) {
        Employee employee = new Employee(firsName, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }
}
