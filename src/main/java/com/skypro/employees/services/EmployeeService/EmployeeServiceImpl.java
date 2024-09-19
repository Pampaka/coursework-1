package com.skypro.employees.services.EmployeeService;

import com.skypro.employees.configuration.EmployeeConfig;
import com.skypro.employees.models.Employee;
import com.skypro.employees.exeptions.EmployeeAlreadyAddedException;
import com.skypro.employees.exeptions.EmployeeNotFoundException;
import com.skypro.employees.exeptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final int MAX_COUNT_EMPLOYEES;
    private final Map<String, Employee> employees = new HashMap<>();

    public EmployeeServiceImpl(EmployeeConfig config) {
        MAX_COUNT_EMPLOYEES = config.getMaxSize();
    }

    @Override
    public List<Employee> findAllEmployees() {
        return new ArrayList<>(employees.values());
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = employees.get(getKey(firstName, lastName));
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int salary, int department) {
        if (employees.size() >= MAX_COUNT_EMPLOYEES) {
            throw new EmployeeStorageIsFullException();
        }

        String key = getKey(firstName, lastName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }

        Employee employee = new Employee(firstName, lastName, salary, department);
        employees.put(key, employee);

        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employees.remove(key);
    }

    private String getKey(String firstName, String lastName) {
        return firstName + "_" + lastName;
    }
}
