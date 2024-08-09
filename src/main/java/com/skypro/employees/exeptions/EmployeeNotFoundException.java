package com.skypro.employees.exeptions;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException() {
        super("Сотрудник не найден");
    }
}
