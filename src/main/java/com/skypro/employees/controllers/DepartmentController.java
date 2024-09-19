package com.skypro.employees.controllers;

import com.skypro.employees.models.Employee;
import com.skypro.employees.services.DepartmentService.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping(path = "departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("max-salary")
    public Employee findEmployeeWithMaxSalary(@RequestParam("departmentId") int departmentId) {
        return departmentService.findEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping("min-salary")
    public Employee findEmployeeWithMinSalary(@RequestParam("departmentId") int departmentId) {
        return departmentService.findEmployeeWithMinSalary(departmentId);
    }

    @GetMapping("all")
    public Map<Integer, List<Employee>> findEmployeesByDepartment(
            @RequestParam(name = "departmentId", required = false) Integer departmentId) {
        return departmentService.findEmployeesGroupByDepartments(departmentId);
    }
}
