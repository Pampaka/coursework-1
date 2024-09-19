package com.skypro.employees.services.DepartmentService;

import com.skypro.employees.models.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee findEmployeeWithMaxSalary(int department);

    Employee findEmployeeWithMinSalary(int department);

    List<Employee> findEmployeesByDepartment(int department);

    Map<Integer, List<Employee>> findEmployeesGroupByDepartments(Integer departmentId);
}
