package com.skypro.employees.exeptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public RestException processNotFoundError(EmployeeNotFoundException error) {
        return getRestException(error);
    }

    @ExceptionHandler(EmployeeAlreadyAddedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public RestException processAlreadyAddedError(EmployeeAlreadyAddedException error) {
        return getRestException(error);
    }

    @ExceptionHandler(EmployeeStorageIsFullException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public RestException processStorageIsFullError(EmployeeStorageIsFullException error) {
        return getRestException(error);
    }

    private RestException getRestException(RuntimeException error) {
        return new RestException(error.getMessage());
    }
}
