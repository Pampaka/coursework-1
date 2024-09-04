package com.skypro.employees.exeptions;

public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException() {
        super("Такой сотрудник уже существует");
    }
}
