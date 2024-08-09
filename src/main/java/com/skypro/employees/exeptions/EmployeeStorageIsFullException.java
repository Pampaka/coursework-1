package com.skypro.employees.exeptions;

public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException() {
        super("Превышен лимит количества сотрудников");
    }
}
