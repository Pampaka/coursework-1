package com.skypro.employees.services.DepartmentService;

import com.skypro.employees.models.Employee;
import com.skypro.employees.exeptions.EmployeeNotFoundException;
import com.skypro.employees.services.EmployeeService.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findEmployeeWithMaxSalary(int departmentId) {
        List<Employee> employees = findEmployeesByDepartment(departmentId);
        return employees.stream()
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee findEmployeeWithMinSalary(int departmentId) {
        List<Employee> employees = findEmployeesByDepartment(departmentId);
        return employees.stream()
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<Employee> findEmployeesByDepartment(int departmentId) {
        List<Employee> employees = employeeService.findAllEmployees();
        return employees.stream()
                .filter(e -> e.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> findEmployeesGroupByDepartments() {
        List<Employee> employees = employeeService.findAllEmployees();
        Map<Integer, List<Employee>> employeesGroups = new HashMap<>();
        employees.forEach(e -> {
            if (employeesGroups.containsKey(e.getDepartment())) {
                employeesGroups.get(e.getDepartment()).add(e);
            } else {
                employeesGroups.put(e.getDepartment(), new ArrayList<>(List.of(e)));
            }
        });
        return employeesGroups;
    }
}
