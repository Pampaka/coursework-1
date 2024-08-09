package com.skypro.employees.services;

import com.skypro.employees.entities.Employee;
import com.skypro.employees.exeptions.EmployeeAlreadyAddedException;
import com.skypro.employees.exeptions.EmployeeNotFoundException;
import com.skypro.employees.exeptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final int MAX_COUNT_EMPLOYEES = 10;
    private final List<Employee> employees = new ArrayList<>();

    @Override
    public Employee findEmployee(String firsName, String lastName) {
        for (Employee employee : employees) {
            if (employee != null &&
                    Objects.equals(employee.getFirstName(), firsName) &&
                    Objects.equals(employee.getLastName(), lastName)
            ) {
                return employee;
            }
        }

        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee addEmployee(String firsName, String lastName) {
        if (employees.size() >= MAX_COUNT_EMPLOYEES) {
            throw new EmployeeStorageIsFullException();
        }

        try {
            findEmployee(firsName, lastName);
            throw new EmployeeAlreadyAddedException();
        } catch (EmployeeNotFoundException ignored) {
        }

        Employee employee = new Employee(firsName, lastName);
        employees.add(employee);

        return employee;
    }

    @Override
    public void removeEmployee(String firsName, String lastName) {
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee != null &&
                    Objects.equals(employee.getFirstName(), firsName) &&
                    Objects.equals(employee.getLastName(), lastName)
            ) {
                employees.remove(i);
                return;
            }
        }

        throw new EmployeeNotFoundException();
    }
}
